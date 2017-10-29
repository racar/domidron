package domidron;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/*##### DOMIDRON
 * Clase de control, ejecute esta clase para poner en funcionamiento el programa.
 */
 

public class DeliveryController {
	
	private static int numero_drones = 20; //modifique este numero para indicar el numero de drones a operar.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Iniciando Control - sistema de entregas");
		DeliveryController dc = new DeliveryController();	
		//ArrayList<String> entregas = dc.readInFile("in.txt"); //src/domidron/
		
		for(int nd = 1; nd <= numero_drones; nd++){
			 NumberFormat formatter = new DecimalFormat("00");  
			 String dronID = formatter.format(nd);
			 ArrayList<String> entregas = dc.readInFile("in"+dronID+".txt");
			
			//String dronID = nd+"";
			Runnable task = () -> {
				
				int x[] = {-5,5};
				int y[] = {-5,5};
				Plano barrio = new Plano(x,y);
				Ruta ruta = new Ruta(entregas);
			    Dron dron1 = new Dron(dronID+"",barrio,0,0); //lo ubica en la posición 0,0 del plano
			    System.out.println("CONTROL: Iniciando dron " + dron1.getId()+" que la fuerza te acompañe...");
			    dron1.setDirection('N');
			    dron1.deliver(ruta);
			};

			//task.run();

			Thread thread = new Thread(task);
			thread.start();
			
		}
		
		
	}
	
	public ArrayList<String> readInFile(String archivo) throws FileNotFoundException, IOException{
		ArrayList<String> rutas = new ArrayList<String>();
		
		File file = new File(archivo);
	
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				rutas.add(line);
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return rutas;
	}

}
