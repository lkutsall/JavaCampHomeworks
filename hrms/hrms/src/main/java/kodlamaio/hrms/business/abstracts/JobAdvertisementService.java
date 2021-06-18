package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.AddModelForJobAdvertisementDto;

public interface JobAdvertisementService {

	//Result add(AddModelForJobAdvertisementDto addModelForJobAdvertisementDto); 
	Result add(JobAdvertisement jobAdvertisement);
	Result activate(int id, String email);
	DataResult<List<JobAdvertisement>> getAllByIsActive();
	DataResult<List<JobAdvertisement>> getAllByIsActiveAndDescendingOrder();
	DataResult<List<JobAdvertisement>> getAllByIsActiveCompanyName(String companyName);
}
