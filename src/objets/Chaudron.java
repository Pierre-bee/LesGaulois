package objets;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;
	
	public boolean resterPotion() {
		if (quantitePotion == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public int prendreLouche() {
		if (quantitePotion == 0) {
			forcePotion = 0;
		}
		else {
			quantitePotion -= 1;
		}
		return forcePotion;
	}
}
