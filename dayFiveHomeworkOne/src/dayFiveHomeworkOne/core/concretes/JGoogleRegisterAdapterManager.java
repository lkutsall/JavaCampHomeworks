package dayFiveHomeworkOne.core.concretes;

import dayFiveHomeworkOne.core.abstracts.JGoogleRegisterAdapterService;
import jGoogle.JGoogleRegister;

public class JGoogleRegisterAdapterManager implements JGoogleRegisterAdapterService{

	JGoogleRegister googleRegister;
	
	public JGoogleRegisterAdapterManager(JGoogleRegister googleRegister) {
		super();
		this.googleRegister = googleRegister;
	}
	
	@Override
	public void registerWithGoogle(String message) {
		googleRegister.registerWithGoogle(message);
		
	}

}
