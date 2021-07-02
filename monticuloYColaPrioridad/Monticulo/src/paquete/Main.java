package paquete;

public class Main {
	
	public static void main(String[] args) {
		Monticulo<Integer> mon = new Monticulo<Integer>();
		
		mon.insertar(4);
		mon.insertar(5);
		mon.insertar(7);
		mon.insertar(8);
		mon.insertar(6);
		mon.insertar(9);
		mon.insertar(8);
		mon.insertar(10);
		
		mon.mostrar();
		System.out.println("---");
		System.out.println(mon.sacar());
		System.out.println("---");
		mon.mostrar();
		System.out.println("---");
		System.out.println(mon.sacar());
		System.out.println("---");
		mon.mostrar();
		System.out.println("---");
		System.out.println(mon.sacar());
		System.out.println("---");
		mon.mostrar();
		System.out.println("---");
		System.out.println(mon.sacar());
		System.out.println("---");
		mon.mostrar();
		System.out.println("---");
		System.out.println(mon.sacar());
		System.out.println("---");
		mon.mostrar();
		
	}
	
}
