package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

/**
 * @author imad
 * représente dictionnaire d'un variable
 */
public class DicoVariable implements IVariable {
			/**
			 * l'indice d'emplacement
			 */
			private int index;
			private GrillePotentiel gp;
			
			/**
			 * @param index l'indice d'emplacement
			 * @param gp grille pententiel 
			 */
			public DicoVariable(int index, GrillePotentiel gp) {
				this.index = index;
				this.gp = gp;
			}

			@Override
			public List<String> getDomain() {
				return gp.getMotsPot().get(index).getMots();
			}

			/**
			 * @return l'indice d'emplacement
			 */
			public int getIndex() {
			return index;
			}
			

}
