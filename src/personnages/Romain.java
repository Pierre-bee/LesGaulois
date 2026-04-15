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

	public int getForce() {
		return force;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = diminuerForceViaResistance(forceCoup);
		force -= forceCoup;
		if (force > 0 && forceCoup != 0) {
			parler("Aïe");
		} else if (force <= 0 && forceCoup != 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		assert isInvariantVerified();
		return equipementEjecte;
	}

	private int diminuerForceViaResistance(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 6;
				} else  {
					resistanceEquipement += 3;
				}
			}
			if (resistanceEquipement >= forceCoup) {
				texte += "\nMais heureusement, grâce à mon équipement sa force a été complètement absorbée. ";
			} else {
				texte += "\nMais heureusement, grace à mon équipement sa force est diminué de " + resistanceEquipement
						+ "!";
			}
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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