package dayFiveHomeworkOne.core.abstracts;

public interface UserValidatorService {

	boolean checkIfNameIsNull(String firstName, String lastName);
	boolean checkIfNameLengthIsValid(String firstName, String lastName);
	boolean checkIfPasswordLengthIsValid(String password);
	boolean checkIfEmailFormatIsValid(String email);
}
