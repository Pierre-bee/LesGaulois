package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceAvantCoup = force;
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne!");
		} else {
			parler("Aïe");
		}
		assert forceAvantCoup > force;
		assert isInvariantVerified();
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ". ");
	}

	public void sEquiper(Equipement equipement) {
		String presenter = "Le soldat " + nom;
		switch (nbEquipement) {
		case 0: {
			this.ajouterEquipement(equipement);
			break;
		}
		case 1: {
			if (equipement.equals(equipements[nbEquipement - 1])) {
				System.out.println(presenter + " possède déjà un " + equipement + ". ");
			} else {
				this.ajouterEquipement(equipement);
			}
			break;
		}
		default:
			System.out.println(presenter + " est déjà bien protégé ! ");
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}