package Cola;

import Lista.Nodo;

public class ColaDinamica<T> implements Cola<T> {

	private Nodo<T> primero;
	private Nodo<T> ultimo;
	
	public ColaDinamica() {
		this.primero = null;
		this.ultimo = null;
	}
	
	@Override
	public void offer(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato,null);
		if(this.primero == null) {
			this.primero = nuevo;
			this.ultimo = nuevo;
		}
		else {
			this.ultimo.setSig(nuevo);
			this.ultimo = nuevo;
		}
	}

	@Override
	public T poll() {
		T dato = this.primero.getDato();
		Nodo<T> aux = this.primero.getSig();
		this.primero = aux;
		if(this.primero == null)
			this.ultimo = null;
		return dato;
	}

	@Override
	public T peek() {
		return this.primero.getDato();
	}

	@Override
	public boolean isEmpty() {
		return this.primero == null;
	}

	@Override
	public void empty() {
		this.primero = null;
		this.ultimo = null;
	}
	
}
