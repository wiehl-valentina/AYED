package Ejercicio1y3y5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Ejercicio1y2.BinaryTree;
import Ejercicio8.Queue;

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
		return (!this.isEmpty() ? altura(this) : -1);
	}
	
	private int altura(GeneralTree<T> arbol) {
		if (arbol.isLeaf()) return 0; 
		else {
			int altura = 0; 
			for (GeneralTree<T> child : arbol.getChildren())
				altura = Math.max(altura, altura(child));
			return altura; 
		}
	}
	
	public int nivel(T dato){
		return nivel(this, dato); 
	}
	
	private int nivel(GeneralTree<T> arbol, T dato) {
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		GeneralTree<T> nodo; 
		int nivel = 0; 
		queue.enqueue(arbol);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			nodo = queue.dequeue(); 
			if (nodo != null) {
				if (nodo.getData() == dato) return nivel; 
				else
					for (GeneralTree<T> child : arbol.getChildren())
						queue.enqueue(child);
			}
			else {
				nivel++; 
				queue.enqueue(null);
			}
		}
		// en caso de no encontrarse en el árbol el dato, retorna -1
		return -1; 
	}

	public int ancho(){
		if (this.isEmpty()) return 0;
		else return (!this.isLeaf()) ? ancho(this) : 1;
	}
	
	public int ancho(GeneralTree<T> arbol) {
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		GeneralTree<T> nodo; 
		queue.enqueue(arbol);
		queue.enqueue(null);
		int cantidadNodos = 0; 
		int max = -1; 
		
		while (!queue.isEmpty()) {
			nodo = queue.dequeue(); 
			if (nodo != null) {
				cantidadNodos++; 
				for (GeneralTree<T> child : arbol.getChildren())
					queue.enqueue(child);
			}
			else if (!queue.isEmpty()) {
				queue.enqueue(null);
				max = Math.max(max, cantidadNodos);
				cantidadNodos = 0; 
			}
		}
		return max; 
	}
	
	public void imprimir(){
		if (this.isEmpty()) return; 
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		GeneralTree<T> nodo; 
		queue.enqueue(this);
		queue.enqueue(null);
		
		while (!queue.isEmpty()) {
			nodo = queue.dequeue(); 
			if (nodo != null) {
				System.out.print(nodo.getData() + " ");
				if (nodo.hasChildren())
					for (GeneralTree<T> child : nodo.getChildren())
						queue.enqueue(child); 
			}
			else if (!queue.isEmpty()) {
				System.out.println(); 
				queue.enqueue(null);
			}
		}
	}
	
	public boolean esAncestro(T a, T b) {
		boolean encontreA = false; 
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>(); 
		GeneralTree<T> nodo = null; 
		queue.enqueue(this);
		queue.enqueue(null);
		
		while (!queue.isEmpty()) {
			nodo = queue.dequeue(); 
			if (nodo != null) {
				if (nodo.getData().equals(a)) encontreA = true; 
				if (nodo.getData().equals(b) && !encontreA) return false;
				if (!encontreA)
					for (GeneralTree<T> child : this.getChildren())
						queue.enqueue(child); 
				
			}
		}
		return (encontreA) ? buscarDescendiente(nodo, b) : false; 
	}
	
	public boolean buscarDescendiente(GeneralTree<T> arbol, T b) {
		boolean encontreB = false; 
		if (arbol.getData().equals(b)) encontreB = true;
		if (arbol.hasChildren()) {
			Iterator<GeneralTree<T>> it = arbol.getChildren().iterator(); 
			while (!encontreB && it.hasNext()) 
				encontreB = buscarDescendiente(it.next(), b);
		}
		return encontreB; 
	}
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(10);
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(5); 
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(8); 
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(21); 
		
		GeneralTree<Integer> a4 = new GeneralTree<Integer>(7); 
		GeneralTree<Integer> a5 = new GeneralTree<Integer>(51); 
		
		LinkedList<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1); 
		children.add(a2);
		children.add(a3);
		arbol.setChildren(children);
		
		LinkedList<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(a4);
		children2.add(a5);
		a2.setChildren(children2);
		
		GeneralTree<Integer> a6 = new GeneralTree<Integer>(17); 
		a4.addChild(a6);
		
		// tests
		System.out.print(arbol.altura());
	}
}