package pobj.motx.tme2;

import java.util.*;

import pobj.motx.tme1.Emplacement;

/**
 * @author 3803464
 *  décrit une contrainte de croisement entre deux mots
 */
public class CroixContrainte implements IContrainte {
	/**l'indice de premier emplacement*/
	private int emp1Ind;
	/**l'indice de deuxiem emplacement*/
	private int emp2Ind;
	/**la position de croisement dans le premier emplacement*/
	private int case1Ind;
	/**la position de croisement dans le deuxiem emplacement*/
	private int case2Ind;
	/**
	 * permet de construire une nouvelle contraine de croisement
	 * @param m1 l'indice de premier emplacement
	 * @param c1 la position de croisement dans le premier emplacement
	 * @param m2 l'indice de deuxiem emplacement
	 * @param c2 la position de croisement dans le deuxiem emplacement
	 */
	public CroixContrainte(int m1,int c1,int m2, int c2) {
		emp1Ind=m1;
		emp2Ind=m2;
		case1Ind=c1;
		case2Ind=c2;
	}

	@Override
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre l1= new EnsembleLettre(new ArrayList<Character>());
		EnsembleLettre l2= new EnsembleLettre(new ArrayList<Character>());
		Dictionnaire d1=grille.getMotsPot().get(emp1Ind);
		Dictionnaire d2=grille.getMotsPot().get(emp2Ind);
		l1=d1.lettrePossible(case1Ind);
		l2=d2.lettrePossible(case2Ind);
		EnsembleLettre inter=l1.intersection(l1, l2);
     	int cpt=0;			
		if(l1.size()>inter.size())cpt+=d1.filtreParLettres(inter.getLettres(), case1Ind);
		if(l2.size()>inter.size())cpt+=d2.filtreParLettres(inter.getLettres(), case2Ind);
		return cpt;
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) 	return true;
		if(!(other instanceof CroixContrainte)) return false;
		CroixContrainte c=(CroixContrainte) other;
		return(c.case1Ind==case1Ind && c.emp1Ind==emp1Ind &&
				c.case2Ind==case2Ind && c.emp2Ind==emp2Ind);
 	}
	@Override
	public String toString() {
		return "CroixContrainte [emp1Ind=" + emp1Ind + ", emp2Ind=" + emp2Ind + ", case1Ind=" + case1Ind + ", case2Ind="
				+ case2Ind + "] \n";
	}
	

}
