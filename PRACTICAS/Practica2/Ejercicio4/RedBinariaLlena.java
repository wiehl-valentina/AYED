package Ejercicio4;
import Ejercicio1y2.BinaryTree;

public class RedBinariaLlena {
	BinaryTree<Integer> red; 
	
	public RedBinariaLlena(BinaryTree<Integer> data) {
		this.red = data; 
	}
	
	public int retardoReenvio() {
		if (!red.isEmpty())
			return retardoReenvio(this.red);
		else
			return -1; 
	}
	
	public int retardoReenvio(BinaryTree<Integer> arbol) {
		int tiempo = 0; 
		
		if (arbol.isLeaf())
			return arbol.getData(); 
		
		if (arbol.hasLeftChild())
			tiempo = Math.max(retardoReenvio(arbol.getLeftChild()), tiempo);
		if (arbol.hasRightChild())
			tiempo = Math.max(retardoReenvio(arbol.getRightChild()), tiempo);
		
		return tiempo + arbol.getData(); 
	}
}
