package Ejercicio10;

import java.util.*;

import Ejercicio1y3y5.GeneralTree;

public class ParcialArboles {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> resultado = new LinkedList<Integer>(); 
		if (arbol != null && !arbol.isEmpty())
			resolver(arbol, resultado, new LinkedList<Integer>(), 0, 0, 0);
		return resultado; 
	}
	
	private static int resolver(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> caminoActual, int nivel, int max, int suma) {
		if (arbol.getData() == 1) {
			caminoActual.add(1);
			suma+= arbol.getData() * nivel; 
		}
		
		if(arbol.hasChildren())
			for (GeneralTree<Integer> child : arbol.getChildren())
				max = resolver(child, resultado, caminoActual, nivel+1, max, suma);
		else if (suma > max) {
			max = suma; 
			resultado.clear();
			resultado.addAll(caminoActual); 
		}
		if (arbol.getData() == 1)
			caminoActual.remove(caminoActual.size()-1);
		return max; 
	}

}
