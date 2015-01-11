package org.usfirst.frc.team4761.robot;

public class Adjust {
	private Accumulator accumulator;
	
	public Adjust () {
		accumulator = RobotMap.joystickAccumulator;
	}
	
	public void add (double input) {
		accumulator.add(input);
	}
	
	public double difference (double ac) {
		return (accumulator.getValue() - ac) * 0.025;
	}
	
	public double getValue () {
		return accumulator.getValue();
	}
}
