package vendedoras.resolucion;

import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Concurso {
	private int consec;
	private int cantVend;
	private List<Vendedora> listaVend = new ArrayList<Vendedora>();
	private int cantVentMax = 0;

	public static void main(String[] args) throws IOException { ///EL TRABAJAR CON OBJETOS NOS PERMITE RESOLVER MULTIPLES CASOS DE PRUEBA
		Scanner ent = new Scanner(new FileReader("premio1.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("premio1.out"));
		Concurso c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();
		
		ent = new Scanner(new FileReader("premio2.in"));
		sal = new PrintWriter(new FileWriter("premio2.out"));
		c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();
		
		ent = new Scanner(new FileReader("premio3.in"));
		sal = new PrintWriter(new FileWriter("premio3.out"));
		c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();

		ent = new Scanner(new FileReader("premio4.in"));
		sal = new PrintWriter(new FileWriter("premio4.out"));
		c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();

		ent = new Scanner(new FileReader("premio6.in"));
		sal = new PrintWriter(new FileWriter("premio6.out"));
		c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();

		ent = new Scanner(new FileReader("premio7.in"));
		sal = new PrintWriter(new FileWriter("premio7.out"));
		c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();

		ent = new Scanner(new FileReader("premio8.in"));
		sal = new PrintWriter(new FileWriter("premio8.out"));
		c1 = new Concurso(ent);
		c1.obtenerGanadora(sal);
		ent.close();
		sal.close();
	}

	public Concurso(Scanner ent) {
		int cantVent, j;
		cantVend = ent.nextInt();
		int[] vec;
		for (int i = 0; i < cantVend; i++) {
			cantVent = ent.nextInt();
			if (cantVentMax < cantVent)
				cantVentMax = cantVent;
			vec = new int[cantVent];
			for (j = 0; j < cantVent; j++)
				vec[j] = ent.nextInt();
			listaVend.add(new Vendedora(vec, cantVent, (i + 1)));
		}
		consec = ent.nextInt();
	}

	public void obtenerGanadora(PrintWriter sal) {
		Vendedora vendAct;
		Iterator<Vendedora> iter = listaVend.iterator();
		int cantVentAct;
		while (iter.hasNext()) {
			vendAct = iter.next();
			cantVentAct = vendAct.obtenerCantVent();
			if (cantVentAct < consec)
				iter.remove();
		}

		if (listaVend.size() > 1) {
			int may;
			while (cantVentMax >= consec && listaVend.size() > 1) {
				may = obtenerMayorConsecutivo(listaVend, consec);
				eliminarMenores(listaVend, may);
				consec++;
			}
			if (listaVend.size() == 1) {
				consec--;
				vendAct = listaVend.get(0);
				sal.println(vendAct.obtenerNroVend());
				sal.println(consec + " " + vendAct.totalMayoresVentasConsecutivas(consec));
			} else {
				sal.println("NO SE PUEDE DESEMPATAR");
			}
		} else if (listaVend.size() == 1) {
			vendAct = listaVend.get(0);
			sal.println(vendAct.obtenerNroVend());
			sal.println(consec + " " + vendAct.totalMayoresVentasConsecutivas(consec));
		} else {
			sal.println("NO HAY GANADORA");
		}
	}

	private int obtenerMayorConsecutivo(List<Vendedora> listaVend, int consec) {
		Iterator<Vendedora> iter = listaVend.iterator();
		Vendedora vendAux;
		int may = 0, act;
		while (iter.hasNext()) {
			vendAux = iter.next();
			act = vendAux.totalMayoresVentasConsecutivas(consec);
			if (may < act)
				may = act;
		}
		return may;
	}

	private void eliminarMenores(List<Vendedora> listaVend, int may) {
		Iterator<Vendedora> iter = listaVend.iterator();
		Vendedora vendAux;
		int act;
		while (iter.hasNext()) {
			vendAux = iter.next();
			act = vendAux.totalMayoresVentasConsecutivas(consec);
			if (act < may)
				iter.remove();
		}
	}

}
