package org.usfirst.frc.team4761.robot;

public class Accumulator {
	private double bucket = 0;
	
	public void add (double input) {
		if (Math.abs(input) > 0.01) {
			bucket += input * 0.5;
		}
	}
	
	public double getValue () {
		return bucket;
	}
}