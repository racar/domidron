package domidron.test;

import static org.junit.Assert.assertEquals;

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
		
		ArrayList<String> rutas = DeliveryController.readInFile("in_test.txt");
	
		for(int i = 0; i<= 2;++i){
			assertEquals(rutasArchivoTest.get(i),rutas.get(i));
		}
	}

}
