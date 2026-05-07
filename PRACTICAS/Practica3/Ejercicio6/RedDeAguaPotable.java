package Ejercicio6;
import java.util.LinkedList;
import java.util.List;

import Ejercicio1y3y5.GeneralTree;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> red; 
	
	public RedDeAguaPotable(GeneralTree<Character> red) {
		this.red = red; 
	}
	
	public double minimoCaudal(double caudal) {
		return (!red.isEmpty()) ? minimoCaudalHelper(red, caudal) : 0; 
	}
	
	private double minimoCaudalHelper(GeneralTree<Character> red, double caudal) {
		if (red.isLeaf()) return caudal; 
		double minGeneral = Integer.MAX_VALUE; 
		double minPorHijo;
		
		for (GeneralTree<Character> child : red.getChildren()) {
			minPorHijo = minimoCaudalHelper(child, caudal/red.getChildren().size());
			minGeneral = Math.min(minGeneral, minPorHijo);
		}
		return minGeneral; 
	}
	
	public static void main(String[] args) {
		GeneralTree<Character> arbol = new GeneralTree<Character>('A');
		GeneralTree<Character> hijo1 = new GeneralTree<Character>('B');
		GeneralTree<Character> hijo2 = new GeneralTree<Character>('C');
		GeneralTree<Character> hijo3 = new GeneralTree<Character>('D');
		GeneralTree<Character> hijo4 = new GeneralTree<Character>('E');
		GeneralTree<Character> hijo5 = new GeneralTree<Character>('F');
		GeneralTree<Character> hijo6 = new GeneralTree<Character>('G');
		GeneralTree<Character> hijo7 = new GeneralTree<Character>('H');
		GeneralTree<Character> hijo8 = new GeneralTree<Character>('I');
		GeneralTree<Character> hijo9 = new GeneralTree<Character>('J');
		GeneralTree<Character> hijo10 = new GeneralTree<Character>('K');
		GeneralTree<Character> hijo11 = new GeneralTree<Character>('L');
		GeneralTree<Character> hijo12 = new GeneralTree<Character>('M');
		GeneralTree<Character> hijo13 = new GeneralTree<Character>('N');
		GeneralTree<Character> hijo14 = new GeneralTree<Character>('O');
		
		List<GeneralTree<Character>> hijos1 = new LinkedList<GeneralTree<Character>>();
		hijos1.add(hijo1);
		hijos1.add(hijo2);
		hijos1.add(hijo3); 
		hijos1.add(hijo4); 
		arbol.setChildren(hijos1);
		
		List<GeneralTree<Character>> hijos2 = new LinkedList<GeneralTree<Character>>();
		hijos2.add(hijo5);
		hijos2.add(hijo6);
		hijo2.setChildren(hijos2);
		
		List<GeneralTree<Character>> hijos3 = new LinkedList<GeneralTree<Character>>();
		hijos3.add(hijo7); 
		hijos3.add(hijo8); 
		hijos3.add(hijo9); 
		hijos3.add(hijo10); 
		hijos3.add(hijo11); 
		hijo3.setChildren(hijos3);
		
		hijo6.addChild(hijo12);
		
		List<GeneralTree<Character>> hijos4 = new LinkedList<GeneralTree<Character>>();
		hijos4.add(hijo13);
		hijos4.add(hijo14);
		hijo9.setChildren(hijos4);
		
		GeneralTree<Character> arbol2 = new GeneralTree<Character>(); 
		
		RedDeAguaPotable red = new RedDeAguaPotable(arbol2); 
		System.out.println(red.minimoCaudal(1000));
	}
}
