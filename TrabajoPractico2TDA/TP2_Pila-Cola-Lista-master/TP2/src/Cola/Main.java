package Cola;

public class Main {
	
	public static void main(String[] args) {
		ColaEstatica<String> cola = new ColaEstatica<String>();
		cola.offer("Sofia");
		System.out.println(cola.peek());
	}
	
}
