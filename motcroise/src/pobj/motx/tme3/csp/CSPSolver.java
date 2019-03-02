package pobj.motx.tme3.csp;

import java.util.Collections;
import java.util.List;

public class CSPSolver {
	private IChoixVar stratVar =new StratMin() ;
	public IChoixVar getStratVar() {
		return stratVar;
	}
	public void setStratVar(IChoixVar stratVar) {
		this.stratVar = stratVar;
	}
	public ICSP solve(ICSP problem) {
		// Condition terminale : succès
		if (problem.getVars().isEmpty()) {
			return problem;
		}
		// condition terminale : échec sur cette branche
		if (!problem.isConsistent()) {
			return problem;
		} else {
		}
		// On choisit une variable arbitraire, ici la première
		// On est garantis que ! getVars().isEmpty(), testé au dessus
		IVariable vi = this.stratVar.chooseVar(problem);
		System.out.print(((MotX)problem).getGP().getGrillePlaces().getGrille());
		ICSP next = null;
		// On est garantis que toute variable a un domaine non nul
		IChoixValeur f= new StratValFisrt();
		List<String> vals=f.orderValues(problem, vi);
		/*List<String> vals=vi.getDomain();
		Collections.shuffle(vals);*/
		for (String val : vals) {
			//System.out.println("Fixe var :" + ((DicoVariable)vi).getIndex() + " à " + val);
			next = problem.assign(vi, val);
			next = solve(next);
			if (next.isConsistent()) {
				return next;
			} else {
				//System.out.println("Essai valeur suivante.");
			}
			
		}
		//System.out.println("Backtrack sur variable "+((DicoVariable)vi).getIndex());
		return next;
	}

}
