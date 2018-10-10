package Pruebas;

import Aplicacion.CajaAhorro;
import junit.framework.TestCase;

public class TestCajaAhorro extends TestCase {

	private CajaAhorro caja;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.caja = new CajaAhorro(12345, "Cliente", 2000d);
	}
	
	public void testDepositarOk(){
		try{
			this.caja.depositar(500d);
			assertEquals(this.caja.getSaldo(), 2500d, 0.1);
		}
		catch(IllegalArgumentException e){
			fail("Arrojo excepcion monto negativo cuando el monto era positivo");
		}
	}
	
	public void testDepositarErroneo(){
		try{
			this.caja.depositar(-500d);
			fail("Permitio depositar un monto negativo");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testExtraerOk(){
		try{
			this.caja.extraer(1000d);
			assertEquals(this.caja.getSaldo(), 1000d, 0.1);
		}
		catch(RuntimeException e){
			fail("Arrojo excepcion saldo insuficiente cuando el saldo era mayor al monto a extraer");
		}
	}
	
	public void testExtraerErroneo(){
		try{
			this.caja.extraer(10000d);
			fail("Permitio extraer un monto mayor al saldo que tenia");
		}
		catch(RuntimeException e){
			assertTrue(true);
		}
	}

}
