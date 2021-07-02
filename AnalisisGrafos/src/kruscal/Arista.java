package kruscal;

public class Arista implements Comparable<Arista>{
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
	
	public int obtenerNodoIni(){
		return nodoIni;
	}
	
	public int obtenerNodoFin() {
		return nodoFin;
	}

	@Override
	public int compareTo(Arista obj) {
		return this.valor - obj.valor;
	}
	
	
}
