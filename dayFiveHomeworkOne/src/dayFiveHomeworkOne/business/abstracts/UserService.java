package dayFiveHomeworkOne.business.abstracts;

import dayFiveHomeworkOne.entities.concretes.User;

public interface UserService {

	void register(User user);
	void registerWithGoogle(User user);
}
