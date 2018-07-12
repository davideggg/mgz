package model;

import java.util.List;

public class BusyPositionException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusyPositionException(List<Articolo> articoli) {
		for (Articolo art: articoli) {
			System.out.println("Articolo: " + Integer.toString(art.hashCode()));
			System.out.println("Posizione " + art.getPosizione() + " già occupata!");
		}
	}
}
