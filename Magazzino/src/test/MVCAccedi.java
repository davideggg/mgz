package test;

import controller.AccediController;
import model.Impiegato;
import view.AccediView;

public class MVCAccedi {
	public static void main(String args[]) {
		AccediView theView = new AccediView();
		String id = theView.getId();
		String password = theView.getPassword();
		Impiegato theModel = new Impiegato(id,password);
		AccediController theController = new AccediController(theView,theModel);
		theView.setVisible(true);
	}
}
