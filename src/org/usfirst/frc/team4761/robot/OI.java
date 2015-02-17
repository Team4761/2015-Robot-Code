package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4761.robot.buttons.LiftConveyerBackward;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyerForward;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorForward;
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
	//public Joystick[] joysticks = {new Joystick(0), new Joystick(1), new Joystick(2), new Joystick(3)};
	public Joystick[] joysticks = {new Joystick(0), new Joystick(1)};
	
	ButtonManager buttonManager = new ButtonManager();
	
	public OI() {
		
		putData("RCPickUp", new RcPickUp());
		putData("Drive To Step", new DriveToStep());
		putData("Drive Along Step", new DriveAlongStep());
		putData("Go to next barrel", new GoToNextBarrel());
		putData("Go to barrel back", new GoToBackEdgeOfBarrel());
		putData("Run Main Conveyor", new org.usfirst.frc.team4761.robot.commands.MainConveyorForward());
		putData("Move To Stack Top", new MoveElevatorToStackTop());
		
		// Bind buttons for button boards
		/*buttonManager.runWhilePressed(2, 2, new MainConveyorForward(2, 2));
		buttonManager.runWhilePressed(1, 2, new MainConveyorBackward(1, 2));
		
		buttonManager.runWhilePressed(12, 2, new LiftConveyorForward(12, 2));
		buttonManager.runWhilePressed(13, 2, new LiftConveyorBackward(13, 2));
		
		buttonManager.runWhilePressed(8, 2, new RCGrabberRight(8, 2));
		buttonManager.runWhilePressed(9, 2, new RCGrabberLeft(9, 2));
		
		buttonManager.runWhilePressed(6, 2, new MoveElevator(true, 0.5, 6, 2));
		buttonManager.runWhilePressed(10, 2, new MoveElevator(false, 0.2, 10, 2));
		
		buttonManager.setToggle(10, 2, new WedgeToggle());
		buttonManager.setToggle(11, 2, new RCGrabberToggle());*/
		
		// Bind buttons for joysticks
		buttonManager.runOnPress(9, 1, new TurnToZero());
		buttonManager.runOnPress(8, 1, new ResetGyro());
		buttonManager.runWhilePressed(11, 0, new MainConveyorForward(11, 0));
		buttonManager.runWhilePressed(10, 0, new MainConveyorBackward(10, 0));
		
		buttonManager.runWhilePressed(6, 0, new LiftConveyorForward(6, 0));
		buttonManager.runWhilePressed(7, 0, new LiftConveyorBackward(7, 0));
		
		buttonManager.runWhilePressed(8, 0, new RCGrabberLeft(8, 0));
		buttonManager.runWhilePressed(9, 0, new RCGrabberRight(9, 0));
		
		buttonManager.runWhilePressed(6, 1, new MoveElevator(true, 0.5, 6, 1));
		buttonManager.runWhilePressed(7, 1, new MoveElevator(false, 0.25, 7, 1));
		
		buttonManager.runOnPress(3, 0, new RaiseRcGrabber());
		buttonManager.runOnPress(2, 0, new LowerRcGrabber());
		
		buttonManager.runOnPress(11, 1, new PlowExtend());
		buttonManager.runOnPress(10, 1, new PlowRetract());
		
		// PS3 Controller buttons
		
		/* buttonManager.runWhilePressed(5, 2, new LiftConveyerForward());
		buttonManager.runWhilePressed(4, 2, new LiftConveyerBackward());
		buttonManager.runOnPress(0, 2, new RaiseRcGrabber());
		buttonManager.runOnPress(2, 2, new LowerRcGrabber()); */
		
		
	}
}
