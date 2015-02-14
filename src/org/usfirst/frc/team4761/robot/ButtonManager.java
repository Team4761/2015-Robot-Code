package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import java.util.ArrayList;

/**
 * Allows for easy mapping of Joystick buttons to the execution of commands.
 */
public class ButtonManager {
	static boolean inited = false;
	public static final int LEFT = 0, RIGHT = 1, BUTTONS = 2;
	
	static ArrayList<ButtonCommand> list = new ArrayList<ButtonCommand>();
	
	static JoystickButton[][] buttons = new JoystickButton[3][20];
	static Joystick[] joysticks = {new Joystick(LEFT), new Joystick(RIGHT), new Joystick(BUTTONS)};
	
	private ButtonManager() {
	}
	
	private void init() {
		try
		{
		for (int x = 0; x < buttons.length; x++) {
			for (int i = 0; i < 3; i++) {
				buttons[i][x] = new JoystickButton(joysticks[i], x);
			}
		}
		
		new Thread(new ButtonManagerHandler()).start();
		inited = true;
		}
		catch (Exception e)
		{
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
	
	/**
	 * Toggle the execution of the specified command whenever the button is pressed.
	 *
	 * @param button   an int specifying the button to be used
	 * @param joystick an int specifying the Joystick to be used (LEFT_JOYSTICK, RIGHT_JOYSTICK, or BUTTON_BOARD)
	 * @param command  an instance of a Command to be run
	 */
	public void setToggle(int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, true);
	}
	
	/**
	 * Start the specified command whenever the button is pressed (alternative to onPress).
	 *
	 * @param button   an int specifying the button to be used
	 * @param joystick an int specifying the Joystick to be used (LEFT_JOYSTICK, RIGHT_JOYSTICK, or BUTTON_BOARD)
	 * @param command  an instance of a Command to be run
	 */
	public void runOnPress(int button, int joystick, Command command) {
		checkInit();
		new ButtonCommand(button, joystick, command, false);
	}
	
	private void checkInit() {
		if (!inited) {
			init();
		}
	}
	
	private class ButtonManagerHandler implements Runnable {
		public void run() {
			try
			{
			while (true) {
				for (ButtonCommand command : list) {
					boolean state = command.stick.getRawButton(command.button);
					if (command.last == false && state == true) {
						if (command.toggleable) {
							command.toggled = !command.toggled;
							if (command.toggled) {
								command.command.start();
							} else {
								command.command.cancel();
							}
						} else {
							command.command.start();
						}
					}
					command.last = state;
				}
			}
			}
		catch (Exception e)
		{
			System.out.println("Error in ButtonManagerHandler thread!");
			e.printStackTrace();
		}
		}
	}
	
	private class ButtonCommand {
		int button;
		Command command;
		boolean toggled = false, last = false, toggleable;
		Joystick stick;
		
		private ButtonCommand(int button, int joystick, Command command, boolean toggleable) {
			try
			{
			this.button = button;
			this.command = command;
			this.toggleable = toggleable;
			stick = ButtonManager.joysticks[joystick];
			ButtonManager.list.add(this);
			}
		catch (Exception e)
		{
			System.out.println("Error creating a ButtonCommand!");
			e.printStackTrace();
		}
		}
	}
}
