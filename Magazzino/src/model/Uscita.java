package model;

import java.util.*;

public class Uscita implements Comparable<Uscita>{
	private Integer numeroBolla;
	private Negozio negozio;
	private String spedizioniere;
	private Date data;
	private Set<Articolo> articoli = new TreeSet<Articolo>();
	
	public Uscita(Negozio negozio, String spedizioniere, Date data, Set<Articolo> articoli) {
		this.negozio = negozio;
		this.spedizioniere = spedizioniere;
		this.data = data;
		for (Articolo art: articoli) {
			this.articoli.add(art);
		}
		this.setNumeroBolla(this.hashCode());
	}
	
	public Negozio getNegozio(){
		return this.negozio;
	}
	
	public String getSpedizioniere(){
		return this.spedizioniere;
	}
	
	public Date getData(){
		return this.data;
	}
	
	public Set<Articolo> getArticoli(){
		return this.articoli;
	}
	
	public Integer getNumeroBolla() {
		return numeroBolla;
	}

	public void setNumeroBolla(Integer numeroBolla) {
		this.numeroBolla = numeroBolla;
	}
	
	@Override
	public int hashCode() {
		return negozio.hashCode() + spedizioniere.hashCode() + data.hashCode();
	}
	
	@Override
	public int compareTo(Uscita other) {
		return this.data.hashCode() - other.data.hashCode();
	}
}
