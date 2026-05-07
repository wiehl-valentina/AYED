package Ejercicio8;
import Ejercicio1y3y5.GeneralTree;

public class Navidad<T> {
	
	GeneralTree<T> arbol; 
	
	public Navidad(GeneralTree<T> arbol) {
		this.arbol = arbol; 
	}
	
	public String esAbetoNavidenio() {
		if (arbol.isLeaf()) return "No es abeto navideño"; 
		return (!arbol.isEmpty() && esAbetoNavidenio(arbol)) ? "Es abeto navideño" : "No es abeto navideño";
	}
	
	private boolean esAbetoNavidenio(GeneralTree<T> arbol) {
		if (arbol.isLeaf())
			return true; 
		int cantHijosHojas = 0; 
		for (GeneralTree<T> child : arbol.getChildren())
			if (esAbetoNavidenio(child))
				cantHijosHojas++; 
		return (cantHijosHojas>=3) ? true : false; 
	}
	
}
