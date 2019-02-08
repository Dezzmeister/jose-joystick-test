package main;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

public class Main {

	public static void main(String[] args) {
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
		Controller joystick = null;
		
		for (Controller c : controllers) {
			System.out.println(c.getName() + " " + c.getType());
			if (c.getType() == Type.STICK) {
				joystick = c;
			}
		}
		
		while (joystick.poll()) {
			Component[] components = joystick.getComponents();
			//components[] contains all the joystick's axes and button values
			//0 is throttle
			//1 is y axis
			//Code example here: https://github.com/jinput/jinput/wiki/Code-Example
			System.out.println(components[1].getPollData());
		}
	}

}
