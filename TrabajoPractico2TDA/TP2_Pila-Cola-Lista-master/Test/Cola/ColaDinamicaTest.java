package Cola;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ColaDinamicaTest {

	private ColaDinamica<String> cola;

	@Before
	public void crearCola() {
		cola = new ColaDinamica<String>();
	}

	@Test
	public void quePuedeEncolar() {
		cola.offer("Sofia");
		Assert.assertNotNull(cola);
	}
	
	@Test
	public void queDesacolaElPrimero() {
		cola.offer("Sofia");
		cola.offer("Marta");
		Assert.assertEquals("Sofia", cola.poll());
	}
	
	@Test
	public void queFuncionaPeek() {
		cola.offer("Sofia");
		cola.offer("Marta");
		Assert.assertEquals("Sofia", cola.peek());
	}

	@Test
	public void queFuncionaIsEmptyCuandoEstaVacia() {
		Assert.assertEquals(true, cola.isEmpty());
	}
	
	@Test
	public void queFuncionaIsEmptyCuandoNoEstaVacia() {
		cola.offer("Sofia");
		Assert.assertEquals(false, cola.isEmpty());
	}
	
	@Test
	public void queVaciaLaCola() {
		cola.offer("Ariel");
		cola.empty();
		Assert.assertEquals(true,cola.isEmpty());
	}
	
}
