package Lista;

public class Lista<T> {

	private Nodo<T> primEl;

	public Lista() {
		primEl = null;
	}

	public void pushBack(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato, null);
		if (primEl == null) {
			primEl = nuevo;
			return;
		}
		Nodo<T> aux = this.primEl;
		while (aux != null) {
			aux = aux.getSig();
		}
	}

	public T popBack() {
		if (this.primEl == null)
			return null;
		Nodo<T> act = this.primEl;
		Nodo<T> ant = null;
		while (act.getSig() != null) {
			ant = act;
			act = act.getSig();
		}
		if (ant == null) {
			this.primEl = null;
		} else {
			ant.setSig(null);
		}
		return act.getDato();
	}

	public void pushFront(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato, this.primEl);
		this.primEl = nuevo;
	}

	public T popFront() {
		if (this.primEl == null)
			return null;
		T dato = this.primEl.getDato();
		this.primEl = this.primEl.getSig();
		return dato;
	}

	public void remove(T dato) {
		if (this.primEl == null)
			return;
		Nodo<T> act = this.primEl;
		Nodo<T> ant = null;
		while (act != null && act.getDato().equals(dato) == false) {
			ant = act;
			act = act.getSig();
		}
		if (ant == null) {
			this.primEl = this.primEl.getSig();
		}
		ant.setSig(act.getSig());
	}

	public void reverse() {
		if (this.primEl == null || this.primEl.getSig() == null)
			return;
		Nodo<T> aux = this.primEl;
		Nodo<T> ultEl = invertir(this.primEl, this.primEl.getSig());
		this.primEl.setSig(null);
		primEl = ultEl;
		// invierte el orden de los elementos en la lista
	}

	private Nodo<T> invertir(Nodo<T> act, Nodo<T> sig) {

		Nodo<T> sigSig = sig.getSig();
		sig.setSig(act);
		if (sigSig != null) 
			return invertir(sig, sigSig);
		return sig;
	}

	public void insertAt(int posicion, T dato) {
		Nodo<T> act = primEl;
		Nodo<T> ant = null;
		Nodo<T> nuevo;
		while (act != null && posicion-- > 1) {
			ant = act;
			act = act.getSig();
		}
		if (posicion != 1)
			return;
		nuevo = new Nodo<T>(dato, act);
		if (ant == null) {
			primEl = nuevo;
		} else {
			ant.setSig(nuevo);
		}

	}

	public void eraseAt(int posicion) {
		if (this.primEl == null)
			return;
		Nodo<T> act = this.primEl;
		Nodo<T> ant = null;
		while (act != null && posicion-- > 1) {
			ant = act;
			act = act.getSig();
		}
		if (act == null)
			return;
		if (ant == null)
			primEl = act.getSig();
		else {
			ant.setSig(act.getSig());
		}
	}

	public boolean isEmpty() {
		return this.primEl == null;
	}

	public void empty() {
		primEl = null;
	}

	public boolean search(T dato) {
		Nodo<T> act = this.primEl;
		while (act != null && act.getDato().equals(dato) != true) {
			act = act.getSig();
		}
		return act != null;
	}

	public T searchAt(int posicion) {
		Nodo<T> act = this.primEl;
		while (act != null && posicion-- > 1) {
			act = act.getSig();
		}
		return act==null ? null: act.getDato();
	}

	public int size() {
		Nodo<T> act = this.primEl;
		int contador = 0;
		while (act != null) {
			contador++;
			act = act.getSig();
		}
		return contador;
	}
}
