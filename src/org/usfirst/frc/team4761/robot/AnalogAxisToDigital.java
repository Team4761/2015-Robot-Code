package org.usfirst.frc.team4761.robot;

public class AnalogAxisToDigital {
	private int axis, joystick;
	
	public AnalogAxisToDigital (int axis, int joystick) {
		this.axis = axis;
		this.joystick = joystick;
	}
	
	public boolean get () {
		// Values need to be tested
		if (Robot.oi.joysticks[joystick].getRawAxis(axis) > 0.5) {
			return true;
		} else {
			return false;
		}
	}
}