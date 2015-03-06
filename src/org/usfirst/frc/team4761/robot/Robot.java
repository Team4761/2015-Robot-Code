package org.usfirst.frc.team4761.robot;

import org.simonandrews.robolog.LogManager;
import org.usfirst.frc.team4761.robot.commandgroups.Autonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DebugAutonomous;
import org.usfirst.frc.team4761.robot.commandgroups.DriveToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.NoWedgeAuto;
import org.usfirst.frc.team4761.robot.commandgroups.PushToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.Teleop;
import org.usfirst.frc.team4761.robot.sensors.GyroThread;
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
	public static RobotMap robotMap = new RobotMap();
	public static DriveTrain driveTrain = new DriveTrain();
	public static Elevator elevator = new Elevator();
	public static MainConveyorBelt mainConveyorBelt = new MainConveyorBelt();
	public static Plower plower = new Plower();
	public static RcGrabber rcGrabber = new RcGrabber();
	public static RcGrabberBase rcGrabberBase = new RcGrabberBase();
	public static LiftConveyorBelt liftConveyorBelt = new LiftConveyorBelt();
	
	public static OI oi;
	public Command teleop;
	
	Command autonomousCommand, autonomous, wedgeAuto, driveToAuto, debugAuto, pushToAuto;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		teleop = new Teleop();
		
		if (RobotMap.robot == 1) {
			autonomousCommand = new PushToAuto();
		}
		
		LogManager.setMinimumLevel(RobotMap.minLogLevel);
		
		Thread thread = new Thread(new GyroThread());
		thread.start();
		autonomous = new PushToAuto();
		wedgeAuto = new NoWedgeAuto();
		driveToAuto = new DriveToAuto();
		debugAuto = new DebugAutonomous();
		pushToAuto = new PushToAuto();
		int currentAuto = Settings.read("AutoMode");

		switch (currentAuto) {
			case 0:
				SmartDashboard.putBoolean("Step Autonomous", true);
			case 1:
				SmartDashboard.putBoolean("Three Barrels Autonomous", true);
			case 2:
				SmartDashboard.putBoolean("Drive To Auto-Zone", true);
			case 3:
				SmartDashboard.putBoolean("Debug Autonomous", true);
			case 4:
				SmartDashboard.putBoolean("Push Barrel To Auto-Zone", true);	
		}
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		// Check autonomous
		int autoModeOverride = -1;
		if (!(SmartDashboard.getBoolean("Step Autonomous") || SmartDashboard.getBoolean("Three Barrels Autonomous") || SmartDashboard.getBoolean("Drive To Auto-Zone") || SmartDashboard.getBoolean("Debug Autonomous"))) {
			autoModeOverride = Settings.read("AutoMode");
		}
		if (SmartDashboard.getBoolean("Step Autonomous") || autoModeOverride == 0) {
			autonomousCommand = autonomous;
			Settings.write("AutoMode", 0);
		} else if (SmartDashboard.getBoolean("Three Barrels Autonomous") || autoModeOverride == 1) {
			autonomousCommand = wedgeAuto;
			Settings.write("AutoMode", 1);
		} else if (SmartDashboard.getBoolean("Drive To Auto-Zone") || autoModeOverride == 2) {
			autonomousCommand = driveToAuto;
			Settings.write("AutoMode", 2);
		} else if (SmartDashboard.getBoolean("Debug Autonomous") || autoModeOverride == 3) {
			autonomousCommand = debugAuto;
			Settings.write("AutoMode", 3);
		} else if (SmartDashboard.getBoolean("Push Barrel To Auto-Zone") || autoModeOverride == 4) {
			autonomousCommand = pushToAuto;
			Settings.write("AutoMode", 4);
		} else {
			System.err.println("Missing/invalid auto selected!");
		}
	}
	
	public void autonomousInit() {
		if (RobotMap.robot == 1) {
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