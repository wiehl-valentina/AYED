package Ejercicio6;

import Ejercicio1y3y5.GeneralTree;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> red;
	
	public double minimoCaudal(double caudal) {
		if (!red.isEmpty() && red != null)
			return minimoCaudal(red, caudal);
		return 0; 
	}
	
	private double minimoCaudal(GeneralTree<Character> red, double caudal) {
		double min = Double.MAX_VALUE;
		if (red.isLeaf())
			return caudal; 
		if (red.hasChildren())
			for (GeneralTree<Character> child : red.getChildren())
				min = Math.min(minimoCaudal(child, caudal/red.getChildren().size()), min);
		return min; 
	}

}
