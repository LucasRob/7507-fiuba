package Aplicacion;
import java.util.ArrayList;

public class Cliente {
	
	private String nombre;
	private ArrayList cajasAhorro;
	
	public Cliente(String nombre) {
		this.nombre = nombre;
		this.cajasAhorro = new ArrayList();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public CajaAhorro getCajaAhorro(int numero){
		for(int i = 0; i < this.cajasAhorro.size(); i++){
			CajaAhorro cajaAhorro = (CajaAhorro) this.cajasAhorro.get(i);
			if(cajaAhorro.getNumero() == numero)
				return cajaAhorro;
		}
		return null;
	}
	
	public void agregarCajaAhorro(CajaAhorro cajaAhorro){
		if (this.cajasAhorro.size() >= 4)
			throw new RuntimeException();
		this.cajasAhorro.add(cajaAhorro);
	}
	
	public void transferir(CajaAhorro origen, CajaAhorro destino, double monto){
		origen.extraer(monto);
		destino.depositar(monto);
	}
	
	public double saldoTotal(){
		double saldoTotal = 0;
		for(int i = 0; i < this.cajasAhorro.size(); i++){
			CajaAhorro cajaAhorro = (CajaAhorro) this.cajasAhorro.get(i); 
			saldoTotal += cajaAhorro.getSaldo(); 
		}
		return saldoTotal;
	}

}
