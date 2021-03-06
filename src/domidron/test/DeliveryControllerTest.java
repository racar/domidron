package domidron.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import domidron.DeliveryController;

public class DeliveryControllerTest {
	
	@Test
	public void readFileTest(){
		ArrayList<String> rutasArchivoTest = new ArrayList<String>();
		rutasArchivoTest.add("AAAAIAAD");
		rutasArchivoTest.add("DDAIAD");
		rutasArchivoTest.add("AAIADAD");
		
		ArrayList<String> rutas = null;
		DeliveryController dc = new DeliveryController();
		
		try {
			rutas = dc.readInFile("src/domidron/test/resources/in_test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for(int i = 0; i<= 2;++i){
			assertEquals(rutasArchivoTest.get(i),rutas.get(i));
		}
	}

}
