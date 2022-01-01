package Homework3;

import java.util.Random;
import java.util.Scanner;


public class TestDriver {
	
	
	public static void main(String[] args) {
		final int CASHERS = 3;
		int ORDERS;
		int PRICE;
		final Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		ORDERS = random.nextInt(11) + 5;
		System.out.print("Please enter the price of the macaron >> ");
		PRICE = scanner.nextInt();
		final MacaronShop ms = new MacaronShop(PRICE, ORDERS);
		
		
		ms.openShop(CASHERS);
		
		
	}
}
