package org.usfirst.frc.team4761.robot.commands;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.usfirst.frc.team4761.robot.DataPacket;
import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.HSLImage;
import edu.wpi.first.wpilibj.image.ImageBase;
import edu.wpi.first.wpilibj.image.MonoImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class SendCameraImage extends Command{

	DataPacket packet;
	AxisCamera cam;
	byte[] fakeImage = {	(byte)255, (byte)0, (byte)0, (byte)0, (byte)255, (byte)0, (byte)0, (byte)0, (byte)255, 
							(byte)0, (byte)0, (byte)0, (byte)0, (byte)128, (byte)0, (byte)0, (byte)0, (byte)128,
							(byte)0, (byte)0, (byte)0, (byte)128, (byte)128, (byte)128, (byte)255, (byte)255, (byte)255};
	@Override
	protected void initialize() { 		packet = new DataPacket("Camera Image", null);
		//cam = new AxisCamera("Camera");	// this should contain the camera's actual name!
	}

	@Override
	protected void execute() {
		try {
			readImage();
			Robot.dataManager.send(packet);	// send it!
		} catch (Exception e) {
			packet.data = e.getMessage();
			Robot.dataManager.send(packet);
			e.printStackTrace();
		}
		
	}
	public void readImage() throws Exception
	{
		MonoImage img = new MonoImage();	// write image to a file
		//img.write("/tmp/test.png");
		//Files.readAllBytes(Paths.get("/tmp/test.png"));
		packet.data = fakeImage;	// data to send
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
