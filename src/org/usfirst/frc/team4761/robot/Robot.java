package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.simonandrews.robolog.LogManager;
import org.usfirst.frc.team4761.robot.commandgroups.Autonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DebugAutonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DriveToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.NoWedgeAuto;
import org.usfirst.frc.team4761.robot.commandgroups.PushToAuto;
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
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static MainConveyorBelt mainConveyorBelt;
	public static Plower plower;
	public static RcGrabber rcGrabber;
	public static RcGrabberBase rcGrabberBase;
	public static LiftConveyorBelt liftConveyorBelt;
	public static RobotMap robotMap = new RobotMap();
	
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
		driveTrain = new DriveTrain();
		
		if (RobotMap.robot == 1) {
			autonomousCommand = new NoWedgeAuto();
			elevator = new Elevator();
			mainConveyorBelt = new MainConveyorBelt();
			plower = new Plower();
			rcGrabber = new RcGrabber();
			rcGrabberBase = new RcGrabberBase();
			liftConveyorBelt = new LiftConveyorBelt();
		}
		
		LogManager.setMinimumLevel(RobotMap.minLogLevel);
		
		Thread thread = new Thread(new GyroThread());
		thread.start();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		if (RobotMap.robot == 1) {
			// Assign autonomous
			int autoModeOverride = -1;
			if (!(SmartDashboard.getBoolean("Step Autonomous") || SmartDashboard.getBoolean("Three Barrels Autonomous") || SmartDashboard.getBoolean("Drive To Auto-Zone") || SmartDashboard.getBoolean("Debug Autonomous")))
					autoModeOverride = Settings.read("AutoMode");
			if (SmartDashboard.getBoolean("Step Autonomous") || autoModeOverride == 0) {
				autonomousCommand = new Autonomous();
				Settings.write("AutoMode", 0);
			} else if (SmartDashboard.getBoolean("Three Barrels Autonomous") || autoModeOverride == 1) {
				autonomousCommand = new NoWedgeAuto();
				Settings.write("AutoMode", 1);
			} else if (SmartDashboard.getBoolean("Drive To Auto-Zone") || autoModeOverride == 2) {
				autonomousCommand = new DriveToAuto();
				Settings.write("AutoMode", 2);
			} else if (SmartDashboard.getBoolean("Debug Autonomous") || autoModeOverride == 3) {
				autonomousCommand = new DebugAutonomous();
				Settings.write("AutoMode", 3);
			} else if (SmartDashboard.getBoolean("Push Barrel To Auto-Zone") || autoModeOverride == 4) {
				autonomousCommand = new PushToAuto();
				Settings.write("AutoMode", 4);
			} else {
				System.err.println("Missing/invalid auto selected!");
			}
		
			if (autonomousCommand != null) autonomousCommand.start();
		}
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