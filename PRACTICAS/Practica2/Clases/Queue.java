package Clases;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Sequence{
	private List<T> data;
	
	public Queue() {
		data = new ArrayList<T>(); 
	}
	
	public void enqueue(T dato) {
		this.data.add(dato); 
	}
	
	public T dequeue() {
		return this.data.remove(0);
	}

	public T head() {
		return this.data.get(0); 
	}
	
	@Override
	public int size() {
		return this.data.size(); 
	}

	@Override
	public boolean isEmpty() {
		return this.data.isEmpty(); 
	} 
	
	public String toString() {
		String aux = ""; 
		for (int i=0; i<this.data.size(); i++) {
			aux+= this.data.get(i) + " ";
		}
		return aux; 
	}
}
