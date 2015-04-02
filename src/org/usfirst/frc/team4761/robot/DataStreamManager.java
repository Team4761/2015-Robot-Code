package org.usfirst.frc.team4761.robot;

import java.net.*;
import java.io.*;
public class DataStreamManager implements Runnable
{
	ServerSocket ss;
	Socket s;
	ObjectOutputStream out;
	boolean inited = false;
	public DataStreamManager()
	{
		try
		{
			ss = new ServerSocket(1707, 50, InetAddress.getByName("roboRIO-4761.local"));
			System.out.println("Server started at: " + ss.getInetAddress().getHostAddress()+":1707");
			new Thread(this).start();
		}
		catch (Exception e)
		{
			System.err.println("Error initializing Data Stream.");
			e.printStackTrace();
		}
	}
	public void send(DataPacket packet)
	{
		if (!inited)
			return;
		try 
		{
			out.writeObject(packet);
			out.flush();
		} 
		catch (Exception e)
		{
			System.out.println("Error sending packet.");
		}
	}
	public void run()
	{
		try
		{
			s = ss.accept();
			System.out.println("A client has connected!");
			out = new ObjectOutputStream(s.getOutputStream());
			inited = true;
		}
		catch (Exception e)
		{
			System.err.println("Error setting up Data Stream Socket.");
		}
	}
}
