package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import model.Impiegato;
import view.AccediView;

public class AccediController {
	private AccediView theView;
	private Impiegato theModel;
	
	public AccediController(AccediView theView, Impiegato theModel) {
		this.theView = theView;
		this.theModel = theModel;

		        // Comunica alla View quando viene premuto bottone accedi
		        // di eseguire il metodo actionPerformed
		        // nella classe interna AccediListener
		this.theView.addAccediListener(new AccediListener());
	}
	
	class AccediListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				String id, password;

		            // try sulle interazioni nel caso in cui
		            // - id e/o password vengano inserite erroneamente
		            // - lettura da file json non vada a buon fine
				try{
					id = theView.getId();
					password = theView.getPassword();
					
					String ruolo = theModel.accedi(id, password);
					System.out.println("RUOLO: " + ruolo);
					//theView.setCalcSolution(theModel.getCalculationValue());
				} catch(IOException | ParseException | JSONException ex) {
					System.out.println(ex);
					theView.displayErrorMessage("id e/o password errati");
				}
		}
	}
}
