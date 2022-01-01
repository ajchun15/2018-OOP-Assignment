package Lab3;
import java.util.Scanner;

public class Compare {
	
	public static int getEntireInfo(Beverage bever, int numOfBottle)
	{
		System.out.println("");
		System.out.println("==================== ");
		System.out.println("");
		
		System.out.printf("%s's info: \n",bever.getName());
		System.out.printf("Volume: %.2f \n",bever.getVolume());
		System.out.printf("Price per bottle: %d \n",bever.getPrice());
		System.out.printf("Price per 100ml: %d \n",bever.figureMlPerPrice());
		int buffer;
		if(numOfBottle >= bever.getMin_num()) 
		{
			System.out.printf("Discount rate: %d \n",bever.getDisc_rate());
			System.out.printf("Price per 100ml with a discount : %d \n",(int)bever.figureDiscPricePerMl());
			buffer = (int)(bever.figureDiscPricePerBottle()*(float)numOfBottle);
		}
		else buffer = bever.getPrice()*numOfBottle;


		System.out.printf("Total price with a discount: %d \n", buffer);
		return buffer;

		
	}
	public static void compareTwo(Beverage bever1, Beverage bever2, int numOfBottle)
	{
		float price1, price2;
		//첫번째 음료 비교 구문
		if(numOfBottle >= bever1.getMin_num())
		{
			price1 = bever1.figureDiscPricePerMl();
		}
		else price1 = (float)bever1.figureMlPerPrice();
		
		//두번째 음료 비교 구문
		if(numOfBottle >= bever2.getMin_num())
		{
			price2 = bever2.figureDiscPricePerBottle();
		}
		else price2 = (float)bever2.figureMlPerPrice();
		
		if(price1 < price2)
		{
			System.out.printf("%s is chaeper than %s \n", bever1.getName(), bever2.getName());
		}
		else if(price1 > price2)
		{
			System.out.printf("%s is chaeper than %s \n", bever2.getName(), bever1.getName());
		}
		else
		{
			System.out.println("Bevearage's price is same...");
		}
	}
	
	public static void main(String[] args)
	{
		int numOfBottle;
		String name;
		int price, discount_rate, min_disc;
		float volume;
		Beverage bever1, bever2;
		
		System.out.println("<Discount Rate Calculator");
		System.out.println("## This program takes information of two kinds of beverages that a user");
		System.out.println("## wants to purchase. Based on the calculated price per 100ml, the program");
		System.out.println("## suggest the cheaper beverage to the user.");
		
		System.out.print("Enter the number of bottles you want to purchase: ");
		Scanner sr = new Scanner(System.in);
		numOfBottle = sr.nextInt();
		sr.nextLine();
		
		System.out.println("Input the 1st Beverage's Info ");
		System.out.print("Enter the name: ");
		name = sr.nextLine();
		System.out.print("Enter the price: ");
		price = sr.nextInt();
		System.out.print("Enter the volume: ");
		volume = sr.nextFloat();
		System.out.print("Enter the discout rate: ");
		discount_rate = sr.nextInt();
		System.out.print("Enter the minimum number of purchase to get the discount ");
		min_disc = sr.nextInt();
		bever1 = new Beverage(name, volume, price, discount_rate, min_disc);
		
		sr.nextLine();
		System.out.println("Input the 2nd Beverage's Info ");
		System.out.print("Enter the name: ");
		name = sr.nextLine();
		System.out.print("Enter the price: ");
		price = sr.nextInt();
		System.out.print("Enter the volume: ");
		volume = sr.nextFloat();
		System.out.print("Enter the discout rate: ");
		discount_rate = sr.nextInt();
		System.out.print("Enter the minimum number of purchase to get the discount ");
		min_disc = sr.nextInt();
		bever2 = new Beverage(name, volume, price, discount_rate, min_disc);
		
		getEntireInfo(bever1, numOfBottle);
		getEntireInfo(bever2, numOfBottle);
		
		System.out.println("====================");
		compareTwo(bever1, bever2, numOfBottle);
	}
}
