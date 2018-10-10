package Pruebas;

import Aplicacion.Banco;
import Aplicacion.CajaAhorro;
import Aplicacion.Cliente;
import junit.framework.TestCase;

public class TestBanco extends TestCase {

	private Banco banco;
	private Cliente cliente;
		
	protected void setUp() throws Exception {
		super.setUp();		
		this.banco = new Banco();
		this.cliente = new Cliente("Jose");
	}
	
	public void testAgregarCliente(){
		this.banco.agregarCliente(this.cliente);		
		assertEquals(cliente, this.banco.getCliente("Jose"));		
	}
	
	public void testGetClienteInexistente(){
		assertNull(this.banco.getCliente("Pedro"));
	}
	
	public void testSaldoTotalClientes(){
		cargarBanco();
		assertEquals(3950d, this.banco.saldoTotalClientes(), 0.1);
	}

	private void cargarBanco(){
		Cliente cliente2 = new Cliente("Pedro");
		
		CajaAhorro caja1 = new CajaAhorro(12345, "Juan", 200d);
		CajaAhorro caja2 = new CajaAhorro(14785, "Juan", 250d);
		CajaAhorro caja3 = new CajaAhorro(25847, "Juan", 500d);
		CajaAhorro caja4 = new CajaAhorro(33698, "Pedro", 1000d);
		CajaAhorro caja5 = new CajaAhorro(48151, "Pedro", 2000d);
		
		this.cliente.agregarCajaAhorro(caja1);
		this.cliente.agregarCajaAhorro(caja2);
		this.cliente.agregarCajaAhorro(caja3);
		cliente2.agregarCajaAhorro(caja4);
		cliente2.agregarCajaAhorro(caja5);
		
		this.banco.agregarCliente(this.cliente);
		this.banco.agregarCliente(cliente2);	
	}
	
}
