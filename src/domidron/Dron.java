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
		this.position_x = pos_x;
		this.position_y = pos_y;
	}
	
	public void setRuta(Ruta ruta){
		
	}
	
	public void deliver(){
		
	}
	
	public void actualizaPosicion(char command){
		if(command == 'A') {
			switch(this.getDirection()){
				case 'N': ++this.position_x; break;
				case 'E': ++this.position_y; break;
				case 'S': --this.position_x; break;
				case 'W': --this.position_x; break;			
			}
			
		}else if(command == 'I'){
			switch(this.getDirection()){
			case 'N': this.setDirection('W'); break;
			case 'E': this.setDirection('N'); break;
			case 'S': this.setDirection('E'); break;
			case 'W': this.setDirection('S'); break;
			}
			
		}else if(command == 'D'){
			switch(this.getDirection()){
			case 'N': this.setDirection('E'); break;
			case 'E': this.setDirection('S'); break;
			case 'S': this.setDirection('W'); break;
			case 'W': this.setDirection('N'); break;
			}
		}
	}
}
