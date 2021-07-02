package paquete;

public class BinomioDeNewton {

	public double coeficientes[];
	public int exponente;
	
	public BinomioDeNewton(double coeficientes[], int exponente) {
		this.coeficientes=coeficientes;
		this.exponente=exponente;
	}
	
	/// 1
	double obtenerCoeficiente(int k) {
		double parte1= combinatoria(exponente,k);
		double parte2= Math.pow(this.coeficientes[0], k);
		double parte3= Math.pow(this.coeficientes[1], (this.exponente-k));
		return parte1*parte2*parte3;
	}
	
	
	
	double factorial(double numero) {
		if(numero==1 || numero==0)
			return 1;
		for(int i=(int) (numero-1);i>1;i--)
			numero*=i;
		return numero;
	}
	
	double combinatoria(int m, int n) {
		return factorial(m)/(factorial(n)*factorial(m-n));
	}
	
	/// 2
	void obtenerPolinomioCompleto(double nuevoCoeficientes[]) {
		double parcial;
		for(int i=0; i<nuevoCoeficientes.length; i++) {
			parcial= combinatoria(exponente,i)*
					Math.pow(this.coeficientes[0], exponente)*Math.pow(this.coeficientes[1], i);
			if(exponente%2!=0)
				if((this.coeficientes[0]<0&&this.coeficientes[i]>0)||(this.coeficientes[0]>0&&this.coeficientes[i]<0))
					parcial*= -1;
			nuevoCoeficientes[i]=parcial;
		}	
	}
	
	double evaluarBinomio(double x, double coeficientes[]) {
		double resultado=0;
		int exponente= coeficientes.length-1;
		for(int i=0; i<coeficientes.length-1;i++) {
			resultado+= coeficientes[i]*Math.pow(x, exponente);
		}
		resultado+= coeficientes[coeficientes.length-1];
		return resultado;
	}
	
	public static void main(String[] args) {
		BinomioDeNewton bn = new BinomioDeNewton(new double[] {4,5},4);
		double nuevosCoeficientes[] = new double[(int) bn.exponente+1];
		long tiempoInicio, tiempoFin;
		
		tiempoInicio= System.currentTimeMillis();
		bn.obtenerCoeficiente(3);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("obtenerCoeficiente: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		bn.obtenerPolinomioCompleto(nuevosCoeficientes);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("obtenerPolinomioCompleto: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		bn.evaluarBinomio(3, nuevosCoeficientes);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarBinomio: " + (tiempoFin-tiempoInicio));

	}

}
