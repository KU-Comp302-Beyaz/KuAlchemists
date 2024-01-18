package domain.network;

import java.net.*;
import java.io.*;

public class Client {

//	public static void main(String[] args) {

	public void openServer() {
		// Server's IP and port.
		String serverName = "172.21.224.166";
		int port = 6068;
		
		
		

		try {
			
//			InetAddress ip = InetAddress.getLocalHost();
//		    String hostname = ip.getHostName();
			
			// Create new socket for connection
			System.out.println("Connecting to " + serverName + " on port " + port);
			@SuppressWarnings("resource")
			Socket client = new Socket(serverName, port);

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(fromServer.readLine());

            while (true) {
                System.out.print("Enter your choice (rock, paper, scissors): ");
                String choice = fromUser.readLine();
                toServer.println(choice);

                String result = fromServer.readLine();
                System.out.println("Result: " + result);
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
