package Pila;

import Lista.*;

public class PilaHL<T> extends Lista<T> implements Pila<T> {
	
	@Override
	public void push(T dato) {
		pushBack(dato);
	}

	@Override
	public T pop() {
		return popBack();
	}

	@Override
	public T peek() {
		return peek();
	}

}
