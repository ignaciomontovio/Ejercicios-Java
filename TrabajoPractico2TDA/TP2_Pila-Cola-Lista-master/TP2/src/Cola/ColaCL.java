package Cola;

import Lista.*;

public class ColaCL<T> implements Cola<T>{

	Lista<T> listaP;
	
	public ColaCL() {
		this.listaP = new Lista<T>();
	}
	
	@Override
	public void offer(T dato) {
		listaP.pushBack(dato);
	}

	@Override
	public T poll() {
		return listaP.popFront();
	}

	@Override
	public T peek() {
		return listaP.searchAt(0);
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
