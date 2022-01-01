package Lab12;

public class Student {
	private String name;
	private int id;
	private int grade;
	private float gpa;
	private int hours;
	
	public Student(String name, int id, int grade, float gpa, int hours) {
		this.name = name;
		this.id = id;
		this.grade = grade;
		this.gpa = gpa;
		this.hours = hours;
	}
	
	public void print() {
		System.out.printf("[Name: %s, ID: %d, Grade: %d, GPA: %.2f, Hours: %d]\n", 
				name, id, grade, gpa, hours);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
}
