package model;

import java.util.*;

public class Responsabile extends Impiegato {
	private Negozio negozio;
	
	public Responsabile(String username, String password) {
		super(username, password);
	}
	
	public void setNegozio(String cf, String nome, String indirizzo, String citta) {
		this.negozio = new Negozio(cf, nome, indirizzo, citta);
	}
	
	public void effettuaOrdine(Date data,TipoArticolo[]tipi, Integer[]quantita) {
		//Crea L'Ordine
		Ordine ord = new Ordine(negozio, data, tipi, quantita);
		//Controlla se puo essere soddisfatto
		if (Magazzino.getInstance().RiceviArticoli(ord)) {
			ord.statoOrdine = 1;  //soddisfacibile
		} else {
			ord.statoOrdine = 0;  //non soddisfacibile
		}
		Magazzino.getInstance().addOrdineInAttesa(ord);
		//ORDINE IN ATTESA DI ESSERE EVASO
	}
	
	public Set<Ordine> riassuntoOrdini() {
		return negozio.getOrdini();
	}
}
