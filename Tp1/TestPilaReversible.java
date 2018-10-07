import junit.framework.TestCase;
import junit.framework.Assert;


public class TestPilaReversible extends TestCase {
	
	Integer ej1;
	PilaReversible pilaR;
	PilaReversible pilaVacia;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.ej1 = new Integer(2);
		this.pilaR = new PilaReversible(2);
		this.pilaR.apilar(ej1);
	}
	
	public void testPilaReversible_Ok(){
		//Prueba crear una pila reversible con tamaño positivo 
		
		try{
			this.pilaVacia = new PilaReversible(2);
			Assert.assertEquals(true, true);
		}catch (IllegalArgumentException e){
			fail("El tamaño de la pila es correcto pero mandó excepción");
		}
		
	}
	
	public void testPilaReversible_Fail(){
		//Prueba crear una pila reversible con tamaño negativo
		
		try{
			this.pilaVacia = new PilaReversible(-1);
			fail("El tamaño de la pila es incorrecto pero lo tomó igual");
		}catch (IllegalArgumentException e){
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testAgrandar_Ok_Ok(){
		//Prueba agrandar una pila reversible con tamaño positivo
		Integer ej12 = new Integer(56);
		Integer ej13 = new Integer(59);
		this.pilaR.apilar(ej12);
		this.pilaR.agrandar(1);
		try{
			
			this.pilaR.apilar(ej13);
			Assert.assertEquals(true, true);
		}catch (IllegalArgumentException e){
			fail("Agrandé pero largó excepción");

		}
		
	}
	
	public void testAgrandar_Ok_Parametro(){
		//Prueba agrandar una pila reversible
		
		try{
			this.pilaR.agrandar(2);
			
			Assert.assertEquals(true, true);
		}catch (IllegalArgumentException e){
			fail("La cantidad de elementos es correcta pero mandó excepción");

		}
		
	}
	
	public void testAgrandar_Fail(){
		//Prueba agrandar una pila reversible con tamaño negativo

		try{
			this.pilaR.agrandar(-1);
			fail("La cantidad de elementos es incorrecta pero mandó excepción");
		}catch (IllegalArgumentException e){
			Assert.assertEquals(true, true);

		}
		
	}
	
	public void testApilar_Ok(){
		// Prueba Apilar un elemento no nulo en una pila no llena
		Integer ej2 = new Integer(4);
		try{
			this.pilaR.apilar(ej2);
			Assert.assertEquals(this.pilaR.obtenerTope(), ej2);
		}catch (RuntimeException e){
			fail("Agregué un elemento dentro del tamaño estipulado e igualmente me tiró error");
		}
		
	}
	
	public void testApilar_Fail_Void(){
		//Prueba apilar un elemento nulo
		Integer ej3=null;
		try{
			this.pilaR.apilar(ej3);
			fail("Agregó un elemento nulo");
		}catch (RuntimeException e){
			Assert.assertEquals(true, true);
		}
	}
	
	public void testApilar_Fail_Agregar_de_mas(){
		//Prueba apilar un elemento en una pila reversible llena
		
		Integer ej4 = new Integer(5);
		Integer ej5 = new Integer(6);
		try{
			this.pilaR.apilar(ej4);
			this.pilaR.apilar(ej5);
			fail("Agregó elementos de más");
		}catch (RuntimeException e){
			Assert.assertEquals(true, true);
		}
	}
	
	public void testDesapilar_Ok(){
		//Prueba desapilar un elemento en una pila reversible no vacía
		Integer ej5 = new Integer(15);
		this.pilaR.apilar(ej5);
		try{
			this.pilaR.desapilar();
			Integer ej6 = this.pilaR.desapilar();
			Assert.assertEquals(ej6,this.ej1);
		}catch (RuntimeException e){
			fail("No estaba vacía la pila pero devolvió excepción");
		}
	}
	
	public void testDesapilar_Fail(){
		//Prueba desapilar un elemento en una pila vacía
		this.pilaVacia = new PilaReversible(2);
		try{
			this.pilaVacia.desapilar();
			fail("Estaba vacía la pila pero desapiló igual");
		}catch (RuntimeException e){
			Assert.assertEquals(true,true);
		}
	}
	
	public void testObtenerTope_Ok(){
		//Prueba obtener el tope de una pila no vacía
		try{
			Integer ej7 = this.pilaR.obtenerTope();
			Assert.assertEquals(ej7, this.ej1);
		} catch (RuntimeException e){
			fail("No estaba vacía la pila e igual lanzó excepción");
		}
	}
	
	public void testObtenerTope_Ok_Ok(){
		//Prueba obtener el tope de una pila no vacía y verifica que no esté vacía
		Integer ej7 = this.pilaR.obtenerTope();
		ej7.intValue();
		Assert.assertEquals(false,this.pilaR.estaVacia());
		
	}
	
	
	public void testObtenerTope_Fail(){
		//Prueba obtener el tope de una pila vacía
		
		try{
			this.pilaVacia = new PilaReversible(2);
			this.pilaVacia.obtenerTope();
			fail("Estaba vacía la pila e igual realizó la acción");
			
		} catch (RuntimeException e){
			Assert.assertEquals(true, true);
		}
	}
	
	public void testRevertir_Ok(){
		//Prueba revertir una pila reversible llena
		
		Integer ej8 = new Integer(15);
		Integer ej9 = new Integer(90);
		Integer ej10 = new Integer(100);
		this.pilaR.apilar(ej8);
		this.pilaR.agrandar(4);
		this.pilaR.apilar(ej9);
		this.pilaR.apilar(ej10);
		try{
			this.pilaR.revertir();
			Assert.assertEquals(this.ej1, this.pilaR.obtenerTope());
			
		}catch (RuntimeException e){
			fail("La pila estaba llena e igual tiró excepción");
		}
	}
	
	public void testRevertir_Fail(){
		//Prueba revertir una pila reversible vacía
		
		this.pilaVacia = new PilaReversible(2);
		try{
			this.pilaVacia.revertir();
			fail("La pila estaba vacía pero igual realizó la acción");

			
		}catch (RuntimeException e){
			Assert.assertEquals(true, true);

		}
	}
	
	public void testEstaVacia_True(){
		//Prueba si la pila reversible está vacía cuando en realidad no lo está
		this.pilaVacia = new PilaReversible(2);
		Assert.assertEquals(true, this.pilaVacia.estaVacia());
	}
	
	public void testEstaVacia_False(){
		//Prueba si la pila reversible está vacía cuando en realidad lo está

	
		Assert.assertEquals(false, this.pilaR.estaVacia());
	}
	
	

}
