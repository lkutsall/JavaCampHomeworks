package Concrete;

import Abstract.Entity;

public class Campaign implements Entity {

	int id;
	String campaignName;
	float discountrate;
	
	public Campaign() {
		
	}
	
	public Campaign(int id, String campaignName, float discountrate) {
		super();
		this.id = id;
		this.campaignName = campaignName;
		this.discountrate = discountrate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public float getDiscountrate() {
		return discountrate;
	}

	public void setDiscountrate(float discountrate) {
		this.discountrate = discountrate;
	}
}
