package domidron.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domidron.Dron;
import domidron.Plano;
import domidron.Ruta;

public class DronTest {
	@Test
	public void actualizaPosicionTestPasoSimple(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,0,0); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('A');
		assertEquals(0,dron1.getPosition_x());
		assertEquals(1,dron1.getPosition_y());
		assertEquals('N',dron1.getDirection());
	}
	
	@Test
	public void actualizaPosicionTestPasoSimplePosicion(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,2,3); //lo ubica en la posición 2,3 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('A');
		assertEquals(2,dron1.getPosition_x());
		assertEquals(4,dron1.getPosition_y());
		assertEquals('N',dron1.getDirection());
	}
	
	@Test
	public void actualizaPosicionTestDirection(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,0,0); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('I');
		assertEquals(0,dron1.getPosition_x());
		assertEquals(0,dron1.getPosition_y());
		assertEquals('W',dron1.getDirection());
	}
	
	@Test
	public void actualizaPosicionTestDirectionAllCases(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,0,0); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('I');
		assertEquals('W',dron1.getDirection());
		dron1.actualizaPosicion('I');
		assertEquals('S',dron1.getDirection());
		dron1.actualizaPosicion('I');
		assertEquals('E',dron1.getDirection());
		dron1.actualizaPosicion('I');
		assertEquals('N',dron1.getDirection());
		dron1.actualizaPosicion('D');
		assertEquals('E',dron1.getDirection());
		dron1.actualizaPosicion('D');
		assertEquals('S',dron1.getDirection());
		dron1.actualizaPosicion('D');
		assertEquals('W',dron1.getDirection());
		dron1.actualizaPosicion('D');
		assertEquals('N',dron1.getDirection());
	}
	
	/*********delivery tests*******/
	
	@Test
	public void deliverTestRuta1(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		ArrayList<String> entregas = new ArrayList<String>();
		entregas.add("AAAAIAAD");
		Ruta ruta = new Ruta(entregas);
		
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,0,0); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.deliver(ruta);
		
		assertEquals(-2,dron1.getPosition_x());
		assertEquals(4,dron1.getPosition_y());
		assertEquals('N',dron1.getDirection());
		
	}
	
	@Test
	public void deliverTestRuta2(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		ArrayList<String> entregas = new ArrayList<String>();
		entregas.add("DDAIAD");
		Ruta ruta = new Ruta(entregas);
		
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,-2,4); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.deliver(ruta);
		
		assertEquals(-1,dron1.getPosition_x());
		assertEquals(3,dron1.getPosition_y());
		assertEquals('S',dron1.getDirection());
		
	}
	@Test
	public void deliverTestRuta3(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		ArrayList<String> entregas = new ArrayList<String>();
		entregas.add("AAIADAD");
		Ruta ruta = new Ruta(entregas);
		
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,-3,3); //lo ubica en la posición -3,3 del plano
		dron1.setDirection('S');
		dron1.deliver(ruta);
		
		assertEquals(-2,dron1.getPosition_x());
		assertEquals(0,dron1.getPosition_y());
		assertEquals('W',dron1.getDirection());
		
	}
	
	
	
	@Test
	public void deliverTestRuta4(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		ArrayList<String> entregas = new ArrayList<String>();
		entregas.add("AAAAIAAIAADAAAAAD");
		Ruta ruta = new Ruta(entregas);
		
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("DTestRuta4",barrio,0,0); //lo ubica en la posición -3,3 del plano
		dron1.setDirection('N');
		dron1.deliver(ruta);
		
		assertEquals(-7,dron1.getPosition_x());
		assertEquals(2,dron1.getPosition_y());
		assertEquals('N',dron1.getDirection());
		
	}
	/******** CASOS POR REVISAR
	/********* REVISAR SI LAS RUTAS 2 y 3  DEL DOCUMENTO SON SOLO DE REFERENCIA
	/********* tests con las dos rutas descritas en el documento que no me dan el resultado esperado*******/
	
	@Test
	public void deliverTestRuta2Documento(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		ArrayList<String> entregas = new ArrayList<String>();
		entregas.add("DDAIAD");
		Ruta ruta = new Ruta(entregas);
		
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,-2,4); //lo ubica en la posición -2,4 del plano
		dron1.setDirection('N');
		dron1.deliver(ruta);
		
		assertEquals(-3,dron1.getPosition_x());
		assertEquals(3,dron1.getPosition_y());
		assertEquals('S',dron1.getDirection());
		
	}
	@Test
	public void deliverTestRuta3Documento(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		ArrayList<String> entregas = new ArrayList<String>();
		entregas.add("AAIADAD");
		Ruta ruta = new Ruta(entregas);
		
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron("D1",barrio,-3,3); //lo ubica en la posición -3,3 del plano
		dron1.setDirection('S');
		dron1.deliver(ruta);
		
		assertEquals(-4,dron1.getPosition_x());
		assertEquals(2,dron1.getPosition_y());
		assertEquals('W',dron1.getDirection());
		
	}


}
