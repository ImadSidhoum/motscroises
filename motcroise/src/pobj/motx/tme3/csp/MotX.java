package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;

/**
 * @author imad
 *
 */
public class MotX implements ICSP{
	/**
	 * l'ensemble des variable pour cet problem
	 */
	private List<IVariable> dicoVars=new ArrayList<>();
	
	/**
	 * la grille du problème
	 */
	private GrillePotentiel gp;
	/**permet de construire un nouveau problème
	 * @param gp la grille du problème
	 */
	public MotX(GrillePotentiel gp) {
		this.gp=gp;
		List<Emplacement> emps=gp.getGrillePlaces().getPlaces();
		for (int i=0;i<emps.size();i++) {
			if(emps.get(i).hasCaseVide()) {
				dicoVars.add(new DicoVariable(i,gp));
			}
		}		
	}

	@Override
	public List<IVariable> getVars() {
		
		return dicoVars;
	}

	@Override
	public boolean isConsistent() {
		return !gp.isDead();
		
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		DicoVariable bis;
		if(vi instanceof DicoVariable){
			bis = (DicoVariable) vi;
		}
		bis = (DicoVariable) vi;
		return new MotX( gp.fixer(bis.getIndex(), val) ) ;
	}
	public GrillePotentiel getGP() {
		return this.gp;
	}
}
