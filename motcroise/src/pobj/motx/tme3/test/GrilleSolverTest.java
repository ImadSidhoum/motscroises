package pobj.motx.tme3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.csp.MotX;
import pobj.motx.tme3.csp.CSPSolver;
import pobj.motx.tme3.csp.ICSP;
 
public class GrilleSolverTest {

	@Test
	public void testSplit() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/split.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		problem = (MotX) solver.solve(problem);
		System.out.println("succès grille split ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

}
