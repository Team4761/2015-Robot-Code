package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.simonandrews.robolog.LogManager;
import org.usfirst.frc.team4761.robot.commandgroups.Autonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DriveToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.NoWedgeAuto;
import org.usfirst.frc.team4761.robot.commandgroups.Teleop;
import org.usfirst.frc.team4761.robot.sensors.GyroThread;
import org.usfirst.frc.team4761.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Elevator elevator = new Elevator();
	public static final MainConveyorBelt mainConveyorBelt = new MainConveyorBelt();
	public static final Plower plower = new Plower();
	public static final RcGrabber rcGrabber = new RcGrabber();
	public static final RcGrabberBase rcGrabberBase = new RcGrabberBase();
	public static final LiftConveyorBelt liftConveyorBelt = new LiftConveyorBelt();
	
	public static OI oi;
	public Command teleop;
	
	Command autonomousCommand;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		teleop = new Teleop();
		autonomousCommand = new NoWedgeAuto();
		
		LogManager.setMinimumLevel(RobotMap.minLogLevel);
		
		Thread thread = new Thread(new GyroThread());
		thread.start();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		// Assign autonomous
		if (SmartDashboard.getBoolean("Step Autonomous")) {
			autonomousCommand = new Autonomous();
		} else if (SmartDashboard.getBoolean("Three Barrels Autonomous")) {
			autonomousCommand = new NoWedgeAuto();
		} else if (SmartDashboard.getBoolean("Drive To Auto-Zone")) {
			autonomousCommand = new DriveToAuto();
		}
		
		if (autonomousCommand != null) autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
		teleop.start();
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
