package pobj.motx.tme1;

/**
 * @author 3803464
 *
 * Classe de représentation d'une case dans une grille de mots croisés
 */

public class Case {
	/**ligne de la case */	
 	private int lig;
	/** colone de la case */
 	private int col;
	/** le contenu de la case */
 	private char c;
 	/** consruit une Case de ligne de colonne et de contenu spécifiés*/
	public Case (int lig, int col,char c) {
		this.lig=lig;
		this.col = col;
		this.c=c;
	}
	/** Accède à la ligne de cette case 
	 * @return la ligne de cette case
	 */
	public int getLig() {
		return this.lig;
	}
	/**
	 * Accède à la colonne de cette case
	 * @return la colonne de cette case
	 */
	public int getCol() {
		return this.col;
	}
	/**
	 * Accède au contenu de la case
	 * @return le contenu de la case
	 */
	public char getChar() {
		return this.c;
	}
	/**
	 * modifie le contenu de la case
	 * @param c le nouveau contenu de la case
	 */
	public void setChar(char c) {
		this.c=c;
	}
	/**
	 * Teste si la case est vide
	 * @return vrai si la case est vide , faux sinon
	 */
	public boolean isVide() {
		return (this.c ==' ');
	}
	/**
	 * teste si la case est pleine
	 * @return vrai si la case est pleine
	 */
	public boolean isPleine() {
		return (this.c=='*');
	}
	/**
	 * redéfinition de toString 
	 */
	public String toString() {
		return this.c+" ";
	}
}
