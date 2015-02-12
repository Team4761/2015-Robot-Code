package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4761.robot.commandgroups.RcPickUp;
import org.usfirst.frc.team4761.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick1;
	public Joystick joystick2;
	public Joystick buttons; // Buttons on the control board
	
	public OI() {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		buttons = new Joystick(2);
		
		SmartDashboard.putData("RC Lower", new RcLower());
		SmartDashboard.putData("RC Lift", new RcLift());
		SmartDashboard.putData("RC Off", new RcOff());
		SmartDashboard.putData("Plow Extend", new PlowExtend());
		SmartDashboard.putData("Plow Off", new PlowOff());
		SmartDashboard.putData("Plow Retract", new PlowRetract());
		SmartDashboard.putData("RCPickUp", new RcPickUp());
	}
}
