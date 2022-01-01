package Lab6;

public class Member {
	protected String firstName;
	protected String lastName;
	protected String birthday;
	
	public Member(String firstName, String lastName, String birthday) {
		if(firstName.length() > 20) {
			System.out.println("the maximum length of first name is 20.");
			System.exit(0);
		}
		if(lastName.length() > 20) {
			System.out.println("the maximum length of last name is 20.");
			System.exit(0);
		}
		if(birthday.length()!= 8) {
			System.out.println("the length of the birthday argument must be 8 characters.");
			System.exit(0);
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	@Override
	public String toString(){
		return String.format("<Member>\nfirst name: %s\nlast name: %s\nbirthday: %s\n", firstName, lastName, birthday );
	}
	
}
