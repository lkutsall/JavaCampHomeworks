package Utils;

import Abstract.Player;
import Concrete.TurkishPlayer;

public class NationChecker {

	public static boolean checkIfTurkish(Player player) {
		
		boolean isTurkish = true;
		
		if (player.getClass() == TurkishPlayer.class) {
			return isTurkish;
		}else {
			isTurkish = false;
			return isTurkish;
		}
	}
	
}
