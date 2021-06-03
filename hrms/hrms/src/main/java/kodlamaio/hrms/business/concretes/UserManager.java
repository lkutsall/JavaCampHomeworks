package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private EmailService emailService;
	
	@Autowired
	public UserManager(EmailService emailService) {
		super();
		this.emailService = emailService;
	}
	@Override
	public Result activate(String email) {
		emailService.verifyUserByEmail(email);
		return new SuccessResult("Verification completed.");
	}

}
