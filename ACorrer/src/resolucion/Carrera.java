package resolucion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Carrera {
	private int cantInscriptos;
	private int cantCatFem;
	private int cantCatMas;
	private int cantArrivos;
	private int[] rangosEdadesFem;
	private int[] rangosEdadesMas;
	private String[] inscriptos;
	private int[] ordenLlegada;
	/// ---------------- Vencedores forma el resultado
	private int[][] vencedores;

	public Carrera(Scanner ent) {
		int i;
		this.cantInscriptos = ent.nextInt();
		this.cantCatFem = ent.nextInt();
		this.cantCatMas = ent.nextInt();
		this.cantArrivos = ent.nextInt();
		this.rangosEdadesFem = new int[this.cantCatFem];
		for (i = 0; i < this.cantCatFem; i++) {
			ent.nextInt();
			this.rangosEdadesFem[i] = ent.nextInt();
		}
		this.rangosEdadesMas = new int[this.cantCatMas];
		for (i = 0; i < this.cantCatMas; i++) {
			ent.nextInt();
			this.rangosEdadesMas[i] = ent.nextInt();
		}
		ent.nextLine(); /// PARA QUE NO LEA ESPACIO EN BLANCO
		this.inscriptos = new String[this.cantInscriptos];
		for (i = 0; i < this.cantInscriptos; i++) {
			this.inscriptos[i] = new String(ent.nextLine());
		}
		this.ordenLlegada = new int[this.cantArrivos];
		for (i = 0; i < this.cantArrivos; i++) {
			this.ordenLlegada[i] = ent.nextInt();
		}

		vencedores = new int[cantCatFem + cantCatMas][5];
		for (i = 0; i < cantCatFem; i++) {
			vencedores[i][0] = i + 1;
			vencedores[i][4] = 1;
		}
		for (i = cantCatFem; i < cantCatFem + cantCatMas; i++) {
			vencedores[i][0] = i - cantCatFem + 1;
			vencedores[i][4] = 1;
		}
		/// LA ULTIMA LINEA DE LA MATRIZ CONTIENE LA CANTIDAD DE ELEMENTOS ACTUALES
	}

	public void resolver(PrintWriter sal) {
		int edad, categoria;
		char sexo;
		for (int i = 0; i < ordenLlegada.length; i++) {
			categoria = -1;
			edad = Integer.parseInt(inscriptos[ordenLlegada[i] - 1].substring(0, 2));
			sexo = inscriptos[ordenLlegada[i] - 1].charAt(3);
			if (sexo == 'F')
				
				for (int j = 0; j < cantCatFem && categoria == -1; j++) {
					if (edad <= rangosEdadesFem[j]) {
						categoria = j + 1;
						if (vencedores[categoria - 1][4] < 4) {
							this.vencedores[categoria - 1][vencedores[categoria - 1][4]] = ordenLlegada[i];
							vencedores[categoria - 1][4]++;
						}

					}
				}
			else
				for (int j = 0; j < cantCatMas && categoria == -1; j++) {
					if (edad <= rangosEdadesMas[j]) {
						categoria = j + 1;
						if (vencedores[cantCatFem + categoria - 1][4] < 4) {
							this.vencedores[cantCatFem + categoria- 1][vencedores[cantCatFem + categoria - 1][4]] = ordenLlegada[i];
							vencedores[cantCatFem + categoria - 1][4]++;
						}

					}

				}
		}
		for (int i = 0; i < vencedores.length; i++)
			sal.printf("%d %d %d %d\n", vencedores[i][0], vencedores[i][1], vencedores[i][2], vencedores[i][3]);
	}

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(new FileReader("carrera.in"));
		Carrera carrera = new Carrera(entrada);
		entrada.close();
		PrintWriter salida = new PrintWriter(new FileWriter("carrera.out"));
		carrera.resolver(salida);
		salida.close();
		
		entrada = new Scanner(new FileReader("carrera1.in"));
		salida = new PrintWriter(new FileWriter("carrera1.out"));
		carrera = new Carrera(entrada);
		carrera.resolver(salida);
		entrada.close();
		salida.close();
		
		entrada = new Scanner(new FileReader("carrera2.in"));
		salida = new PrintWriter(new FileWriter("carrera2.out"));
		carrera = new Carrera(entrada);
		carrera.resolver(salida);
		entrada.close();
		salida.close();
		
		entrada = new Scanner(new FileReader("carrera3.in"));
		salida = new PrintWriter(new FileWriter("carrera3.out"));
		carrera = new Carrera(entrada);
		carrera.resolver(salida);
		entrada.close();
		salida.close();
		
		entrada = new Scanner(new FileReader("carrera4.in"));
		salida = new PrintWriter(new FileWriter("carrera4.out"));
		carrera = new Carrera(entrada);
		carrera.resolver(salida);
		entrada.close();
		salida.close();
		
	}
}
