package coloreo.grafos;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class HallarTamMayorConjunto {
	private int cantNodos;
	private int[][] matrizAdyacencia;
	private ArrayList<Nodo> nodos= new ArrayList<Nodo>();
	private ArrayList<Integer> vecesColor = new ArrayList<Integer>();
	private ArrayList<Integer> listaSolucion = new ArrayList<Integer>();
	private int vecesMayColor = 0;
	
	public HallarTamMayorConjunto(int[][] matAdy,int cantNodos) {
		this.matrizAdyacencia = matAdy;
		this.cantNodos = cantNodos;
	}
	
	public int obtenerSolucion() {
		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i));
		}
		for (int i = 0; i < 1000; i++) {
			Random miRan = new Random();
			Collections.shuffle(nodos, miRan);
			pintarLista();
			obtenerMayorConsecutivo();
			for (Nodo nodo : nodos) 
				nodo.resetear();	
		}
		return vecesMayColor;

	}
	
	public void pintarLista() {
		int colorAct, j;
		Nodo nodoAct;
		Integer col;
		Iterator<Nodo> iter = nodos.iterator();
		vecesColor.clear();
		while (iter.hasNext()) {
			nodoAct = iter.next();
			colorAct = 1;
			j = 0;
			while (j < cantNodos) {
				if (matrizAdyacencia[nodoAct.getNroNodo()][j] != (int) Integer.MAX_VALUE
						&& obtenerColor(j) == colorAct) {

					j = 0;
					colorAct++;

				} else
					j++;
			}
			if (vecesColor.size() < colorAct) {
				vecesColor.add((Integer) 1);
			} else {
				col = vecesColor.get(colorAct - 1);
				vecesColor.set(colorAct - 1, (Integer) (col + 1));
			}
			nodoAct.setColor(colorAct);
		}
	}

	public void obtenerMayorConsecutivo() {
		int i = 0;
		int mayVeces = 0;
		int iMay = 0;
		for (Integer cantVeces : vecesColor) {
			if ((int) cantVeces > mayVeces) {
				mayVeces = (int) cantVeces;
				iMay = i;
			}
			i++;
		}
		if (mayVeces > vecesMayColor) {
			vecesMayColor = mayVeces;
			listaSolucion.clear();
			for (Nodo nodoAct : nodos) {
				if (nodoAct.getColor() == (iMay + 1))
					listaSolucion.add((Integer) nodoAct.getNroNodo());
			}
		}

	}

	public int obtenerColor(int valor) {
		Iterator<Nodo> iter = nodos.iterator();
		Nodo act;
		while (iter.hasNext()) {
			act = iter.next();
			if (act.getNroNodo() == valor) {
				return act.getColor();
			}
		}
		return -1;
	}
}
