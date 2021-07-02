package prim.colaPrioridad;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
	ArrayList<Arista> arbol = new ArrayList<Arista>();
	PriorityQueue<Arista> nodos = new PriorityQueue<Arista>();
	private int matrizAdyacencia[][];
	private int cantNodos;

	public Prim(int[][] mat, int cantNodos) {
		matrizAdyacencia = mat;
		this.cantNodos = cantNodos;
//		for (int i = 0; i < cantNodos; i++) {
//			for (int j = 0; j < cantNodos; j++) {
//				if(matrizAdyacencia[i][j] != (int)Integer.MAX_VALUE)
//					nodos.add(new Arista(i,j,matrizAdyacencia[i][j]));
//			}
//		}
	}

	public ArrayList<Arista> obtenerArbol(int nodoIni) {
		nodoIni--;
		int cantVis = 1;
		Arista arisAct;
		boolean[] visitado = new boolean[cantNodos];
		visitado[nodoIni] = true;
		for (int i = 0; i < cantNodos; i++) {
			if (matrizAdyacencia[nodoIni][i] != (int) Integer.MAX_VALUE)
				nodos.add(new Arista(nodoIni, i, matrizAdyacencia[nodoIni][i]));
		}
		while (cantVis < cantNodos) {
			arisAct = nodos.remove();
			if (visitado[arisAct.getNodo2()] == false) {
				arbol.add(arisAct);
				for (int i = 0; i < cantNodos; i++) {
					if (matrizAdyacencia[arisAct.getNodo2()][i] != (int) Integer.MAX_VALUE)
						nodos.add(new Arista(arisAct.getNodo2(), i, matrizAdyacencia[arisAct.getNodo2()][i]));
					
				}
				visitado[arisAct.getNodo2()] = true;
			cantVis++;
			}

		}
		return arbol;
	}
	
	public static void main(String[] args) {
		int[][] mat = new int[7][7];
		for(int i = 0;i < 7;i++) {
			for(int j = 0;j < 7;j++) {
				mat[i][j] = (int)Integer.MAX_VALUE;
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
		
		Prim miPrim = new Prim(mat,7);
		miPrim.obtenerArbol(3);
	}
}
