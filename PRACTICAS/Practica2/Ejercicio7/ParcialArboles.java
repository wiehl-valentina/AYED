package Ejercicio7;
import Ejercicio1y2.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> data; 
	
	public ParcialArboles(BinaryTree<Integer> dato) {
		data = dato; 
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> subarbol = buscar(data, num); 
		if (!subarbol.isEmpty())
			return isLeftTree(subarbol);
		else
			return false; 
	}
	
	private boolean isLeftTree(BinaryTree<Integer> arbol) {
		int hijosUnicosIzquierda = -1; 
		int hijosUnicosDerecha = -1; 
		
		if (arbol.hasLeftChild())
			hijosUnicosIzquierda = calcularHijosUnicos(arbol.getLeftChild());
		if (arbol.hasRightChild())
			hijosUnicosDerecha = calcularHijosUnicos(arbol.getRightChild());
		
		return hijosUnicosIzquierda > hijosUnicosDerecha; 
	}

	private int calcularHijosUnicos(BinaryTree<Integer> arbol) {
		int cantidadHijosUnicos = 0; 
		
		if (arbol.hasLeftChild())
			cantidadHijosUnicos += calcularHijosUnicos(arbol.getLeftChild());
		if (arbol.hasRightChild())
			cantidadHijosUnicos += calcularHijosUnicos(arbol.getRightChild());
		
		if (!arbol.hasLeftChild() && arbol.hasRightChild() || arbol.hasLeftChild() && !arbol.hasRightChild())
			cantidadHijosUnicos++;
		
		return cantidadHijosUnicos; 
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, int num) {
		if (arbol.getData() == num)
			return arbol; 
		BinaryTree<Integer> resultado = new BinaryTree<Integer>();
		if (arbol.hasLeftChild())
			resultado = buscar(arbol.getLeftChild(), num); 
		if (arbol.hasRightChild())
			resultado = buscar(arbol.getRightChild(), num);
		return resultado; 
	}
	
	
	
}
