package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4761.robot.commandgroups.Autonomous;
import org.usfirst.frc.team4761.robot.commandgroups.Teleop;
import org.usfirst.frc.team4761.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4761.robot.subsystems.Elevator;
import org.usfirst.frc.team4761.robot.subsystems.LowerConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.Plower;
import org.usfirst.frc.team4761.robot.subsystems.RCGrabber;
import org.usfirst.frc.team4761.robot.subsystems.RCSpinner;
import org.usfirst.frc.team4761.robot.subsystems.UpperConveyerBelt;
import org.usfirst.frc.team4761.robot.commands.RcLower;
import org.usfirst.frc.team4761.robot.commands.RcOff;
import org.usfirst.frc.team4761.robot.commands.RcLift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final RCGrabber rcGrabber = new RCGrabber();
	public static final RCSpinner rcSpinner = new RCSpinner();
	public static final Plower plower = new Plower();
	public static final Elevator elevator = new Elevator();
	public static final LowerConveyorBelt lowerConveyorBelt = new LowerConveyorBelt();
	public static final UpperConveyerBelt upperConveyorBelt = new UpperConveyerBelt();
	
	public static OI oi;
	public Command teleOpCommand;
	public Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit () {
		oi = new OI();
		teleOpCommand = new Teleop();
		autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic () {
		Scheduler.getInstance().run();
	}

    public void autonomousInit () {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic () {
        Scheduler.getInstance().run();
    }

    public void teleopInit () {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleOpCommand.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit () {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic () {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic () {
        LiveWindow.run();
    }
}
