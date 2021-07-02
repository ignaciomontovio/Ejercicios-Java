package ignacio.letras.extremas;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Map.Entry;

import java.util.Scanner;

import java.util.TreeMap;

public class Estadistica {
	private int cantPal;
	List<Palabra> palabras;
	TreeMap<Character, Integer> letras;
	private int mayCdadVeces = 0;

	public static void main(String[] args) throws IOException {
		Scanner ent = new Scanner(new FileReader("EXTREMAS1.in"));
		PrintWriter sal = new PrintWriter(new FileWriter("EXTREMAS1.out"));
		Estadistica e1 = new Estadistica(ent);
		e1.obtenerResultado(sal);
		ent.close();
		sal.close();
		
		ent = new Scanner(new FileReader("EXTREMAS2.in"));
		sal = new PrintWriter(new FileWriter("EXTREMAS2.out"));
		e1 = new Estadistica(ent);
		e1.obtenerResultado(sal);
		ent.close();
		sal.close();
		
		ent = new Scanner(new FileReader("EXTREMAS3.in"));
		sal = new PrintWriter(new FileWriter("EXTREMAS3.out"));
		e1 = new Estadistica(ent);
		e1.obtenerResultado(sal);
		ent.close();
		sal.close();
		
		ent = new Scanner(new FileReader("EXTREMAS4.in"));
		sal = new PrintWriter(new FileWriter("EXTREMAS4.out"));
		e1 = new Estadistica(ent);
		e1.obtenerResultado(sal);
		ent.close();
		sal.close();
	}

	public Estadistica(Scanner ent) {
		cantPal = ent.nextInt();
		letras = new TreeMap<Character, Integer>();
		palabras = new ArrayList<Palabra>();
		Palabra nue;
		for (int i = 0; i < cantPal; i++) {
			nue = new Palabra(ent.next());
			palabras.add(nue);
			ponerEnMapa(nue.obtenerLetraInicial());
			ponerEnMapa(nue.obtenerLetraFinal());
		}

	}

	public void obtenerResultado(PrintWriter sal) {
		Iterator<Palabra> iter;
		Palabra aux;
		for (Entry<Character, Integer> val : letras.entrySet()) {
			if (val.getValue() > mayCdadVeces) {
				mayCdadVeces = val.getValue();
			}

		}
		for (Entry<Character, Integer> val : letras.entrySet()) {
			if (val.getValue() == mayCdadVeces) {
				sal.print(val.getKey());
			}

		}
		for (Entry<Character, Integer> val : letras.entrySet()) {
			if (val.getValue() == mayCdadVeces) {
				iter = palabras.listIterator();
				while (iter.hasNext()) {
					aux = iter.next();
					if (aux.obtenerLetraFinal() == val.getKey() || aux.obtenerLetraInicial() == val.getKey()) {
						sal.printf("\n%s", aux.toString());
						iter.remove();
					}
				}
			}

		}
	}

	private void ponerEnMapa(Character car) {
		int aux;
		if (letras.containsKey(car)) {
			aux = letras.get(car) + 1;
			mayCdadVeces = mayCdadVeces < aux ? aux : mayCdadVeces;
			letras.put(car, aux);
		} else {
			letras.put(car, 1);
		}
	}

}
