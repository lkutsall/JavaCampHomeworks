package dayTwoHomeworkOne;

public class Main {

	public static void main(String[] args) {
		CourseManager courseManager = new CourseManager();
		
		Instructor instructor1 = new Instructor(1, "Engin Demiroğ");
		
		Course course1 = new Course(1, "Java", instructor1);
		Course course2 = new Course(2, "C#", instructor1);
		
 		
		courseManager.addCourse(course1);
		courseManager.addCourse(course2);
		
		Course[] courses = {course1, course2};
		
		courseManager.getAllCourses(courses);
	}

}
