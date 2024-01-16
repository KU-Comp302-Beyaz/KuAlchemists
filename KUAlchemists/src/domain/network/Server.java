package domain.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import domain.Player;


public class Server extends Thread {
	
	private ServerSocket serverSocket;
    private List<Client> players;
    private List<ClientHandler> clientHandlers;
    private Thread thread;
    private String threadd;
	
	private static final int max_players = 4;
	private static final int min_players = 2;

	public void startServer() {
	    try {
            serverSocket = new ServerSocket(6068);
            clientHandlers = new ArrayList<>();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                if (clientHandlers.size() < max_players) {
                    ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                    clientHandlers.add(clientHandler);
                    clientHandler.start();
                } else {
                    //  client server is full
                    clientSocket.close();

                }
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
    public void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
        }
        }
    
    @Override
    public void start() {
		if (thread == null) {
            thread = new Thread(this, threadd);
            thread.start();
        }
    }
    
	
    @Override
    public void run() {
        startServer();
    }

	public static String next() {
		// TODO Auto-generated method stub
		return null;
	}
}
