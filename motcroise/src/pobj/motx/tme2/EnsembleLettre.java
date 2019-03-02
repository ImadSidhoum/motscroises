package pobj.motx.tme2;

import java.util.*;

/**
 * @author 3803464
 * Décrit uen ensemble de caractère au sens mathématique
 */
public class EnsembleLettre {
	/**
	 * stocke les caractères de cet ensemble
	 */
	private List<Character> l= new ArrayList<>();
	/**construit un nouveau ensemble de lettres
	 * @param a liste de caractéres intiales
	 */
	public EnsembleLettre(List<Character> a) {
		l.addAll(a);
	}
	public EnsembleLettre() {

	}
	/**accède à la liste de caractères de cet ensemble
	 * @param I l'indice de caractères souhaité
	 * @return le caractère d'indice I dans la liste des lettres
	 */
	public char getCharInd(int I) {
		return l.get(I);
	}
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(char i:l) {
			sb.append(i+" ");
		}
		return sb.toString();
	}
	/** ajoute un nouveau caractère à l'ensemble s'il n'existe pas
	 * @param c le caractère à ajouter
	 * @return true si le caractère a été bien ajouté , faux sinon
	 */
	public boolean add(char c) {
		if (!l.contains(c)) {
			l.add(c);
			return true;
		}
		return false;
	}
	/**
	 * @return la taille de l'ensemble
	 */
	public int size() {
		return l.size();
	}
	/**
	 * @param c le caractère qu'on souhaite conaitre son existance
	 * @return true si l'ensemble contient ce caractère faux sinon
	 */
	public boolean contains(char c) {
		return l.contains(c);
	}
	/**
	 * @return liste de lettres de cet ensemble
	 */
	public List<Character> getLettres(){
		return l;
	}
	/** calcule l'intersection des deux ensemble
	 * @param a le premier ensemble de lettres
	 * @param b le deuxieme ensemble de lettres
	 * @return l'intersection des deux ensembles
	 */
	public EnsembleLettre intersection(EnsembleLettre a, EnsembleLettre b) {
		EnsembleLettre c=new EnsembleLettre(a.getLettres());
		c.getLettres().retainAll(b.getLettres());
		return c;
	}

}
