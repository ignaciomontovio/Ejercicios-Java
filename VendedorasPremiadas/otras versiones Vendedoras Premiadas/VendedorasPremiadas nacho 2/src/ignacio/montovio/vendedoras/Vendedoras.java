package ignacio.montovio.vendedoras;

public class Vendedoras {
	
	private int[] vent;
	private boolean estado;

	public Vendedoras(int[] ventas) {
		estado = true;
		vent = ventas;
	}

	public boolean obtenerEstado() {
		return estado;
	}
	
	public int totalMayoresConsecutivos(int consec) {
		int total, mayor = 0;
		int i, j;
		if (estado == true && vent.length >= consec) {
			for (i = consec - 1; i < vent.length; i++) {
				total = 0;
				for (j = consec - 1; j >= 0; j--)
					total += vent[i - j];
				if (mayor < total)
					mayor = total;
			}
			return mayor;
		} else
			return -1;
	}
	
	public void descalificar() {
		this.estado = false;
	}
	
}
