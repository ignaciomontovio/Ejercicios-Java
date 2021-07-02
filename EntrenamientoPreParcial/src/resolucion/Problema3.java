package resolucion;

import java.util.HashMap;
import java.util.Scanner;

public class Problema3 {
	private String linea;
	private HashMap<String,Integer> cantPalabras = new HashMap<String,Integer>();
	private int cantTotalPalabras = 0 ;
	
	public Problema3(Scanner ent){
		char letra;
		int i,j;
		String palabra;
		while(ent.hasNextLine()) {
			indice = i = 0;
			this.linea = ent.nextLine();
			while(this.linea.charAt(i) != '\n' && this.linea.charAt(i) != '\0' ) {
				letra = linea.charAt(i);
				if(letra != ' ' && letra != ',' && letra != '.' && letra != '\t') {
					j = i+1;
					letra = linea.charAt(j);
					while(letra != ' ' && letra != ',' && letra != '.' && letra != '\t') {
						letra = linea.charAt(j);
						j++;
					}
					palabra = linea.substring(i,j);
					if(this.cantPalabras.containsKey(palabra)) {
						int cantidad = this.cantPalabras.get(palabra);
						this.cantPalabras.put(palabra, cantidad+1);
					}
					else
						this.cantPalabras.put(palabra, 1);
					i = j;
				}
				
//				if(this.linea.charAt(i) == ' ') {
//					String palabra = this.linea.substring(indice, i);
//					indice = i+1;
//					if(this.cantPalabras.containsKey(palabra)) {
//						int cantidad = this.cantPalabras.get(palabra);
//						this.cantPalabras.put(palabra, cantidad+1);
//					}
//					else
//						this.cantPalabras.put(palabra, 1);
//					cantTotalPalabras++;
//					i++;
//				}
			}
		}
	}
	// ,.,.  \t Hola mundo
	
	public void obtenerResultado(Scanner sal) {
		
	}
}
