package domidron;

import java.util.List;

public class Ruta {

	private int numeroEntregas = 0;
	private List<String> entregas;
	
	public Ruta(List<String> entregas){
		this.entregas = entregas;
		this.numeroEntregas = entregas.size();
	}
	
	
	public int getNumeroEntregas() {
		return numeroEntregas;
	}


	public List<String> getEntregas() {
		return entregas;
	}
	
}
