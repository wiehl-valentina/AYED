package Ejercicio11;
import Ejercicio8.Queue;
import Ejercicio1y3y5.GeneralTree;

public class ParcialArboles11 {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
		GeneralTree<Integer> nodo; 
		int nodosNivelAnterior = 0;
		int nodosNivelActual = 0; 
		queue.enqueue(arbol);
		queue.enqueue(null);
		
		while (!queue.isEmpty()) {
			nodo = queue.dequeue();
			if (nodo != null) {
				nodosNivelActual++; 
				for (GeneralTree<Integer> child : arbol.getChildren())
					queue.enqueue(child);
			}
			else if (nodosNivelAnterior-nodosNivelActual!=1)
				return false; 
			else if (!queue.isEmpty()){
				queue.enqueue(null);
				nodosNivelAnterior = nodosNivelActual;
				nodosNivelActual = 0; 
			}
		}
		return true; 
	}
}
