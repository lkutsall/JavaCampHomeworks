package dayThreeHomeworkTwo;

public class Main {

	public static void main(String[] args) {
		InstructorManager instructorManager = new InstructorManager();
		StudentManager studentManager = new StudentManager();
		
		Instructor instructor1 = new Instructor();
		instructor1.setFirstName("Engin");
		instructor1.setLastName("Demiroğ");
		instructorManager.register(instructor1);

		Student student1 = new Student();
		student1.setFirstName("Kutsal");
		student1.setLastName("Mustafaoğlu");
		student1.setStudentNumber("12314124");
		studentManager.register(student1);

	}

}
