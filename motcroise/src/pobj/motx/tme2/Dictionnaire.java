package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();
	
	private EnsembleLettre [] cache=null;

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		copy.setCache(cache);
		return copy;
	}
	/**
	 * Rend les mots de ce Dictionnaire.
	 * @return une liste de mots de ce Dictionnaire
	 */
	public List<String> getMots(){
		return mots;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		if (cpt>0) cache=null;
		return cpt;
	}
	/**
	 * Retire les mots qui ne contiennent pas le caractère c à la postion i.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param c le caractère de filtrage
	 * @param la position de caractère
	 * @return le nombre de mots supprimés
	 */
	public int filtreParLettre(char c,int i) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.charAt(i) == c)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		if (cpt>0) cache=null;
		return cpt;
	}
	/**
	 * Retire les mots qui ne contiennent pas un caractère de la liste c à la postion i.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param c liste des caractères pour le  filtrage
	 * @param la position de caractère
	 * @return le nombre de mots supprimés
	 */
	public int filtreParLettres(List<Character> c,int i) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (c.contains(mot.charAt(i)))
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		if (cpt>0) cache=null;
		return cpt;
	}
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dic = new Dictionnaire();
		try	(BufferedReader br = new BufferedReader( new FileReader(path))) {
			for (String line = br.readLine() ;line != null ; line = br.readLine() ) {
				dic.add(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return dic;
			
	}
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	public EnsembleLettre lettrePossible(int position){
		if (mots.isEmpty()) return new EnsembleLettre();
		if (cache==null) {
			cache=new EnsembleLettre[mots.get(0).length()];
			}
		if (cache[position]==null) {

			EnsembleLettre ens = new EnsembleLettre();
			for(int i = 0 ; i < mots.size() ; i++){
				ens.add(mots.get(i).charAt(position));
			}
			cache[position]=ens;
			}
		return cache[position];
		}
	public void setCache(EnsembleLettre [] cache) {
		this.cache=cache;
	}
}

