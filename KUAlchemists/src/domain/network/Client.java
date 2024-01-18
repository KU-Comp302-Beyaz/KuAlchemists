package domain.network;

import java.net.*;
import java.io.*;

public class Client {

//	public static void main(String[] args) {

	public void openServer() throws ClassNotFoundException {
		// Server's IP and port.
		String serverName = "172.20.148.220";
		int port = 6068;
		
		
		

		try {
			
//			InetAddress ip = InetAddress.getLocalHost();
//		    String hostname = ip.getHostName();
			
			// Create new socket for connection
			System.out.println("Connecting to " + serverName + " on port " + port);
			@SuppressWarnings("resource")
			Socket client = new Socket(serverName, port);

			ObjectInputStream fromServer = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream toServer = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream fromUser = new ObjectInputStream(System.in);

            System.out.println((String) fromServer.readObject());

            while (true) {
                System.out.print("Enter your choice (rock, paper, scissors): ");
                String choice = (String) fromUser.readObject();
                toServer.writeObject(choice);

                String result = (String) fromServer.readObject();
                System.out.println("Result: " + result);
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
