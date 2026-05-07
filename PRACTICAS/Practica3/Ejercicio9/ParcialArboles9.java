package Ejercicio9;
import Ejercicio1y3y5.GeneralTree;

public class ParcialArboles9 {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		return (!arbol.isEmpty()) ? esDeSeleccionHelper(arbol) : false; 
	}
	
	private static boolean esDeSeleccionHelper(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf()) return true; 
		int min = Integer.MAX_VALUE;  
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			if (!esDeSeleccionHelper(child)) return false; 
			min = Math.min(min, child.getData()); 	
		}
		return (min==arbol.getData()) ? true : false; 
	}
}

