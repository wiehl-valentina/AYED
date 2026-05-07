package Ejercicio9;
import Ejercicio1y2.BinaryTree;

public class ParcialArboles {
	public BinaryTree<Dato> sumAndDif(BinaryTree<Integer> arbol) {
		BinaryTree<Dato> arbolNuevo = new BinaryTree<Dato>(); 
		if (!arbol.isEmpty())
			sumAndDif(arbol, arbolNuevo, 0, 0);
		return arbolNuevo; 
		
	}
	
	private void sumAndDif(BinaryTree<Integer> original, BinaryTree<Dato> nuevo, int datoPadre, int suma) {
		Dato valoresNuevos = new Dato(original.getData()+suma, original.getData()-datoPadre);
		nuevo.setData(valoresNuevos);
		
		if (original.hasLeftChild()) {
			nuevo.addLeftChild(new BinaryTree<Dato>());
			sumAndDif(original.getLeftChild(), nuevo.getLeftChild(), original.getData(), original.getData()+suma);
		}
		
		if (original.hasRightChild()) {
			nuevo.addRightChild(new BinaryTree<Dato>());
			sumAndDif(original.getRightChild(), nuevo.getRightChild(), original.getData(), original.getData()+suma);
		}
	}
}