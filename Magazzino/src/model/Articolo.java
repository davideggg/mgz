package model;

import java.util.*;

public class Articolo implements Comparable<Articolo> {
	private Integer codice;
	private TipoArticolo tipo;
	private Ingresso ingresso;
	private Double prezzo;
	private String posizione;
	private Date dataProduzione;

	public Articolo(TipoArticolo tipo, Double prezzo, Date dataProduzione, String posizione) {
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.dataProduzione = dataProduzione;
		this.posizione = posizione;
		this.setCodice(this.hashCode());
	}

	public TipoArticolo getTipo() {
		return this.tipo;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	
	public Double getPrezzo() {
		return this.prezzo;
	}
	
	public Date dataProduzione() {
		return this.dataProduzione;
	}
	
	public String getPosizione() {
		return this.posizione;
	}
	
	public void setPosizione(String pos) {
		this.posizione = pos;
	}
	
	@Override
	public String toString() {
		return this.tipo.toString() + "\nPrezzo: " + this.prezzo.toString() + "\n";
	}

	@Override
	public int hashCode() {
		return this.posizione.hashCode() + this.tipo.hashCode();
	}

	@Override
	public int compareTo(Articolo other) {
		return this.hashCode() - other.hashCode();
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}
}
