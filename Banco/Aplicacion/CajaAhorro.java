package Aplicacion;

public class CajaAhorro {
	
	private int numero;
	private String titular;
	private double saldo;
	
	public CajaAhorro(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getTitular(){
		return this.titular;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
		
	public void depositar(double monto){
		validarMontoNegativo(monto);
		this.saldo += monto;
	}
	
	public void extraer(double monto){
		validarMontoNegativo(monto);
		if(monto > saldo)
			throw new RuntimeException();
		this.saldo -= monto;
	}
	
	private void validarMontoNegativo(double monto){
		if (monto < 0){
			throw new IllegalArgumentException();
		}
	}

}
