package Adapters;

import java.rmi.RemoteException;
import java.time.ZoneId;

import Abstract.Player;
import Abstract.PlayerValidation;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisValidator implements PlayerValidation {

	@Override
	public boolean checkIfThePlayerValid(Player turkishPlayer) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = false;

		try {
			return client.TCKimlikNoDogrula(
					Long.parseLong(turkishPlayer.getNationalId()), 
					turkishPlayer.getFirstName().toUpperCase(), 
					turkishPlayer.getLastName().toUpperCase(), 
					turkishPlayer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear()
					);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
