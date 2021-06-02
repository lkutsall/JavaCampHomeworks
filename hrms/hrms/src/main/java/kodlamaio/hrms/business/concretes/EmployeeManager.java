package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.abstracts.CredentialsCheckService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.RegisterModelForEmployeeDto;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private CredentialsCheckService credentialsCheckService;
	private EmailService emailService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, CredentialsCheckService credentialsCheckService, EmailService emailService) {
		super();
		this.employeeDao = employeeDao;
		this.credentialsCheckService = credentialsCheckService;
		this.emailService = emailService;
	}
	
	@Override
	public Result register(RegisterModelForEmployeeDto registerModelForEmployeeDto) {

		Employee employee = DtoToEntityMapManager.employeeMapper(registerModelForEmployeeDto);
		
		Result result = BusinessRules.run(
				checkIfEmailExists(employee.getEmail()),
				checkIfNationalIdIsExist(employee.getNationalId()), 
				checkIfPasswordEqualsRepeatPassword(registerModelForEmployeeDto)
				);
		
		if (credentialsCheckService.checkIfInformationIsNull(employee).isSuccess()) {
			if (result != null) {
				return result;
			}

			employeeDao.save(employee);
			emailService.sendEmail(employee.getEmail());
			return new SuccessResult(employee.getFirstName() + ", registered successfully.");
		}else {
			return credentialsCheckService.checkIfInformationIsNull(employee);
		}

	}
	
	@Override
	public DataResult<List<Employee>> getAllByIsActive() {
		List<Employee> employees = employeeDao.getAllByIsActive();
		return new SuccessDataResult<List<Employee>>(employees, "All employees listed.");
	}

	private Result checkIfEmailExists(String email) {
		Employee employee = employeeDao.getByEmail(email);
		if (employee != null) {
			return new ErrorResult(email + ", is already exists in database.");
		} else {
			return new SuccessResult();
		}
	}

	private Result checkIfNationalIdIsExist(String nationalId) {
		Employee employee = employeeDao.getByNationalId(nationalId);
		if (employee != null) {
			return new ErrorResult(nationalId + ", is already exists in database.");
		} else {
			return new SuccessResult();
		}
	}

	private Result checkIfPasswordEqualsRepeatPassword(RegisterModelForEmployeeDto registerModelForEmployeeDto) {
		if (registerModelForEmployeeDto.getPassword().equals(registerModelForEmployeeDto.getPasswordRepeat())) {
			return new SuccessResult();
		}else {
			return new ErrorResult("The passwords are not equal.");
		}
	}

}
