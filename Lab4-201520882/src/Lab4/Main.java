package Lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int calculateAverage(Member[] club)
	{
		float total = 0;
		int avg;
		
		for(int i =0; i< club.length; i++)
		{
			total += (float)club[i].getAge();
		}
		
		avg = (int)(total / (float)club.length);
		
		return avg;
	}
	
	public static ArrayList<String> findIntersection(Member[] club1, Member[] club2)
	{
		ArrayList<String> intersectionMember = new ArrayList<String>();
		String club1Name, club2Name;
		
		for(int i =0; i<club1.length; i++)
		{
			for(int j = 0; j< club2.length; j++)
			{
				if(club1[i].getAge() == club2[j].getAge())
				{
					club1Name = club1[i].getName();
					club2Name = club2[j].getName();
					
					if(club1Name.equals(club2Name))
					{
						intersectionMember.add(club1[i].getName());
					}
				}
			}
			
		}
		
		return intersectionMember;
	}
	
	public static void main(String []args)
	{
		int numOfPeopleA, numOfPeopleB;
		String name; int age;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> intersectionMember;
		
		System.out.print("Input the number of people in the bicycle club: ");
		
		numOfPeopleA = sc.nextInt();
		sc.nextLine();
		
		Member[] firstGroup = new Member[numOfPeopleA];
		
		for(int i =0; i < numOfPeopleA; i++)
		{
			System.out.printf("\nEnter the Member%d's name: ", i+1);
			name = sc.nextLine();
			
			System.out.printf("Enter the Member%d's age: ", i+1);
			age = sc.nextInt();
			
			
			firstGroup[i] = new Member(name, age);
			sc.nextLine();
		}
		
		System.out.print("\nInput the number of people in the tennis club: ");
		numOfPeopleB = sc.nextInt();
		sc.nextLine();
		
		Member[] secondGroup = new Member[numOfPeopleB];
		
		for(int i =0; i< numOfPeopleB; i++)
		{
			System.out.printf("\nEnter the Member%d's name: ", i+1);
			name = sc.nextLine();
			
			System.out.printf("Enter the Member%d's age: ", i+1);
			age = sc.nextInt();
			
			secondGroup[i] = new Member(name, age);
			sc.nextLine();
		}
		
		System.out.println("\n====================\n");
		
		System.out.printf("The average age of the bicycle club = %d\n", calculateAverage(firstGroup) );
		System.out.printf("The average age of the tennis club = %d\n\n", calculateAverage(secondGroup));
		
		intersectionMember = findIntersection(firstGroup, secondGroup);
		
		System.out.print(intersectionMember);
		System.out.printf(" joined the both clubs\n");
		
		
		
	}
}
