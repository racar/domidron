package domidron;

public class Dron {
	private String id;
	private int position_x;
	private int position_y;
	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	private char direction;  //Puede ser N-Norte, S-sur, W-oeste, E-este
	
	public Dron(Plano plano,int pos_x, int pos_y){
		
	}
	
	public void setRuta(Ruta ruta){
		
	}
	
	public void deliver(){
		
	}
	
	public void actualizaPosicion(char command){
		
	}
}