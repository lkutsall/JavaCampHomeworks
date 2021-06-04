package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isActive= true")
	List<JobAdvertisement> getAllByIsActive();
	
	@Query("From JobAdvertisement Where isActive= true Order By expirationDate DESC")
	List<JobAdvertisement> getAllByIsActiveAndDescendingOrder();
	
	@Query("From JobAdvertisement Where isActive= true and employer.companyName=: companyName")
	List<JobAdvertisement> getAllByIsActiveCompanyName(String companyName);
}
