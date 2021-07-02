package Cola;

public class ColaEstatica<T> implements Cola<T> {

	private T[] cola;
	private int cantElem = 0;
	private int tam;

	public ColaEstatica() {
		this.cola = (T[]) new Object[5];
		this.tam = this.cola.length;
	}

	@Override
	public void offer(T dato) {
		if (this.cantElem < this.tam) {
			this.cola[this.cantElem] = dato;
			this.cantElem++;
		} else {
			T[] nuevo = (T[]) new Object[this.tam * 2];
			this.tam *= 2;
			int i = 0;
			for (T copia : this.cola) {
				nuevo[i++] = copia;
			}
			nuevo[this.cantElem++] = dato;
			this.cola = nuevo;
		}
	}

	@Override
	public T poll() {
		if (this.cantElem > 0) {
			T dato = this.cola[0];
			for (int i = 1; i < cantElem; i++) {
				this.cola[i-1] =this.cola[i]; 
			}
			this.cantElem--;
			return dato;
		} else
			return null;

	}

	@Override
	public T peek() {
		if (this.cantElem > 0) {
			T dato = this.cola[0];
			return dato;
		} else
			return null;
	}

	@Override
	public boolean isEmpty() {
		return this.cantElem == 0;
	}

	@Override
	public void empty() {
		this.cantElem = 0;
	}

}
