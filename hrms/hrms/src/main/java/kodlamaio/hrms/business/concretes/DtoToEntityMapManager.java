package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterModelForEmployeeDto;
import kodlamaio.hrms.entities.dtos.RegisterModelForEmployerDto;

public class DtoToEntityMapManager {

	public static Employer employerMapper(RegisterModelForEmployerDto registerModelForEmployerDto) {

		Employer employer = new Employer();
		employer.setCompanyName(registerModelForEmployerDto.getCompanyName());
		employer.setPhoneNumber(registerModelForEmployerDto.getPhoneNumber());
		employer.setWebAddress(registerModelForEmployerDto.getWebSite());
		employer.setEmail(registerModelForEmployerDto.getEmail());
		employer.setPassword(registerModelForEmployerDto.getPassword());
		employer.setActive(false);
		
		return employer;
	}
	
	public static Employee employeeMapper(RegisterModelForEmployeeDto registerModelForEmployeeDto) {
		
		Employee employee = new Employee();
		employee.setFirstName(registerModelForEmployeeDto.getFirstName());
		employee.setLastName(registerModelForEmployeeDto.getLastName());
		employee.setNationalId(registerModelForEmployeeDto.getNationalId());
		employee.setDateOfBirth(registerModelForEmployeeDto.getDateOfBirth());
		employee.setEmail(registerModelForEmployeeDto.getEmail());
		employee.setPassword(registerModelForEmployeeDto.getPassword());
		employee.setActive(false);
		
		return employee;
	}

}
