package kodlamaio.hrms.core.utilities.validations.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.abstracts.CredentialsCheckService;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class CredentialsCheckManager implements CredentialsCheckService{

	@Override
	public Result checkIfInformationIsNull(Employee employee) {
		if (
				employee.getFirstName() != ""  && 
				employee.getLastName() != "" && 
				employee.getDateOfBirth().toString() != "" &&
				employee.getNationalId() != "" &&
				employee.getEmail() != "" &&
				employee.getPassword() != ""
				) {
			return new SuccessResult();
		}else {
			return new ErrorResult("Any of these informations cannot be null.");
		}
	}
}
