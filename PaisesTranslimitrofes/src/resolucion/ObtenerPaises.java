package resolucion;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ObtenerPaises {
	private int cantPares;
	TreeMap<String, ArrayList<String>> paises;
	TreeSet<Translimitrofes> trans;
	public ObtenerPaises(Scanner ent) {
		paises = new TreeMap<String, ArrayList<String>>();
		trans = new TreeSet<Translimitrofes>();
		cantPares = ent.nextInt();
		String nombre1, nombre2;
		ArrayList<String> aux;
		///Genero el mapa con clave el nombre del pais y valor un arraylist con todos los paises limitrofes
		for (int i = 0; i < cantPares; i++) {
			nombre1 = ent.next();
			nombre2 = ent.next();
			if (paises.containsKey(nombre1)) {
				aux = paises.get(nombre1);
				aux.add(nombre2);
				paises.put(nombre1, aux);
			} else {
				aux = new ArrayList<String>();
				aux.add(nombre2);
				paises.put(nombre1, aux);
			}

			if (paises.containsKey(nombre2)) {
				aux = paises.get(nombre2);
				aux.add(nombre1);
				paises.put(nombre2, aux);
			} else {
				aux = new ArrayList<String>();
				aux.add(nombre1);
				paises.put(nombre2, aux);
			}
		}

	}

	public void resolver(PrintWriter sal) {
		ArrayList<String> lista;
		String pais;
		String limitrofe;
		///grabo en el archivo los paises con la cantidad de paises limitrofes que posee (El tamanio del arraylist))
		for (Map.Entry<String, ArrayList<String>> entry : paises.entrySet()) {
			sal.print(entry.getKey() + " ");
			lista = entry.getValue();
			sal.println(lista.size());
		}
		///Genero un treeSet con objetos translimitrofes que contienen el pais con cada translimitrofe
		for (Map.Entry<String, ArrayList<String>> entry : paises.entrySet()) {
			pais = entry.getKey();
			lista = entry.getValue();
			Iterator<String> iter = lista.iterator();
			while (iter.hasNext()) {
				limitrofe = iter.next();
				translimitrofes(pais, limitrofe);
			}

		}
		/// El treeSet deberia eliminarme los duplicados porque defini como duplicado si los strings son A,B y B,A
		///falta verificar porque no me elimina esos "duplicados"
		if(trans.size() == 0)
			sal.print("No hay paises translimitrofes");
		else
		{
			Iterator<Translimitrofes> iter = trans.iterator();
			Translimitrofes recorrer;
			while(iter.hasNext()) {
				recorrer = iter.next();
				sal.println(recorrer.toString());
			}
		}
	}
	
	private void translimitrofes(String pais, String limitrofe) {
		ArrayList<String> lista = paises.get(limitrofe);
		ArrayList<String> listaTrans;
		Iterator<String> iter = lista.iterator();
		String translimitrofe;
		while(iter.hasNext()) {
			translimitrofe = iter.next();
			listaTrans = paises.get(translimitrofe);
			if(pais.compareTo(translimitrofe) != 0 && !listaTrans.contains(pais)) {
				trans.add(new Translimitrofes(pais,translimitrofe));
			}
		}
	}
	
}
