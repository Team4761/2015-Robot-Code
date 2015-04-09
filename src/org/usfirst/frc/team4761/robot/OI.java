package org.usfirst.frc.team4761.robot;

import org.usfirst.frc.team4761.robot.buttons.AutoStack;
import org.usfirst.frc.team4761.robot.buttons.AutoTote;
import org.usfirst.frc.team4761.robot.buttons.CanCrusherToggle;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.LiftConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.ElevatorDown;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorBackward;
import org.usfirst.frc.team4761.robot.buttons.MainConveyorForward;
import org.usfirst.frc.team4761.robot.buttons.ElevatorUp;
import org.usfirst.frc.team4761.robot.buttons.RcGrabberLeft;
import org.usfirst.frc.team4761.robot.buttons.RcGrabberRight;
import org.usfirst.frc.team4761.robot.buttons.RcGrabberToggle;
import org.usfirst.frc.team4761.robot.buttons.ResetGyro;
import org.usfirst.frc.team4761.robot.commandgroups.LazyButton;
import org.usfirst.frc.team4761.robot.commands.KillAllCommands;
import org.usfirst.frc.team4761.robot.commands.Stop;
import org.usfirst.frc.team4761.robot.commands.conveyorbelts.GoToElevatorConveyor;
import org.usfirst.frc.team4761.robot.commands.elevator.MoveElevatorToStackTop;
import org.usfirst.frc.team4761.robot.commands.rcarm.RcArmMove;
import org.usfirst.frc.team4761.robot.commands.rcarm.RcArmType;
import org.usfirst.frc.team4761.robot.commands.rcarm.TestServo;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberMove;
import org.usfirst.frc.team4761.robot.commands.rcgrabber.RcGrabberType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// With XBox controller, button board left, button board right
	public Joystick[] joysticks = {new Joystick(0), new Joystick(1), new Joystick(2)};
	
	ButtonManager buttonManager = new ButtonManager();
	
	public OI () {
		// Bind buttons for button boards
		buttonManager.runWhilePressed(9, 1, new MainConveyorForward(9, 1));
		buttonManager.runWhilePressed(8, 1, new MainConveyorBackward(8, 1));
		
		buttonManager.runWhilePressed(11, 1, new LiftConveyorForward(11, 1));
		buttonManager.runWhilePressed(10, 1, new LiftConveyorBackward(10, 1));
		
		buttonManager.runWhilePressed(15, 1, new RcGrabberLeft(15, 1));
		buttonManager.runWhilePressed(14, 1, new RcGrabberRight(14, 1));
		
		buttonManager.runWhilePressed(18, 1, new ElevatorUp(18, 1));
		buttonManager.runWhilePressed(16, 1, new ElevatorDown(16, 1));
		
		buttonManager.setToggle(1, 1, new RcGrabberToggle());
		
		buttonManager.setToggle(2, 1, new CanCrusherToggle());
		
		buttonManager.runOnPress(5, 1, new MoveElevatorToStackTop());
		buttonManager.runOnPress(6, 1, new GoToElevatorConveyor());
		buttonManager.runOnPress(7, 1, new LazyButton());

		buttonManager.runOnceOnHold(19, 1, new AutoTote(19, 1));
		buttonManager.runOnceOnHold(17, 1, new AutoStack(17, 1));

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
		buttonManager.runWhilePressed(4, 0, new RcGrabberMove(RcGrabberType.UP));
		buttonManager.runWhilePressed(1, 0, new RcGrabberMove(RcGrabberType.DOWN));
		buttonManager.runWhilePressed(3, 0, new RcGrabberLeft(3, 0));
		buttonManager.runWhilePressed(2, 0, new RcGrabberRight(2, 0));
		buttonManager.runOnPress(7, 0, new ResetGyro(90));
		buttonManager.runOnPress(8, 0, new Stop());
		
		SmartDashboard.putData("Extend Pusher", new RcArmMove(RcArmType.EXTEND));
		SmartDashboard.putData("Retract Pusher", new RcArmMove(RcArmType.RETRACT));
		SmartDashboard.putData("Open Servo", new RcArmMove(255,0));
		SmartDashboard.putData("Close Servo", new RcArmMove(0, 0));
		SmartDashboard.putData("Winch In", new RcArmMove(RcArmType.WINCH_IN, 1));
		SmartDashboard.putData("Winch Out", new RcArmMove(RcArmType.WINCH_OUT, 1));
	}
}
