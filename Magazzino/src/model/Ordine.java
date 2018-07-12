package model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ordine implements Comparable<Ordine>{
	private Integer codice;
	private Negozio negozio;
	private Date data;
	public Integer statoOrdine;
	private Uscita uscita;
	private Set<Ingresso> ingressi = new TreeSet<Ingresso>();
	private Map<TipoArticolo, Integer> quantitaArticoli = new TreeMap<TipoArticolo, Integer>();

	public Ordine(Negozio negozio, Date data, TipoArticolo[] tipi, Integer[] quantita) {
		this.negozio = negozio;
		this.data = data;
		for (int i = 0; i< tipi.length; i++) {
			this.quantitaArticoli.put(tipi[i], quantita[i]);
		}
		this.setCodice(this.hashCode());
	}

	public Negozio getNegozio() {
		return this.negozio;
	}

	public Date getData() {
		return this.data;
	}
	
	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Map<TipoArticolo, Integer> getQuantitaArticoli() {
		return this.quantitaArticoli;
	}
	
	public int getPrezzo() {
		int prezzo = 0;
		return prezzo;
	}
	
	public Uscita getUscita() {
		return uscita;
	}

	public void setUscita(Uscita uscita) {
		this.uscita = uscita;
	}

	public Set<Ingresso> getIngressi() {
		return ingressi;
	}

	public void setIngressi(Set<Ingresso> ingressi) {
		this.ingressi = ingressi;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.data);
		String formattedDate = formatter.format(cal.getTime());
		return "ORDINE: " + this.hashCode() + " In Data:" + formattedDate + "\nDa negozio: \n" + this.negozio.toString() + "\nStato: " + this.statoOrdine.toString();
	}
	
	@Override
	public int hashCode() {
		return negozio.hashCode() + data.hashCode();
	}

	@Override
	public int compareTo(Ordine other) {
		return this.data.hashCode() - other.data.hashCode();
	}	
}
