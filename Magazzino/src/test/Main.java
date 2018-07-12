package test;

import java.io.IOException;
import java.util.Calendar;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import model.Articolo;
import model.BusyPositionException;
import model.Impiegato;
import model.Magazziniere;
import model.Magazzino;
import model.Ordine;
import model.Responsabile;
import model.Segreteria;
import model.TipoArticolo;

public class Main {
	public static void main(String args[]) throws BusyPositionException {
		Magazzino magazzino = Magazzino.getInstance();
		String[] materiali = new String[3];
		materiali[0] = "gomma";
		materiali[1] = "tessuto";
		materiali[2] = "plastica";
		Impiegato user1 = new Impiegato("Mario", "pmario");
		try {
			user1.accedi(user1.getId(), user1.getPassword());
		} catch (JSONException | IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user1.setRuolo("Segreteria");
		if (user1.getRuolo() == "Segreteria") {
			Segreteria segretario = new Segreteria(user1.getId(), user1.getPassword());
			segretario.inserisciArticolo("A1sneakers adidas", "scarpe adidas tacchetti di ferro", "calcio", materiali);
			segretario.inserisciArticolo("A2guanti adidas", "guanti adidas per portieri", "calcio", materiali);
			for (TipoArticolo a : magazzino.getTipiArticolo().keySet()) {
				System.out.println(a.toString() + "\nQuantita: " + magazzino.getTipiArticolo().get(a).toString() + "\n");
			}
		}
		
		Impiegato user2 = new Impiegato("Marco", "1234");
		user2.setRuolo("Magazziniere");
		if (user2.getRuolo() == "Magazziniere") {
			Magazziniere magazziniere = new Magazziniere(user2.getId(), user2.getPassword());
			Articolo[] articoli = new Articolo[2];
			Integer pos = 0;
			for (TipoArticolo tipo:magazzino.getTipiArticolo().keySet()) {
				Calendar cal = Calendar.getInstance();
				Articolo art = new Articolo(tipo, 35.3, cal.getTime(), "1A");
				articoli[pos] = art;
				pos++;
			}
			articoli[1].setPosizione("1B");
			int codiceart1 = articoli[0].hashCode();
			//int codiceart2 = articoli[1].hashCode();
			System.out.println("PREREGISTRA:");
			for (TipoArticolo a : magazzino.getTipiArticolo().keySet()) {
				System.out.println(a.toString() + "\nQuantita: " + magazzino.getTipiArticolo().get(a).toString() + "\n");
			}
			Calendar cal = Calendar.getInstance();
			magazziniere.registraIngresso(cal.getTime(), articoli);
			magazziniere.spostaArticolo(codiceart1, "27");
			//magazziniere.spostaArticolo(codiceart2, "27");
			for (Articolo a : magazzino.getArticoliMagazzino()) {
				System.out.println(a.toString() + "\nQuantita: " + magazzino.getTipiArticolo().get(a.getTipo()).toString() + "\nPosizione: " + a.getPosizione());
			}
		}
		
		Impiegato user3 = new Impiegato("Roberto", "1234");
		user3.setRuolo("Responsabile");
		if (user3.getRuolo() == "Responsabile") {
			Responsabile responsabile = new Responsabile(user3.getId(), user3.getPassword());
			responsabile.setNegozio("DDS872015", "Adidas", "via da qua, 24", "Milano");
			TipoArticolo[]tipi = new TipoArticolo[1];
			Integer quantita[] = new Integer[1];
			tipi[0] = new TipoArticolo("A1sneakers adidas", "scarpe adidas tacchetti di ferro", "calcio", materiali);
			quantita[0] = 1;
			Calendar cal = Calendar.getInstance();
			responsabile.effettuaOrdine(cal.getTime(), tipi, quantita);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//responsabile.effettuaOrdine(LocalDateTime.now(), tipi, quantita);
			for (Ordine ord: magazzino.getOrdiniInAttesa()) {
				System.out.println(ord.toString());
			}
		}
		System.out.println(Integer.toString(magazzino.getArticoliMagazzino().size()));
		Magazziniere magazziniere = new Magazziniere(user2.getId(), user2.getPassword());
		for (Ordine ord: magazzino.getOrdiniInAttesa()) {
			Calendar cal = Calendar.getInstance();
			magazziniere.evadiOrdine(ord, cal.getTime(), "Bartolini");
		}
		
	}
}
