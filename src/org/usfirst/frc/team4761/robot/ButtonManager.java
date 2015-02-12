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
	static Joystick[] joysticks = new Joystick[3];
	static boolean inited = false;
	public static final int LEFT_JOYSTICK = 0, RIGHT_JOYSTICK = 1, BUTTON_BOARD = 2;
	private ButtonManager(){}
	private void init()
	{
		for (int i = 0; i < 3; i++)
			joysticks[i] = new Joystick(i);
		for (int x = 0; x < buttons.length; x++)
			for (int i = 0; i < 3; i++)
				buttons[i][x] = new JoystickButton(joysticks[i], x);
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
					if (command.last==false && state==true)
					{
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
		boolean toggled = false, last = false;
		Joystick stick;
		private ButtonCommand(int button, int jystick, Command command)
		{
			this.button = button;
			this.command = command;
			stick = ButtonManager.joysticks[jystick];
		}
	}
}
