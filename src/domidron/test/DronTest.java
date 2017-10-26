package domidron.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import domidron.Dron;
import domidron.Plano;

public class DronTest {
	@Test
	public void actualizaPosicionTestPasoSimple(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron(barrio,0,0); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('A');
		assertEquals(1,dron1.getPosition_x());
		assertEquals(0,dron1.getPosition_y());
		assertEquals('N',dron1.getDirection());
	}
	
	@Test
	public void actualizaPosicionTestPasoSimplePosicion(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron(barrio,2,3); //lo ubica en la posición 2,3 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('A');
		assertEquals(3,dron1.getPosition_x());
		assertEquals(3,dron1.getPosition_y());
		assertEquals('N',dron1.getDirection());
	}
	
	@Test
	public void actualizaPosicionTestDirection(){
		int x[] = {-5,5};
		int y[] = {-5,5};
		Plano barrio = new Plano(x,y);
		Dron dron1 = new Dron(barrio,0,0); //lo ubica en la posición 0,0 del plano
		dron1.setDirection('N');
		dron1.actualizaPosicion('I');
		assertEquals(0,dron1.getPosition_x());
		assertEquals(0,dron1.getPosition_y());
		assertEquals('W',dron1.getDirection());
	}

}
