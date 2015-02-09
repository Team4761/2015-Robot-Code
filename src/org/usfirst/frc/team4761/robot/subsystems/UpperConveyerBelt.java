package org.usfirst.frc.team4761.robot.subsystems;

import edu.wpi.first.wpilibj.SafePWM;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UpperConveyerBelt extends Subsystem {
	//FIXME: Update this entire class for when the actual hardware comes out.
	private static final int sc_port = (Integer) null;
	private static double speed = 0.3;
    public static Victor speedController = new Victor(sc_port); //actual hw may not be a victor
	public void initDefaultCommand() {
    }
	public static void go() {
		if(speed > 0) { //Conveyor belt can only go one way
			speedController.set(speed);
		}
	}
}