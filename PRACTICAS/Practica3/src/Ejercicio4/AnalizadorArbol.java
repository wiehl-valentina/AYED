package Ejercicio4;

import Ejercicio1y3y5.GeneralTree;
import Ejercicio1y3y5.Queue;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		if (arbol == null || arbol.isEmpty())
			return 0; 
		
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>(); 
		queue.enqueue(arbol);
		queue.enqueue(null);
		
		double cantidadNodos = 0;
		double tiempoRetardo = 0; 
		double max = 0; 
		
		while (!queue.isEmpty()) {
			GeneralTree<AreaEmpresa> nodo = queue.dequeue(); 
			if (nodo != null) {
				cantidadNodos++; 
				tiempoRetardo += nodo.getData().getRetardo();
				for (GeneralTree<AreaEmpresa> child : nodo.getChildren())
					queue.enqueue(child);
			}
			else {
				max = Math.max(tiempoRetardo/cantidadNodos, max);
				cantidadNodos = 0; 
				tiempoRetardo = 0; 
				if (!queue.isEmpty())
					queue.enqueue(null);
			}
		}
		return max; 
	}
	
}
