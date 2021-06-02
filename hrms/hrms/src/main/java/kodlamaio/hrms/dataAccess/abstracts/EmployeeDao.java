package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee getByEmail(String email);
	Employee getByNationalId(String nationalId);
	@Query("From Employee where isActive= true")
	List<Employee> getAllByIsActive();
}
