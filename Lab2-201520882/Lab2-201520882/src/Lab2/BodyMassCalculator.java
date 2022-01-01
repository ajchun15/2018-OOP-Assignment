package Lab2;
import java.util.Scanner;

public class BodyMassCalculator {
	public static void main(String[] args)
	{
		System.out.println("<Body mass calculator>");
		System.out.println("##This program takes height and weight information to calculate a BMI index.");
		System.out.println("##The user may choose between different unit pairs: (kg,  meter) or  (pound, inch).");
		
		System.out.println("Enter 1 for (kg, meter), 2 for (pound, inch)");
		
		int condition;
		double bmi , weight, height;
		Scanner input = new Scanner(System.in);
		condition = input.nextInt();
		//조건을 입력받음.
		
		switch(condition)
		{
		case 1:
			System.out.println("You chose(kg, meter)");
			System.out.println("Enter weight:");
			weight = input.nextDouble();
			System.out.println("Enter height:");
			height = input.nextDouble();
			//몸무게와 키를 입력받는 부분.
			
			bmi = weight / (height*height);
			System.out.printf("%s%.4f", "The BMI is: ", bmi);
			break;
		case 2:
			System.out.println("You chose (pound, inch)");
			System.out.println("Enter weight:");
			weight = input.nextDouble();
			System.out.println("Enter height:");
			height = input.nextDouble();
			//몸무게와 키를 입력받는 부분.
			
			bmi = weight*703 /(height*height);
			System.out.printf("%s%.4f", "The BMI is: ", bmi);
			break;
		default:
			System.out.println("Wrong input. Start again.");
			break;
			//잘못된 값이 들어올때.
		}
		input.close();
	}
}
