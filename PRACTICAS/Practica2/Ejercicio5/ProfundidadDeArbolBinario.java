package Ejercicio5;
import Ejercicio1y2.BinaryTree;
import Clases.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol; 
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> data) {
		arbol = data; 
	}
	
	public int sumarElementosProfundidad(int profundidad) {
		Queue<BinaryTree<Integer>> queue = new Queue<BinaryTree<Integer>>(); 
		queue.enqueue(arbol);
		queue.enqueue(null);
		
		int nivel = 0;
		int suma = 0; 
		
		while (!queue.isEmpty() && nivel <= profundidad) {
			BinaryTree<Integer> nodo = queue.dequeue(); 
			if (nodo != null) {
				if (nivel == profundidad)
					suma += nodo.getData();
				else {					
					if (nodo.hasLeftChild())
						queue.enqueue(nodo.getLeftChild());
					if (nodo.hasRightChild())
						queue.enqueue(nodo.getRightChild());
				}
			} else if (!queue.isEmpty()) {
				nivel++; 
				queue.enqueue(null);
			}
		}
		return suma; 
	}
}
