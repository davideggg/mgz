package model;

import java.util.*;

public class Negozio {
	public String codiceFiscale;
	public String nome;
	public String indirizzo;
	public String citta;
	private Set<Ordine> Ordini = new HashSet<Ordine>();
	
	public Negozio(String codiceFiscale, String nome, String indirizzo,	String citta) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
	
	public boolean addOrdine(Ordine ordine) {
		return Ordini.add(ordine);
	}
	
	public Set<Ordine> getOrdini(){
		return Ordini;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + "\nIndirizzo: " + this.indirizzo + "\nCitta': " + this.citta; 
	}
	
	@Override
	public int hashCode() {
		return codiceFiscale.hashCode() + nome.hashCode() + indirizzo.hashCode() + citta.hashCode();
	}
} 
