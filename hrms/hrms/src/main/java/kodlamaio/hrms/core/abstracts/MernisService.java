package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.Employee;

public interface MernisService {

	boolean checkIfUserIsRealPerson(Employee employee);
}
