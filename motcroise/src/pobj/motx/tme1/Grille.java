package pobj.motx.tme1;

/**
 * @author 3803464
 * Classe de représentation d'un grille de mots croisés
 */
public class Grille {
	/**une grille de 2 dimension contenant tous les cases */
	private Case[][] cases;
	/**construit une grille vierge avec la hauteur et la largeur passées en parametre */
	public Grille(int hauteur, int largeur) {
		this.cases=new Case[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j < largeur;j++) {
				cases[i][j]=new Case(i,j,' ');
			}
		}
	}
	/**accède à la case à la ligne lig et colonne col
	 * @param lig indice de la ligne et col indice de la colonne
	 * @return la case à cet emplacement*/
	public Case getCase(int lig, int col) {
		if((cases[lig][col].getLig()==lig)&&
				(cases[lig][col].getCol()==col)) {
			return cases[lig][col];
		}
		else return null;
	}
	/**
	 * @return le nombre de lignes de la grille */
	public int nbLig() {
		return this.cases.length;
	}
	/**
	 * @return le nombre de colonnes de la grille */
	public int nbCol() {
		return this.cases[0].length;
	}
	/**redéfinition de la fonction toString*/
	@Override
	public 	String toString() {
		return GrilleLoader.serialize(this,false);
	}
	/**copie la grille actuelle en créant une nouvelle grille avec nouvelles réferences
	 * @return une copie de cette grille */
	public Grille copy() {
		Grille result=new Grille(this.nbLig(),this.nbCol());
		for(int i=0;i<this.nbLig();i++) {
			for(int j=0;j<this.nbCol();j++) {
				result.getCase(i,j).setChar(this.getCase(i,j).getChar());
			}
		}
		return result;
	}
}
