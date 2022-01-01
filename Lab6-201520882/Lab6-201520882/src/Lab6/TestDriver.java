package Lab6;

public class TestDriver {
	public static void main(String[] args){
		String firstname = "Jason";
		String lastname = "Bourne";
		String birthday = "19920401";
		
		Member member1 = new Member(firstname, lastname, birthday);
		
		Student student1 = new Student(firstname, lastname, birthday, 15);
		
		Graduate grad1 = new Graduate(firstname, lastname, birthday, 10);
		
		Undergraduate undergrad1 = new Undergraduate(firstname, lastname, birthday, 18);
		
		System.out.println(member1.toString());
		System.out.println(student1.toString());
		System.out.println(grad1.toString());
		System.out.println(undergrad1.toString());
	}
}
