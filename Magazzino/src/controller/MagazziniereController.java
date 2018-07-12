package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import view.MagazziniereView;
import model.Magazziniere;

public class MagazziniereController {
	private MagazziniereView theView;
	private Magazziniere theModel;
	
	public MagazziniereController(MagazziniereView theView, Magazziniere theModel) {
		this.theView = theView;
		this.theModel = theModel;

		        // Comunica alla View quando viene premuto bottone accedi
		        // di eseguire il metodo actionPerformed
		        // nella classe interna AccediListener
		this.theView.addConfermaOrarioListener(new ConfermaOrarioListener());
		this.theView.addCambiaOrarioListener(new CambiaOrarioListener());
		this.theView.addTypeFieldListener(new TypeFieldListener());
		//this.theView.addArticoloListener(new AccediListener());
		//this.theView.addIngressoListener(new AccediListener());
	}
	
	class ConfermaOrarioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				int ins_hour, ins_minute;

		            // try sulle interazioni nel caso in cui
		            // - ora e/o minuti vengano inseriti erroneamente
				try{
					ins_hour = theView.getHour();
					ins_minute = theView.getMinute();
					
					if (checkTime(ins_hour, ins_minute)) {
						theView.setOrario();
					} else {
						throw new NumberFormatException();
					}
					
				} catch(NumberFormatException ex) {
					System.out.println(ex);
					theView.displayErrorMessage("ora e/o minuti invalidi");
				}
		}
		
		private boolean checkTime(int ins_hour, int ins_minute) {
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);  
			int now_hour = cal.get(Calendar.HOUR_OF_DAY);
			int now_minute = cal.get(Calendar.MINUTE);
			
			if (ins_hour > now_hour)
				return false;
			else if (ins_hour == now_hour && ins_minute > now_minute)
				return false;
			return true;
		}
	}
	
	class CambiaOrarioListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				theView.unsetOrario();
		}
	}
	
	class TypeFieldListener implements PopupMenuListener {
		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			// ottieni lista
			List<String> ls = new ArrayList<String>(); 
			ls.add("mammt");
			ls.add("pappt");
			
			theView.setTypeField(ls);
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void popupMenuCanceled(PopupMenuEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
