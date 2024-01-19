package domain.network;

import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class InputProcessor extends Thread {
	
	public enum InputTypes {
		
	}
	
	private static InputProcessor instance;
	
	private InputProcessor() {}
	 
	public static synchronized InputProcessor getInstance() {
		
		if (instance==null)
			instance = new InputProcessor();
		return instance;
		
	}
	
	public Object processInput(Object input) {
		
		
		return null;
		
	}

}


