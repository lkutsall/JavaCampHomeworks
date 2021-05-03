package inheritance;

public class Main {

	public static void main(String[] args) {

		IndividualCustomer kutsal = new IndividualCustomer();
		kutsal.customerNumber = "12345";
		
		CorporateCustomer shieldKravmaga = new CorporateCustomer();
		shieldKravmaga.customerNumber = "67890";
		
		CustomerManager customerManager = new CustomerManager();
		
		Customer[] customers = {kutsal, shieldKravmaga};
		
		customerManager.addMultiple(customers);
	}

}
