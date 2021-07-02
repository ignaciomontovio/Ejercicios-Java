package vendedoras.resolucion;

public class Vendedora {
	private int[] ventas;
	private int cantVent;
	private int nroVend;
	
	public Vendedora(int[] ven,int cant,int nroVend) {
		ventas = ven;
		this.nroVend = nroVend;
		cantVent = cant;
	}

	public int totalMayoresVentasConsecutivas(int consec) {
		int j, may = -1, total;
		for (int i = consec - 1; i < ventas.length; i++) {
			total = 0;
			for (j = consec - 1; j >= 0; j--)
				total += ventas[i-j];
			if(total > may)
				may = total;
		}
		return may;
	}
	
	public int obtenerCantVent() {
		return cantVent;
	}
	
	public int obtenerNroVend() {
		return nroVend;
	}
}
