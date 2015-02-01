package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick joystick1 = new Joystick(0);
	public static final Joystick joystick2 = new Joystick(1);
	public static final Joystick buttons = new Joystick(2); // Buttons on the control board
}

