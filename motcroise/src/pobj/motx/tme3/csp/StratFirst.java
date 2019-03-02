package pobj.motx.tme3.csp;

/**
 * @author imad
 *représente la stratégie de choix de variable qui prend la premiere variable 
 */
public class StratFirst implements IChoixVar{

	@Override
	public IVariable chooseVar(ICSP problem) {
		
		return ((MotX)problem).getVars().get(0);
	}

}
