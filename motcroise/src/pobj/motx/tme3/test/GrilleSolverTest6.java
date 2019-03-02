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
 
public class GrilleSolverTest6 {

	@Test
	public void testLarge() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		System.out.println("succès grille large ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	@Test
	public void testLarge2() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large2.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		System.out.println("succès grille large2 ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	@Test
	public void testLarge3() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large3.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		problem = (MotX) solver.solve(problem);

		System.out.println("succès grille large3 ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	@Test
	public void testLarge4() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large4.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		System.out.println("succès grille large4 ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	@Test
	public void testLarger() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/larger.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		problem = (MotX) solver.solve(problem);
	
		System.out.println("succès grille larger ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	@Test
	public void testReverse() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/reverse.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);
		System.out.println("succès grille reverse ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	@Test
	public void testPropage() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/propage.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		

		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		//ICSP solution = solver.solve(problem);
		ICSP solution = solver.solve(problem);

			problem = (MotX) solver.solve(problem);
		
	
		System.out.println("succès grille propage ");
		System.out.println("Solution \n" + ((MotX)solution).getGP().getGrillePlaces().getGrille() + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
}
