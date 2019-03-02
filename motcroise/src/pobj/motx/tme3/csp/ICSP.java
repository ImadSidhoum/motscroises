package pobj.motx.tme3.csp;

import java.util.List;

/**
 * @author imad
 *  représente un problem
 */
public interface ICSP {
	/**
	 * @return l'ensemble de variable du problem
	 */
	public List<IVariable> getVars();
	/**
	 * @return true si le problem est consistent , false sinon
	 */
	public boolean isConsistent();
	/** fixe la variable vi à la valeur val
	 * @param vi une varaible de problem
	 * @param val une valeur possible de la variable vi 
	 * @return le problem après avoir fixer vi à val
	 */
	public ICSP assign(IVariable vi, String val);
}
