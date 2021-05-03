package dayThreeHomeworkTwo;

public class InstructorManager extends UserManager {

	public void register(Instructor instructor) {
		System.out.println("Instructor, " + instructor.getFirstName() + " " + instructor.getLastName() + " registered to system.");
	}
}
