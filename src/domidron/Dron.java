package domidron;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
  
public class Dron {
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
	}
	
	public void setRuta(Ruta ruta){
		
	}
	
	public void deliver(Ruta ruta) {
		clearFile();
		for(int j=0; j<ruta.getNumeroEntregas(); j++){
		//ruta.getEntregas().forEach(
		//		(String entrega) -> {
							 char[] comandos = ruta.getEntregas().get(j).toCharArray();
								 for(int i= 0; i < comandos.length; i++){
									 actualizaPosicion(comandos[i]);
								 }
								try {
									reportarPosicion();
									
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								
				
			//				  }
		//);
		}
		System.out.println("DRON "+ this.getId() + ":he terminado mi ruta.");
		
	}
	
	public void actualizaPosicion(char command){
		if(command == 'A') {
			switch(this.getDirection()){
				case 'N': this.position_y = this.position_y+1; break;
				case 'E': this.position_x = this.position_x+1; break;
				case 'S': this.position_y = this.position_y-1; break;
				case 'W': this.position_x = this.position_x-1; break;			
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
	
			
			File f = new File("out.txt");
			if (f.exists()) {
				f.delete();
				}
			
			
			
		}
}
	
