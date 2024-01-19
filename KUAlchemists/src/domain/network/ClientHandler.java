package domain.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket clientSocket;
    private Server server;
    private BufferedReader fromClient;
    private PrintWriter toClient;
    private ObjectInputStream oinput;


    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;

        try {
            fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            toClient = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Object inputLine = null;

        try {
        	oinput = new ObjectInputStream(clientSocket.getInputStream());
            while (true) {

                if ((inputLine = oinput.readObject()) != null) {
                }
            }
        } catch (IOException e) {
            System.out.println(inputLine);
            System.out.println(oinput);
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


