package domidron;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DeliveryController {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("ok java");
			DeliveryController dc = new DeliveryController();
			ArrayList<String> entregas = dc.readInFile("src/domidron/in.txt");
			int x[] = {-5,5};
			int y[] = {-5,5};
			Plano barrio = new Plano(x,y);
			Ruta ruta = new Ruta(entregas);
			
			Runnable task = () -> {
			    
			    Dron dron1 = new Dron("D1",barrio,0,0); //lo ubica en la posición 0,0 del plano
			    System.out.println("Hello dron " + dron1.getId()+" que la fuerza te acompañe..");
			    dron1.setDirection('N');
			    dron1.deliver(ruta);
			};

			task.run();

			Thread thread = new Thread(task);
			thread.start();
		



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
