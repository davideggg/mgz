package test;

import controller.MagazziniereController;
import model.Magazziniere;
import view.MagazziniereView;

public class MVCMagazziniere {
	public static void main(String args[]) {
		MagazziniereView theView = new MagazziniereView();
		Magazziniere theModel = new Magazziniere("id", "password");
		MagazziniereController theController = new MagazziniereController(theView, theModel);
		theView.setVisible(true);
	}
}
