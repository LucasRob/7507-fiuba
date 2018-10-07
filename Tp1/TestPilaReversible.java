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
		//Prueba crear una pila reversible con tama�o positivo 
		
		try{
			this.pilaVacia = new PilaReversible(2);
			Assert.assertEquals(true, true);
		}catch (IllegalArgumentException e){
			fail("El tama�o de la pila es correcto pero mand� excepci�n");
		}
		
	}
	
	public void testPilaReversible_Fail(){
		//Prueba crear una pila reversible con tama�o negativo
		
		try{
			this.pilaVacia = new PilaReversible(-1);
			fail("El tama�o de la pila es incorrecto pero lo tom� igual");
		}catch (IllegalArgumentException e){
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testAgrandar_Ok_Ok(){
		//Prueba agrandar una pila reversible con tama�o positivo
		Integer ej12 = new Integer(56);
		Integer ej13 = new Integer(59);
		this.pilaR.apilar(ej12);
		this.pilaR.agrandar(1);
		try{
			
			this.pilaR.apilar(ej13);
			Assert.assertEquals(true, true);
		}catch (IllegalArgumentException e){
			fail("Agrand� pero larg� excepci�n");

		}
		
	}
	
	public void testAgrandar_Ok_Parametro(){
		//Prueba agrandar una pila reversible
		
		try{
			this.pilaR.agrandar(2);
			
			Assert.assertEquals(true, true);
		}catch (IllegalArgumentException e){
			fail("La cantidad de elementos es correcta pero mand� excepci�n");

		}
		
	}
	
	public void testAgrandar_Fail(){
		//Prueba agrandar una pila reversible con tama�o negativo

		try{
			this.pilaR.agrandar(-1);
			fail("La cantidad de elementos es incorrecta pero mand� excepci�n");
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
			fail("Agregu� un elemento dentro del tama�o estipulado e igualmente me tir� error");
		}
		
	}
	
	public void testApilar_Fail_Void(){
		//Prueba apilar un elemento nulo
		Integer ej3=null;
		try{
			this.pilaR.apilar(ej3);
			fail("Agreg� un elemento nulo");
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
			fail("Agreg� elementos de m�s");
		}catch (RuntimeException e){
			Assert.assertEquals(true, true);
		}
	}
	
	public void testDesapilar_Ok(){
		//Prueba desapilar un elemento en una pila reversible no vac�a
		Integer ej5 = new Integer(15);
		this.pilaR.apilar(ej5);
		try{
			this.pilaR.desapilar();
			Integer ej6 = this.pilaR.desapilar();
			Assert.assertEquals(ej6,this.ej1);
		}catch (RuntimeException e){
			fail("No estaba vac�a la pila pero devolvi� excepci�n");
		}
	}
	
	public void testDesapilar_Fail(){
		//Prueba desapilar un elemento en una pila vac�a
		this.pilaVacia = new PilaReversible(2);
		try{
			this.pilaVacia.desapilar();
			fail("Estaba vac�a la pila pero desapil� igual");
		}catch (RuntimeException e){
			Assert.assertEquals(true,true);
		}
	}
	
	public void testObtenerTope_Ok(){
		//Prueba obtener el tope de una pila no vac�a
		try{
			Integer ej7 = this.pilaR.obtenerTope();
			Assert.assertEquals(ej7, this.ej1);
		} catch (RuntimeException e){
			fail("No estaba vac�a la pila e igual lanz� excepci�n");
		}
	}
	
	public void testObtenerTope_Ok_Ok(){
		//Prueba obtener el tope de una pila no vac�a y verifica que no est� vac�a
		Integer ej7 = this.pilaR.obtenerTope();
		ej7.intValue();
		Assert.assertEquals(false,this.pilaR.estaVacia());
		
	}
	
	
	public void testObtenerTope_Fail(){
		//Prueba obtener el tope de una pila vac�a
		
		try{
			this.pilaVacia = new PilaReversible(2);
			this.pilaVacia.obtenerTope();
			fail("Estaba vac�a la pila e igual realiz� la acci�n");
			
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
			fail("La pila estaba llena e igual tir� excepci�n");
		}
	}
	
	public void testRevertir_Fail(){
		//Prueba revertir una pila reversible vac�a
		
		this.pilaVacia = new PilaReversible(2);
		try{
			this.pilaVacia.revertir();
			fail("La pila estaba vac�a pero igual realiz� la acci�n");

			
		}catch (RuntimeException e){
			Assert.assertEquals(true, true);

		}
	}
	
	public void testEstaVacia_True(){
		//Prueba si la pila reversible est� vac�a cuando en realidad no lo est�
		this.pilaVacia = new PilaReversible(2);
		Assert.assertEquals(true, this.pilaVacia.estaVacia());
	}
	
	public void testEstaVacia_False(){
		//Prueba si la pila reversible est� vac�a cuando en realidad lo est�

	
		Assert.assertEquals(false, this.pilaR.estaVacia());
	}
	
	

}
