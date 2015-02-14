package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4761.robot.commandgroups.Autonomous;
import org.usfirst.frc.team4761.robot.commandgroups.Teleop;
import org.usfirst.frc.team4761.robot.sensors.GyroThread;
import org.usfirst.frc.team4761.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4761.robot.subsystems.Elevator;
import org.usfirst.frc.team4761.robot.subsystems.LiftConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.MainConveyorBelt;
import org.usfirst.frc.team4761.robot.subsystems.Plower;
import org.usfirst.frc.team4761.robot.subsystems.RcGrabber;
import org.usfirst.frc.team4761.robot.subsystems.RcGrabberBase;

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
	
	public static Compressor compressor;
	
	public static OI oi;
	public Command teleop;

    Command autonomousCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit () {
		oi = new OI();
		teleop = new Teleop();
		autonomousCommand = new Autonomous();
		
	   	Thread thread = new Thread(new GyroThread());
    	thread.start();
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
        teleop.start();
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
        if (compressor==null){
        	compressor = new Compressor();
        }
        if(!compressor.enabled())System.out.println("Compressor isn't enabled?");
    }
}
