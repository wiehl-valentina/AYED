package Ejercicio9;

import Ejercicio1y3y5.GeneralTree;

public class ParcialArboles {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if (arbol != null && !arbol.isEmpty())
			return esDeSeleccionHelper(arbol); 
		return false; 
	}
	
	private static boolean esDeSeleccionHelper(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf())
			return true; 
		
		int min = Integer.MAX_VALUE; 
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			if (!esDeSeleccionHelper(child)) return false; 
			min = Math.min(child.getData(), min);
		}
		return min == arbol.getData(); 
	}
	
}
