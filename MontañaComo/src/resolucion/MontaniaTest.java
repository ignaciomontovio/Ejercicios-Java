package resolucion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class MontaniaTest {

	@Test
	public void test() throws IOException {
		Scanner ent = new Scanner(new FileReader("como.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("como.out"));
		Montania mon = new Montania(ent);
		mon.obtenerResultado(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test1() throws IOException {
		Scanner ent = new Scanner(new FileReader("como1.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("como1.out"));
		Montania mon = new Montania(ent);
		mon.obtenerResultado(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test2() throws IOException {
		Scanner ent = new Scanner(new FileReader("como2.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("como2.out"));
		Montania mon = new Montania(ent);
		mon.obtenerResultado(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test3() throws IOException {
		Scanner ent = new Scanner(new FileReader("como3.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("como3.out"));
		Montania mon = new Montania(ent);
		mon.obtenerResultado(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test4() throws IOException {
		Scanner ent = new Scanner(new FileReader("como4.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("como4.out"));
		Montania mon = new Montania(ent);
		mon.obtenerResultado(sal);
		ent.close();
		sal.close();
	}

	@Test
	public void test5() throws IOException {
		Scanner ent = new Scanner(new FileReader("como5.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("como5.out"));
		Montania mon = new Montania(ent);
		mon.obtenerResultado(sal);
		ent.close();
		sal.close();
	}
}
