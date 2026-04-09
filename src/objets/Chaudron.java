package objets;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;

	public boolean resterPotion() {
		return quantitePotion != 0;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion += quantite;
		this.forcePotion = forcePotion;
	}

	public int prendreLouche() {
		if (quantitePotion < 1) {
			forcePotion = 0;
		} else {
			quantitePotion--;
		}
		return forcePotion;
	}
}
