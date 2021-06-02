package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterModelForEmployerDto;

public interface EmployerService {

	Result register(RegisterModelForEmployerDto registerModelForEmployerDto);
	DataResult<List<Employer>> getAllByIsActive();
}
