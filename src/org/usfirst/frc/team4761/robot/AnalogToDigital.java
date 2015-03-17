package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class AnalogToDigital {
	private AnalogInput analog;
	
	public AnalogToDigital (int port) {
		this.analog = new AnalogInput(port);
	}
	
	public boolean get () {
		// Values need to be tested
		if (analog.getVoltage() > 0) {
			return true;
		} else {
			return false;
		}
	}
}