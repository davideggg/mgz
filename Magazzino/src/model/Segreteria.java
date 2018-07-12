package model;
public class Segreteria extends Impiegato{
	public Segreteria(String username, String password) {
		super(username, password);
	}
	
	public boolean inserisciArticolo(String nome, String descrizione, String sport, String[] materiali) {	
		TipoArticolo art = new TipoArticolo(nome, descrizione, sport, materiali);
		return Magazzino.getInstance().addTipoArticolo(art);
	} 

	public boolean rimuoviArticolo(String nome, String descrizione, String sport, String[] materiali) {
		TipoArticolo art = new TipoArticolo(nome, descrizione, sport, materiali);
		return Magazzino.getInstance().removeTipoArticolo(art);
	}
	
	public void visualizzaOrdini() {
		
	}
}
