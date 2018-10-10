package Aplicacion;
import java.util.ArrayList;

public class Banco {
	
	private ArrayList clientes;

	public Banco() {
		this.clientes = new ArrayList();
	}
		
	public void agregarCliente(Cliente cliente){
		this.clientes.add(cliente);
	}
	
	public Cliente getCliente(String nombre){
		for(int i = 0; i < this.clientes.size(); i++){
			Cliente cliente = (Cliente)this.clientes.get(i);
			if(cliente.getNombre().equals(nombre))
				return cliente;
		}
		return null;
	}
	
	public double saldoTotalClientes(){
		double saldoTotal = 0;
		for(int i = 0; i < this.clientes.size(); i++){
			Cliente cliente = (Cliente)this.clientes.get(i); 
			saldoTotal += cliente.saldoTotal(); 
		}
		return saldoTotal;
	}

}
