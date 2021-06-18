package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobType;

public interface JobTypeService {

	public DataResult<List<JobType>> getAll();
}
