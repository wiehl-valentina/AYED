package Ejercicio1y2;
import Clases.Queue;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int cantidadHojas = 0; 
		
		if (this.isEmpty())
			return 0; 
		
		if (this.isLeaf())
			return 1; 
		
		if (this.hasLeftChild())
			cantidadHojas += this.getLeftChild().contarHojas(); 
		if (this.hasRightChild())
			cantidadHojas += this.getRightChild().contarHojas();
		
		return cantidadHojas;
	}
		
    public BinaryTree<T> espejo(){
    	if (this.isLeaf())
    		return this; 
    	
    	BinaryTree<T> nodoEspejo = new BinaryTree<T>(); 
    	nodoEspejo.setData(this.getData()); 
    	if (this.hasLeftChild()) {
    		nodoEspejo.addRightChild(this.getLeftChild().espejo());
    	}
    	if (this.hasRightChild())
    		nodoEspejo.addLeftChild(this.getRightChild().espejo());
    	
    	return nodoEspejo; 
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		int nivel = 0;
		Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>(); 
		queue.enqueue(this);
		queue.enqueue(null);
		
		while (!queue.isEmpty() && nivel <= m) {
			BinaryTree<T> nodo = queue.dequeue(); 
			if (nodo != null) {
				if (nivel >= n)
					System.out.println(nodo.getData() + " | ");
				if (nodo.hasLeftChild())
					queue.enqueue(nodo.getLeftChild());
				if (nodo.hasRightChild())
					queue.enqueue(nodo.getRightChild());
			} else if (!queue.isEmpty()){
				nivel++; 
				queue.enqueue(null);
				System.out.println();
			}
		}	
   }
		
}

