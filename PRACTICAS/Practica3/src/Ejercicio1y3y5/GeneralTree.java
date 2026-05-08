package Ejercicio1y3y5; 

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	
		return !this.isEmpty() ? altura(this, 0) : -1;
	}
	
	private int altura(GeneralTree<T> arbol, int altura) {
		if (arbol.isLeaf())
			return altura;
		altura++;
		int max = 0; 
		if (arbol.hasChildren())
			for (GeneralTree<T> child : arbol.getChildren())
				max = Math.max(altura(child, altura), max);
		return max; 
	}
	
	public int nivel(T dato){
		return !this.isEmpty() ? nivelHelper(dato) : -1; 
	}
	
	private int nivelHelper(T dato) {
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		queue.enqueue(this);
		queue.enqueue(null);
		int nivel = 0; 
		
		while (!queue.isEmpty()) {
			GeneralTree<T> nodo = queue.dequeue(); 
			if (nodo != null) {
				if (nodo.getData().equals(dato))
					return nivel; 
				if (nodo.hasChildren())
					for (GeneralTree<T> child : nodo.getChildren())
						queue.enqueue(child);
			}
			else if (!queue.isEmpty()) {
				queue.enqueue(null);
				nivel++; 
			}
		}
		// retorna -1 si no encuentra el dato en el árbol
		return -1; 
	}

	public int ancho(){
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		queue.enqueue(this);
		queue.enqueue(null);
		
		int nodosMaximos = 1; 
		int nodosActuales = 0; 
		
		while (!queue.isEmpty()) {
			GeneralTree<T> nodo = queue.dequeue(); 
			if (nodo != null) {
				for (GeneralTree<T> child : nodo.getChildren()) {
					queue.enqueue(child);
					nodosActuales++; 
				}
			}
			else if (!queue.isEmpty()) {
				nodosMaximos = Math.max(nodosMaximos, nodosActuales);
				nodosActuales = 0; 
				queue.enqueue(null);
			}
		}
		return nodosMaximos; 
	}
	
	public boolean esAncestro(T a, T b) {
		if (!this.isEmpty() && this != null)
			return esAncestroHelper(a, b);
		return false; 
	}
	
	private boolean esAncestroHelper(T a, T b) {
		GeneralTree<T> nodoA = buscarNodos(this, a);
		
		if (nodoA != null) {
			if (nodoA.hasChildren())
				for (GeneralTree<T> child : nodoA.getChildren())
					if (buscarNodos(child, b) != null) return true; 
		}
		return false; 
	}
	
	private GeneralTree<T> buscarNodos(GeneralTree<T> arbol, T dato) {
		if (arbol.getData().equals(dato))
			return arbol; 
		
		if (arbol.hasChildren())
			for (GeneralTree<T> child : arbol.getChildren()) {
				GeneralTree<T> res = buscarNodos(child, dato); 
				if (res != null) return res; 
			}
		return null; 
	}
}