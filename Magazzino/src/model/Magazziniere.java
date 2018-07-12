package model;

import java.util.*;

public class Magazziniere extends Impiegato {
	public Magazziniere(String username, String password) {
		super(username, password);
	}
	
	public boolean registraIngresso(Date data, Articolo[] articoli) throws BusyPositionException {
		Ingresso ingresso = new Ingresso(data, articoli);
		return Magazzino.getInstance().addIngresso(ingresso);
	}
	/////////////////////////////!!!!!!
	public boolean registraUscita(Ordine ordine, String spedizioniere, Date data, Set<Articolo> articoli) {
		//Crea Uscita
		Uscita uscita = new Uscita(ordine.getNegozio(), spedizioniere, data, articoli);
		//Associa uscita all'ordine
		ordine.setUscita(uscita);
		//crea lista ingressi associati agli articoli
		Set<Ingresso> ingressi = new TreeSet<Ingresso>();
		for (Articolo art: articoli) {
			ingressi.add(art.getIngresso());
		}
		//Associa lista ingressi all'ordine
		ordine.setIngressi(ingressi);
		return Magazzino.getInstance().addUscita(uscita);
	}
	public boolean spostaArticolo(int code, String posNuova) {
		return Magazzino.getInstance().spostaArticolo(code, posNuova);
	}
	
	public Set<Ordine> getOrdiniInAttesa(){
		return Magazzino.getInstance().getOrdiniInAttesa();
	}
	
	public Set<TipoArticolo> getTipiArticolo(){
		return Magazzino.getInstance().getTipiArticolo().keySet();
	}
	
	public boolean evadiOrdine(Ordine ordine, Date data, String spedizioniere) {
		//Ordine soddisfacibile
		if (ordine.statoOrdine == 1) {
			Set<Articolo> articoliDaSpedire = new HashSet<Articolo>();
			//prendi elenco tipiArticolo e relativa quantita
			Map<TipoArticolo, Integer> quantitaArticoli = ordine.getQuantitaArticoli();
			//Per ogni tipologia prendi relativa quantita di articoli
			for (TipoArticolo tipo: quantitaArticoli.keySet()) {
				for (int i = 0; i< quantitaArticoli.get(tipo); i++) {
					articoliDaSpedire.add(Magazzino.getInstance().getArticoloMagazzino(tipo));
				}
			}
			//registra e associa all'ordine l'uscita e l'ingresso di ogni articolo
			registraUscita(ordine, spedizioniere, data , articoliDaSpedire);
			//aggiungi a lista degli ordini avvenuti del negozio
			ordine.getNegozio().addOrdine(ordine);
		}
		return true;
	}
}
