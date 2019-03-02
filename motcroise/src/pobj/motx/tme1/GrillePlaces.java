package pobj.motx.tme1;
import java.util.*;
/**
 * @author 3803464
 *
 * Classe qui représente une grille remplie et ses emplacements
 */
public class GrillePlaces {
	/**liste des emplacements contient tous les emplacement de la grille*/
	private List<Emplacement> places=new ArrayList<>();
	/**la grille */
	private Grille grille;
	/**le nombre d'emplacements horizentaux et verticaux */
	private int nbH,nbV;
	/**construire une nouvel grille remplie*/
	public GrillePlaces (Grille grille) {
		this.grille=grille;
		for(int i=0; i< grille.nbLig();i++) {
			cherchePlaces(getLig(i));
		}

		nbH=places.size();
		for(int i=0; i< grille.nbCol();i++) {
			cherchePlaces(getCol(i));
		}
	
		nbV=places.size()-nbH;

	}
	/**accède au emplacements de la grille
	 * 
	 *  @return les emplacements de la grille*/
	public List<Emplacement> getPlaces(){
		return places;
	}
	/**
	 * @return le nombre d'emplacements horizontaux
	 * */
	public int getNbHorizontal() {

		return  nbH;
	}
   /** redéfinition de toString*/
	public String toString() {
		int i=1;
		StringBuilder s = new StringBuilder();
		for(Emplacement e:places) {
			s.append("le mot"+i+" "+":"+e+"\n");
		}
		return s.toString();
	}
	/**accède à la ligne lig dans la grille
	 * @param indice de la ligne
	 * @return la liste des cases de la ligne lig de la grille*/
	private List<Case> getLig(int lig){
		List<Case> cases= new ArrayList<Case>();
		for (int i=0;i<grille.nbCol();i++) {
			cases.add(grille.getCase(lig, i));
		}
		return cases;
		
	}
	/**accède à la colonne col dans la grille
	 * @param indice de la colonne
	 * @return la liste des cases de la colonne col de la grille*/
	private List<Case> getCol(int col){
		List<Case> cases= new ArrayList<Case>();
		for (int i=0;i<grille.nbLig();i++) {
			cases.add(grille.getCase(i,col));
		}
		return cases;
	}
	/** cherche tout les emplacements dans la liste des cases fournie en parametre
	 * @param liste de cases de la grille
	 * */
	private void cherchePlaces(List<Case> cases) {
		List<Case> trouv=new ArrayList<Case>();	
		for(int j=0; j<cases.size()-1; j++) {
			if(!(cases.get(j).isPleine())&& !(cases.get(j+1).isPleine())) {
				while(j<cases.size()&&(!(cases.get(j).isPleine()))){
					trouv.add(cases.get(j));
					j++;
				}
				places.add(new Emplacement(trouv));
				trouv.clear();

			}
		}
		
	}
	/** faire une copie de la grille courante et fixe le mot soluce dans l'emplacement d'indice m
	 * @param m l'indice d'emplacement et soluce le mot a fixer
	 * @return la grillePlaces avec le mot fixé
	 * */
    public GrillePlaces fixer(int m, String soluce){
		Grille nouvelleGrille = grille.copy();
		Emplacement lemot = this.getPlaces().get(m);
		for( int i  = 0 ; i < lemot.size() ; i ++ ){
			nouvelleGrille.getCase(lemot.getCases().get(i).getLig() , lemot.getCases().get(i).getCol()).setChar(soluce.charAt(i));
		}
		return new GrillePlaces( nouvelleGrille );
		
	}
	/**accede à la grille courante
	 * @return la grille courante
	 * */
	public Grille getGrille() {
		return grille;
	}
}
