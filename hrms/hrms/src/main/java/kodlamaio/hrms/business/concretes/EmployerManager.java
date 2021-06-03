package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterModelForEmployerDto;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailService emailService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public Result register(RegisterModelForEmployerDto registerModelForEmployerDto) {
		
		Employer employer = DtoToEntityMapManager.employerMapper(registerModelForEmployerDto);

		Result result = BusinessRules.run(
				checkIfEmailBelongsCompany(registerModelForEmployerDto.getEmail(), registerModelForEmployerDto.getWebSite()), 
				checkIfPasswordEqualsRepeatPassword(registerModelForEmployerDto),
				checkIfEmailExists(employer.getCompanyName())
				);
		if (result != null) {	
			return result;
		}
		
		Employer employerToRegister = employerDao.save(employer);
		emailService.sendEmail(employer.getEmail());
		return new SuccessResult(employerToRegister.getCompanyName() + " registered to database successfully." + emailService.sendEmail(employer.getEmail()).getMessage());
	}
	
	public DataResult<List<Employer>> getAll(){
		List<Employer> employers = employerDao.findAll();
		return new SuccessDataResult<List<Employer>>(employers, "All employers listed successfully.");
	}

	@Override
	public DataResult<List<Employer>> getAllByIsActive() {
		List<Employer> employers = employerDao.getAllByIsActive();
		return new SuccessDataResult<List<Employer>>(employers, "Data listed successfully.");
	}
	
	private Result checkIfEmailBelongsCompany(String email, String webSite) {
		
		String[] webSiteArr = webSite.split("\\.");
		String[] emailArr = email.split("[@\\.]");
		if (webSiteArr[0].equals(emailArr[1])) {
			return new SuccessResult();
		}
		return new ErrorResult("Please enter a company email address.");
	}
	
	private Result checkIfPasswordEqualsRepeatPassword(RegisterModelForEmployerDto registerModelForEmployerDto) {
		if (registerModelForEmployerDto.getPassword().equals(registerModelForEmployerDto.getPasswordRepeat())) {
			return new SuccessResult();
		}else {
			return new ErrorResult("The passwords are not equal.");
		}
	}

	private Result checkIfEmailExists(String email) {
		Employer employer = employerDao.getByEmail(email);
		if (employer != null) {
			return new ErrorResult(email + ", is already exists in database.");
		} else {
			return new SuccessResult();
		}
	}

}
