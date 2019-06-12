package main;

import java.text.ParseException;

import domZdravlja.DomZdravlja;
import gui.LoginProzor;
import osobe.Lekar;
import osobe.MedicinskaSestra;
import osobe.Pacijent;
import pregled.Knjizica;
import pregled.Pregled;

public class Main2 {

	private static String LEKARI_FAJL = "lekari.txt";
	private static String KNJIZICE_FAJL = "knjizica.txt";
	private static String PACIJENTI_FAJL = "pacijenti.txt";
	private static String PREGLEDI_FAJL = "pregledi.txt";
	private static String MEDICINSKE_SESTRE_FAJL = "medicinskeSestre.txt";

	public static void main(String[] args) {
		DomZdravlja dz = new DomZdravlja();
	
		dz.ucitajLekare(LEKARI_FAJL);
		dz.ucitajMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		try {
			dz.ucitajKnjizice(KNJIZICE_FAJL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dz.ucitajPacijente(PACIJENTI_FAJL);
		try {
			dz.ucitajPreglede(PREGLEDI_FAJL);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LoginProzor lp = new LoginProzor(dz);
		lp.setVisible(true);
		
	}
	
	  public static void ispisiSvePodatke(DomZdravlja domZdravlja) {
		  for(Lekar lekar : domZdravlja.getLekari()) {
			  System.out.println(lekar + "\n");
		  }
		  for(Pacijent pacijent : domZdravlja.getPacijenti()) {
			  System.out.println(pacijent + "\n");
		  }
		  for(MedicinskaSestra medicinskaSestra: domZdravlja.getMedicinskeSestre()) {
			  System.out.println(medicinskaSestra + "\n");
		  }
		  for(Pregled pregled : domZdravlja.getPregledi()) {
			  System.out.println(pregled + "\n");
		  }
		  for(Knjizica knjizica :domZdravlja.getKnjizice()) {
			  System.out.println(knjizica + "\n");
		  }
	  }
}
