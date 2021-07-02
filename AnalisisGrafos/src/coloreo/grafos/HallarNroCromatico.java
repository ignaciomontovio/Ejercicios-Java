package coloreo.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class HallarNroCromatico {
	private int[][] matrizAdyacencia;
	private int cantNodos;
	ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	private ArrayList<Integer> vecesColor = new ArrayList<Integer>();
	private int cantColMen;
	
	public HallarNroCromatico(int[][] mat,int cantNodos) {
		matrizAdyacencia = mat;
		this.cantNodos = cantNodos;
		cantColMen = 0;
	}
	
	public int obtenerNroCrom() {
		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i));
		}
		for (int i = 0; i < 1000; i++) {
			Random miRan = new Random();
			Collections.shuffle(nodos, miRan);
			pintarLista();
			obtenerCantCol();
			for (Nodo nodo : nodos) 
				nodo.resetear();	
		}
		return 1;
	}
	
	public void pintarLista() {
		int colorAct, j;
		Nodo nodoAct;
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
			nodoAct.setColor(colorAct);
		}
	}
	
	public void obtenerCantCol() {
		int nroMay = 0;
		for (Nodo nodoAct: nodos) {
			nroMay = nroMay < nodoAct.getColor()?nodoAct.getColor():nroMay;
		}
		cantColMen = cantColMen > nroMay?nroMay:cantColMen;
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
