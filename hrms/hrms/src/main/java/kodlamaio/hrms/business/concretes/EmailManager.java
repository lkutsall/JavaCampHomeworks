package kodlamaio.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailManager implements EmailService {

	private UserDao userDao;
	
	@Autowired
	public EmailManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result sendEmail(String email) {
		UUID uuid = UUID.randomUUID(); 
		String verificationCode = uuid.toString();
		return new SuccessResult(verificationCode + " sent to : " + email + ". Please check your inbox and click the code to verify your account.");
	}

	@Override
	public Result verifyUserByEmail(String email) {
		User userToBeActivated = userDao.getByEmail(email);
		userToBeActivated.setActive(true);
		userDao.save(userToBeActivated);
		return null;
	}

}
