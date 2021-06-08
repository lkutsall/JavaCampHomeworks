package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterService) {
		super();
		this.coverLetterDao = coverLetterService;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter added to database successfully.");
	}

	@Override
	public DataResult<CoverLetter> getCoverLetterByEmployeeId(int id) {
		CoverLetter coverLetter = coverLetterDao.getCoverLetterByEmployee_Id(id);
		return new SuccessDataResult<CoverLetter>(coverLetter, " Successfully listed.");
	}

}
