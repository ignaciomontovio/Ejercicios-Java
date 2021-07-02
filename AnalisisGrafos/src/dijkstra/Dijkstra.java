package dijkstra;

import java.util.ArrayList;

public class Dijkstra {
	int[][] matrizAdyacencia;
	int cantNodos;
	int[] vectorCostos;
	int[] vectorPredecesores;
	ArrayList<Integer> listaNoSol = new ArrayList<Integer>();

	public Dijkstra(int[][] mat, int cantNodos) {
		matrizAdyacencia = mat;
		this.cantNodos = cantNodos;
		vectorCostos = new int[this.cantNodos];
		vectorPredecesores = new int[this.cantNodos];
	}

	public int[] obtenerVectorDeCostos(int nodoIni) {
		nodoIni--;
		for (int i = 0; i < this.cantNodos; i++) {
			if (i != nodoIni)
				listaNoSol.add((Integer) i);
		}
		int valAct;
		int menor;
		for (int i = 0; i < cantNodos; i++) {
			vectorCostos[i] = matrizAdyacencia[nodoIni][i];
			if (vectorCostos[i] < (int) Integer.MAX_VALUE)
				vectorPredecesores[i] = nodoIni + 1;
			else
				vectorPredecesores[i] = (int) Integer.MAX_VALUE;
		}
		while (listaNoSol.size() > 0 && (menor = buscarMenor()) != -1) {
			listaNoSol.remove((Integer) menor);
			for (Integer nodo : listaNoSol) {
				valAct = matrizAdyacencia[menor][nodo];
				if (valAct < (int) Integer.MAX_VALUE && (valAct += vectorCostos[menor]) < vectorCostos[nodo]) {
					vectorCostos[nodo] = valAct;
					vectorPredecesores[nodo] = menor + 1;
				}

			}

		}
		return vectorCostos;
	}

	public int[] obtenerVectorPredecesores() {
		return vectorPredecesores;
	}

	public int buscarMenor() {

		int posMenor = listaNoSol.get(0);
		int menor = vectorCostos[posMenor];
		for (Integer posAct : listaNoSol) {
			if (vectorCostos[posAct] < menor) {
				menor = vectorCostos[posAct];
				posMenor = posAct;
			}
		}
		return menor == (int) Integer.MAX_VALUE ? -1 : posMenor;
	}
}