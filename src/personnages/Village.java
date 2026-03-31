package personnages;



public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;

	public Village(String nom, String nomChef, int forceChef, final int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		chef = new Gaulois(nomChef, forceChef);
		chef.setVillage(this);
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}
	public void ajouterVillageois(Gaulois gaulois) {
		gaulois.setVillage(this);
		villageois[nbVillageois] =  gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village ! ");
			return null;
		}
		return villageois[numVillageois-1];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village \"" + this.nom + "\" du chef " + this.chef.getNom() +  " vivent les gaulois : ");
		for(int i = 0; i < nbVillageois; i += 1) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", "Abraracourcix", 6, 30);
		village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
	}
}
