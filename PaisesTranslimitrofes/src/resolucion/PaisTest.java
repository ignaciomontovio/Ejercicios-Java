package resolucion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

import org.junit.Test;

public class PaisTest {

	@Test
	public void test() throws IOException {
		Scanner ent = new Scanner(new FileReader("paises.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("paises.out"));
		ObtenerPaises prue1 = new ObtenerPaises(ent);
		prue1.resolver(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test1() throws IOException {
		Scanner ent = new Scanner(new FileReader("paises1.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("paises1.out"));
		ObtenerPaises prue1 = new ObtenerPaises(ent);
		prue1.resolver(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test2() throws IOException {
		Scanner ent = new Scanner(new FileReader("paises2.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("paises2.out"));
		ObtenerPaises prue1 = new ObtenerPaises(ent);
		prue1.resolver(sal);
		ent.close();
		sal.close();
	}
	
	@Test
	public void test3() throws IOException {
		Scanner ent = new Scanner(new FileReader("paises3.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("paises3.out"));
		ObtenerPaises prue1 = new ObtenerPaises(ent);
		prue1.resolver(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test4() throws IOException {
		Scanner ent = new Scanner(new FileReader("paises4.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("paises4.out"));
		ObtenerPaises prue1 = new ObtenerPaises(ent);
		prue1.resolver(sal);
		ent.close();
		sal.close();
	}

}
