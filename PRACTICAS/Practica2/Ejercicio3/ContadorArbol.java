package Ejercicio3;
import Ejercicio1y2.BinaryTree;
import java.util.*; 
public class ContadorArbol {
	private BinaryTree<Integer> data; 
	
	public List<Integer> listarParesInOrden() {
		List<Integer> pares = new LinkedList<Integer>();
		if (!this.data.isEmpty())
			recorrerInOrden(data, pares);
		return pares; 
			
	}
	
	public List<Integer> listarParesPostOrden() {
		List<Integer> pares = new LinkedList<Integer>();
		if (!this.data.isEmpty())
			recorrerPostOrden(data, pares); 
		return pares; 
	}
	
	private boolean esPar(int dato) {
		return dato%2==0; 
	}
	
	private void recorrerInOrden(BinaryTree<Integer> arbol, List<Integer> lista) {
		if (arbol.hasLeftChild())
			recorrerInOrden(arbol.getLeftChild(), lista);
		if (esPar(arbol.getData()))
			lista.add(arbol.getData());
		if (arbol.hasRightChild())
			recorrerInOrden(arbol.getRightChild(), lista);
	}
	
	private void recorrerPostOrden(BinaryTree<Integer> arbol, List<Integer> lista) {
		if (arbol.hasLeftChild())
			recorrerPostOrden(arbol.getLeftChild(), lista); 
		if (arbol.hasRightChild())
			recorrerPostOrden(arbol.getRightChild(), lista);
		if (esPar(arbol.getData()))
			lista.add(arbol.getData());
	}
}
