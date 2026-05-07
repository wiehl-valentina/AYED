package Ejercicio4;
import Ejercicio1y3y5.GeneralTree;
import Ejercicio8.Queue;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		if (!arbol.isEmpty()) return 0;
		else return (!arbol.isLeaf()) ? devolverMaximoPromedioHelper(arbol) : arbol.getData().getTiempo(); 
	}
	
	private double devolverMaximoPromedioHelper(GeneralTree<AreaEmpresa> arbol) {
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>(); 
		GeneralTree<AreaEmpresa> nodo; 
		queue.enqueue(arbol);
		queue.enqueue(null);
		int tiempoTotal = 0; 
		int max = -1; 
		int cantidadNodos = 0; 
		
		while (!queue.isEmpty()) {
			nodo = queue.dequeue();
			if (nodo != null) {
				tiempoTotal+= nodo.getData().getTiempo();
				cantidadNodos++; 
				for (GeneralTree<AreaEmpresa> child : arbol.getChildren())
					queue.enqueue(child);
			}
			else {
				if (!queue.isEmpty())
					queue.enqueue(null);
				max = Math.max(max, (tiempoTotal/cantidadNodos));
				cantidadNodos = 0; 
				tiempoTotal = 0; 
			}
		}
		return max; 
	}
}
