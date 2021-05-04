import java.util.GregorianCalendar;

import Abstract.BaseCustomerManager;
import Adaptors.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) throws Exception {

		BaseCustomerManager baseCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Birisi");
		customer1.setLastName("BirisininSoyismi");
		customer1.setDateOfBirth(new GregorianCalendar(1999, 11, 01).getTime());
		customer1.setNationalId("00000000000");
		
		baseCustomerManager.save(customer1);

	}

}
