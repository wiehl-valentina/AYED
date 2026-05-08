package Ejercicio4;

public class AreaEmpresa {
	
	private String id; 
	private int retardo;
	
	public AreaEmpresa(String id, int retardo) {
		super();
		this.id = id;
		this.retardo = retardo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getRetardo() {
		return retardo;
	}
	
	public void setRetardo(int retardo) {
		this.retardo = retardo;
	} 
	
}
