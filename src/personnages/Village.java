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
		return villageois[numVillageois];
	}
}
