package resolucion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problema2 {

	
	public static void reemplazar(String archivoOrigen, String archivoDestino, String palabraAReemplazar, String nuevaPalabra) throws IOException{
			Scanner ent = new Scanner(new FileReader(archivoOrigen));
			PrintWriter sal = new PrintWriter(new FileWriter(archivoDestino));
			String texto = "";
			while(ent.hasNextLine()) {
				texto += ent.nextLine()+"\n";
			}
			texto = texto.replaceAll(palabraAReemplazar,nuevaPalabra);
			System.out.println(texto);
			sal.println(texto);
			ent.close();
			sal.close();
		}
	
	public static void main(String[] args) throws IOException {
		reemplazar("C:/entrada.txt","C:/salida.txt","vieja","mama");
	}

}
