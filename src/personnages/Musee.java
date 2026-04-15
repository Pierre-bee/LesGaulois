package personnages;

import objets.Equipement;
import objets.Trophee;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees;

	public void donnerTrophees(Gaulois gaulois, Equipement equipementDonne) {
		Trophee nouveauTrophee = new Trophee(gaulois, equipementDonne);
		if (nbTrophees < trophees.length) {
			trophees[nbTrophees] = nouveauTrophee;
		}
		else {
			System.out.println("Il n'y a plus de place dans le musée ! ");
		}
	}
}
