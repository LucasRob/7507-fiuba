package Pruebas;

import Aplicacion.CajaAhorro;
import Aplicacion.Cliente;
import junit.framework.TestCase;

public class TestCliente extends TestCase {

	private Cliente cliente;
	private final String nombre = "Jose";
	private CajaAhorro caja1;
	private CajaAhorro caja2;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.cliente = new Cliente(nombre);
		
		this.caja1 = new CajaAhorro(12345, nombre, 2000d);
		this.caja2 = new CajaAhorro(15973, nombre, 200d);
		
		this.cliente.agregarCajaAhorro(this.caja1);
		this.cliente.agregarCajaAhorro(this.caja2);
	}
	
	public void testAgregarCajaAhorroOk(){
		try{
			CajaAhorro caja3 = new CajaAhorro(14785, nombre, 5000d);
			this.cliente.agregarCajaAhorro(caja3);
			assertEquals(caja3, this.cliente.getCajaAhorro(14785));
		}
		catch(RuntimeException e){
			fail("No me permite agregar menos de cuatro cajas");
		}
	}
	
	public void testAgregarCajaAhorroErroneo(){
		try{
			CajaAhorro caja3 = new CajaAhorro(14785, nombre, 5000d);
			CajaAhorro caja4 = new CajaAhorro(36985, nombre, 1200d);
			CajaAhorro caja5 = new CajaAhorro(85214, nombre, 500d);
			
			this.cliente.agregarCajaAhorro(caja3);
			this.cliente.agregarCajaAhorro(caja4);
			this.cliente.agregarCajaAhorro(caja5);
			
			fail("Permitio agregar mas de cuatro cajas");
		}
		catch(RuntimeException e){
			assertTrue(true);
		}
	}
	
	public void testGetCajaAhorro(){
		assertEquals(this.caja1, this.cliente.getCajaAhorro(12345));
		assertNull(this.cliente.getCajaAhorro(12));
	}
	
	public void testSaldoTotal(){
		assertEquals(2200d, this.cliente.saldoTotal(), 0.1);
	}

}
