package Ejercicio11;

import Ejercicio1y3y5.GeneralTree;
import Ejercicio1y3y5.Queue;

public class ParcialArboles {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
		queue.enqueue(arbol);
		queue.enqueue(null);
		
		int nodosEsperados = 1; 
		int nodosActuales = 0; 
		
		while (!queue.isEmpty()) {
			GeneralTree<Integer> nodo = queue.dequeue(); 
			if (nodo != null) {
				nodosActuales++; 
				if (nodo.hasChildren())
					for (GeneralTree<Integer> child : nodo.getChildren()) {
						queue.enqueue(child);
					}
						
			}
			else {
				if (nodosActuales != nodosEsperados)
					return false;
				if (!queue.isEmpty()) {
					queue.enqueue(null); 
					nodosEsperados++; 
					nodosActuales = 0;					
				}
			}
		}
		return true; 
	}

}
