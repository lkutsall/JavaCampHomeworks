package dayTwoHomeworkOne;

public class Course {
	public Course(int id, String courseName, Instructor instructor) {
		this.id = id;
		this.courseName = courseName;
		this.instructor = instructor.fullName;
	}
	
	int id;
	String courseName;
	String instructor;
}
