package Ejercicio8;
import Ejercicio1y2.BinaryTree;

public class ParcialArboles {
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		// si uno de los dos árboles está vacío chequeo que ambos lo estén
		if (arbol1.isEmpty() || arbol2.isEmpty())
			return arbol1.isEmpty() && arbol2.isEmpty(); 
		return iguales(arbol1, arbol2);
	}
	
	private boolean iguales(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (!arbol1.getData().equals(arbol2.getData()))
			return false;
		
		boolean resultado = true; 
		
		if (arbol1.hasLeftChild())
			if (arbol2.hasLeftChild())
				resultado = resultado && iguales(arbol1.getLeftChild(), arbol2.getLeftChild());
			else
				return false; 
		
		if (resultado)
			if (arbol1.hasRightChild())
				if (arbol2.hasRightChild())
					resultado = resultado && iguales(arbol1.getRightChild(), arbol2.getRightChild());
				else
					return false;
		
		return resultado;
	}
	
}
