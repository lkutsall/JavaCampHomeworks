import java.util.GregorianCalendar;

import Adapters.MernisValidator;
import Concrete.Campaign;
import Concrete.CampaignManager;
import Concrete.ForeignPlayer;
import Concrete.PlayerManager;
import Concrete.Product;
import Concrete.ProductManager;
import Concrete.TurkishPlayer;

public class Main {

	public static void main(String[] args) {

		PlayerManager playerManager = new PlayerManager(new MernisValidator());
		ProductManager productManager = new ProductManager();
		CampaignManager campaignManager = new CampaignManager(new MernisValidator());
		TurkishPlayer player1 = new TurkishPlayer();
		player1.setId(1);
		player1.setFirstName("Mehmet");
		player1.setLastName("Ağa");
		player1.setDateOfBirth(new GregorianCalendar(1900, 12, 30).getTime());
		player1.setNationalId("00000000000");
		
		playerManager.add(player1);
		
		ForeignPlayer player2 = new ForeignPlayer();
		player2.setId(1);
		player2.setFirstName("John");
		player2.setLastName("Doe");
		player2.setDateOfBirth(new GregorianCalendar(1999, 11, 01).getTime());
		
		playerManager.add(player2);
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Product product1 = new Product();
		product1.setId(1);
		product1.setProductName("Days Gone");
		product1.setPrice(200);
		
		productManager.add(product1);
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Campaign campaignForTurkish = new Campaign();
		campaignForTurkish.setId(1);
		campaignForTurkish.setCampaignName("Madem Türksün göster düşsün!");
		campaignForTurkish.setDiscountrate(25);
		
		campaignManager.add(campaignForTurkish);
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		campaignManager.applyCampaign(campaignForTurkish, player1, product1);
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		campaignManager.applyCampaign(campaignForTurkish, player2, product1);

	}

}
