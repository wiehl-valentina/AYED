package Ejercicio4;

import Ejercicio1y3y5.GeneralTree;

public class Test {
	
	public static void main(String[] args) {

		// 1. Crear los objetos AreaEmpresa (Datos)
		AreaEmpresa a1 = new AreaEmpresa("Mantenimiento", 10); 
		AreaEmpresa a2 = new AreaEmpresa("Sistemas", 5); 
		AreaEmpresa a3 = new AreaEmpresa("Recursos Humanos", 15); 
		AreaEmpresa a4 = new AreaEmpresa("Redes", 20); 
		AreaEmpresa a5 = new AreaEmpresa("Desarrollo", 25); 
		AreaEmpresa a6 = new AreaEmpresa("Capacitacion", 8); 
	
		// 2. Crear los nodos del árbol (GeneralTree)
		GeneralTree<AreaEmpresa> nodoMantenimiento = new GeneralTree<>(a1);
		GeneralTree<AreaEmpresa> nodoSistemas = new GeneralTree<>(a2);
		GeneralTree<AreaEmpresa> nodoRRHH = new GeneralTree<>(a3);
		GeneralTree<AreaEmpresa> nodoRedes = new GeneralTree<>(a4);
		GeneralTree<AreaEmpresa> nodoDesarrollo = new GeneralTree<>(a5);
		GeneralTree<AreaEmpresa> nodoCapacitacion = new GeneralTree<>(a6);
	
		// 3. Armar la estructura jerárquica
		// Mantenimiento (Raíz)
		//  ├── Sistemas
		//  │    ├── Redes
		//  │    └── Desarrollo
		//  └── Recursos Humanos
	//	       └── Capacitacion
	
		nodoMantenimiento.addChild(nodoSistemas);
		nodoMantenimiento.addChild(nodoRRHH);
	
		nodoSistemas.addChild(nodoRedes);
		nodoSistemas.addChild(nodoDesarrollo);
	
		nodoRRHH.addChild(nodoCapacitacion);
		
		AnalizadorArbol analizador = new AnalizadorArbol(); 
		System.out.println(analizador.devolverMaximoPromedio(nodoMantenimiento));
		
	}
}
