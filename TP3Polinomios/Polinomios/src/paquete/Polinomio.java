package paquete;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.grado = grado;
		this.coeficientes = coeficientes;
	}

	/// 1
	double evaluarMSucesivas(double x) {
		double resultado = 0;
		double exponente = 1;
		for (int i = 0; i < this.grado; i++) {
			for (int j = 0; j < this.grado - 1; j++) 
				exponente*= x;
			
			resultado+= this.coeficientes[i]*exponente;
			exponente=1;
		}
		return resultado;
	}
	
	/// 2-A
	double evaluarRecursiva(double x) {
		double resultado=0;
		double potencia=0;
		for(int i=0; i<this.grado; i++) {
			potencia = potencia(x, this.grado-1);
			resultado+= potencia * this.coeficientes[i];
		}
		return resultado;
	}
	
	/// 2-B
	double evaluarRecursivaPar(double x) {
		double resultado=0;
		double potencia=0;
		for(int i=0; i<this.grado; i++) {
			potencia = potenciaParOImpar(x, this.grado-1);
			resultado+= potencia * this.coeficientes[i];
		}
		return resultado;
	}
	
	///Potencias
	double potencia(double x, int exponente) {
		if(exponente==0)
			return 1;
		if(exponente==1)
			return x;
		return potencia(x,exponente-1);
	}
	

	double potenciaParOImpar(double x, int exponente) {
		if(exponente==0)
			return 1;
		if(exponente==1)
			return x;
		if(exponente%2==0)
			return potenciaParOImpar(x*x,exponente/2);
		else
			return potenciaParOImpar(x, exponente-1);
	}
	
	/// 3
	double evaluarProgDinamica(double x) {
		int grado= (int) this.grado;
		double resultado =0;
		double potencias[] = new double[grado + 1];
		for(int i=0; i<this.grado; i++) 
			potencias[i]= potencia(x, this.grado-1);
		for(int j=0; j<this.grado;j++)
			resultado+= potencias[j] * this.coeficientes[j]; 
		return resultado;
	}
	
	
	/// 4
	double evaluarMejorada(double x) {
		double resultado =0;
		double potencias[] = new double[(int) this.grado + 1];
		for(int i=0; i<this.grado;i++) {
			potencias[i]= potencia(x, this.grado-1);
			resultado+= potencias[i] * this.coeficientes[i]; 
		}
		return resultado;
	}
	
	/// 5
	double evaluarPow(double x) {
		double resultado=0;
		for (int i=0; i<this.grado; i++) 
			resultado+= this.coeficientes[i] * Math.pow(x, this.grado-1);
		return resultado;
	}
	
	/// 6
	double evaluarHorner(double x) {
		double resultado= x*this.coeficientes[0];
		for(int i=1; i<this.grado;i++) {
			resultado+= x*this.coeficientes[i];
			if(i<this.grado)
				resultado*=x;
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		Polinomio polinomio = new Polinomio (3,new double[] {3,2,-1,6});
		long tiempoInicio, tiempoFin;
		
		tiempoInicio= System.currentTimeMillis();
		polinomio.evaluarMSucesivas(2);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarMSucesivas: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		polinomio.evaluarRecursiva(2);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarRecursiva: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		polinomio.evaluarRecursivaPar(2);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarRecursivaPar: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		polinomio.evaluarMejorada(2);
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarMejorada: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		polinomio.evaluarPow(2);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarPow: " + (tiempoFin-tiempoInicio));
		
		tiempoInicio= System.currentTimeMillis();
		polinomio.evaluarHorner(2);
		for(int i = 0; i < 1000000; i++) {
		}
		tiempoFin= System.currentTimeMillis();
		System.out.println("evaluarHorner: " + (tiempoFin-tiempoInicio));
		
	}

}
