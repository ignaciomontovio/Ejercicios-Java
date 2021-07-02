package resolucion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Depositos {
	private int cantDep;
	private int[][] tamanios;
	private int volumenLiquido;

	public Depositos(Scanner ent) {
		cantDep = ent.nextInt();
		tamanios = new int[cantDep][2];
		for (int i = 0; i < cantDep; i++) {
			tamanios[i][0] = ent.nextInt();
			tamanios[i][1] = ent.nextInt();
		}
		volumenLiquido = ent.nextInt();
	}

	public void obtenerResultado(PrintWriter sal) {
		int volumenTotal, volumenAnterior = 0;
		int alturaAct;
		if(cantDep == 1) {
			volumenTotal = tamanios[0][0] * tamanios[0][1];
			if(volumenTotal <= volumenLiquido) {
				alturaAct = volumenLiquido/tamanios[0][0];
				sal.println(1);
				sal.println(tamanios[0][1]-alturaAct);
			}
			else 
				sal.printf("REVALSAN: %d Litros", volumenLiquido-volumenTotal);
			return;
		}
		for (int i = 1; i < cantDep; i++) {
			volumenTotal = 0;
			alturaAct = tamanios[i][1];
			for (int j = 0; j < i; j++) {
				volumenTotal += tamanios[j][0] * (tamanios[j][1] - alturaAct);
			}
			if (volumenTotal >= volumenLiquido) {
				sal.println(i);
				sal.println((double)(volumenLiquido - volumenAnterior) / (volumenTotal - volumenAnterior));
				return;
			}
			volumenAnterior = volumenTotal;
		}
		sal.println("REBALSAN ");
	}

	public static void main(String[] args) throws IOException {
		Scanner ent = new Scanner(new FileReader("depositos.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("depositos.out"));
		Depositos dep = new Depositos(ent);
		dep.obtenerResultado(sal);
		ent.close();
		sal.close();

		ent = new Scanner(new FileReader("depositos1.in"));
		sal = new PrintWriter(new FileWriter("depositos1.out"));
		dep = new Depositos(ent);
		dep.obtenerResultado(sal);
		ent.close();
		sal.close();
	}
}
