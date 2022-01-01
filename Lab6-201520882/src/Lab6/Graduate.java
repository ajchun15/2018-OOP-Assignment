package Lab6;

public class Graduate extends Student {
	private double tuitionPerCredit;
	private double waive;
	
	public Graduate(String firstName, String lastName, String birthday, int credit) {
		super(firstName, lastName, birthday, credit);
		this.tuitionPerCredit = 1000;
		this.waive = 0.8;
	}
	
	public double calculateTotalTuiton() {
		return (credit)*(tuitionPerCredit)*(1-waive);
	}
	
	@Override
	public String toString() {
		return String.format("<Graduate>\nfirst name: %s\nlast name: %s\nbirthday: %s\n"
				+ "credit: %d\ntuiton per credit: %.1f\nwaive: %.1f\n"
				+ "total tuition with waive: %.1f\n", firstName, lastName, birthday, credit
				,tuitionPerCredit, waive, calculateTotalTuiton());
	}
}
