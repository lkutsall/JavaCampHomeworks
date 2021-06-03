package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EmailService {

	Result sendEmail(String email);
	Result verifyUserByEmail(String email);
}
