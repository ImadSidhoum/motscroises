package pobj.motx.tme2;
import java.util.*;

import pobj.motx.tme1.*;

/**
 * @author 3803464
 * contient la grille actuelle avec les touts les emplacements avec leurs domains potentiels
 */
public class GrillePotentiel {
	/**
	 *  stocke la grille actuelle (partiellement remplie)
	 */
	private GrillePlaces gr;
	/**
	 * stocke le dictionnaire français complet
	 */
	private Dictionnaire dictionnaire;
	/**
	 * stocke le domaine de chaque emplace-ment de la grille, dans le même ordre que la grille
	 */
	private List<Dictionnaire> motsPot=new ArrayList<Dictionnaire>();
	/**
	 * stocke la liste des contraintes de croisement entre deux mots
	 */
	private List<IContrainte> contraintes= new ArrayList<>();
	/** construit une nouvelle grille potentiel et calcule les contraintes
	 * @param grille la grille a résoudre
	 * @param dicoComplet le dictionnaire français complet
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {

		gr=grille;
		dictionnaire=dicoComplet;
		initialiserMotsPot();
		//filtrageLongueurAndFixe();
		rechercheContrainte();
		propage();
	}
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet , List<Dictionnaire> motsPot ){
		gr=grille;
		dictionnaire=dicoComplet;
		this.motsPot = motsPot;
		filtrageLongueurAndFixe();
		rechercheContrainte();
		propage();
}
	
	/**
	 * recherche touts les croisements entre les emplacements et crée les contraintes
	 */
	private void rechercheContrainte() {
		int nbH=gr.getNbHorizontal();
		Emplacement e1,e2;
		List<Case> c1,c2;
		for  (int i=0;i<nbH;i++) {
			e1=gr.getPlaces().get(i);
			for(int j=nbH;j<gr.getPlaces().size();j++) {
				e2=gr.getPlaces().get(j);
				c1=e1.getCases();
				c2=e2.getCases();
				for(int k =0;k<c1.size();k++) {
					for (int l=0;l<c2.size();l++) {
						if((c1.get(k).getLig()==c2.get(l).getLig())&&
								(c1.get(k).getCol()==c2.get(l).getCol())){
							if(c1.get(k).isVide()) 
								contraintes.add(new CroixContrainte(i,k,j,l));
								break;
						}

					}
				}
			}
			
		}
		
	}
	
	/**
	 *  filtre les dictionnaire de chaque emplacement par la longueur de cet emplacement
	 *  et  les filtre meme par caractères fixes
	 */
	private void filtrageLongueurAndFixe() {
		List<Emplacement> emplacements=gr.getPlaces();
		int i=0;
		char c;
		for(Emplacement e:emplacements) {
			motsPot.get(i).filtreLongueur(e.size());	
			for (int j=0; j<e.size();j++) {
				c=e.getCases().get(j).getChar();
				if (c!=' ') {
					motsPot.get(i).filtreParLettre(c, j);
				}
			}
			i++;
		}
		
	}
	
	/**
	 * intialise touts les mots potentiel de chaque emplacement par touts les mots possilbes(dictionnaire français complet) 
	 */
	private void initialiserMotsPot() {

		List<Emplacement> emplacements=gr.getPlaces();
		int i=0;
		char c;
		Dictionnaire dico;
		for(Emplacement e:emplacements) {
			dico=dictionnaire.copy();
			dico.filtreLongueur(e.size());	
			for (int j=0; j<e.size();j++) {
				c=e.getCases().get(j).getChar();
				if (c!=' ') {
					dico.filtreParLettre(c, j);
				}
			}
			motsPot.add(dico);
			i++;
		}
	}
	
	/**
	 * @return l'ensemble des contraintes de cette grille
	 */
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	/**
	 * @return true si cette grille reste réalisable false sinon
	 */
	public boolean isDead() {
		for(Dictionnaire c: motsPot) {
			if (c.size()==0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return liste de dictionnaire des mots potentiels de chaque emplacement 
	 */
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	/**fixe le mot soluce dans l'emplacement m  
	 * @param m indice d'un emplacement
	 * @param soluce le mot à fixer dans la grille
	 * @return une copie de cette grille avec le mot soluce fixé à l'emplacement d'indice m 
	 */
	/*public GrillePotentiel fixer(int m, String soluce) {
		
		GrillePotentiel l=new GrillePotentiel(gr.fixer(m, soluce),dictionnaire);
		return l;
	}*/
	public GrillePotentiel fixer(int m, String soluce){
		 
		GrillePlaces grille = gr.fixer( m , soluce );
		List<Dictionnaire> mots = new ArrayList<Dictionnaire>();
		
		for( int i = 0 ; i < motsPot.size() ; i++ ){
			mots.add( motsPot.get(i).copy() );
		}
		return new GrillePotentiel( grille, dictionnaire , mots  );
		
}
	/**
	 * @return grillePlace de cette grille
	 */
	public GrillePlaces getGrillePlaces() {
		return gr;
	}
	
	/** propage les contraintes
	 * @return true si la propagation des contraintes a convergée false sinon(pas realisable)
	 */
	private boolean propage() {
		int res=0;
		while(true) {
			res=0;
			for (IContrainte a:contraintes) {
				res+=a.reduce(this);
			}
			if (this.isDead()) {
				return false;
			}
			//BONUS 3
			/*for (int i=0;i<motsPot.size();i++) {
				Dictionnaire a=motsPot.get(i);
				if (a.size()==1) {
					contraintes.add(new MotUnique(a.get(0),i));
					
				}
			}*/
			if (res==0) {
				return true;
			}

			
			
		}
		
		
	}

}
