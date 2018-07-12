package model;

import java.util.*;

public class Ingresso implements Comparable<Ingresso>{
	private Integer codice;
	private Date data;
	private Set<Articolo> articoli = new HashSet<>();
	
	public Ingresso(Date data, Articolo[] articoli) {
		this.data = data;
		for(Articolo art: articoli) {
			art.setIngresso(this);
			this.articoli.add(art);
		}
	    this.setCodice(this.hashCode());
	}
	
	public Date getData(){
		return this.data;
	}
	
	public Set<Articolo> getArticoli(){
		return this.articoli;
	}
	
	public boolean removeArticolo(Articolo art) {
		return getArticoli().remove(art); 
	}
	
	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	
	@Override
	public int hashCode() {
		return data.hashCode() + articoli.hashCode();
	}
	
	@Override
	public int compareTo(Ingresso other) {
		return this.data.hashCode() - other.data.hashCode();
	}
}
