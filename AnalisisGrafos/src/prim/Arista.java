package prim;

public class Arista {
	private int nodoIni;
	private int nodoFin;
	private int valor;
	
	public Arista(final int nodoIni,final int nodoFin,final int valor) {
		this.nodoIni = nodoIni;
		this.nodoFin = nodoFin;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Arista [nodoIni=" + nodoIni + ", nodoFin=" + nodoFin + ", valor=" + valor + "]";
	}
	
	
}
