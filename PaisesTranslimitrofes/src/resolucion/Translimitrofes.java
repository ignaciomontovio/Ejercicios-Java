package resolucion;

public class Translimitrofes implements Comparable<Translimitrofes> {
	private String pais;
	private String translimitrofe;

	public Translimitrofes(String pais, String translimitrofe) {
		this.pais = pais;
		this.translimitrofe = translimitrofe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((translimitrofe == null) ? 0 : translimitrofe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Translimitrofes other = (Translimitrofes) obj;

		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (translimitrofe == null) {
			if (other.translimitrofe != null)
				return false;
		} else if (!translimitrofe.equals(other.translimitrofe))
			return false;
		if (this.pais.equals(other.translimitrofe) == true && this.translimitrofe.equals(other.pais) == true) {
			return true;
		}
		return true;
	}

	@Override
	public int compareTo(Translimitrofes obj) {
		int cmp;
		if (this.pais.equals(obj.translimitrofe) == true && this.translimitrofe.equals(obj.pais) == true) {
			return 0;
		}
		if ((cmp = this.pais.compareTo(obj.pais)) == 0)
			cmp = this.translimitrofe.compareTo(obj.translimitrofe);
		return cmp;
	}

	@Override
	public String toString() {
		return pais + " " + translimitrofe;
	}
}
