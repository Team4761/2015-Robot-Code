package org.usfirst.frc.team4761.robot;

import static edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putNumber;

import org.usfirst.frc.team4761.robot.buttons.AutoStack;
import org.usfirst.frc.team4761.robot.buttons.AutoTote;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.LowerElevator;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberLeft;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberRight;
import org.usfirst.frc.team4761.robot.buttons.RCGrabberToggle;
import org.usfirst.frc.team4761.robot.buttons.RaiseElevator;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commandgroups.TurnInDown;
import org.usfirst.frc.team4761.robot.commands.KillAllCommands;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.GoToElevatorConveyor;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToStackTop;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.LowerRcGrabber;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RaiseRcGrabber;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// With XBox controller, button board left, button board right
	public Joystick[] joysticks = {new Joystick(0), new Joystick(1), new Joystick(2)};
	
	ButtonManager buttonManager = new ButtonManager();
	
	public OI () {
		putNumber("P", 0.03);
		putNumber("I", 0);
		putNumber("D", 0);
		putNumber("Elevator Speed: ", 0.35);
		
		// Bind buttons for button boards
		buttonManager.runWhilePressed(9, 1, new MainConveyorForward(9, 1));
		buttonManager.runWhilePressed(8, 1, new MainConveyorBackward(8, 1));
		
		buttonManager.runWhilePressed(11, 1, new LiftConveyorForward(11, 1));
		buttonManager.runWhilePressed(10, 1, new LiftConveyorBackward(10, 1));
		
		buttonManager.runWhilePressed(15, 1, new RCGrabberLeft(15, 1));
		buttonManager.runWhilePressed(14, 1, new RCGrabberRight(14, 1));
		
		buttonManager.runWhilePressed(18, 1, new RaiseElevator(18, 1));
		buttonManager.runWhilePressed(16, 1, new LowerElevator(16, 1));
		
		buttonManager.setToggle(1, 1, new RCGrabberToggle());
		
		buttonManager.runOnPress(5, 1, new MoveElevatorToStackTop());
		buttonManager.runOnPress(6, 1, new GoToElevatorConveyor());
		buttonManager.runOnPress(7, 1, new TurnInDown());

		buttonManager.runOnPress(19, 1, new AutoTote(19, 1));
		//buttonManager.runOnceOnHold(17, 1, new AutoStack(17, 1));
		
		buttonManager.runOnPress(4, 1, new ResetGyro(90));
		buttonManager.runOnPress(3, 1, new KillAllCommands());
		
		// Bind buttons for joysticks (KEEP THESE HERE IN CASE OF BUTTON BOARD FAILURE)
		/*buttonManager.runOnPress(8, 1, new ResetGyro(90));
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
		
		buttonManager.runOnPress(2, 1, new TurnInDown());*/
		
		// Bind buttons for XBox Controller
		buttonManager.runWhilePressed(4, 0, new RaiseRcGrabber());
		buttonManager.runWhilePressed(1, 0, new LowerRcGrabber());
		buttonManager.runWhilePressed(3, 0, new RCGrabberLeft(3, 0));
		buttonManager.runWhilePressed(2, 0, new RCGrabberRight(2, 0));
		buttonManager.runOnPress(7, 0, new ResetGyro(90));
		buttonManager.runOnPress(8, 0, new Stop());
	}
}
