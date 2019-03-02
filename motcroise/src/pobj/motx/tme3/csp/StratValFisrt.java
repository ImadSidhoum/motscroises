package pobj.motx.tme3.csp;

import java.util.List;

/**
 * @author imad
 * * représente la stratégie d'ordonnancement de valeurs possible pour une variable qui prend les valeurs dans l'ordre initial

 */
public class StratValFisrt implements IChoixValeur {

	@Override
	public List<String> orderValues(ICSP problem, IVariable v) {
	
		return v.getDomain();
	}

}
