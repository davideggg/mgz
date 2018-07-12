package model;

public class TipoArticolo implements Comparable<TipoArticolo>{
	String nome;
	String descrizione;
	String sport;
	String[] materiali;
	
	public TipoArticolo(String nome, String descrizione, String sport, String[] materiali) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.sport = sport;
		this.materiali = materiali;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + "\nDescrizione: " + this.descrizione + "\nSport: " + this.sport;
	}
	
	@Override
	public int hashCode() {
		return nome.hashCode() ^ sport.hashCode();
	}

	@Override
	public int compareTo(TipoArticolo other) {
		return this.hashCode() - other.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof TipoArticolo ) {
			TipoArticolo otherAsTipoArticolo = (TipoArticolo) other;
			return this.nome.equals(otherAsTipoArticolo.nome) && this.sport.equals(otherAsTipoArticolo.sport);
		}else {
			return false;
		}
	}
	
}
