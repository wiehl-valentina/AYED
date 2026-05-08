package Ejercicio2;

import Ejercicio1y3y5.GeneralTree;

public class Test {

	public static void main(String[] args) {
				/*
		        
		        1
		  /     |     \
		 2      3      4
		/  \      \    / | \
		5    6      7  8  9 10
		   |
		  11
		
		*/
		
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		GeneralTree<Integer> nodo11 = new GeneralTree<>(11);
		GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
		GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
		GeneralTree<Integer> nodo9 = new GeneralTree<>(9);
		GeneralTree<Integer> nodo10 = new GeneralTree<>(10);
		
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
		nodo6.addChild(nodo11);
		
		GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
		nodo2.addChild(nodo5);
		nodo2.addChild(nodo6);
		
		GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
		nodo3.addChild(nodo7);
		
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		nodo4.addChild(nodo8);
		nodo4.addChild(nodo9);
		nodo4.addChild(nodo10);
		
		GeneralTree<Integer> arbol = new GeneralTree<>(1);
		arbol.addChild(nodo2);
		arbol.addChild(nodo3);
		arbol.addChild(nodo4);
	
		RecorridosAG recorridos = new RecorridosAG(); // [5, 11, 7, 9]
		System.out.println(recorridos.numerosImparesMayoresQuePreOrden(arbol, 4)); 
		System.out.println(recorridos.numerosImparesMayoresQueInOrden(arbol, 4));
		System.out.println(recorridos.numerosImparesMayoresQuePostOrden(arbol, 4));
		System.out.println(recorridos.numerosImparesMayoresQuePorNiveles(arbol, 4)); // [5, 7, 9, 11]
		System.out.println(arbol.altura());
		System.out.println(arbol.nivel(11));
		System.out.println(arbol.ancho());
		System.out.println(arbol.esAncestro(2, 11));
	}

}
