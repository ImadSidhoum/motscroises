package pobj.motx.tme1;

import java.util.*;

/**
 * @author 3803464
 * Classe qui représent un mot dans une grille de mots croisés
 */

public class Emplacement {
	/** liste de cases qui représente un emplacement dans une grille (un mot)*/
	private List<Case> lettres= new ArrayList<>();

	/**Construit un nouvel emplacement 
	 * @param cases liste de cases de cet emplacement
	 * */
	
	public Emplacement(List<Case> cases) {
		for(int i=0;i<cases.size();i++) {
			lettres.add(cases.get(i));
		}
	}
	public Emplacement() {}
	/**redéfinition de toString
	 * */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Case lettre:lettres) {
			sb.append(lettre.getChar());
		}
		return "case de debut :("+lettres.get(0).getLig()+","+lettres.get(0).getCol()+")"+sb.toString();
	}
	/**calcule la taille de l'emplacement
	 * @return taille de l'emplacement
	 */
	public int size() {
		return lettres.size();
	}
	/**accède au cases de cet emplacement
	 * @return liste des cases de cet emplacement
	 */
	public List<Case> getCases(){
		return lettres;
	}
	 public boolean hasCaseVide() {
		 for (Case c : lettres) {
			 if (c.isVide())return true;
		 }
		 return false;
	 }
	 public void addCase(Case c) {
		 lettres.add(c);
	 }

}
