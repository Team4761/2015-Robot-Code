package org.usfirst.frc.team4761.robot;

import org.simonandrews.robolog.LogManager;
import org.usfirst.frc.team4761.robot.commandgroups.Autonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DebugAutonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DriveToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.NoWedgeAuto;
import org.usfirst.frc.team4761.robot.commandgroups.Teleop;
import org.usfirst.frc.team4761.robot.commands.WatchForAutoEnd;
import org.usfirst.frc.team4761.robot.commands.elevator.GoToPosition;
import org.usfirst.frc.team4761.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4761.robot.subsystems.Elevator;
import org.usfirst.frc.team4761.robot.subsystems.LiftConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.MainConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.Plower;
import org.usfirst.frc.team4761.robot.subsystems.RcGrabber;
import org.usfirst.frc.team4761.robot.subsystems.RcGrabberBase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static MainConveyorBelt mainConveyorBelt;
	public static Plower plower;
	public static RcGrabber rcGrabber;
	public static RcGrabberBase rcGrabberBase;
	public static LiftConveyorBelt liftConveyorBelt;
	public static RobotMap robotMap;
	public static Robot robot;
	public static OI oi;
	public boolean autoDone = false;
	public Command teleop;
	
	public Command autonomousCommand;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		robot = this;
		robotMap = new RobotMap();
		oi = new OI();
		teleop = new Teleop();
		driveTrain = new DriveTrain();
		elevator = new Elevator();
		if (Robot.robotMap.robot == 1) {
			autonomousCommand = new NoWedgeAuto();

			mainConveyorBelt = new MainConveyorBelt();
			plower = new Plower();
			rcGrabber = new RcGrabber();
			rcGrabberBase = new RcGrabberBase();
			liftConveyorBelt = new LiftConveyorBelt();
		}
		
		LogManager.setMinimumLevel(Robot.robotMap.minLogLevel);
		
		// We are using a different gyro
		//Thread thread = new Thread(new GyroThread());
		//thread.start();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		new GoToPosition(1000).start();
		//elevator.set(0.5);
		/*
		new WatchForAutoEnd().start();
		if (Robot.robotMap.robot == 1) {
			// Assign autonomous
			if (SmartDashboard.getBoolean("Step Autonomous")) {
				autonomousCommand = new Autonomous();
			} else if (SmartDashboard.getBoolean("Three Barrels Autonomous")) {
				autonomousCommand = new NoWedgeAuto();
			} else if (SmartDashboard.getBoolean("Drive To Auto-Zone")) {
				autonomousCommand = new DriveToAuto();
			} else if (SmartDashboard.getBoolean("Debug Autonomous")) {
				autonomousCommand = new DebugAutonomous();
			}
		
			if (autonomousCommand != null) autonomousCommand.start();
		}*/
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
	}
	
	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}