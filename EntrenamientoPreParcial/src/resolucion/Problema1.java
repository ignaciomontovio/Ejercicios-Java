package resolucion;

import java.util.Arrays;

public class Problema1 {
	private int[][]matriz;
	private int n;
	public Problema1(final int n) {
		matriz = new int[n][n];
		this.n = n;
		int cont;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				matriz[i-1][j-1] = 1;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for( cont = (i>j)?j:i ;cont>1;cont--) {
					if(i % cont ==0 && j %cont == 0) {
						matriz[i-1][j-1] = 0;
						continue;
					}
						
				}
			}
		}
	}
	
	public void mostrarMatriz() {
		for(int i=0; i<n; i++) {
			System.out.printf("\n");
			for(int j=0; j<n; j++)
				System.out.printf("%d\t", matriz[i][j]);
		}
	}
	
	public static void main(String[] args) {
		Problema1 pro1 = new Problema1(10);
		pro1.mostrarMatriz();
	}
}
