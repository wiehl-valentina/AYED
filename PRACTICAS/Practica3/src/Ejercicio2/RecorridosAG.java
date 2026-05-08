package Ejercicio2;

import java.util.*;

import Ejercicio1y3y5.GeneralTree;
import Ejercicio1y3y5.Queue;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>(); 
		if (!a.isEmpty())
			numerosImparesMayoresQuePreOrden(a, n, resultado);
		return resultado; 
	}
	
	private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> arbol, Integer n, List<Integer> lista) {
		if (arbol.getData() % 2 == 1 && arbol.getData() > n)
			lista.add(arbol.getData());
		
		for (GeneralTree<Integer> child : arbol.getChildren())
			numerosImparesMayoresQuePreOrden(child, n, lista);
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>(); 
		if (!a.isEmpty())
			numerosImparesMayoresQueInOrden(a, n, resultado);
		return resultado; 
	}
	
	private void numerosImparesMayoresQueInOrden(GeneralTree<Integer> arbol, Integer n, List<Integer> resultado) {
		if (arbol.hasChildren())
			numerosImparesMayoresQueInOrden(arbol.getChildren().get(0), n, resultado);
		
		if (arbol.getData() % 2 == 1 && arbol.getData() > n)
			resultado.add(arbol.getData());
		
		if (arbol.hasChildren())
			for (int i=1; i < arbol.getChildren().size(); i++)
				numerosImparesMayoresQueInOrden(arbol.getChildren().get(i), n, resultado); 
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>(); 
		if (!a.isEmpty())
			numerosImparesMayoresQuePostOrden(a, n, resultado); 
		return resultado; 
	}
	
	private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> arbol, Integer n, List<Integer> resultado) {
		if (arbol.hasChildren())
			for (GeneralTree<Integer> child : arbol.getChildren())
				numerosImparesMayoresQuePostOrden(child, n, resultado); 
		if (arbol.getData() % 2 == 1 && arbol.getData() > n)
			resultado.add(arbol.getData());
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>(); 
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(a);
		queue.enqueue(null);
		
		while (!queue.isEmpty()) {
			GeneralTree<Integer> nodo = queue.dequeue(); 
			if (nodo != null) {
				if (nodo.getData() % 2 == 1 && nodo.getData() > n)
					resultado.add(nodo.getData());
				for (GeneralTree<Integer> child : nodo.getChildren())
					queue.enqueue(child);
			}
			else if (!queue.isEmpty())
				queue.enqueue(null);
		}
		
		return resultado; 
	}
	
}
