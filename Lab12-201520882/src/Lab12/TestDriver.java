package Lab12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class TestDriver {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("Joshua", 1, 3, 3.7f, 85),
				new Student("Connie",2,2,4.1f,68),
				new Student("Joshua",3,1,2.8f,32),
				new Student("Gloria",4,4,3.4f,120),
				new Student("Dorothy",5,3,2.1f,79),
				new Student("Stacy",6,4,3.6f,128),
				new Student("Dustin",7,1,3.3f,19),
				new Student("Connie",8,2,2.9f,32),
				new Student("Stacy",9,1,4.5f,16),
				new Student("Gloaria",10,3,2.9f,114)
				);
		int menuNum;
		String name;
		int inputTmpI;
		float inputTmpF;
		
		System.out.println("<School affairs informatin searching system>");
		System.out.println("1. Search by student name");
		System.out.println("2. Search by grade");
		System.out.println("3. Search by GPA");
		System.out.println("4. Search by rank");
		Consumer<Student> consume = value-> value.print();
		Scanner scr = new Scanner(System.in);
		
		menuNum = scr.nextInt();
		
		
		switch(menuNum) {
		case 1:
			System.out.println("Enter the name");
			scr.nextLine();
			name = scr.nextLine();

			studentList.stream().filter(i-> {
				if(i.getName().equals(name)) {
					return true;
				}
				else return false;
			}).forEach(consume);
			
			break;
		case 2:
			System.out.println("Enter the grade");
			inputTmpI = scr.nextInt();
			
			studentList.stream().filter(i->{
				if(i.getGrade() == inputTmpI) return true;
				else return false;
			}).forEach(consume);
			break;
		case 3:
			System.out.println("Enter the GPA");
			inputTmpF = scr.nextFloat();
			
			studentList.stream().filter(i->{
				if(i.getGpa() >= inputTmpF) return true;
				else return false;
			}).forEach(consume);
			break;
		case 4:
			System.out.println("Enter the number");
			inputTmpI = scr.nextInt();
			
			studentList.stream().sorted(new Comparator<Student>() {
				public int compare(Student s1, Student s2) {
					if(s1.getGpa() > s2.getGpa()) {
						return -1;
					}
					else if(s1.getGpa() < s2.getGpa()) {
						return 1;
					}
					else {
						if(s1.getHours() > s2.getHours()) return -1;
						else return 1;
					}
				}
			}).limit(inputTmpI).forEach(consume);
			break;
		}
		
		
	}
}

