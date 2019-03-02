package pobj.motx.tme2;

/**
 * @author 3803464
 * décrit une contraine 
 */
public interface IContrainte {
	
	/**réduit le domaine potentiel en modifiant la grille passée en argument
	 * @param grille 
	 * @returnend le nombre total de mots filtrés
	 */
	public int reduce(GrillePotentiel grille);

}
