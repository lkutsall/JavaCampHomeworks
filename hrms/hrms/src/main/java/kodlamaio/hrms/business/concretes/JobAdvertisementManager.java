package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonelDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.SystemPersonel;
import kodlamaio.hrms.entities.dtos.AddModelForJobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private SystemPersonelDao systemPersonelDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, SystemPersonelDao systemPersonelDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.systemPersonelDao = systemPersonelDao;
	}

	// @Override
	/*
	 * public Result add(AddModelForJobAdvertisementDto
	 * addModelForJobAdvertisementDto) { JobAdvertisement jobAdvertisement =
	 * DtoToEntityMapManager.jobAdvertisementMapper(addModelForJobAdvertisementDto);
	 * jobAdvertisementDao.save(jobAdvertisement);
	 * 
	 * return new SuccessResult("Job added to database successfully."); }
	 */

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);

		return new SuccessResult("Job added to database successfully.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActive() {
		List<JobAdvertisement> jobAdvertisementsWhichAreActive = jobAdvertisementDao.getAllByIsActive();
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementsWhichAreActive,
				"Active job advertisements listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveAndDescendingOrder() {
		List<JobAdvertisement> choosenJobAdvertisements = jobAdvertisementDao.getAllByIsActiveAndDescendingOrder();
		return new SuccessDataResult<List<JobAdvertisement>>(choosenJobAdvertisements, "Data listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveCompanyName(String companyName) {
		List<JobAdvertisement> choosenJobAdvertisements = jobAdvertisementDao.getAllByIsActiveCompanyName(companyName);
		return new SuccessDataResult<List<JobAdvertisement>>(choosenJobAdvertisements, "Data listed.");
	}

	@Override
	public Result activate(int id, String email) {
		JobAdvertisement jobAdvertisementToAvtivate = jobAdvertisementDao.getJobAdvertisementById(id);
		Result result = BusinessRules.run(checkIfEmailBelongsSystemPersonel(email));
		if (result != null) {
			return result;
		} else {

			jobAdvertisementToAvtivate.setActive(true);
			return new SuccessResult(jobAdvertisementToAvtivate.getJobDescription() +" activated successfully.");
		}
	}

	private Result checkIfEmailBelongsSystemPersonel(String email) {
		SystemPersonel systemPersonelToCheck = systemPersonelDao.getSystemPersonelByEmail(email);

		if (systemPersonelToCheck == null) {
			return new ErrorResult("You should be a system personel for this process.");
		} else {
			return new SuccessResult();
		}
	}
}
