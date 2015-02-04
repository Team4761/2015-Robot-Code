package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joystick1;
	public static Joystick joystick2;
	public static Joystick buttons; // Buttons on the control board
	
	public OI () {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		buttons = new Joystick(2);
	}
}