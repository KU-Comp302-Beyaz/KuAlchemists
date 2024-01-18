package domain.network;

import java.net.*;
import java.io.*;

public class Server extends Thread {
	private ServerSocket serverSocket;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		//serverSocket.setSoTimeout(10000);
	}
	
	public int play(String choice1, String choice2) {
		
		// If tie, result is 0. If player 1 wins result is 1 otherwise result is 2.
		int result;

        // Game logic
        if (choice1.equals("rock") && choice2.equals("scissors") ||
                choice1.equals("paper") && choice2.equals("rock") ||
                choice1.equals("scissors") && choice2.equals("paper")) {
            result = 1;
        } else if (choice1.equals(choice2)) {
            result = 0;
        } else {
            result = 2;
        }
        
        return result;
	}

	public void run() {
		while (true) {
			try {
				
				// Create server socket for connection
				System.out.println("Waiting for players on port " + serverSocket.getLocalPort() + "...");
				Socket player1 = serverSocket.accept();
	            System.out.println("Player 1 connected.");

	            Socket player2 = serverSocket.accept();
	            System.out.println("Player 2 connected.");

				
	            ObjectInputStream fromPlayer1 = new ObjectInputStream(player1.getInputStream());
	            ObjectOutputStream toPlayer1 = new ObjectOutputStream(player1.getOutputStream());
	            ObjectInputStream fromPlayer2 = new ObjectInputStream(player2.getInputStream());
	            ObjectOutputStream toPlayer2 = new ObjectOutputStream(player1.getOutputStream());

	            toPlayer1.writeObject("You are Player 1.");
	            toPlayer2.writeObject("You are Player 2.");

	            while (true) {
	                String choice1 = (String) fromPlayer1.readObject();
	                String choice2 = (String) fromPlayer2.readObject();
	                
	        		if (choice1 == null || choice2 == null) {
	                    break;
	                }
	                
	        		int result = play(choice1, choice2);
	        		
	        		if (result == 0) {
	        			toPlayer1.writeObject("It's a tie!");
	                    toPlayer2.writeObject("It's a tie!");
	        		} else if (result == 1) {
	        			toPlayer1.writeObject("You win!");
	                    toPlayer2.writeObject("You lose!");
	        		} else if (result == 2) {
	        			toPlayer1.writeObject("You lose!");
	                    toPlayer2.writeObject("You win!");
	        		}
	            }

	            player1.close();
	            player2.close();
	            serverSocket.close();


			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		// Port number
		int port = 6068;
		
		try {
			
			// Server thread
			Thread t = new Server(port);
			t.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}