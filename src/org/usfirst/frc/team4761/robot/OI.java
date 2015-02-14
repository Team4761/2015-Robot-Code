package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4761.robot.buttons.LiftConveyorDown;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorUp;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.MoveElevator;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberLeft;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberRight;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberToggle;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.buttons.TurnToZero;
import org.usfirst.frc.team4761.robot.buttons.WedgeToggle;
import org.usfirst.frc.team4761.robot.commandgroups.RcPickUp;
import org.usfirst.frc.team4761.robot.commands.*;

import static edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick1;
	public Joystick joystick2;
	public Joystick buttons; // Buttons on the control board
	ButtonManager buttonManager = new ButtonManager();
	
	public OI() {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		buttons = new Joystick(2);
		
		putData("RCPickUp", new RcPickUp());
		putData("Drive To Step", new DriveToStep());
		putData("Drive Along Step", new DriveAlongStep());
		putData("Go to next barrel", new GoToNextBarrel());
		putData("Pick up RC", new RcPickUp());
		
		// Bind buttons for button boards
		buttonManager.runWhilePressed(2, 2, new MainConveyorForward());
		buttonManager.runWhilePressed(1, 2, new MainConveyorBackward());
		
		buttonManager.runWhilePressed(6, 2, new LiftConveyorUp());
		buttonManager.runWhilePressed(5, 2, new LiftConveyorDown());
		
		buttonManager.runWhilePressed(8, 2, new RCGrabberRight());
		buttonManager.runWhilePressed(9, 2, new RCGrabberLeft());
		
		buttonManager.runWhilePressed(12, 2, new MoveElevator(true, 0.5));
		buttonManager.runWhilePressed(13, 2, new MoveElevator(false, 0.25));
		
		buttonManager.setToggle(10, 2, new WedgeToggle());
		buttonManager.setToggle(11, 2, new RCGrabberToggle());
		
		// Bind buttons for joysticks
		//buttonManager.onPress(2, 0, new TurnToZero());
		//buttonManager.onPress(3, 0, new ResetGyro()); // CHECK BUTTON
		buttonManager.runWhilePressed(11, 0, new MainConveyorForward());
		buttonManager.runWhilePressed(10, 0, new MainConveyorBackward());
		
		buttonManager.runWhilePressed(6, 0, new LiftConveyorUp());
		buttonManager.runWhilePressed(7, 0, new LiftConveyorDown());
		
		buttonManager.runWhilePressed(8, 0, new RCGrabberRight());
		buttonManager.runWhilePressed(9, 0, new RCGrabberLeft());
		
		buttonManager.runWhilePressed(6, 1, new MoveElevator(true, 0.5));
		buttonManager.runWhilePressed(7, 1, new MoveElevator(false, 0.25));
		
		buttonManager.runOnPress(3, 0, new RaiseRcGrabber());
		buttonManager.runOnPress(2, 0, new LowerRcGrabber());
		
		buttonManager.setToggle(11, 1, new WedgeToggle());
	}
}
