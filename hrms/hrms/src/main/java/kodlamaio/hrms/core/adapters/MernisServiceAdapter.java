package kodlamaio.hrms.core.adapters;

import java.time.ZoneId;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfUserIsRealPerson(Employee employee) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			
			return client.TCKimlikNoDogrula(
					Long.parseLong(employee.getNationalId()), 
					employee.getFirstName().toUpperCase(), 
					employee.getLastName().toUpperCase(), 
					employee.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()
					);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

}
