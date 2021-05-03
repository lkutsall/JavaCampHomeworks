package interfaces;

public class Main {

	public static void main(String[] args) {
		
		Logger[] loggers = {new SmsLogger(), new EmailLogger(), new DatabaseLogger()};
		
		CustomerManager customerManager =  new CustomerManager(loggers);
		
		Customer kutsal = new Customer(1, "Kutsal", "Mustafaoglu");
		
		customerManager.add(kutsal);

	}

}
