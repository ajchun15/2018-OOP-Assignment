package Lab14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main(String[] args ) throws IOException {
		try {
			Socket socket = new Socket("localhost", 4444);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("### Enter initial guess: ");
			
			String userInput;
			String fromServer;
			
			while(true) {
				System.out.print("Guess is: ");
				userInput = stdIn.readLine();
				out.println(userInput);
				fromServer = in.readLine();
				if(fromServer.equals("Game Over")) {
					System.out.println(fromServer);
					break;
				}
				System.out.println("hint from server: " + fromServer);
				System.out.println("==================================");
			}
		} catch(UnknownHostException e) {
			System.err.println("Don't know about host localhost");
			System.exit(1);
		} catch(IOException e) {
			System.err.println("Couldn't get I/O for the connection to localhost");
			System.exit(1);
		}
	}
}
