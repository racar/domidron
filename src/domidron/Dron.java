package domidron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

  
public class Dron {
	private Plano plano_operacion;
	
	public Plano getPlano_operacion() {
		return plano_operacion;
	}

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	
	public Dron(String id, Plano plano,int pos_x, int pos_y){
		this.id = id;
		this.position_x = pos_x;
		this.position_y = pos_y;
		plano_operacion = plano;
	}
	
	public void setRuta(Ruta ruta){
		
	}
	
	public void deliver(Ruta ruta) {
		clearFile();
//		for(int j=0; j<ruta.getNumeroEntregas(); j++){
		ruta.getEntregas().forEach(
				(String entrega) -> {
						//	 char[] comandos = ruta.getEntregas().get(j).toCharArray();
							 char[] comandos = entrega.toCharArray();
								 for(int i= 0; i < comandos.length; i++){
									 actualizaPosicion(comandos[i]);
								 }
								try {
									reportarPosicion();
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								System.out.println("DRON "+ this.getId() + ":he terminado mi entrega. Posición Actual: ("+this.getPosition_x()+","+this.getPosition_y()+") "+this.getDirection());
				
							  }
		);
//		}
		
		System.out.println("DRON "+ this.getId() + ":he terminado mi ruta.");
		
	}
	
	public void actualizaPosicion(char command){
		if(command == 'A') {
			switch(this.getDirection()){
				case 'N': ++position_y;
						  if(position_y > plano_operacion.getY()[1]) 
							  System.out.println("Dron "+getId()+" por fuera del barrio. y="+position_y);
						  
							  break;
				case 'E': ++position_x; 
						  if(position_x > plano_operacion.getX()[1]) 
							  System.out.println("Dron "+getId()+" por fuera del barrio. x="+position_x);
						  
						  
							  break;
				case 'S': --position_y; 
						  if(position_y < plano_operacion.getY()[0]) 
							  System.out.println("Dron "+getId()+" por fuera del barrio. y="+position_y);
						  
							  break;
				case 'W': --position_x;
						  if(position_x < plano_operacion.getX()[0]) 
							  System.out.println("Dron "+getId()+" por fuera del barrio. x="+position_x);
						  
						  break;			
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
	
	private void reportarPosicion() throws IOException{

		
		File f = new File("out"+this.getId()+".txt");
		if (!f.exists()) {
			f.createNewFile();
			}
		
		PrintWriter out = new PrintWriter(new FileWriter(f, true));
		out.println("("+this.getPosition_x()+","+this.getPosition_y()+") "+this.getDirection());
		out.close();
		
	}	
	
	private void clearFile() {
	
			
			File f = new File("out"+this.getId()+".txt");
			if (f.exists()) {
				f.delete();
				}
			
			
			
		}
	

}
	
