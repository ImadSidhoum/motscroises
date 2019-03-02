package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author imad
 * * représente la stratégie d'ordonnancement de valeurs possible pour une variable qui ordonne les valeurs d'aprés le score scrabble

 */
public class StratValFreq implements IChoixValeur {
	/**
	 * dictionnaire représente le score de chaque caractère
	 */
	private Map<Character,Integer> scores=new HashMap<>();
	/**
	 * les scores de chaque caractère
	 */
	int[] sc= {1,3,3,2,1,4,2,4,1,8,10,1,2,1,1,3,8,1,1,1,1,4,10,10,10,10};
	/**
	 * les caractères possibles
	 */
	Character[] scs= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	/**
	 * construit et initialise map de caractère-score
	 */
	public StratValFreq() {
		for (int i=0;i<sc.length;i++) {
			scores.put(scs[i],sc[i]);
		}
	}
	@Override
	public List<String> orderValues(ICSP problem, IVariable v) {
		List<String> valeurs=v.getDomain();
		Map<Integer,List<String>> res=new TreeMap<>();
		for (String s:valeurs) {
			int sc=score(s);
			if (res.containsKey(sc)) {
				res.get(sc).add(s);
			}
			else {
				List<String> a= new ArrayList<>();
				a.add(s);
				res.put(sc,a);
			}
			
		}
		valeurs.clear();
		for(List<String> z: res.values()) {
			valeurs.addAll(z);
		}
		Collections.reverse(valeurs);
		return valeurs;
		
	}
	
	/**calcule le score total de mot
	 * @param mot  le mot qu'on veut calculer son score
	 * @return le score total du mot 
	 */
	private int score(String mot) {
		int cpt=0;
		for (int i=0 ; i<mot.length();i++) {
			cpt+=scores.get(mot.charAt(i));
		}
		return cpt;
	}

}
