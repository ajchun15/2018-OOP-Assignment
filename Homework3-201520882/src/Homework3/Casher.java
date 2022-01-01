package Homework3;

public class Casher implements Runnable{
	private final MacaronShop myShop;
	
	public Casher(MacaronShop ms) {
		myShop = ms;
	}
	
	public void run() {
		
		int macaronNum;
		
		synchronized(myShop) {
			
		macaronNum = myShop.getOrderList()[myShop.getIndexNextCustomor()];
		myShop.setIndexNextCustomor(myShop.getIndexNextCustomor()+1);
		System.out.printf("Packing %d macarons\n", macaronNum);
		}
		
		
		
		try {
		Thread.sleep(300*macaronNum);
		} catch(Exception e) {
			
		}
		int price, sales;
		
		synchronized(myShop) {
			price = myShop.getPrice();
			sales = myShop.getSales();
			myShop.setSales(price*macaronNum + sales);
			sales = myShop.getSales();
			System.out.printf("Sold %d macarons and earned $%d ! Macaron shop earned $%d today.\n", macaronNum, price*macaronNum, sales);
		}
		
		
	}
}
