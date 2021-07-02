package Cola;

import Lista.*;

public class ColaHL<T> extends Lista<T> implements Cola<T> {

	@Override
	public void offer(T dato) {
		super.pushBack(dato);
	}

	@Override
	public T poll() {
		return super.popFront();
	}

	@Override
	public T peek() {
		return super.searchAt(0);
	}

	
}
