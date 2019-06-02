package main;

import domZdravlja.DomZdravlja;
import osobe.Lekar;
import osobe.MedicinskaSestra;
import osobe.Pacijent;
import pregled.Knjizica;
import pregled.Pregled;

public class Main2 {

	private static String LEKARI_FAJL = "lekari.txt";
	private static String PACIJENTI_FAJL = "pacijenti.txt";
	private static String MEDICINSKE_SESTRE_FAJL = "medicinskeSestre.txt";
	private static String PREGLEDI_FAJL = "pregledi.txt";
	private static String KNJIZICE_FAJL = "knjizica.txt";

	public static void main(String[] args) {
		DomZdravlja dz = new DomZdravlja();
		
		dz.ucitajLekare(LEKARI_FAJL);
		dz.ucitajPacijente(PACIJENTI_FAJL);
		dz.ucitajMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		dz.ucitajPreglede(PREGLEDI_FAJL);
		dz.ucitajKnjizice(KNJIZICE_FAJL);
		
		
		//DODAVANJE PODATAKA
		
		dz.dodajNovogLekara();
		dz.dodajNovogLekara();
		dz.dodajNovogLekara();
		dz.snimiLekare(LEKARI_FAJL);
		 
		dz.dodajNovuMedicinskuSestru();
		dz.dodajNovuMedicinskuSestru();
		dz.dodajNovuMedicinskuSestru();
		dz.snimiMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		 
		dz.dodajNovuKnjizicu();
		dz.dodajNovuKnjizicu();
		dz.dodajNovuKnjizicu();
		dz.snimiKnjizice(KNJIZICE_FAJL);
		 
		dz.dodajNovogPacijenta();
		dz.dodajNovogPacijenta();
		dz.dodajNovogPacijenta();
		dz.snimiPacijente(PACIJENTI_FAJL);
		 
		dz.dodajNoviPregled();
		dz.dodajNoviPregled();
		dz.dodajNoviPregled();
		dz.snimiPreglede(PREGLEDI_FAJL);
		 
		
		//IZMENA PODATAKA
		
		dz.izmeniLekara();
		dz.snimiLekare(LEKARI_FAJL);
		
		dz.izmeniMedicinskuSestru();
		dz.snimiMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		
		dz.izmeniPacijenta();
		dz.snimiPacijente(PACIJENTI_FAJL);
		
		dz.izmeniKnjizicu();
		dz.snimiKnjizice(KNJIZICE_FAJL);
		
		dz.izmeniPregled();
		dz.snimiPreglede(PREGLEDI_FAJL);
		
		
		//BRISANJE PODATAKA
		
		dz.obrisiLekara();
		dz.snimiPreglede(PREGLEDI_FAJL);
		dz.snimiPacijente(PACIJENTI_FAJL);
		
		dz.obrisiPacijenta();
		dz.snimiPacijente(PACIJENTI_FAJL);
		dz.snimiPreglede(PREGLEDI_FAJL);
		
		dz.obrisiMedicinskuSestru();
		dz.snimiMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		
		dz.obrisiPregled();
		dz.snimiPreglede(PREGLEDI_FAJL);
		
		dz.obrisiKnjizicu();
		dz.snimiPacijente(PACIJENTI_FAJL);
		dz.snimiKnjizice(KNJIZICE_FAJL);
		
		ispisiSvePodatke(dz);
	}
	
	  public static void ispisiSvePodatke(DomZdravlja domZdravlja) {
		  for(Lekar lekar : domZdravlja.getLekari()) {
			  if(lekar.getActive() == true) {
				  System.out.println(lekar + "\n");
			  }
		  }
		  for(Pacijent pacijent : domZdravlja.getPacijenti()) {
			  if(pacijent.getActive() == true) {
				  System.out.println(pacijent + "\n");
			  }
		  }
		  for(MedicinskaSestra medicinskaSestra: domZdravlja.getMedicinskeSestre()) {
			  if(medicinskaSestra.getActive() == true) {
				  System.out.println(medicinskaSestra + "\n");
			  }
		  }
		  for(Pregled pregled : domZdravlja.getPregledi()) {
			  if(pregled.getActive() == true) {
				  System.out.println(pregled + "\n");
			  }
		  }
		  for(Knjizica knjizica :domZdravlja.getKnjizice()) {
			  if(knjizica.getActive() == true) {
				  System.out.println(knjizica + "\n");
			  }
		  }
	  }
}
