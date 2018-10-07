import java.util.*;

public class PilaReversible {
	private int tamanio;
	private ArrayList pila;
	
	
	public PilaReversible(int N) {
		if (N < 0){ 
			throw new IllegalArgumentException();
		}
		tamanio = N;
		pila = new ArrayList(N);
	}

	public void apilar(Integer elemento) {
		if ((tamanio==pila.size()) || (elemento==null)){
			throw new RuntimeException();
		}
		
		pila.add(0, elemento);
		
	}

	public void agrandar(int M) {
		if (M < 0){ 
			throw new IllegalArgumentException();
		}
		tamanio=tamanio+M;
		
		
	}

	public Integer obtenerTope() {
		if (pila.isEmpty()){
			throw new RuntimeException();
		}
		
		return (Integer)pila.get(0);
	}

	public boolean estaVacia() {
		
		return pila.isEmpty();
	}

	public Integer desapilar() {
		if (pila.isEmpty()){
			throw new RuntimeException();
		}
		return (Integer) pila.remove(0);
	}

	public void revertir() {
	
		int N = pila.size();
		int j = N-1;
		int i = 0;
		Integer elemi,elemj;
		
		if (pila.isEmpty()){
			throw new RuntimeException();
		}
			
		
		switch (N % 2){
		case 0: while ((j-i)!=-1){
					elemi=(Integer)pila.get(i);
					elemj=(Integer)pila.get(j);
					pila.set(i, elemj);
					pila.set(j, elemi);
					i++;
					j--;
					}
				break;
		case 1: while(j!=i){
					elemi=(Integer)pila.get(i);
					elemj=(Integer)pila.get(j);
					pila.set(i, elemj);
					pila.set(j, elemi);
					i++;
					j--;
				}
				break;
		}
		
	}


	
	
	
	
	

}
