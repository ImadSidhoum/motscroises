package pobj.motx.tme3.csp;

/**
 * @author imad
 * permet de choisir la bonne variable
 */
public interface IChoixVar {
	/**
	 * @param problem le probleme à resoudre ( grille complete)
	 * @return une variable qu'on va résoudre au premier
	 */
	public IVariable chooseVar(ICSP problem);


}
