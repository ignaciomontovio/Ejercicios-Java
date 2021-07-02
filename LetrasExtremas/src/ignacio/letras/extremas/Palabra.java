package ignacio.letras.extremas;

public class Palabra {
	private String pal;

	public Palabra(String pal) {
		this.pal = pal;
	}
	
	public char obtenerLetraInicial() {
		return pal.charAt(0);
	}

	public char obtenerLetraFinal() {
		return pal.charAt((pal.length() - 1));
	}

	@Override
	public String toString() {
		return pal;
	}
	
}
