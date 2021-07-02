package coloreo.grafos;

public class Nodo implements Comparable<Nodo>{
	private int nroNodo;
	private int color;

	public int getNroNodo() {
		return nroNodo;
	}

	public void setNroNodo(int nroNodo) {
		this.nroNodo = nroNodo;
	}

	public Nodo(int nroNodo) {
		this.nroNodo = nroNodo;
		color = -1;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public void resetear() {
		color = -1;
	}

	@Override
	public String toString() {
		return "Nodo [nroNodo=" + nroNodo + ", color=" + color + "]";
	}

	@Override
	public int compareTo(Nodo obj) {
		return this.color-obj.color;
	}

}
