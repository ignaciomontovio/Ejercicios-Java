package kruskal.colaPrioridad;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskal {
	ArrayList<Arista> arbol = new ArrayList<Arista>();
	PriorityQueue<Arista> nodos = new PriorityQueue<Arista>();
	private int matrizAdyacencia[][];
	private int cantNodos;
	private int[] unionFind;
	private final int OK = 22;
	private final int NO_OK = 25;
	public Kruskal(int[][] matriz,int cantNodos) {
		this.matrizAdyacencia = matriz;
		this.cantNodos = cantNodos;
		unionFind = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			unionFind[i] = i;
		}
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if(matrizAdyacencia[i][j] != (int)Integer.MAX_VALUE) {
					nodos.add(new Arista(i,j,matrizAdyacencia[i][j]));
				}
				
			}
		}
	}
	
	public ArrayList<Arista> obtenerArbol(){
		Arista arisAct;
		while(arbol.size() < cantNodos-1) {
			arisAct = nodos.remove();
			if(union(arisAct.getNodoIni(),arisAct.getNodoFin()) == OK) {
				arbol.add(arisAct);
			}
		}
		return arbol;
	}
	
	private int find(int nroNodo) {
		while(unionFind[nroNodo] != nroNodo)
			nroNodo = unionFind[nroNodo];
		return nroNodo;
	}
	
	private int union(int nodo1,int nodo2) {
		int padre1 = find(nodo1);
		int padre2 = find(nodo2);
		if(padre1 != padre2) {
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

		Kruskal miKruskal = new Kruskal(mat, 7);
		miKruskal.obtenerArbol();
	}
	
}
