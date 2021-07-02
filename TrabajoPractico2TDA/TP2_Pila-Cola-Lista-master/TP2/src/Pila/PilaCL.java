package Pila;
import Lista.*;

public class PilaCL <T> implements Pila<T> {
	Lista<T> listaP;
	
	public PilaCL() {
		listaP = new Lista<T>();
	}

	@Override
	public void push(T dato) {
		listaP.pushBack(dato);
	}

	@Override
	public T pop() {
		return listaP.popBack();
	}

	@Override
	public T peek() {
		return listaP.searchAt(listaP.size());
	}

	@Override
	public boolean isEmpty() {
		return listaP.isEmpty();
	}

	@Override
	public void empty() {
		listaP.empty();
	}
}
