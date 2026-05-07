package Ejercicio6;
import Ejercicio1y2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol; 
	
	public Transformacion(BinaryTree<Integer> data) {
		arbol = data; 
	}
	
	public BinaryTree<Integer> suma() {
		if (!arbol.isEmpty())
			suma(arbol); 
		return arbol; 
	}
	
	private int suma(BinaryTree<Integer> arbolOriginal) {
		int suma = 0;
		int dato = arbol.getData();
		
		if (arbolOriginal.isLeaf()) {			
			suma = arbolOriginal.getData();
			arbolOriginal.setData(0);
			return suma; 
		}
		
		if (arbolOriginal.hasLeftChild())
			suma += suma(arbolOriginal.getLeftChild());
		if (arbolOriginal.hasRightChild())
			suma += suma(arbolOriginal.getRightChild());
		
		arbolOriginal.setData(suma);
		return suma + dato; 
	}
	
	public static void main (String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<Integer>(2));
        arbol.addRightChild(new BinaryTree<Integer>(6));
        arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        arbol.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        System.out.println("Arbol original");
        System.out.println();
        arbol.entreNiveles(0, 2);
        System.out.println();
        System.out.println();
        System.out.println("--------------------");
        Transformacion trasformacion = new Transformacion(arbol);
        BinaryTree<Integer> arbolTransformado = trasformacion.suma();
        System.out.println();
        System.out.println("Arbol transformado");
        System.out.println();
        arbolTransformado.entreNiveles(0, 2); 
    }	
}
