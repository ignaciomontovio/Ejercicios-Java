package Floyd;

public class Floyd {
	private int cantNodos;
	private int[][] matrizResultado1,matrizResultado2;
	public Floyd(int[][] matrizAdyacencia,int cantNodos) {
		this.cantNodos = cantNodos;
		matrizResultado1= new int[cantNodos][cantNodos];
		matrizResultado2= new int[cantNodos][cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				matrizResultado1[i][j]= (i==j)?0:matrizAdyacencia[i][j];
				matrizResultado2[i][j]= (i==j)?0:matrizAdyacencia[i][j];
			}
		}
	}
	
	public int[][] obtenerMatriz() {
		int res;
		int[][] matAux;
		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				for (int k = 0; k < cantNodos; k++) {
					if(j != i && k != i && j != k) {
						if(matrizResultado1[j][i] != (int)Integer.MAX_VALUE && matrizResultado1[i][k] != (int)Integer.MAX_VALUE && (res = matrizResultado1[j][i]+matrizResultado1[i][k])<matrizResultado1[j][k]) {
							matrizResultado2[j][k] = res;
						}
					}
					if(j == i || i == j)
						matrizResultado2[j][k] = matrizResultado1[j][k];
				}
			}

				matAux = matrizResultado1;
				matrizResultado1 = matrizResultado2;
				matrizResultado2 = matAux;
			
		}
		if(cantNodos % 2 == 0)
			return matrizResultado2;
		else
			return matrizResultado1;
	}
	
	public static void main(String[] args) {
		int[][] mat = new int[3][3];
		mat[0][0] = (int)Integer.MAX_VALUE;
		mat[0][1] = 8;
		mat[0][2] = 5;
		mat[1][0] = 3;
		mat[1][1] = (int)Integer.MAX_VALUE;
		mat[1][2] = (int)Integer.MAX_VALUE;
		mat[2][0] = (int)Integer.MAX_VALUE;
		mat[2][1] = 2;
		mat[2][2] = (int)Integer.MAX_VALUE;
		
		Floyd miFloyd = new Floyd(mat,3);
		miFloyd.obtenerMatriz();
	}
}
