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

	
	private static final int max_players = 4;
	private static final int min_players = 2;

	public void start() {
         try {
			serverSocket = new ServerSocket(6068);
			while (true) {
                Socket clientSocket = serverSocket.accept();

				//...				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		
	}
	
	
}
