package busquedaEnProfundidad;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
	private Stack<Integer> pila = new Stack<Integer>();
	private int[][] matrizAdyacencia;
	private int cantNodos;
	private int cantAristas;
	private int[] estado;
	private int[] distancia;
	private int[] padre;
	private final int NOVISITADO = 0;
	private final int VISITADO = 1;
	public DFS(Scanner ent) {
		int i,nodo1,nodo2;
		cantNodos = ent.nextInt();
		cantAristas = ent.nextInt();
		estado = new int[cantNodos];
		distancia = new int[cantNodos];
		padre = new int[cantNodos];
		matrizAdyacencia = new int[cantNodos][cantNodos];
		for(i = 0;i<cantNodos;i++) {
			for(int j = 0;j<cantNodos;j++) {
				matrizAdyacencia[i][j] = (int)Integer.MAX_VALUE;
			}
		}
		for(i = 0;i<cantAristas;i++) {
			nodo1 = ent.nextInt();
			nodo2 = ent.nextInt();
			matrizAdyacencia[nodo1][nodo2] = 1;
			matrizAdyacencia[nodo2][nodo1] = 1;
		}
		for(i = 0;i<cantNodos;i++) {
			estado[i] = NOVISITADO; //0 == No Vistado 1 == Visitado
			distancia[i] = 0; 
			padre[i] = -1;
		}
	}
	
	public void resolverBFS(int nodoIni) {
		nodoIni--;
		Integer nodoAct;
		estado[nodoIni] = 1;
		distancia[nodoIni] = 0;
		pila.add((Integer)nodoIni);
		while(!pila.isEmpty()) {
			nodoAct = pila.pop();
			for(int i = 0;i < cantNodos;i++) {
				if(estado[i] == 0 && matrizAdyacencia[(int)nodoAct][i] != (int)Integer.MAX_VALUE) {
					estado[i] = VISITADO;
					distancia[i] = distancia[nodoAct] + 1; 
					padre[i] = nodoAct;
					pila.add((Integer)i);
				}
			}
		}
		System.out.printf("Estado");
		for(int i = 0; i < cantNodos;i++) {
			System.out.printf("%d ",estado[i]);
		}
		System.out.printf("\nDistancia");
		for(int i = 0; i < cantNodos;i++) {
			System.out.printf("%d ",distancia[i]);
		}
		System.out.printf("\nPadre");
		for(int i = 0; i < cantNodos;i++) {
			System.out.printf("%d ",padre[i]);
		}
	}
	public static void main(String[] args) throws IOException {
		String PATH = "C:/Users/Nach/Desktop/Programacion Avanzada/AnalisisGrafos/bin/busquedaEnAnchura/bfs.in";
		Scanner ent = new Scanner(new FileReader(PATH));
		DFS rec = new DFS(ent);
		rec.resolverBFS(1);
	}
}
