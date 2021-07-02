package prim;

import java.util.ArrayList;

public class Prim {
	int[][] matrizAdyacencia;
	int cantNodos;
	int[] vecResultado;
	int cantResul = 0;
	ArrayList<Integer> listaRestantes = new ArrayList<Integer>();
	ArrayList<Arista> arbolPrim = new ArrayList<Arista>();

	public Prim(int[][] mat, int cantNodos) {
		matrizAdyacencia = mat;
		this.cantNodos = cantNodos;
		this.vecResultado = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			listaRestantes.add((Integer)i);
		}
	}
	
	public void obtenerArbol(final int nodoIni) {
		int nodoIniMen,nodoFinMen,valMen;
		vecResultado[cantResul] = nodoIni-1;
		cantResul++;
		listaRestantes.remove((Integer)(nodoIni-1));
		while(listaRestantes.size() != 0) {
			
			nodoIniMen = -1;
			nodoFinMen = -1;
			valMen = (int)Integer.MAX_VALUE;
			for (Integer restante : listaRestantes) {
				for(int i = 0;i <cantResul;i++) {
					if(matrizAdyacencia[vecResultado[i]][restante] < valMen) {
						valMen = matrizAdyacencia[vecResultado[i]][restante];
						nodoIniMen = vecResultado[i];
						nodoFinMen = restante;
					}
						
				}
			}
			arbolPrim.add(new Arista(nodoIniMen,nodoFinMen,valMen));
			vecResultado[cantResul] = nodoFinMen;
			cantResul++;
			listaRestantes.remove((Integer)nodoFinMen);
		}
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
