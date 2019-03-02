package pobj.motx.tme3.csp;

import java.util.List;

/**
 * @author imad
 *représente une variable
 */
public interface IVariable {
	/**
	 * @return l'ensemble de valeurs possibles pour cette variable
	 */
	public List<String> getDomain();


}
