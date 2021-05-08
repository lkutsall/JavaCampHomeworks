package dayFiveHomeworkOne.core.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dayFiveHomeworkOne.core.abstracts.UserValidatorService;

public class UserValidator implements UserValidatorService {


	public boolean checkIfNameLengthIsValid(String firstName, String lastName) {
		if (firstName.length() <= 2 || lastName.length() <= 2) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkIfPasswordLengthIsValid(String password) {
		if (password.length() > 6) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkIfEmailFormatIsValid(String email) {

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return false;
		}else {
			return true;
		}
	}

	public boolean checkIfNameIsNull(String firstName, String lastName) {
		if (firstName == null) {
			return true;
		}else {
			return false;
		}
	}

}
