package org.usfirst.frc.team4761.robot;

import java.util.concurrent.CopyOnWriteArrayList;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Allows for easy mapping of Joystick buttons to the execution of commands.
 */
public class ButtonManager {
	static boolean inited = false, buttonDown;
	public static final int LEFT = 0, RIGHT = 1, BUTTONS = 2;
	
	static CopyOnWriteArrayList<ButtonCommand> list = new CopyOnWriteArrayList<ButtonCommand>();
	
	static JoystickButton[][] buttons = new JoystickButton[3][20];
	static Joystick[] joysticks = {new Joystick(LEFT), new Joystick(RIGHT), new Joystick(BUTTONS)};
	
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
	
	/**
	 * Starts the specified command whenever the button is pressed.
	 *
	 * @param button   an int specifying the button to be used
	 * @param joystick an int specifying the Joystick to be used (LEFT_JOYSTICK, RIGHT_JOYSTICK, or BUTTON_BOARD)
	 * @param command  an instance of a Command to be run
	 */
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
	
	private class ButtonManagerHandler implements Runnable 
	{
		public void run() 
		{
			try 
			{
				while (true) 
				{
					for (ButtonCommand command : list)
					{
						buttonDown = command.get();
						if (command.type == ButtonCommand.TYPE_TOGGLEABLE)	// TOGGLEABLE button
						{
							if (command.pressed())	// on button press
								command.store = !command.store;	// toggle state
							if (command.store)
								command.start();	// if toggled on, start command
							else
								command.stop();	// if toggled off, stop command
						}
						else if (command.type == ButtonCommand.TYPE_ROP)	// RUN ON PRESS button
							if (command.pressed())
								command.start();	// on button press, start command
						else if (command.type == ButtonCommand.TYPE_RWP)	// RUN WHILE PRESS button
							if (buttonDown)
								command.start();	// if button is held down, start (or keep running) command
						else if (command.type == ButtonCommand.TYPE_CROP)	// CANCELABLE RUN ON PRESS
						{
							if (buttonDown && !command.store)
							{
								command.start();	// if button is held down and the command has not finished executing, start command
								command.store = true;
							}
							else if (!buttonDown)
							{
								command.stop();	// if button is released, stop command and mark as finished
								command.store = false;
							}
						}
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
		boolean store = false, last = false;
		static final int TYPE_TOGGLEABLE = 0, TYPE_ROP = 1, TYPE_RWP = 2, TYPE_CROP = 3;
		private ButtonCommand(int button, int joystick, Command command, int type) {
			try 
			{
				this.button = button;
				this.command = command;
				this.type = type;
				stick = ButtonManager.joysticks[joystick];
				ButtonManager.list.add(this);
			}
			catch (Error e)
			{
				System.out.println("Error creating a ButtonCommand!");
				e.printStackTrace();
			}
		}
		public boolean get()
		{
				return stick.getRawButton(button);
		}
		public void start()
		{
			command.start();
		}
		public void stop()
		{
			command.cancel();
		}
		public boolean pressed()
		{
			return buttonDown && !last;
		}
	}
}
