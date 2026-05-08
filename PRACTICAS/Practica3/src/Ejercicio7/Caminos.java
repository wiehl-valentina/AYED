package Ejercicio7;

import java.util.*; 

import Ejercicio1y3y5.GeneralTree;

public class Caminos {
	
	private GeneralTree<Integer> arbol; 
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> resultado = new LinkedList<Integer>(); 
		if (arbol != null && !arbol.isEmpty()) {
			caminoAHojaMasLejana(arbol, new LinkedList<Integer>(), resultado);
		}
		return resultado; 
	}
	
	private void caminoAHojaMasLejana(GeneralTree<Integer> arbol, List<Integer> caminoActual, List<Integer> caminoMaximo) {
		caminoActual.add(arbol.getData());
		
		if (arbol.hasChildren())
			for (GeneralTree<Integer> child : arbol.getChildren())
				caminoAHojaMasLejana(child, caminoActual, caminoMaximo);
		else if (caminoActual.size() > caminoMaximo.size()) {
			caminoMaximo.clear(); 
			caminoMaximo.addAll(caminoActual);
		}
		caminoActual.remove(caminoActual.size()-1);
	}
	
}
