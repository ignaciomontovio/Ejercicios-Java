package resolucion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class CasasDeRegalos {
	private int cantNodos;
	private int[][] matrizAdyacencia;
	private ArrayList<Nodo> nodos= new ArrayList<Nodo>();
	private ArrayList<Integer> vecesColor = new ArrayList<Integer>();
	private ArrayList<Integer> listaSolucion = new ArrayList<Integer>();
	private int vecesMayColor;

	public CasasDeRegalos(Scanner ent) {
		int nodoAct, nodoRel;
		cantNodos = ent.nextInt();
		matrizAdyacencia = new int[cantNodos][cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				matrizAdyacencia[i][j] = (int) Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < cantNodos; i++) {
			nodoRel = 0;
			nodoAct = ent.nextInt();
			nodoRel = ent.nextInt();
			while (nodoRel != -1) {
				matrizAdyacencia[nodoAct - 1][nodoRel - 1] = 1;
				matrizAdyacencia[nodoRel - 1][nodoAct - 1] = 1;
				nodoRel = ent.nextInt();
			}
		}
		vecesMayColor = -1;
	}

	public void obtenerSolucion(PrintWriter sal) {
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
		sal.println(vecesMayColor);
		for(Integer nodoAct: listaSolucion) {
			sal.printf("%d ", (int)nodoAct+1);
		}

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

	public static void main(String[] args) throws IOException {
		Scanner ent = new Scanner(new FileReader("regalos2.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("regalos2.out"));
		CasasDeRegalos casa1 = new CasasDeRegalos(ent);
		casa1.obtenerSolucion(sal);
		ent.close();
		sal.close();
	}
}
