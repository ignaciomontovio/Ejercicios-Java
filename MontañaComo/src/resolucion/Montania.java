package resolucion;

import java.io.PrintWriter;
import java.util.Scanner;

public class Montania {

	private int posIX;
	private int posIY;
	int[] valles;
	int cantValles;

	public Montania(Scanner ent) {
		cantValles = ent.nextInt();
		valles = new int[cantValles];
		for (int i = 0; i < cantValles; i++) {
			valles[i] = ent.nextInt();
		}
		posIX = ent.nextInt();
	}

	public void obtenerResultado(PrintWriter sal) {
		int valleIni, valleFin;
		int xMax = 0;
		int xAnt = 0;
		int band = 1;
		for (int contFin = 1; contFin < cantValles; contFin++) {
			valleIni = valles[contFin - 1];
			valleFin = valles[contFin];
			xAnt = xMax; /// Valor de X correspondiente a valleIni
			xMax += Math.abs(valleIni - valleFin); /// Valor de X correspondiente a valleFin
			if (xMax >= posIX) {
				if (band == 1) {/// CALCULO EL VALOR DE Y CUANDO ENCONTRAMOS LA POSICION EN X
					band = 0;
					if (valleIni > valleFin)
						posIY = -(posIX - xAnt) + valleIni;
					else
						posIY = posIX - xAnt + valleIni;
				}
				if (valleIni > valleFin)
					posIY--; /// Si es una bajada descuento 1 a la altura maxima posible
				else if (posIY < valleFin) {/// Si no es posible sobrepasar la proxima colina calculo el resultado
					sal.printf("%d %d", (xAnt + (posIY - valleIni)), posIY);
					return;
				}
			}
		}
	}

}
