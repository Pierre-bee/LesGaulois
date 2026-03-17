package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public boolean resterPotion() {
		if (quantitePotion == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
}
