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
			nbTrophees++;
		}
		else {
			System.out.println("Il n'y a plus de place dans le musée ! ");
		}
	}
	
	public String extraireInstructionsOCaml() {
		String listeOCaml = "let musee = [";
		StringBuilder valeursListe = new StringBuilder();
		for(int i = 0; i < nbTrophees; i++) {
			valeursListe.append("\n\t");
			valeursListe.append("\"");
			valeursListe.append(trophees[i].getGaulois().getNom());
			valeursListe.append("\"");
			valeursListe.append(", ");
			valeursListe.append("\"");
			valeursListe.append(trophees[i].getEquipement());
			valeursListe.append("\"");
			valeursListe.append(";");
		}
		valeursListe.delete(valeursListe.length()-1, valeursListe.length());
		listeOCaml += valeursListe.toString();
		listeOCaml += "\n]";
		return listeOCaml;
	}
}
