package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[2] equipements;
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
		int force_avant_coup = force;
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne!");
		} else {
			parler("Aïe");
		}
		assert force_avant_coup > force;
		assert isInvariantVerified();
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
	}
}