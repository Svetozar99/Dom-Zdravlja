package main;

import domZdravlja.DomZdravlja;
import enumeracije.Kategorija;
import enumeracije.Pol;
import enumeracije.Sluzba;
import enumeracije.Status;
import enumeracije.Uloga;
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
		
		DomZdravlja domZdravlja = new DomZdravlja();
		
		System.out.println("DODAVANJE TEST PODATAKA...");
		
		Lekar lekar = new Lekar("001", "Miso", "Misovic", "2201991153690", Pol.MUSKI, "Puskinova 29", "0644096874", "miso991", "lozinka123", Uloga.LEKAR, 40.000, Sluzba.SLUZBA_OPSTE_MEDICINE, "specijalizacija...");
		domZdravlja.dodajLekara(lekar);
		Lekar lekar1 = new Lekar("002", "Marko", "Markovic", "1311968783654", Pol.MUSKI, "Cankareva 18", "0628524961", "Markan77", "lozinkaDr", Uloga.LEKAR, 50.000, Sluzba.ZDRAVSTVENA_ZASTITA_DJECE, "specijalizacija neka");
		domZdravlja.dodajLekara(lekar1);
		
		MedicinskaSestra medicinskaSestra = new MedicinskaSestra("001", "Slavica", "Savic", "3109978461783", Pol.ZENSKI, "Jovana Ducica 14", "0639751462", "slava32", "lozinka321", Uloga.MEDICINSKA_SESTRA, 40.000, Sluzba.SLUZBA_OPSTE_MEDICINE);
		domZdravlja.dodajMedSestru(medicinskaSestra);
		MedicinskaSestra medicinskaSestra1 = new MedicinskaSestra("002", "imeMedS", "prezimeMedS", "jmbgMedS", Pol.ZENSKI, "adresaMedS", "brTelMedS", "korImeMedS", "lozinkaMedS",Uloga.MEDICINSKA_SESTRA, 35.000, Sluzba.STOMATOLOSKA_SLUZBA);
		domZdravlja.dodajMedSestru(medicinskaSestra1);

		Knjizica knjizica = new Knjizica("001",12, "24.09.2020", Kategorija.TRECA);
		domZdravlja.dodajKnjizice(knjizica);
		Knjizica knjizica1 = new Knjizica("002", 14, "datumIstekaKnj", Kategorija.PRVA);
		domZdravlja.dodajKnjizice(knjizica1);
		
		Pacijent pacijent = new Pacijent("001", "Ljubisa", "Kovac", "15111965456987", Pol.MUSKI,"Svetosavska bb", "0658269741", "ljubo23", "lozinkaaa", Uloga.PACIJENT, lekar, knjizica);
		domZdravlja.dodajPacijenta(pacijent);
		Pacijent pacijent1 = new Pacijent("002", "imePacijenta", "prezimePacijenta", "jmbgPacijenta", Pol.ZENSKI, "adresaPacijenta", "brTelPacijenta", "korImePacijenta", "lozinkaPacijenta", Uloga.PACIJENT, lekar1, knjizica1);
		domZdravlja.dodajPacijenta(pacijent1);
		 
		Pregled pregled = new Pregled(pacijent, lekar, "22.01.2021", "18", "opis neki", Status.ZAKAZAN);
		domZdravlja.dodajPreglede(pregled);
		Pregled pregled1 = new Pregled(pacijent1, lekar1, "terminPregleda", "sobaPregleda", "opisPregleda", Status.OTKAZAN);
		domZdravlja.dodajPreglede(pregled1);
		
		System.out.println("Snimanje dodanih pdataka...");
		domZdravlja.snimiLekare(LEKARI_FAJL);
		domZdravlja.snimiMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		domZdravlja.snimiKnjizice(KNJIZICE_FAJL);
		domZdravlja.snimiPacijente(PACIJENTI_FAJL);
		domZdravlja.snimiPreglede(PREGLEDI_FAJL);
		
		domZdravlja.ucitajLekare(LEKARI_FAJL);
		domZdravlja.ucitajPacijente(PACIJENTI_FAJL);
		domZdravlja.ucitajMedicinskeSestre(MEDICINSKE_SESTRE_FAJL);
		domZdravlja.ucitajPreglede(PREGLEDI_FAJL);
		domZdravlja.ucitajKnjizice(KNJIZICE_FAJL);
		
		System.out.println("PODACI UCITANI IZ DATOTEKA:");
		System.out.println("---------------------------------------------------------------------------");
		ispisiSvePodatke(domZdravlja);
		System.out.println("---------------------------------------------------------------------------");

	}
	public static void ispisiSvePodatke(DomZdravlja domZdravlja) {
		for(Lekar lekar : domZdravlja.getLekari()) {
			System.out.println(lekar + "\n");
		}
		
		for(Pacijent pacijent : domZdravlja.getPacijenti()) {
			System.out.println(pacijent + "\n");
		}
		for(MedicinskaSestra medicinskaSestra : domZdravlja.getMedicinskeSestre()) {
			System.out.println(medicinskaSestra + "\n");
		}
		for(Pregled pregled : domZdravlja.getPregledi()) {
			System.out.println(pregled + "\n");
		}
		for(Knjizica knjizica : domZdravlja.getKnjizice()) {
			System.out.println(knjizica + "\n");
		}
	}

}
