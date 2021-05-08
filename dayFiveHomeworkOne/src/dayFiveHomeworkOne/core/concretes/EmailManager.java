package dayFiveHomeworkOne.core.concretes;

public class EmailManager{

	public static void sendVerificationMail(String email) {
		System.out.println("Verification mail sent to email: ".concat(email));
		
	}
	
	public static boolean verify(String answer) {
		switch (answer) {
		case "y":
		case "Y": {
			
			System.out.println("Verified!");
			return true;
		}
		case "n":
		case "N": {
			
			System.out.println("Verification ancelled!");
			return false;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + answer);
		}
	}

}
