package org.usfirst.frc.team4761.robot;

import static edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putBoolean;
import static edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putNumber;

import org.usfirst.frc.team4761.robot.buttons.LiftConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.MoveElevator;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberLeft;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberRight;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.buttons.TurnToZero;
import org.usfirst.frc.team4761.robot.commandgroups.TurnInDown;
import org.usfirst.frc.team4761.robot.commands.KillAllCommands;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.GoToElevatorConveyor;
import org.usfirst.frc.team4761.robot.commands.drivetrain.DriveToTotes;
import org.usfirst.frc.team4761.robot.commands.drivetrain.SnapToNearestCardinal;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToStackTop;
import org.usfirst.frc.team4761.robot.commands.plower.PlowExtend;
import org.usfirst.frc.team4761.robot.commands.plower.PlowRetract;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.LowerRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RaiseRcGrabber;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// With XBox controller
	public Joystick[] joysticks = {new Joystick(0), new Joystick(1), new Joystick(2)};
	
	// Without XBox controller
	//public Joystick[] joysticks = {new Joystick(0), new Joystick(1)};
	
	ButtonManager buttonManager = new ButtonManager();
	
	public OI () {
		putBoolean("Step Autonomous", false);
		putBoolean("Three Barrels Autonomous", true);
		putBoolean("Drive To Auto-Zone", false);
		putBoolean("Push Barrel To Auto-Zone", false);
		
		putNumber("P", 0.025);
		putNumber("I", 0);
		putNumber("D", 0.02);
		
		if (RobotMap.robot == 1) {
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
			buttonManager.runOnPress(8, 1, new ResetGyro(90));
			buttonManager.runOnPress(3, 1, new KillAllCommands());
			
			buttonManager.runOnPress(1, 1, new MoveElevatorToStackTop());
			buttonManager.runOnPress(1, 0, new GoToElevatorConveyor());
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
			
			buttonManager.runOnPress(2, 1, new TurnInDown());
			
			// Bind buttons for XBox Controller
			buttonManager.runWhilePressed(4, 2, new RaiseRcGrabber());
			buttonManager.runWhilePressed(1, 2, new LowerRcGrabber());
			buttonManager.runWhilePressed(3, 2, new RCGrabberLeft(3, 2));
			buttonManager.runWhilePressed(2, 2, new RCGrabberRight(2, 2));
			buttonManager.runOnPress(10, 2, new SnapToNearestCardinal());
			buttonManager.runOnPress(6, 2, new TurnInDown());
			buttonManager.runOnPress(8, 2, new Stop());
			buttonManager.runOnPress(7, 2, new DriveToTotes());
		} else {
			buttonManager.runOnPress(8, 1, new ResetGyro(90));
		}
	}
}
