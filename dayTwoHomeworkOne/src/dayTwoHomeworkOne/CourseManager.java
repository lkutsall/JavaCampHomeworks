package dayTwoHomeworkOne;

public class CourseManager {
	public void addCourse(Course course) {
		System.out.println("You added the " + course.courseName + " successfully.");
	}
	
	public void getAllCourses(Course[] courses) {
		for (Course course : courses) {
			System.out.println("Course id : " + course.id + " Course name : " + course.courseName + " and your instructor is : " + course.instructor);
		}
	}
}
