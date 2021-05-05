package Concrete;

import Abstract.CampaignService;
import Abstract.Player;
import Abstract.PlayerValidation;
import Utils.NationChecker;

public class CampaignManager implements CampaignService {

	private PlayerValidation playerValidation;
	
	public CampaignManager(PlayerValidation playerValidation) {
		super();
		this.playerValidation = playerValidation;
	}

	@Override
	public void add(Campaign campaign) {
		System.out.println(campaign.getCampaignName() + " added to the system successfully.");
		
	}

	@Override
	public void update(Campaign campaign) {
		System.out.println(campaign.getCampaignName() + " updated successfully.");
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println(campaign.getCampaignName() + " deleted from the system successfully.");
		
	}

	@Override
	public void applyCampaign(Campaign campaign, Player player, Product product) {
		
		if (NationChecker.checkIfTurkish(player) && playerValidation.checkIfThePlayerValid(player) ) {
			System.out.println(player.getFirstName() + "; the campaign applied to your product successfully. Now the " + product.getProductName() + "'s price is just " + ((product.price*campaign.discountrate)/100) + " $ only for you.");
		}else {
			System.out.println("Sorry " + player.getFirstName() + ", this campaign is valid for only Turkish citizens. If you are Turkish citizen, this means the information you gave is invalid. If you are not Turkish citizen, please try the other campaigns that works for your country.");
		}
		
	}

}
