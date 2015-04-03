package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4761.robot.*;

public class SendGyroData extends Command
{
	DataPacket x, y, z;
	@Override
	protected void initialize() {
		x = new DataPacket("Gyro_X", 0);
	}

	@Override
	protected void execute() {
		x.data = RobotMap.imu.getYaw();
		Robot.dataManager.send(x);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
