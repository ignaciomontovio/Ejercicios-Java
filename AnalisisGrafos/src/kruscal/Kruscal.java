package kruscal;

import java.util.ArrayList;
import java.util.Iterator;

public class Kruscal {
	int[][] matrizAdyacencia;
	int cantNodos;
	ArrayList<Arista> arbol = new ArrayList<Arista>();
	ArrayList<Arista> arbolKruscal = new ArrayList<Arista>();
	int[] unionFind;
	private final int OK = 22;
	private final int NO_OK = 25;

	public Kruscal(int[][] mat, int cantNodos) {
		matrizAdyacencia = mat;
		this.cantNodos = cantNodos;
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (matrizAdyacencia[i][j] < (int) Integer.MAX_VALUE)
					arbol.add(new Arista(i, j, matrizAdyacencia[i][j]));
			}
		}
		arbol.sort(null);
		unionFind = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++)
			unionFind[i] = i;
	}

	public void obtenerArbol() {
		int nodoIni, nodoFin;
		Iterator<Arista> iter = arbol.iterator();
		while (arbolKruscal.size() < cantNodos - 1) {
			Arista arista = iter.next();
			nodoIni = arista.obtenerNodoIni();
			nodoFin = arista.obtenerNodoFin();
			if (union(nodoIni, nodoFin) == OK)
				arbolKruscal.add(arista);

		}
		System.out.println("ee");
	}

	private int find(int nroNodo) {
		while (unionFind[nroNodo] != nroNodo)
			nroNodo = unionFind[nroNodo];
		return nroNodo;
	}

	private int union(int nodo1, int nodo2) {
		int padre1 = find(nodo1);
		int padre2 = find(nodo2);
		if (padre1 != padre2) {
			unionFind[padre1] = padre2;
			return OK;
		}
		return NO_OK;
	}

	public static void main(String[] args) {
		int[][] mat = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				mat[i][j] = (int) Integer.MAX_VALUE;
			}
		}
		mat[0][1] = 2;
		mat[1][0] = 2;
		mat[0][3] = 1;
		mat[3][0] = 1;
		mat[5][6] = 1;
		mat[6][5] = 1;
		mat[1][3] = 3;
		mat[3][1] = 3;
		mat[2][0] = 4;
		mat[0][2] = 4;
		mat[3][6] = 4;
		mat[6][3] = 4;
		mat[2][3] = 2;
		mat[3][2] = 2;
		mat[3][4] = 7;
		mat[4][3] = 7;
		mat[2][5] = 5;
		mat[5][2] = 5;
		mat[3][5] = 8;
		mat[5][3] = 8;
		mat[6][4] = 6;
		mat[4][6] = 6;
		mat[1][4] = 10;
		mat[4][1] = 10;

		Kruscal miKruscal = new Kruscal(mat, 7);
		miKruscal.obtenerArbol();
	}
}
