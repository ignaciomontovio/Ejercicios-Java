package Pila;

public class PilaEstatica<T> implements Pila<T> {

	private T[] pila;
	private int tope = 0;
	private int tam;

	public PilaEstatica() {
		this.pila = (T[]) new Object[5];
		this.tam = this.pila.length;
	}

	@Override
	public void push(T dato) {
		if (this.tam > tope) {
			this.pila[tope] = dato;
			tope++;
		} else {
			T[] nuevo =(T[]) new Object[tam*2];
			int i=0;
			for (T t : this.pila) {
				nuevo[i++] = t;
			}
			nuevo[tope++] = dato;
			this.pila = nuevo;
			tam *=2;
		}

	}

	@Override
	public T pop() {
		if(this.tope > 0) {
			T dato = this.pila[--tope];
			return dato;
		}
		return null;
	}

	@Override
	public T peek() {
		if(this.tope > 0) {
			T dato = this.pila[tope-1];
			return dato;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.tope == 0;
	}

	@Override
	public void empty() {
		this.tope = 0;
	}

}
