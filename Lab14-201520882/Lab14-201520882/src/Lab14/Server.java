package Lab14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Server {
	public static void main(String[] args) throws InterruptedException {
		try {
			
			ServerSocket serverSocket = new ServerSocket(4444);
			Socket clientSocket = serverSocket.accept();
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			
			Random random = new Random();
			random.setSeed(System.currentTimeMillis());
			int rightAnswer = random.nextInt(100) + 1;
			System.out.printf("Server: answer is : %d\n", rightAnswer);
			int answer;
			String inputLine;
			String outputLine = "";
			while(true) {
				inputLine = in.readLine();
				answer = Integer.parseInt(inputLine);
				if(answer > rightAnswer) {
					outputLine = "-";
				}
				else if(answer < rightAnswer) {
					outputLine = "+";
				}
				
				if( answer == rightAnswer) {
					out.println("Game Over");
				}
				else if((Math.abs(answer - rightAnswer) >= 10)) {
					outputLine += "10";
				}
				else if((Math.abs(answer - rightAnswer) >= 5) && Math.abs(answer - rightAnswer) < 10) {
					outputLine += "5";
				}
				else if((Math.abs(answer - rightAnswer) >= 1) &&(Math.abs(answer - rightAnswer) < 5) ) {
					outputLine += "1";
				}
				TimeUnit.SECONDS.sleep(1);
				out.println(outputLine);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
