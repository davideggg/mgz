package model;

import java.util.*;

public class Magazzino {
	private static Magazzino instance = null;
	private Set<Articolo> articoli = new TreeSet<Articolo>();
	private Set<Ingresso> Ingressi = new TreeSet<Ingresso>();
	private Set<Uscita> Uscite = new TreeSet<Uscita>();
	private Set<Ordine> OrdiniInAttesa = new TreeSet<Ordine>();
	private Map<TipoArticolo,Integer> tipoQuantita = new TreeMap<TipoArticolo,Integer>();
	
	private Magazzino() {};
	
	public static Magazzino getInstance() {
		if (instance == null) {
			instance = new Magazzino();
		}
		return instance;
	}
	
	//Gestione mappatura articoli nelle posizioni in magazzino
	public boolean addArticolo(Articolo art, String pos) {
		this.tipoQuantita.put(art.getTipo(), tipoQuantita.get(art.getTipo()) +1);
		return this.articoli.add(art);
	}
	
	public boolean spostaArticolo(int code, String pos) {
		boolean success= false;
		for (Articolo art: getArticoliMagazzino()) {
			if (art.getPosizione() == pos) {
				return success;
			}
		}
		for (Articolo art: getArticoliMagazzino()) {
			if (code == art.hashCode()) {
				art.setPosizione(pos);
				success = true;
			}
		}
		return success;
	}
	
	public boolean removeArticolo(Articolo art) {
		this.tipoQuantita.put(art.getTipo(), tipoQuantita.get(art.getTipo()) -1);
		return this.articoli.remove(art);
	}
	
	public Set<Articolo> getArticoliMagazzino(){
		return this.articoli;
	}
	
	//Gestione Ingressi
	public boolean addIngresso(Ingresso ingresso) throws BusyPositionException{
		boolean success = false;
		List<Articolo> articoliNoPos = new ArrayList<>();
		for (Articolo art : ingresso.getArticoli()) {
			boolean busy = false;
			for (Articolo artInMagazzino : getArticoliMagazzino()) {
				if (art.getPosizione() == artInMagazzino.getPosizione()) {
					articoliNoPos.add(art);
					ingresso.removeArticolo(art);
					busy = true;
				}
			}
			if (! busy) {
				addArticolo(art, art.getPosizione());
			}
		}
		this.Ingressi.add(ingresso);
		if (articoliNoPos.size() > 0) {
			throw new BusyPositionException(articoliNoPos);
		}else {
			success = true;
		}
		return success;
	}
	
	public boolean removeIngresso(Ingresso ingresso) {
		return this.Ingressi.remove(ingresso);
	} 
	
	//Gestione Uscite
	public boolean addUscita(Uscita uscita) {
		for (Articolo art: uscita.getArticoli()) {
			this.tipoQuantita.put(art.getTipo(), tipoQuantita.get(art.getTipo()) -1);
			removeArticolo(art);
		}
		return this.Uscite.add(uscita);
	}
	
	public boolean removeUscita(Uscita uscita) {
		return this.Uscite.remove(uscita);
	}
	
	//Gestione Tipi di articolo disponibili e relativa quantita
	public boolean addTipoArticolo(TipoArticolo art) {
		return this.tipoQuantita.putIfAbsent(art,0) != null;
	}
	
	public boolean removeTipoArticolo(TipoArticolo art) {
		return this.tipoQuantita.remove(art) != null;
	}
	
	public Map<TipoArticolo,Integer> getTipiArticolo(){
		return this.tipoQuantita;
	}
	
	//Gestione Ordini in attesa di essere evasi
	public boolean addOrdineInAttesa(Ordine ordine) {
			return this.OrdiniInAttesa.add(ordine);
	}
	
	public boolean EvadiOrdineInAttesa(Ordine ordine) {
		return this.OrdiniInAttesa.remove(ordine);
	}
	
	public Set<Ordine> getOrdiniInAttesa(){
		return this.OrdiniInAttesa;
	}
	
	public boolean RiceviArticoli(Ordine ord) {
		boolean success = true;
		for(TipoArticolo tipo : ord.getQuantitaArticoli().keySet()) {
			if (this.tipoQuantita.get(tipo) < ord.getQuantitaArticoli().get(tipo)) {
				success = false;
			}
		} 
		return success;
	}
	
	public Articolo getArticoloMagazzino(TipoArticolo tipo) {
		Articolo result = null;
		for (Articolo art: getArticoliMagazzino()) {
		    if (art.getTipo().equals(tipo)) {
			    removeArticolo(art);
			    result = art;
			    break;
			}
		}
		return result;
	}
	
	public void salvaMovimentiMese() {
		
	}
}
