package org.usfirst.frc.team4761.robot;

import java.io.Serializable;

public class DataPacket implements Serializable
{
	public String key;
	public Object data;
	public DataPacket(String k, Object d)
	{
		key = k;
		data = d;
	}
}