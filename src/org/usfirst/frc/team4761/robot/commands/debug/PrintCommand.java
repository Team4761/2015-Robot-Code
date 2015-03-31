package org.usfirst.frc.team4761.robot.commands.debug;

import edu.wpi.first.wpilibj.command.Command;

public class PrintCommand extends Command 
{
	String q;
	int x;
	static int cnum = 0;
	public PrintCommand(String s)
	{
		q = s;
		setTimeout(5);
	}
	public void execute()
	{
		System.out.println("\tCommand #" + x + " [" + timeSinceInitialized() + "]: " + q);
	}
	@Override
	protected void initialize() {
		cnum++;
		x = cnum;
		System.out.println("Command #" + x + " initialized.");
	}
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	@Override
	protected void end() {
		System.out.println("/t/tCommand #" + x + " reached its EoL.");
	}
	@Override
	protected void interrupted() {
		System.out.println("/t/tCommand #" + x + " was interrupted.");
	}
}
