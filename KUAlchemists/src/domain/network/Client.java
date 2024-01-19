package domain.network;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import java.io.*;

public class Client extends Thread{

	private Socket clientSocket;
	private String ipAddress;
	private int port;
	private ObjectInputStream objIn;
	private ObjectOutputStream objOut;
	private static ArrayList<Client> allClients;
	
	public Client(Socket socket, String ipAddress, int port) throws IOException {
		
		this.clientSocket = socket;
		this.ipAddress = ipAddress;
		this.port = port;
		this.objIn = new ObjectInputStream(socket.getInputStream());
		this.objOut = new ObjectOutputStream(socket.getOutputStream());
		allClients = new ArrayList<>();
		allClients.add(this);
	}
	
	
	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(1000);
				if(objIn.readObject() != null) {
					
					JFrame f = (JFrame) InputProcessor.getInstance().processInput(objIn.readObject());
					f.setVisible(true);
					
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
		
		
	}
	
	
	

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public static ArrayList<Client> getAllClients() {
		return allClients;
	}

	public static void setAllClients(ArrayList<Client> allClients) {
		Client.allClients = allClients;
	}


	public ObjectInputStream getObjIn() {
		return objIn;
	}


	public void setObjIn(ObjectInputStream objIn) {
		this.objIn = objIn;
	}


	public ObjectOutputStream getObjOut() {
		return objOut;
	}


	public void setObjOut(ObjectOutputStream objOut) {
		this.objOut = objOut;
	}
	
	
	
	
	
	
	
	
}


