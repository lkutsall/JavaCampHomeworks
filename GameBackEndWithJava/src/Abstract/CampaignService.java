package Abstract;

import Concrete.Campaign;
import Concrete.Product;

public interface CampaignService {

	void add(Campaign campaign);
	void update(Campaign campaign);
	void delete(Campaign campaign);
	void applyCampaign(Campaign campaign, Player player, Product product);
}
