package Ejercicio10;
import Ejercicio1y3y5.GeneralTree;
import java.util.*; 

public class ParcialArboles10 {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> resultado = new LinkedList<Integer>();
		if (!arbol.isEmpty())
			resolver(arbol, resultado, new LinkedList<Integer>(), 0, 0, -1);
		return resultado; 
	}
	
	private static int resolver(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> listaActual, int nivel, int suma, int max) {
		if (arbol.getData().equals(1)) {
			listaActual.add(arbol.getData());
			suma+= nivel; 
		}
		if (arbol.isLeaf() && suma > max) {
			max = suma; 
			resultado.clear();
			resultado.addAll(listaActual);
		}
		for (GeneralTree<Integer> child : arbol.getChildren()) 
			max = resolver(child, resultado, listaActual, nivel+1, suma, max);
		if (arbol.getData().equals(1))
			listaActual.remove(listaActual.size()-1);
		return max; 
	}
}
