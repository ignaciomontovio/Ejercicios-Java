package kruskal.colaPrioridad;

public class Arista implements Comparable <Arista>{
	private int nodoIni;
	private int nodoFin;
	private int valor;
	
	public Arista(final int nodoIni,final int nodoFin,final int valor) {
		this.nodoIni = nodoIni;
		this.nodoFin = nodoFin;
		this.valor = valor;
	}

	public int getNodoIni() {
		return nodoIni;
	}

	public int getNodoFin() {
		return nodoFin;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Arista [nodoIni=" + nodoIni + ", nodoFin=" + nodoFin + ", valor=" + valor + "]";
	}

	@Override
	public int compareTo(Arista obj) {
		return this.valor - obj.valor;
	}
	
	
}
