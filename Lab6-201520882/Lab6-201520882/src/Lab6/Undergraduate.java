package Lab6;

public class Undergraduate extends Student {
	private double tuitionPerCredit;
	
	public Undergraduate(String firstName, String lastName, String birthday, int credit) {
		super(firstName, lastName, birthday, credit);
		
		this.tuitionPerCredit = 500;
	}
	
	public double calculateTotalTuition() {
		return (credit) * (tuitionPerCredit);
	}
	
	@Override
	public String toString() {
		return String.format("<Undergraduate>\nfirst name: %s\nlast name: %s\nbirthday: %s\n"
				+ "credit: %d\ntuition per credit: %.1f\ntotal tuiton: %.1f\n"
				, firstName, lastName, birthday, credit, tuitionPerCredit, calculateTotalTuition());
	}
}
