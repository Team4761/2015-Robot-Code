package org.usfirst.frc.team4761.robot;

import java.util.concurrent.CopyOnWriteArrayList;

import org.usfirst.frc.team4761.robot.commands.debug.PrintCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Allows for easy mapping of Joystick buttons to the execution of commands.
 */
public class ButtonManager {
	static boolean inited = false, buttonDown;
	public static final int CONTROLLER = 0, BUTTONBOARD_ONE = 1, BUTTONBOARD_TWO = 2;
	
	static CopyOnWriteArrayList<ButtonCommand> list = new CopyOnWriteArrayList<ButtonCommand>();
	
	static JoystickButton[][] buttons = new JoystickButton[3][30];
	
	static Joystick[] joysticks = {new Joystick(CONTROLLER), new Joystick(BUTTONBOARD_ONE), new Joystick(BUTTONBOARD_TWO)};
	
	public ButtonManager() {}
	
	private void init() {
		try {
			for (int x = 0; x < buttons.length; x++) {
				for (int i = 0; i < 3; i++) {
					buttons[i][x] = new JoystickButton(joysticks[i], x);
				}
			}
			
			new Thread(new ButtonManagerHandler()).start();
			inited = true;
		} catch (Exception e) {
			System.out.println("Error in ButtonManager init!");
			e.printStackTrace();
		}
	}
	
	public void onPress(int button, int joystick, Command command) {
		checkInit();
		buttons[joystick][button].whenPressed(command);
	}
	
	public void setToggle(int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, ButtonCommand.TYPE_TOGGLEABLE);
	}
	
	public void runOnPress (int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, ButtonCommand.TYPE_ROP);
	}
	
	public void runWhilePressed (int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, ButtonCommand.TYPE_RWP);
	}
	
	public void runWhilePressedPOV (int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, ButtonCommand.TYPE_RWP, true);
	}
	
	public void runOnceOnHold (int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, ButtonCommand.TYPE_CROP);
	}
	
	private void checkInit() {
		try {
			if (!inited) {
				init();
			}
		} catch (Error e) {
			System.out.println(e);
		}
	}
	
	public static void test() {
		Robot.oi.buttonManager.setToggle      (1, ButtonManager.BUTTONBOARD_ONE, new PrintCommand("Toggle button test."));
		Robot.oi.buttonManager.runOnPress     (2, ButtonManager.BUTTONBOARD_ONE, new PrintCommand("RoP test."));
		Robot.oi.buttonManager.runWhilePressed(3, ButtonManager.BUTTONBOARD_ONE, new PrintCommand("RwP test."));
		Robot.oi.buttonManager.runOnceOnHold  (4, ButtonManager.BUTTONBOARD_ONE, new PrintCommand("cRoP test."));
		System.out.println(">> ButtonManager Test Initialized <<");
	}
	private class ButtonManagerHandler implements Runnable {
		public void run() {
			try {
				while (true) {
					for (ButtonCommand command : list) {
						buttonDown = command.get();
						
						if (command.type == ButtonCommand.TYPE_TOGGLEABLE) {
							if (command.pressed()) {
								command.store = !command.store;
								if (command.store) {
									command.start();
								} else {
									command.stop();
								}
							}
						} else if (command.type == ButtonCommand.TYPE_ROP) {
							if (command.pressed()) {
								command.start();
							}
						} else if (command.type == ButtonCommand.TYPE_RWP) {
							if (buttonDown) {
								command.start();
							}
						} else if (command.type == ButtonCommand.TYPE_CROP) {
							if (buttonDown && !command.store) {
								command.start();
								command.store = true;
							} else if (!buttonDown) {
								command.stop();
								command.store = false;
							}
						}
						command.last = buttonDown;
					}
					Thread.sleep(20);
				}
			} catch (Exception e) {
				System.out.println("Error in ButtonManagerHandler thread!");
				e.printStackTrace();
			}
		}
	}
	
	private class ButtonCommand {
		int button;
		Command command;
		Joystick stick;
		int type;
		boolean store = false, last = false, pov = false;
		static final int TYPE_TOGGLEABLE = 0, TYPE_ROP = 1, TYPE_RWP = 2, TYPE_CROP = 3;
		
		private ButtonCommand (int button, int joystick, Command command, int type) {
			try {
				this.button = button;
				this.command = command;
				this.type = type;
				stick = ButtonManager.joysticks[joystick];
				ButtonManager.list.add(this);
			}
			catch (Error e) {
				System.out.println("Error creating a ButtonCommand!");
				e.printStackTrace();
			}
		}
		
		private ButtonCommand (int button, int joystick, Command command, int type, boolean pov) {
			try {
				if (pov) {
					this.pov = true;
				}
				
				this.button = button;
				this.command = command;
				this.type = type;
				stick = ButtonManager.joysticks[joystick];
				ButtonManager.list.add(this);
			} catch (Error e) {
				System.out.println("Error creating a ButtonCommand!");
				e.printStackTrace();
			}
		}
		
		public boolean get() {
			if (this.pov) {
				if (stick.getPOV() == button) {
					return true;
				} else {
					return false;
				}
			}
			
			return stick.getRawButton(button);
		}
		
		public void start() {
			command.start();
		}
		
		public void stop() {
			command.cancel();
		}
		
		public boolean pressed() {
			return buttonDown && !last;
		}
	}
}
