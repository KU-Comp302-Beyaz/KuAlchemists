package domain.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Client {

	// Server's IP and port.
	String serverName = "127.0.0.1";
	int port = 6068;
    private Socket socket;


    public void connectToServer() {
		try {
			
			// Create new socket for connection
			System.out.println("Connecting to " + serverName + " on port " + port);
			@SuppressWarnings("resource")
			Socket client = new Socket(serverName, port);
	
	        BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
	        BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
	
	        System.out.println(fromServer.readLine());
	
	        while (true) {
	            
	        	
	        	
	        }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
