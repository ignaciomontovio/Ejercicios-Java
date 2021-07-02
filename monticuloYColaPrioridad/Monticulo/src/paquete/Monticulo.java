package paquete;

public class Monticulo<T extends Comparable<T>> {

	private T[] vector;
	private int tamanio = 2;
	private int cantElem = 0;

	public Monticulo() {
		this.vector = (T[]) new Comparable[tamanio];
	}

	public void mostrar() {
		for (int i = 1; i <= cantElem; i++) {
			System.out.println(this.vector[i]);
		}
	}

	private void resize() {
		T[] nuevo = (T[]) new Comparable[tamanio * 2];
		for (int i = 1; i < this.tamanio; i++) {
			nuevo[i] = this.vector[i];
		}
		this.tamanio *= 2;
		this.vector = nuevo;
	}

	public void insertar(T dato) {
		if (cantElem == tamanio - 1)
			resize();
		this.cantElem++;
		this.vector[cantElem] = dato;
		int i = cantElem;
		T aux;
		while (i > 1 && this.vector[i].compareTo(this.vector[(int) i / 2]) < 0) {
			aux = this.vector[i];
			this.vector[i] = this.vector[(int) i / 2];
			this.vector[(int) i / 2] = aux;
			i = (int) i / 2;
		}
	}

	public T sacar() {
		if (this.cantElem == 0)
			return null;
		T dato = this.vector[1];
		if (this.cantElem == 1) {
			this.cantElem--;
			return dato;
		}
		this.vector[1] = this.vector[cantElem--];
		T aux;
		int i = 1;
		while (2 * i + 1 <= this.cantElem) {
			T menor;
			if (this.vector[2 * i].compareTo(this.vector[(2 * i) + 1]) > 0) {
				menor = this.vector[2 * i + 1];
				this.vector[2 * i + 1] = this.vector[i];
				this.vector[i] = menor;
				i = i * 2 + 1;
			} else {
				menor = this.vector[2 * i];
				this.vector[2 * i] = this.vector[i];
				this.vector[i] = menor;
				i *= 2;
			}

		}
		if (2 * i <= this.cantElem) {
			aux = this.vector[i];
			this.vector[i] = this.vector[i * 2];
			this.vector[i * 2] = aux;
		}

		return dato;
	}

}
