package dayThreeHomeworkTwo;

public class StudentManager extends UserManager {

	public void register(Student student) {
		System.out.println("Student, " + student.getFirstName() + " " + student.getLastName() + ", registered into system with number : " + student.getStudentNumber());
	}
}
