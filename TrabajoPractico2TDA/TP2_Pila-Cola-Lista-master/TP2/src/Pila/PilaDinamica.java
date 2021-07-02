package Pila;

import Lista.Nodo;

public class PilaDinamica<T> implements Pila<T> {

	private Nodo<T> tope;
	
	public PilaDinamica() {
		this.tope = null;
	}
	
	@Override
	public void push(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato,this.tope);
		this.tope = nuevo;
	}

	@Override
	public T pop() {
		if(this.tope == null)
			return null;
		T dato = this.tope.getDato();
		this.tope = this.tope.getSig();
		return dato;
	}

	@Override
	public T peek() {
		return tope.getDato();
	}

	@Override
	public boolean isEmpty() {
		return this.tope == null;
	}

	@Override
	public void empty() {
		this.tope = null;
	}
	
	

}
