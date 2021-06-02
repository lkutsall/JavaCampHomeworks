package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(String email) {
		return new SuccessResult("Email sent to : " + email + ". Please check your inbox.");
	}

}
