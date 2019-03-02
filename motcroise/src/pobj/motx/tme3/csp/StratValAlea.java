package pobj.motx.tme3.csp;

import java.util.Collections;
import java.util.List;

/**
 * @author imad
 * représente la stratégie d'ordonnancement de valeurs possible pour une variable aléatoirement
 */
public class StratValAlea implements IChoixValeur {

	@Override
	public List<String> orderValues(ICSP problem, IVariable v) {
		List<String> vals=v.getDomain();
		Collections.shuffle(vals);
		return vals;
	}

}
