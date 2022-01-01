package Homework3;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MacaronShop {
	private int indexNextCustomor = 0;
	private int sales = 0;
	private final int[] orderList;
	private final int price;
	
	public MacaronShop(int price, int orders) {
		this.price = price;
		orderList = new int[orders];
		Random random = new Random();
		for(int i = 0; i < orderList.length; i++) {
			orderList[i] = random.nextInt(10) + 1;
		}
	}
	
	public void openShop(int cashers) {
		ExecutorService executor = Executors.newFixedThreadPool(cashers);
		
		while(this.orderList.length > this.indexNextCustomor) {
			executor.submit(new Casher(this));
		}
			
		
	
	}

	public int getIndexNextCustomor() {
		return indexNextCustomor;
	}

	public void setIndexNextCustomor(int indexNextCustomor) {
		this.indexNextCustomor = indexNextCustomor;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int[] getOrderList() {
		return orderList;
	}

	public int getPrice() {
		return price;
	}
}
