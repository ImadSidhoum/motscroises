package pobj.motx.tme2;

public class MotUnique implements IContrainte{
	String motFix;
	int emp;
	public MotUnique(String motFix,int emp) {
		this.emp=emp;
		this.motFix=motFix;
	}
	@Override
	public int reduce(GrillePotentiel grille) {
		int cpt=0;
		for (int i=0 ;i<grille.getMotsPot().size();i++) {
			if (i!=emp) {
				if(grille.getMotsPot().get(i).getMots().remove(motFix)) {
					cpt++;
				}
			}
		}
		return cpt;
	}

}
