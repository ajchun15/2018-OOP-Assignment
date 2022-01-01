package Lab6;

public class Student extends Member{
	protected int credit;
	
	public Student(String firstName, String lastName, String birthday, int credit) {
		super(firstName, lastName, birthday);
		this.credit = credit;
		
		if(credit > 21) {
			System.out.println("the maximum credit is 21");
			System.exit(0);
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("<Student>\nfirst name: %s\nlast name: %s\nbirthday: %s\ncredit: %d\n"
				, this.firstName, this.lastName, this.birthday, this.credit);
	}
	
}
