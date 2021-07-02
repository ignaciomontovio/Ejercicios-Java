package ignacio.montovio.vendedoras;

import java.io.PrintWriter;

public class Ganadora {

	static char est;
	static int nroVend;
	static int consec;
	static int totalVentas;

	public static void cambiarEstadoAEmpate() {
		est = 'e';
	}

	public static void cambiarEstadoAGanador() {
		est = 'g';
	}

	static void guardarGanadora(PrintWriter archGanadora) {
		if (est == 'g')
			archGanadora.printf("%d\n%d %d", nroVend, consec, totalVentas);
		else if (est == 'e')
			archGanadora.println("NO SE PUEDE DESEMPATAR");
		else
			archGanadora.println("NO HAY GANADORA");
	}

	public static void cambiarEstadoASinGanador() {
		est = 's';
	}

}
