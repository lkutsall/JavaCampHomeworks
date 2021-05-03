package intro;

public class Main {

	public static void main(String[] args) {
		String internetBranchButton = "Internet branch";
		double dollarYesterday = 8.15;
		double dollarToday = 8.15;
		int expiration = 36;
		boolean isDrop = false;

		System.out.println(internetBranchButton);

		if (dollarToday < dollarYesterday) {
			System.out.println("Dollar decreased png.");
		} else if (dollarToday > dollarYesterday) {
			System.out.println("Dollar increased png.");
		} else {
			System.out.println("Dollar didn't change png.");
		}

		String credit1 = "Fast Credit";
		String credit2 = "Happy Retired Credit";
		String credit3 = "Mortgage Credit";
		String credit4 = "Farmer's Credit";
		String credit5 = "MSB Credit";
		String credit6 = "MEB Credit";

		System.out.println(credit1);
		System.out.println(credit2);
		System.out.println(credit3);
		System.out.println(credit4);
		System.out.println(credit5);
		System.out.println(credit6);

		String[] credits = 
			{
				"Fast Credit",
				"Happy Retired Credit",
				"Mortgage Credit",
				"Farmer's Credit",
				"MSB Credit",
				"MEB Credit",
				"Cultural Ministry Credit"
			};
		
		//foreach
		for(String credit : credits) {
			System.out.println(credit);
		}
		
		for(int i = 0; i < credits.length; i++) {
			System.out.println(credits[i]);
		}
		
		int num1 = 10;
		int num2 = 20;
		num1 = num2;
		num2 = 100;
		System.out.println(num1);
		
		int[] numbers1 = {1,2,3,4,5};
		int[] numbers2 = {10,20,30,40,50};
		numbers1 = numbers2;
		numbers2[0] = 100;
		System.out.println(numbers1[0]);
		
		String city1 = "Ankara";
		String city2 = "Istanbul";
		city1 = city2;
		city2 = "Izmir";
		System.out.println(city1);

	}

}
