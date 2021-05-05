package Adapters;

import java.rmi.RemoteException;
import java.time.ZoneId;

import Abstract.MernisService;
import Abstract.Player;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements MernisService {

	private KPSPublicSoapProxy client;
	
	public MernisServiceAdapter(KPSPublicSoapProxy client) {
		super();
		this.client = client;
	}

	public boolean checkIfThePlayerValid(Player turkishPlayer) {

		boolean result = false;

		try {
			return client.TCKimlikNoDogrula(Long.parseLong(turkishPlayer.getNationalId()),
					turkishPlayer.getFirstName().toUpperCase(), turkishPlayer.getLastName().toUpperCase(),
					turkishPlayer.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear());
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
