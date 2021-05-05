package Concrete;

import Abstract.MernisService;
import Abstract.Player;
import Abstract.PlayerService;
import Utils.NationChecker;

public class PlayerManager implements PlayerService {

	private MernisService mernisService;
	
	public PlayerManager(MernisService mernisService) {
		super();
		this.mernisService = mernisService;
	}

	@Override
	public void add(Player player) {
		if (NationChecker.checkIfTurkish(player)) {
			if (mernisService.checkIfThePlayerValid(player)) {
				System.out.println("The player " + player.getFirstName() + ", added to the system successfully.");				
			}else {
				System.out.println("The player " + player.getFirstName() + " can't be added to the system because is invalid.");
			}
		}else {
			System.out.println("The player " + player.getFirstName() + ", added to the system successfully.");
		}
	}

	@Override
	public void update(Player player) {
		System.out.println("The player " + player.getFirstName() + "'s information updated successfully.");
		
	}

	@Override
	public void delete(Player player) {
		System.out.println("The player " + player.getFirstName() + ", deleted from the system successfully.");
		
	}

}
