package ignacio.montovio.vendedoras;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Concurso {
	private int cantVend;
	private int consec;
	private Vendedoras[] listaVendedoras;

	public Concurso(Scanner archVen) {
		cantVend = archVen.nextInt();
		listaVendedoras = new Vendedoras[cantVend];
		int[] ventas;
		int cantVent, j;
//		for (int i = 0; i < cantVend; i++) {
//			cantVent = archVen.nextInt();
//			listaVendedoras[i] = new Vendedoras(cantVent);
//			for (contVent = 0; contVent < cantVent; contVent++) {
//				listaVendedoras[i].vent[contVent] = archVen.nextInt();
//			}
//		}
		for (int i = 0; i < cantVend; i++) {
			cantVent = archVen.nextInt();
			ventas = new int[cantVent];
			for (j = 0; j < cantVent; j++) {
				ventas[j] = archVen.nextInt();
			}
			listaVendedoras[i] = new Vendedoras(ventas);
		}
		consec = archVen.nextInt();
	}

	public static void main(String[] args) throws IOException {
		Scanner archVen = new Scanner(new FileReader("premio7.in"));
		PrintWriter archVenSal = new PrintWriter(new FileWriter("premio7.out"));
		Concurso con1 = new Concurso(archVen);
		con1.obtenerGanadora();
		Ganadora.guardarGanadora(archVenSal);
		archVenSal.close();
		archVen.close();
	}

	private int buscarMayor(int consec) {
		int mayor = -1, aux;
		for (int i = 0; i < cantVend; i++) {
			if (listaVendedoras[i].obtenerEstado() == true) {
				aux = listaVendedoras[i].totalMayoresConsecutivos(consec);
				if (aux > mayor)
					mayor = aux;
			}
		}
		return mayor;
	}

	private int eliminarCompetidoras(int consec) {
		int may = buscarMayor(consec); /// VALOR DEL MAYOR CONSECUTIVO O -1 SI NINGUNO CUMPLE LA CONSECUTIVIDAD
		for (int i = 0; i < cantVend; i++)
			if (may != -1 && listaVendedoras[i].obtenerEstado() == true
					&& listaVendedoras[i].totalMayoresConsecutivos(consec) < may)
				listaVendedoras[i].descalificar();
		return may;
	}

	public int competidorasRestantes() {
		int cant = 0;
		for (int i = 0; i < cantVend; i++) {
			if (listaVendedoras[i].obtenerEstado()) {
				cant++;
				Ganadora.nroVend = i;
			}

		}
		return cant;
	}

	public void obtenerGanadora() {
		int rest = 0, emp = 0;
		emp = eliminarCompetidoras(consec);
		if (emp == -1) {
			Ganadora.cambiarEstadoASinGanador();
			return;
		}
		while (emp != -1 && (rest = competidorasRestantes()) > 1) {
			consec++;
			emp = eliminarCompetidoras(consec);
		}
		if (rest == 1) {
			Ganadora.consec = consec;
			Ganadora.totalVentas = listaVendedoras[Ganadora.nroVend].totalMayoresConsecutivos(Ganadora.consec);
			Ganadora.nroVend++;
			Ganadora.cambiarEstadoAGanador();
		} else {
			Ganadora.cambiarEstadoAEmpate();
		}
	}
}
