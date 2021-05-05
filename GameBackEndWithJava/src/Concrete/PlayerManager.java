package Concrete;

import Abstract.Player;
import Abstract.PlayerService;
import Abstract.PlayerValidation;
import Utils.NationChecker;

public class PlayerManager implements PlayerService {

	private PlayerValidation playerValidation;
	
	public PlayerManager(PlayerValidation playerValidation) {
		super();
		this.playerValidation = playerValidation;
	}

	@Override
	public void add(Player player) {
		if (NationChecker.checkIfTurkish(player)) {
			if (playerValidation.checkIfThePlayerValid(player)) {
				System.out.println("The player " + player.getFirstName() + ", added to the system successfully.");				
			}else {
				System.out.println("The player " + player.getFirstName() + " can't be added to the system becouse is invalid.");
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
