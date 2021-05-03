package dayThreeHomeworkTwo;

public class Instructor extends User {
	
	private String instructorNumber;
	private String course;
	
	public String getInstructorNumber() {
		return instructorNumber;
	}
	public void setInstructorNumber(String instructorNumber) {
		this.instructorNumber = instructorNumber;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
}
