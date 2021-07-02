package Warshall;

public class Warshall {
	int[][] matrizAdyacencia;
	int cantNodos;
	boolean[][] matriz1;
	boolean[][] matriz2;

	public Warshall(int[][] matrizAdyacencia, int cantNodos) {
		this.matrizAdyacencia = matrizAdyacencia;
		this.cantNodos = cantNodos;
		matriz1 = new boolean[cantNodos][cantNodos];
		matriz2 = new boolean[cantNodos][cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				matriz1[i][j] = (matrizAdyacencia[i][j] == 1) ? true : false;
			}
		}
	}

	public boolean[][] resolver() {
		boolean[][] matAux;
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				for (int k = 0; k < cantNodos; k++) {
					if (i == j || i == k || j == k)
						matriz2[j][k] = matriz1[j][k];
					else if (matriz1[j][k] == true || (matriz1[j][i] == true && matriz1[i][k] == true))
							matriz2[j][k] = true;
						else
							matriz2[j][k] = false;
				}
			}
			matAux = matriz1;
			matriz1 = matriz2;
			matriz2 = matAux;
		}
		
		return matriz1;
	}

	public static void main(String[] args) {
		int[][] mat = new int[3][3];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = 0;
			}
		}
		mat[0][1] = 1;
		mat[0][2] = 1;
		mat[1][0] = 1;
		mat[2][1] = 1;
		Warshall prue = new Warshall(mat, 3);
		prue.resolver();
	}
}
