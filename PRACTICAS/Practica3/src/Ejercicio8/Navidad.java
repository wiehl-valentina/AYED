package Ejercicio8;

import Ejercicio1y3y5.GeneralTree;

public class Navidad {

	private GeneralTree<Integer> abeto; 
	
	public String esAbetoNavidenio() {
		if (abeto != null && !abeto.isEmpty())
			return esAbetoNavidenio(abeto) ? "Yes" : "No";
		return "No"; 
	}
	
	private boolean esAbetoNavidenio(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf()) 
			return true; 
		
		int hijosHoja = 0;
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			if (child.isLeaf())
				hijosHoja++;
			else if (!esAbetoNavidenio(child))
				return false;
		}
		return hijosHoja >= 3;
	}
}
