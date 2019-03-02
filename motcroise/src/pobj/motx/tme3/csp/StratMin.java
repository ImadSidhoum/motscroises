package pobj.motx.tme3.csp;


import java.util.List;

/**
 * @author imad
 * représente la stratégie de choix de variable qui choisis la variable qui a le plus petit domaine
 */
public class StratMin implements IChoixVar {

	@Override
	public IVariable chooseVar(ICSP problem) {
		List<IVariable> dicoVars=((MotX)problem).getVars();
		IVariable a=dicoVars.get(0);
		for (IVariable b:dicoVars) {
			if (b.getDomain().size()<a.getDomain().size()) {
				a=b;
			}
		}
		return a;
	}

}
