package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.RegisterModelForEmployeeDto;

public interface EmployeeService {

	Result register(RegisterModelForEmployeeDto registerModelForEmployeeDto);
	DataResult<List<Employee>> getAllByIsActive();
}
