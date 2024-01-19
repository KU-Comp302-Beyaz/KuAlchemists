package domain.network;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.BoardWindow;

import java.io.*;

public class Server extends Thread {
	
	private static Server instance;
	private ServerSocket serverSocket;
	private String ipAddress = "INSERT_IP_ADDRESS";
	private int host = 6080;
	private int playerNumber; //ToDo: Game'den ip address ve player number çekmen lazım.
	
	public static synchronized Server getInstance() throws IOException {
		
		if (instance==null)
			instance = new Server(6080);
		return instance;
		
	}
	

	private Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	@Override
	public void run() {
		
		while (Client.getAllClients().size() != playerNumber) {
			Socket socket;
			try {
				socket = serverSocket.accept();
				Client c = new Client(socket,ipAddress,host);
				Client.getAllClients().add(c);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (int i=0; i<Client.getAllClients().size(); i++) {
			try {
				Client.getAllClients().get(i).getObjOut().writeObject(BoardWindow.getBoardWindow());
			} catch (IOException e) {
				e.printStackTrace();
			};
		}
		
		
		
		
	}
	
	
	
	
}