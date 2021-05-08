package dayFiveHomeworkOne;

import dayFiveHomeworkOne.business.abstracts.UserService;
import dayFiveHomeworkOne.business.concretes.UserManager;
import dayFiveHomeworkOne.core.concretes.JGoogleRegisterAdapterManager;
import dayFiveHomeworkOne.core.concretes.UserValidator;
import dayFiveHomeworkOne.dataAccess.concretes.inMemoryDatabase.inMemoryUserDao;
import dayFiveHomeworkOne.entities.concretes.User;
import jGoogle.JGoogleRegister;

public class Main {

	public static void main(String[] args) {
		
		User newUser = new User(5, "John", "Doe", "johndoe@gmail.com", "johndoe");
		User newUser2 = new User(6, "Jane", "Doe", "janedoe@gmail.com", "janedoe");
		
		UserService userService = new UserManager(new inMemoryUserDao(), new UserValidator());
		userService.register(newUser);
		
		UserService userService2 = new UserManager(new inMemoryUserDao(), new JGoogleRegisterAdapterManager(new JGoogleRegister()));
		userService2.registerWithGoogle(newUser2);
		
	}

}
