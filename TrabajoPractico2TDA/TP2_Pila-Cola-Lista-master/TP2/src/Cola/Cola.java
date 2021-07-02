package Cola;

public interface Cola<T> {
	public void offer(T dato); // acola un dato en la cola.
	public T poll(); // desacola el dato de la cola.
	public T peek(); // devuelva el dato proximo a desacolarse, pero no lo desacola.
	public boolean isEmpty( );// vericar si la cola esta o no vaca.
	public void empty( );//vaciar la cola
}
