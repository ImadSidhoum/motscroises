package pobj.motx.tme3.csp;

import java.util.List;

/**
 * @author imad 
 * pour choisir une valeur depuis les valeurs possible
 */
public interface IChoixValeur {
	/** permet de choisir une valeur
	 * @param problem le probleme à resoudre (la grille complete)
	 * @param v l'emplacement concerné
	 * @return liste de valeurs possibles pour la variable v bien ordonné 
	 */
	public List<String> orderValues (ICSP problem, IVariable v);
	

}
