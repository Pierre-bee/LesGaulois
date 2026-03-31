package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public void setVillage(Village village) {
		this.village = village;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force * effetPotion / 3);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		if (village == null) {
			System.out.println("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else {
			if (village.getChef().getNom() == nom) {
				System.out.println(
						"Bonjour, je m'appelle " + nom + ". Je suis le chef du village nommé \"" + village + "\".");
			} else {
				System.out.println("Bonjour, je m'appelle " + nom + ". J'habite le village nommé \"" + village + "\".");
			}
		}
	}

	@Override
	public String toString() {
		return nom + " [Gaulois, force = " + force + "]";
	}

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
}
