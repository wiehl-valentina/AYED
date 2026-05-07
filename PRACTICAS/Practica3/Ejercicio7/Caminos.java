package Ejercicio7;
import java.util.*; 

import Ejercicio1y3y5.GeneralTree;

public class Caminos {
	
	private GeneralTree<Integer> arbol; 
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> resultado = new LinkedList<Integer>();  
		if (!arbol.isEmpty())
			caminoAHojaMasLejana(arbol, resultado, new LinkedList<Integer>());
		return resultado; 
	}
	
	public void caminoAHojaMasLejana(GeneralTree<Integer> arb, List<Integer> resultado, List<Integer> caminoActual) {
		caminoActual.add(arb.getData());
		// si es una hoja chequeo que caminoActual > resultado y de ser así actualizo resultado
		if (arb.isLeaf() && caminoActual.size() > resultado.size()) {
			resultado.clear();
			resultado.addAll(caminoActual); 
		}
		else
			for (GeneralTree<Integer> child : arb.getChildren())
				caminoAHojaMasLejana(child, resultado, caminoActual);
		caminoActual.remove(caminoActual.size()-1);
	}
	
}
