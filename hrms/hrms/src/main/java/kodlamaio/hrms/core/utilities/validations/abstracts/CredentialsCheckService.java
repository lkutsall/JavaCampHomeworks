package kodlamaio.hrms.core.utilities.validations.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

public interface CredentialsCheckService {

	Result checkIfInformationIsNull(Employee employee);
}
