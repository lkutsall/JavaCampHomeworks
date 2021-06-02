package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>(jobDao.findAll(), "Jobs are listed.");
	}

	@Override
	public Result add(Job job) {
		Result result = BusinessRules.run(checkIfTheJobTitleExists(job.getJobTitle()));
		if (result != null) {
			return result;
		}
		
		jobDao.save(job);
		
		return new SuccessResult(job.getJobTitle() + ", added to database.");
	}

	@Override
	public DataResult<Job> getByJobTitle(String jobTitle) {
		return new SuccessDataResult<Job>(jobDao.getByJobTitle(jobTitle), "Successfully listed.");
	}
	
	private Result checkIfTheJobTitleExists(String jobTitle) {
		Job job = jobDao.getByJobTitle(jobTitle);
		if (job != null) {
			return new ErrorResult("This job title is already exists.");
		}else {
			return new SuccessResult();
		}
	}
}
