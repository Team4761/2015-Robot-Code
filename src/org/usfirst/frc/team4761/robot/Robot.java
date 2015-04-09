package org.usfirst.frc.team4761.robot;

import org.simonandrews.robolog.LogManager;
import org.usfirst.frc.team4761.robot.commandgroups.DriveToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.PushToAuto;
import org.usfirst.frc.team4761.robot.commandgroups.StopAutonomous;
import org.usfirst.frc.team4761.robot.commandgroups.Teleop;
import org.usfirst.frc.team4761.robot.commandgroups.TwoBarrelAutonomous;
import org.usfirst.frc.team4761.robot.sensors.GyroThread;
import org.usfirst.frc.team4761.robot.subsystems.CanCrusher;
import org.usfirst.frc.team4761.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4761.robot.subsystems.Elevator;
import org.usfirst.frc.team4761.robot.subsystems.LiftConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.MainConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.RcArm;
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
	public static RcGrabber rcGrabber = new RcGrabber();
	public static RcGrabberBase rcGrabberBase = new RcGrabberBase();
	public static LiftConveyorBelt liftConveyorBelt = new LiftConveyorBelt();
	public static RcArm rcArm = new RcArm();
	public static CanCrusher canCrusher = new CanCrusher();
	
	public static OI oi;
	public Command teleop, autonomousCommand, autonomous, driveToAuto, debugAuto, pushToAuto, twoBarrelAuto, stopAuto;
		
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		teleop = new Teleop();
		
		LogManager.setMinimumLevel(RobotMap.minLogLevel);
		
		Thread thread = new Thread(new GyroThread());
		thread.start();
	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		String sAuto = "StopAuto";
		
		int autoMode = 0;
		if (oi.joysticks[2].getRawButton(4)) {
			autoMode += 4;
		}
		
		if (oi.joysticks[2].getRawButton(3)) {
			autoMode += 2;
		}
		
		if (oi.joysticks[2].getRawButton(5)) {
			autoMode += 1;
		}
		
		int angle = 90;
		if (!oi.joysticks[2].getRawButton(2)) {
			angle = -90;
		}
		
		pushToAuto = new PushToAuto(angle);
		driveToAuto = new DriveToAuto(angle);
		twoBarrelAuto = new TwoBarrelAutonomous(angle);
		stopAuto = new StopAutonomous(angle);
		
		SmartDashboard.putNumber("Autonomous Angle: ", angle);
		
		// Buttons need to be changed when missile switches are wired
		if (autoMode == 4) {
			sAuto = "PushToAuto";
			autonomousCommand = pushToAuto;
		} else if (autoMode == 2) {
			sAuto = "DriveToAuto";
			autonomousCommand = driveToAuto;
		} else {
			sAuto = "StopAuto";
			autonomousCommand = stopAuto;
		}
		
		//autonomousCommand = debugAuto; // Autonomous Chooser override
		
		System.out.println("AutoMode: " + autoMode);
		
		SmartDashboard.putString("Autonomous Choosen: ", sAuto);
	}
	
	public void autonomousInit() {
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