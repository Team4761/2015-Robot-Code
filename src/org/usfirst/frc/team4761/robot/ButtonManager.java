package org.usfirst.frc.team4761.robot;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Allows for easy mapping of Joystick buttons to the execution of commands.
 */
public class ButtonManager
{
	static JoystickButton[][] buttons = new JoystickButton[3][11];
	static ArrayList<ButtonCommand> list = new ArrayList<ButtonCommand>();
	static Joystick jstick, jstick2, buttonBoard;
	static boolean inited = false;
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int BUTTON_BOARD = 2;
	private ButtonManager(){}
	private void init()
	{
		jstick = new Joystick(0);
		jstick2 = new Joystick(1);
		buttonBoard = new Joystick(2);
		for (int x = 0; x < buttons.length; x++)
		{
			buttons[0][x] = new JoystickButton(jstick, x);
			buttons[1][x] = new JoystickButton(jstick2, x);
			buttons[2][x] = new JoystickButton(buttonBoard, x);
		}
		
		new Thread(new ButtonManagerHandler()).start();
		inited = true;
	}
	/**
	 * Starts the specified command whenever the button is pressed.
	 * @param button	an int specifying the button to be used
	 * @param joystick	an int specifying the Joystick to be used (LEFT_JOYSTICK, RIGHT_JOYSTICK, or BUTTON_BOARD)
	 * @param command	an instance of a Command to be run 
	 */
	public void onPress(int button, int joystick, Command command)
	{
		checkInit();
		buttons[joystick][button].whenPressed(command);
	}
	/**
	 * Toggle the execution of the specified command whenever the button is pressed.
	 * @param button	an int specifying the button to be used
	 * @param joystick	an int specifying the Joystick to be used (LEFT_JOYSTICK, RIGHT_JOYSTICK, or BUTTON_BOARD)
	 * @param command	an instance of a Command to be run 
	 */
	public void setToggle(int button, int joystick, Command command)
	{
		checkInit();
		list.add(new ButtonCommand(button, joystick, command));
	}
	private void checkInit()
	{
		if (!inited)
			init();
	}
	private class ButtonManagerHandler implements Runnable
	{
		public void run()
		{
			while (true)
			{
				for (ButtonCommand command : list)
				{
					boolean state = command.stick.getRawButton(command.button);
					if (command.last==false && state==true)	// if the button has just been pressed
					{										// toggle whether or not the command is active
						command.toggled = !command.toggled;
						if (command.toggled)
							command.command.start();
						else
							command.command.cancel();
					}
					command.last = state;
				}
			}
		}
	}
	private class ButtonCommand
	{
		int button;
		Command command;
		boolean toggled = false;
		boolean last = false;
		Joystick stick;
		private ButtonCommand(int button, int jystick, Command command)
		{
			this.button = button;
			this.command = command;
			if (jystick==ButtonManager.LEFT_JOYSTICK)
				stick = ButtonManager.jstick;
			else if (jystick==ButtonManager.RIGHT_JOYSTICK)
				stick = ButtonManager.jstick2;
			else
				stick = ButtonManager.buttonBoard;
		}
	}
}
