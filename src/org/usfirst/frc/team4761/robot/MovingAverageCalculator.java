package org.usfirst.frc.team4761.robot;

/**
 * Class for working with and calculating moving averages. Can be used to
 * smooth out output to take care of spikes.
 */
public class MovingAverageCalculator {
	private int size;
	private double total = 0d;
	private int index = 0;
	private double samples[];

	/**
	 * Make a new Moving Average Calculator.
	 * @param size How many digits do you want to average at a time?
	 */
	public MovingAverageCalculator(int size) {
		this.size = size;
		samples = new double[size];
		for (int i = 0; i < size; i++) samples[i] = 0d;
	}

	/**
	 * Add a new number onto your existing dataset.
	 * @param x Number to add on
	 */
	public void add(double x) {
		total -= samples[index];
		samples[index] = x;
		total += x;
		if (++index == size) index = 0; // cheaper than modulus
	}

	/**
	 * Get the current average
	 * @return Total of all data
	 */
	public double getAverage() {
		return total / size;
	}
}
