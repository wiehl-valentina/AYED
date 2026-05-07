package Ejercicio2;
import java.util.*;

import Ejercicio1y3y5.GeneralTree;
import Ejercicio8.Queue;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> arbol, Integer n) {
		List<Integer> numeros = new LinkedList<Integer>(); 
		if (arbol != null && !arbol.isEmpty())
			recorrerPreorden(arbol, n, numeros); 
		return numeros; 
	}
	
	private void recorrerPreorden(GeneralTree<Integer> arbol, Integer n, List<Integer> lista) {
		if (arbol.getData()%2!=0 && arbol.getData() > n)
			lista.add(arbol.getData());
		if (arbol.hasChildren())
			for (GeneralTree<Integer> child: arbol.getChildren()) {
				recorrerPreorden(child, n, lista);
			}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> arbol, Integer n) {
		List<Integer> numeros = new LinkedList<Integer>(); 
		if (arbol != null && !arbol.isEmpty())
			recorrerInOrden(arbol, n, numeros);
		return numeros; 
	}
	
	public void recorrerInOrden(GeneralTree<Integer> arbol, Integer n, List<Integer> lista) {
		if (arbol.hasChildren())
			recorrerInOrden(arbol.getChildren().get(0), n, lista);
		if (arbol.getData()%2!=0 && arbol.getData() > n)
			lista.add(arbol.getData());
		if (arbol.getChildren().size() > 1)
			for (int i=1; i < arbol.getChildren().size(); i++)
				recorrerInOrden(arbol.getChildren().get(i), n, lista);
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> arbol, Integer n) {
		List<Integer> numeros = new LinkedList<Integer>(); 
		if (arbol != null && !arbol.isEmpty())
			recorrerPostOrden(arbol, n, numeros); 
		return numeros; 
	}
	
	public void recorrerPostOrden(GeneralTree<Integer> arbol, Integer n, List<Integer> lista) {
		if (arbol.hasChildren())
			for (GeneralTree<Integer> child: arbol.getChildren())
				recorrerPostOrden(child, n, lista); 
		if (arbol.getData()%2!=0 && arbol.getData() > n)
			lista.add(arbol.getData()); 
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> arbol, Integer n) {
		List<Integer> numeros = new LinkedList<Integer>(); 
		GeneralTree<Integer> nodo; 
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>(); 
		queue.enqueue(arbol);
		// no encolo null porque no me interesa diferenciar el nivel
			
		while (!queue.isEmpty()) {
			nodo = queue.dequeue(); 
			// pregunto por el caso de que el nodo esté vacío, no null ya que no interesa diferenciar niveles
			if (!nodo.isEmpty()) {
				if (nodo.getData()%2!=0 && nodo.getData() > n)
						numeros.add(nodo.getData());
				for (GeneralTree<Integer> child: nodo.getChildren())
						queue.enqueue(child);
			}
		}
		return numeros; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
