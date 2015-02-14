package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.buttons.TurnToZero;
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
	public ButtonManager buttonManager;
	
	public OI() {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		buttons = new Joystick(2);
		
		/*
		SmartDashboard.putData("RC Lower", new LowerRcGrabber());
		SmartDashboard.putData("RC Lift", new RaiseRcGrabber());
		SmartDashboard.putData("RC Off", new RcGrabberOff());
		SmartDashboard.putData("Plow Extend", new PlowExtend());
		SmartDashboard.putData("Plow Off", new PlowOff());
		SmartDashboard.putData("Plow Retract", new PlowRetract());
		SmartDashboard.putData("RCPickUp", new RcPickUp());
		SmartDashboard.putData("Spin Out", new SpinRcBaseOut());
		SmartDashboard.putData("Spin In", new SpinRcBaseIn());
		SmartDashboard.putData("Conveyer", new MainConveyorForward());
		*/
		
		SmartDashboard.putData("Drive To Step", new DriveToStep());
		SmartDashboard.putData("Drive Along Step", new DriveAlongStep());
		SmartDashboard.putData("Go to next barrel", new GoToNextBarrel());
		SmartDashboard.putData("Pick up RC", new RcPickUp());
		
		// Bind buttons
		/*
		buttonManager.onPress(2, 0, new TurnToZero());
		buttonManager.onPress(3, 0, new ResetGyro()); // CHECK BUTTON
		*/
	}
}
