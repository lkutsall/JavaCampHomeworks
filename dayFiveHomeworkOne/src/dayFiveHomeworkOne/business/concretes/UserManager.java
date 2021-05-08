package dayFiveHomeworkOne.business.concretes;

import java.util.List;
import java.util.Scanner;

import dayFiveHomeworkOne.business.abstracts.UserService;
import dayFiveHomeworkOne.core.abstracts.JGoogleRegisterAdapterService;
import dayFiveHomeworkOne.core.abstracts.UserValidatorService;
import dayFiveHomeworkOne.core.concretes.EmailManager;
import dayFiveHomeworkOne.dataAccess.abstracts.UserDao;
import dayFiveHomeworkOne.entities.concretes.User;

public class UserManager implements UserService {

	Scanner scanner = new Scanner(System.in);
	private UserDao userDao;
	private UserValidatorService userValidatorService;
	private JGoogleRegisterAdapterService jGoogleRegisterAdapterService;

	public UserManager(UserDao userDao, UserValidatorService userValidatorService) {
		super();
		this.userDao = userDao;
		this.userValidatorService = userValidatorService;
	}
	
	public UserManager(UserDao userDao, JGoogleRegisterAdapterService jGoogleRegisterAdapterService) {
		super();
		this.userDao = userDao;
		this.jGoogleRegisterAdapterService = jGoogleRegisterAdapterService;
	}

	@Override
	public void register(User user) {
		
		if (userValidatorService.checkIfNameIsNull(user.getFirstName(), user.getLastName())) {
			System.out.println("First name and last name can't be null.");
		}else if (!userValidatorService.checkIfNameLengthIsValid(user.getFirstName(), user.getLastName())) {
			System.out.println("First name and last name should be longer then 2 characters.");
		}else if (!userValidatorService.checkIfPasswordLengthIsValid(user.getPassword())) {
			System.out.println("The password should be longer then 6 characters.");
		}else if (userValidatorService.checkIfEmailFormatIsValid(user.getEmail())) {
			System.out.println("The format of the e-mail is not correct.");
		}else if (checkIfEmailExistRule(user.getEmail())) {
			System.out.println("This e-mail is already exists in the database.");
		}else {
			
			EmailManager.sendVerificationMail(user.getEmail());
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			System.out.println("Do you want to verify? (Y/N)");
			String answer = scanner.next();
			if (EmailManager.verify(answer)) {	
				userDao.add(user);
			}else {
				System.out.println("You didn't verify your e-mail address so the process cancelled.");
			}
		}
		
	}
	
	public void registerWithGoogle(User user) {
		jGoogleRegisterAdapterService.registerWithGoogle(user.getFirstName());
	}

	private boolean checkIfEmailExistRule(String email) {

		List<User> usersInDatabase = userDao.getAll();
		for (User user : usersInDatabase) {
			if (user.getEmail() == email) {
				return true;
			}
		}
		return false;
	}
}
