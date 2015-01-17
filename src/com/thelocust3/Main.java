package com.thelocust3;

public class Main {
	public static void main (String[] args) {
		RunCommand cmd = new RunCommand();
		cmd.run("top -l 1", "PhysMem");
	}
}
