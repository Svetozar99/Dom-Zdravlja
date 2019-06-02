package domZdravlja;

import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

public class DomZdravlja {
	private List<Lekar> lekari;
	private List<Pacijent> pacijenti;
	private List<MedicinskaSestra> medicinskeSestre;
	private List<Pregled> pregledi;
	private List<Knjizica> knjizice;
	
	public DomZdravlja() {
		this.lekari = new ArrayList<Lekar>();
		this.pacijenti = new ArrayList<Pacijent>();
		this.medicinskeSestre = new ArrayList<MedicinskaSestra>();
		this.pregledi = new ArrayList<Pregled>();
		this.knjizice = new ArrayList<Knjizica>();
	}
	
	public List<Lekar> getLekari() {
		return lekari;
	}

	public void setLekari(List<Lekar> lekari) {
		this.lekari = lekari;
	}

	public List<Pacijent> getPacijenti() {
		return pacijenti;
	}

	public void setPacijenti(List<Pacijent> pacijenti) {
		this.pacijenti = pacijenti;
	}

	public List<MedicinskaSestra> getMedicinskeSestre() {
		return medicinskeSestre;
	}

	public void setMedicinskeSestre(List<MedicinskaSestra> medicinskeSestre) {
		this.medicinskeSestre = medicinskeSestre;
	}

	public List<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(List<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public List<Knjizica> getKnjizice() {
		return knjizice;
	}

	public void setKnjizice(List<Knjizica> knjizice) {
		this.knjizice = knjizice;
	}
	
	//RANDOM BROJ
	public int randomBroj() {
		int broj;
		Random rand = new Random();
		broj = rand.nextInt(900);
		//System.out.println(broj);
		return broj;
	}
	
	//DODAVANJE NOVOG LEKARA
	public void dodajNovogLekara() {
		System.out.println("DODAVANJE NOVOG LEKARA:");
		Lekar l = new Lekar();
		String scan = skener.nextLine();
		System.out.println("Unesi korisnicko ime lekara: ");
		String korIme = skener.nextLine();		
		for(Lekar lekar:lekari) {
			if(lekar.getKorIme().equalsIgnoreCase(korIme)) { 
				System.out.println("To korisnicko ime vec postoji.");
				}
			}
		l.setKorIme(korIme);
		
		System.out.println("Unesi ime lekara: ");
		String ime = skener.nextLine();
		l.setIme(ime);
		System.out.println("Unesi prezime lekara: ");
		String prezime = skener.nextLine();
		l.setPrezime(prezime);
		System.out.println("Unesi JMBG lekara: ");
		String jmbg = skener.nextLine();
		l.setJmbg(jmbg);
		System.out.println("Unesi adresu lekara: ");
		String adresaa = skener.nextLine();
		l.setAdresa(adresaa);
		System.out.println("Unesi broj telefona lekara: ");
		String brTel = skener.nextLine();
		l.setBrTel(brTel);
		System.out.println("Unesi lozinku lekara: ");
		String lozinka = skener.nextLine();
		l.setLozinka(lozinka);
		System.out.println("Unesite specijalizaciju lekara: ");
		String specij = skener.nextLine();
		l.setSpecijalizacija(specij);
		System.out.println("Unesi platu lekara: ");
		double plata = skener.nextDouble();
		l.setPlata(plata);
		Uloga uloga = Uloga.LEKAR;
		l.setUloga(uloga);
		l.setActive(true);
		int broj = randomBroj();
		String id = "L" + broj;
		l.setId(id);
		System.out.println("Izaberite pol lekara(unesite broj): " + 
									"\n1)MUSKI" + 
									"\n2)ZENSKI" + 
									"\nVas izbor je: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Pol polM = Pol.MUSKI;
			l.setPol(polM);
		}else if(izbor == 2) {
			Pol polZ = Pol.ZENSKI;
			l.setPol(polZ);
		}else {
			System.out.println("Pogresan unos");
		}
		
		System.out.println("Izaberite novu sluzbu lekara" + "\n1) Opste medicine,"
														+ "\n2) Pravni i ekonomski poslovi,"
														+ "\n3) Tehnicki poslovi"
														+ "\n4) Stomatoloska sluzba"
														+ "\n5) Zdravstvena zastita djece"
														+ "\n6) Zdravstvena zastita radnika"
														+ "\nUnesite broj: ");
		int i = skener.nextInt();
	
		if (i == 1) {
			Sluzba sluzbaOM = Sluzba.SLUZBA_OPSTE_MEDICINE;
			l.setSluzba(sluzbaOM);
		}else if(i == 2) {
			Sluzba sluzbaPiE = Sluzba.SLUZBA_ZA_PRAVNE_I_EKONOMSKE_POSLOVE;
			l.setSluzba(sluzbaPiE);
		}else if(i == 3) {
			Sluzba sluzbaT = Sluzba.SLUZBA_ZA_TEHNICKE_POSLOVE;
			l.setSluzba(sluzbaT);
		}else if(i == 4) {
			Sluzba sluzbaST = Sluzba.STOMATOLOSKA_SLUZBA;
			l.setSluzba(sluzbaST);
		}else if(i == 5) {
			Sluzba sluzbaZD = Sluzba.ZDRAVSTVENA_ZASTITA_DJECE;
			l.setSluzba(sluzbaZD);
		}else if(i == 6) {
			Sluzba sluzbaZR = Sluzba.ZDRAVSTVENA_ZASTITA_RADINKA;
			l.setSluzba(sluzbaZR);
		}else {
			System.out.println("Pogresan unos");
		}
		lekari.add(l);
	}
	
	//DODAVANJE NOVE MEDICINSKE SESTRE
	public void dodajNovuMedicinskuSestru() {
		System.out.println("DODAVANJE NOVE MEDICINSKE SESTRE:");
		MedicinskaSestra m = new MedicinskaSestra();
		String scan = skener.nextLine();
		System.out.println("Unesi korisnicko ime medicinske sestre: ");
		String korIme = skener.nextLine();
		for(MedicinskaSestra medicinskaSestra : medicinskeSestre) {
			while(medicinskaSestra.getKorIme().equalsIgnoreCase(korIme)) 
				System.out.println("To korisnicko ime vec postoji, morate uneti drugo.");
		}
		m.setKorIme(korIme);
		m.setActive(true);
		System.out.println("Unesi ime medicinske sestre: ");
		String ime = skener.nextLine();
		m.setIme(ime);
		System.out.println("Unesi prezime medicinske sestre: ");
		String prezime = skener.nextLine();
		m.setPrezime(prezime);
		int broj = randomBroj();
		String id = "MS" + broj;
		m.setId(id);
		
		System.out.println("Unesi JMBG medicinske sestre: ");
		String jmbg = skener.nextLine();
		m.setJmbg(jmbg);
		System.out.println("Unesi adresu medicinske sestre: ");
		String adresaM = skener.nextLine();
		m.setAdresa(adresaM);
		System.out.println("Unesi broj telefona medicinske sestre: ");
		String brTel = skener.nextLine();
		m.setBrTel(brTel);
		
		System.out.println("Unesi lozinku medicinske sestre: ");
		String lozinka = skener.nextLine();
		m.setLozinka(lozinka);
		System.out.println("Unesi platu medicinske sestre: ");
		double plata = skener.nextDouble();
		m.setPlata(plata);
		System.out.println("Izaberite pol medicinske sestre(unesite broj): " + 
									"\n1)MUSKI" + 
									"\n2)ZENSKI" + 
									"\nVas izbor je: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Pol polM = Pol.MUSKI;
			m.setPol(polM);
		}else if(izbor == 2) {
			Pol polZ = Pol.ZENSKI;
			m.setPol(polZ);
		}else {
			System.out.println("Pogresan unos");
		}
		
		System.out.println("Izaberite novu sluzbu medicinske sestre" + "\n1) Opste medicine,"
														+ "\n2) Pravni i ekonomski poslovi,"
														+ "\n3) Tehnicki poslovi"
														+ "\n4) Stomatoloska sluzba"
														+ "\n5) Zdravstvena zastita djece"
														+ "\n6) Zdravstvena zastita radnika"
														+ "\nUnesite broj: ");
		int i = skener.nextInt();
	
		if (i == 1) {
			Sluzba sluzbaOM = Sluzba.SLUZBA_OPSTE_MEDICINE;
			m.setSluzba(sluzbaOM);
		}else if(i == 2) {
			Sluzba sluzbaPiE = Sluzba.SLUZBA_ZA_PRAVNE_I_EKONOMSKE_POSLOVE;
			m.setSluzba(sluzbaPiE);
		}else if(i == 3) {
			Sluzba sluzbaT = Sluzba.SLUZBA_ZA_TEHNICKE_POSLOVE;
			m.setSluzba(sluzbaT);
		}else if(i == 4) {
			Sluzba sluzbaST = Sluzba.STOMATOLOSKA_SLUZBA;
			m.setSluzba(sluzbaST);
		}else if(i == 5) {
			Sluzba sluzbaZD = Sluzba.ZDRAVSTVENA_ZASTITA_DJECE;
			m.setSluzba(sluzbaZD);
		}else if(i == 6) {
			Sluzba sluzbaZR = Sluzba.ZDRAVSTVENA_ZASTITA_RADINKA;
			m.setSluzba(sluzbaZR);
		}else {
			System.out.println("Pogresan unos");
		}
		medicinskeSestre.add(m);
	}
	
	//DODAVANJE NOVOG PACIJENTA
	public void dodajNovogPacijenta() {
		System.out.println("DODAVANJE NOVOG PACIJENTA:");
		Pacijent p = new Pacijent();
		String scan = skener.nextLine();
		System.out.println("Unesi korisnicko ime pacijenta: ");
		String korIme = skener.nextLine();
		for(Pacijent pacijent:pacijenti) {
			while(pacijent.getKorIme().equalsIgnoreCase(korIme)) 
				System.out.println("To korisnicko ime vec postoji, morate uneti drugo.");
		}
		p.setKorIme(korIme);
		int broj = randomBroj();
		String id = "PA" + broj;
		p.setId(id);
		System.out.println("Unesi ime pacijenta: ");
		String ime = skener.nextLine();
		p.setIme(ime);
		System.out.println("Unesi prezime pacijenta: ");
		String prezime = skener.nextLine();
		p.setPrezime(prezime);
		System.out.println("Unesi JMBG pacijenta: ");
		String jmbg = skener.nextLine();
		p.setJmbg(jmbg);
		System.out.println("Unesi adresu pacijenta: ");
		String adresa = skener.nextLine();
		p.setAdresa(adresa);
		System.out.println("Unesi broj telefona pacijenta: ");
		String brTel = skener.nextLine();
		p.setBrTel(brTel);
		
		System.out.println("Unesi lozinku pacijenta: ");
		String lozinka = skener.nextLine();
		p.setLozinka(lozinka);
		p.setActive(true);
		System.out.println("Unesi korisnicko ime lekara od ovog pacijenta: ");
		String korImee = skener.nextLine();
		Lekar lekar = nadjiLekara(korImee);
		p.setLekar(lekar);
		System.out.println("Unesi id knjizice od ovog pacijenta: ");
		String idK = skener.nextLine();
		Knjizica knjizica = nadjiKnjizicu(idK);
		p.setZdrKnjizica(knjizica);
		System.out.println("Izaberite pol pacijenta(unesite broj): " + 
									"\n1)MUSKI" + 
									"\n2)ZENSKI" + 
									"\nVas izbor je: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Pol polM = Pol.MUSKI;
			p.setPol(polM);
		}else if(izbor == 2) {
			Pol polZ = Pol.ZENSKI;
			p.setPol(polZ);
		}
		pacijenti.add(p);
		System.out.println(p.getLekar().getKorIme());
	}
	
	//DODAVANJE NOVE KNJIZICE
	public void dodajNovuKnjizicu() {
		System.out.println("DODAVANJE NOVE KNJIZICE: ");
		Knjizica k = new Knjizica();
		String scan = skener.nextLine();
		k.setActive(true);
		int brojString = randomBroj();
		String id = "KN" + brojString;
		k.setId(id);
		int brojS = randomBroj();
		k.setBroj(brojS);
		System.out.println("Unesi datum isteka knjizice: ");
		String datumST = skener.nextLine();
		k.setDatumIsteka(datumST);
		System.out.println("Izaberite kategoriju knjizice(unesite broj): " + 
															"\n1)PRVA" + 
															"\n2)DRUGA" +
															"\n3)TRECA" +
															"\nVas izbor je: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Kategorija kat1 = Kategorija.PRVA;
			k.setKategorija(kat1);
		}else if(izbor == 2) {
			Kategorija kat2 = Kategorija.DRUGA;
			k.setKategorija(kat2);
		}else if(izbor == 3) {
			Kategorija kat3 = Kategorija.TRECA;
			k.setKategorija(kat3);
		}
		knjizice.add(k);
	}
	
	//DODAVANJE NOVOG PREGLEDA
	public void dodajNoviPregled() {
		System.out.println("DODAVANJE NOVOG PREGLEDA: ");
		Pregled pr = new Pregled();
		String scan = skener.nextLine();
		pr.setActive(true);
		int brojString = randomBroj();
		String idPr = "PR" + brojString;
		pr.setId(idPr);
		System.out.println("Unesi korisnicko ime pacijenta iz ovog pregleda: ");
		String korImePa = skener.nextLine();
		Pacijent pacijentPr = nadjiPacijenta(korImePa);
		pr.setPacijent(pacijentPr);
		System.out.println("Unesi korisnicko ime lekara iz ovog pregleda: ");
		String korImeLe = skener.nextLine();
		Lekar lekarPr = nadjiLekara(korImeLe);
		pr.setLekar(lekarPr);
		System.out.println("Unesi termin pregleda: ");
		String terminPr = skener.nextLine();
		pr.setTermin(terminPr);
		System.out.println("Unesi sobu pregleda: ");
		String sobaPr = skener.nextLine();
		pr.setSoba(sobaPr);
		System.out.println("Unesi opis pregleda: ");
		String opisPr = skener.nextLine();
		pr.setOpis(opisPr);
		System.out.println("Izaberite status pregleda(unesite broj): " + 
															"\n1)ZATRAZEN" + 
															"\n2)ZAKAZAN" +
															"\n3)OTKAZAN" +
															"\n4)ZAVRSEN" +
															"\nVas izbor je: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Status st1 = Status.ZATRAZEN;
			pr.setStatus(st1);
		}else if(izbor == 2) {
			Status st2 = Status.ZAKAZAN;
			pr.setStatus(st2);
		}else if(izbor == 3) {
			Status st3 = Status.OTKAZAN;
			pr.setStatus(st3);
		}else if(izbor == 4) {
			Status st4 = Status.ZAVRSEN;
			pr.setStatus(st4);
		}
		pregledi.add(pr);
	}
	
	//BRISANJE
	
	public void obrisiLekara() {
		System.out.println("Unesi korisnicko ime lekara kojeg zelis da obrises: ");
		String koris = skener.nextLine();
		Lekar l = nadjiLekara(koris);
		//this.lekari.remove(l);
		l.setActive(false);
		for(Pregled pregled : pregledi) {
			if(pregled.getLekar().getActive() == false) {
				System.out.println("Lekar za jedan pregled je obrisan, nadji zameni za njega.");
				System.out.println("Unesi korisnicko ime novog lekara za ovaj pregled: ");
				String scan = skener.nextLine();
				Lekar lekar = nadjiLekara(scan);
				pregled.setLekar(lekar);
			}
		}
		for(Pacijent pacijent: pacijenti) {
			if(pacijent.getLekar().getActive() == false) {
				System.out.println("Lekar jednog pacijenta je obrisan, nadji za zamenu za njega.");
				System.out.println("Unesi korisnicko ime novog lekara za ovog pacijenta: ");
				String scan = skener.nextLine();
				Lekar lekar = nadjiLekara(scan);
				pacijent.setLekar(lekar);
			}
		}
	}
	public void obrisiPacijenta() {
		System.out.println("Unesi korisnicko ime pacijenta kojeg zelis da obrises: ");
		String korisn = skener.nextLine();
		Pacijent p = nadjiPacijenta(korisn);
		//this.pacijenti.remove(p);
		p.setActive(false);
		for(Pregled pregled : pregledi) {
			if(pregled.getPacijent().getActive() == false) {
				System.out.println("Pacijent u jednom pregledu je obrisan, pa ce i taj pregled biti obrisan");
				pregled.setActive(false);
			}
		}
	}
	public void obrisiMedicinskuSestru() {
		System.out.println("Unesi korisnicko ime medicinske sestre koju zelis da obrises: ");
		String kori = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(kori);
		//this.medicinskeSestre.remove(m);
		m.setActive(false);
	}
	public void obrisiKnjizicu() {
		System.out.println("Unesi id knjizice koju zelis da obrises: ");
		String kori = skener.nextLine();
		Knjizica k = nadjiKnjizicu(kori);
		//this.knjizice.remove(k);
		k.setActive(false);
		for(Pacijent pacijent:pacijenti) {
			if(pacijent.getZdrKnjizica().getActive() == false) {
				System.out.println("Knjizica jednog pacijenta je obrisana, zamjeni knjizicu pacijentu");
				System.out.println("Unesi ID nove knjizice za ovog pacijenta: ");
				String scan = skener.nextLine();
				Knjizica knjizica = nadjiKnjizicu(scan);
				pacijent.setZdrKnjizica(knjizica);
			}
		}
	}
	public void obrisiPregled() {
		System.out.println("Unesi id pregleda koji zelis da obrises: ");
		String kori = skener.nextLine();
		Pregled p = nadjiPregled(kori);
		//this.pregledi.remove(p);
		p.setActive(false);
	}
	
	//VRATI OBRISANOG
	
	public void aktivirajLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		l.setActive(true);
		System.out.println("Lekar je aktivan.");
	}
	public void aktivirajPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		p.setActive(true);
		System.out.println("Pacijent je aktivan.");
	}
	public void aktivirajMedicinskuSestru() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		m.setActive(true);
		System.out.println("Medicinska sestra je aktivna.");
	}
	public void ativirajPregled() {
		System.out.println("Unesi id pregleda: ");
		String id = skener.nextLine();
		Pregled p = nadjiPregled(id);
		p.setActive(true);
		System.out.println("Pregled je aktivan.");
	}
	public void aktivirajKnjizicu() {
		System.out.println("Unesi id knjizice: ");
		String idKnj = skener.nextLine();
		Knjizica k = nadjiKnjizicu(idKnj);
		k.setActive(true);
		System.out.println("Knjizica je aktivna.");
	}
	
	//IZMJENA PODATAKA
	
	Scanner skener = new Scanner(System.in);
	
	public void izmeniLekara() {
		System.out.println("IZMENA LEKARA: ");
		System.out.println("Izaberite sta zelite da izmjenite: " +
			  										"\n1)Ime" +
			  										"\n2)Prezime" +
			  										"\n3)JMBG" +
			  										"\n4)Pol" +
			  										"\n5)Adresa" +
			  										"\n6)Broj telefona" +
			  										"\n7)Korisnicko ime" +
			  										"\n8)Lozinka" +
			  										"\n9)Plata" +
			  										"\n10)Sluzba" +
			  									  	"\n11)Specijalizacija" +
			  										"\nVas izbor je: ");
		int izbor = skener.nextInt();
		switch(izbor) {
		case 1:
			izmeniImeLekara();
			break;
		case 2:
			izmeniPrezimeLekara();
			break;
		case 3:
			izmeniJmbgLekara();
			break;
		case 4:
			izmeniPolLekara();
			break;
		case 5:
			izmeniAdresuLekara();
			break;
		case 6:
			izmeniBrojTelefonaLekara();
			break;
		case 7:
			izmeniKorisnickoImeLekara();
			break;
		case 8:
			izmeniLozinkuLekara();
			break;
		case 9:
			izmeniPlatuLekara();
			break;
		case 10:
			izmeniSluzbuLekara();
			break;
		case 11:
			izmeniSpecijalizacijuLekara();
			break;
		default: 
			System.out.println("Pogresan unos. unesite ponovo.");
			izmeniLekara();
			}
		}
	
	public void izmeniMedicinskuSestru() {
		System.out.println("IZMENA MEDICINSKE SESTRE: ");
		System.out.println("Izaberite sta zelite da izmjenite: " +
			  										"\n1)Ime" +
			  										"\n2)Prezime" +
			  										"\n3)JMBG" +
			  										"\n4)Pol" +
			  										"\n5)Adresa" +
			  										"\n6)Broj telefona" +
			  										"\n7)Korisnicko ime" +
			  										"\n8)Lozinka" +
			  										"\n9)Plata" +
			  										"\n10)Sluzba" + 
			  										"\nVas izbor je: "
			  									  	);
	//	String sccan = skener.nextLine();
		int izbor = skener.nextInt();
		switch(izbor) {
		case 1:
			izmeniImeMedicinskeSestre();
			break;
		case 2:
			izmeniPrezimeMedicinskeSestre();
			break;
		case 3:
			izmeniJmbgMedicinskeSestre();
			break;
		case 4:
			izmeniPolMedicinskeSestre();
			break;
		case 5:
			izmeniAdresuMedicinskeSestre();
			break;
		case 6:
			izmeniBrojTelefonaMedicinskeSestre();
			break;
		case 7:
			izmeniKorisnickoImeMedicinskeSestre();
			break;
		case 8:
			izmeniLozinkuMedicinskeSestre();
			break;
		case 9:
			izmeniPlatuMedicinskeSestre();
			break;
		case 10:
			izmeniSluzbuMedicinskeSestre();
			break;
		default: 
			System.out.println("Pogresan unos. unesite ponovo.");
			izmeniMedicinskuSestru();
			}
		}
	
	public void izmeniPacijenta() {
		System.out.println("IZMENA PACIJENTA: ");
		System.out.println("Izaberite sta zelite da izmjenite: " +
			  										"\n1)Ime" +
			  										"\n2)Prezime" +
			  										"\n3)JMBG" +
			  										"\n4)Pol" +
			  										"\n5)Adresa" +
			  										"\n6)Broj telefona" +
			  										"\n7)Korisnicko ime" +
			  										"\n8)Lozinka" +
			  										"\n9)Lekar" +
			  										"\n10)Zdravstvena knjizica" + 
			  										"\nVas izbor je: "
			  									  	);
		int izbor = skener.nextInt();
		switch(izbor) {
		case 1: 
			izmeniImePacijenta();
			break;
		case 2:
			izmeniPrezimePacijenta();
			break;
		case 3:
			izmeniJmbgPacijenta();
			break;
		case 4:
			izmeniPolPacijenta();
			break;
		case 5:
			izmeniAdresuPacijenta();
			break;
		case 6:
			izmeniBrojTelefonaPacijenta();
			break;
		case 7:
			izmeniKorisnickoImePacijenta();
			break;
		case 8:
			izmeniLozinkuPacijenta();
			break;
		case 9:
			izmeniLekaraKodPacijenta();
			break;
		case 10:
			izmeniKnjizicuPacijenta();
			break;
		default: 
			System.out.println("Pogresan unos. unesite ponovo.");
			izmeniPacijenta();
			}
		}
	
	public void izmeniKnjizicu() {
		System.out.println("IZMJENA KNJIZICE");
		System.out.println("Izaberite sta zelite da izmenite:" + 
														"\n1)Broj" + 
														"\n2)Datum isteka" + 
														"\n3)Kategorija");
		int izbor = skener.nextInt();
		switch(izbor) {
		case 1:
			izmeniBrojZdravstveneKnjzice();
			break;
		case 2:
			izmeniDatumKnjizice();
			break;
		case 3:
			izmeniKategorijuKnjizice();
			break;
		default:
			System.out.println("Pogresan unos. Pokusajte ponovo.");
			izmeniKnjizicu();
		}
	}
	
	public void izmeniPregled() {
		System.out.println("IZMENA PREGLEDA: ");
		System.out.println("Izaberite sta zelite da izmenite: " +
												"\n1)Pacijent" + 
												"\n2)Lekar" +
												"\n3)Termin" + 
												"\n4)Soba" + 
												"\n5)Opis" + 
												"\n6)Status" + 
												"\nVas izbor je: ");
		int izbor = skener.nextInt();
		switch(izbor) {
		case 1:
			izmeniPacijentaKodPregleda();
			break;
		case 2:
			izmeniLekaraKodPregleda();
			break;
		case 3:
			izmeniTerminPregleda();
			break;
		case 4:
			izmeniSobuPregleda();
			break;
		case 5:
			izmeniOpisPregleda();
			break;
		case 6:
			izmeniStatusPregleda();
			break;
		default:
			System.out.println("Pogresan unos. Pokusajte ponovo.");
			izmeniPregled();
		}
	}
	
	//IME
	
	public void izmeniImeLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novo ime lekara: ");
		String unos = skener.nextLine();
		l.setIme(unos);
		System.out.println("Novo ime lekara je: " + l.getIme());
	}
	public void izmeniImePacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String unoss = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novo ime pacijenta: ");
		String unos = skener.nextLine();
		p.setIme(unos);
		System.out.println("Novo ime pacijenta je: " + p.getIme());
	}
	public void izmeniImeMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novo ime medicinske sestre: ");
		String unos = skener.nextLine();
		m.setIme(unos);
		System.out.println("Novo ime medicinske sestre je: " + m.getIme());
	}
	
	//PREZIME
	public void izmeniPrezimeLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novo prezime lekara: ");
		String unos = skener.nextLine();
		l.setPrezime(unos);
		System.out.println("Novo prezime lekara je: " + l.getPrezime());
	}
	public void izmeniPrezimePacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novo prezime pacijenta: ");
		String unos = skener.nextLine();
		p.setPrezime(unos);
		System.out.println("Novo prezime pacijenta je: " + p.getPrezime());
	}
	public void izmeniPrezimeMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novo prezime medicinske sestre: ");
		String unos = skener.nextLine();
		m.setPrezime(unos);
		System.out.println("Novo prezime medicinske sestre je: " + m.getPrezime());
	}
	
	//JMBG
	public void izmeniJmbgLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novi jmbg lekara: ");
		String unos = skener.nextLine();
		l.setJmbg(unos);
		System.out.println("Novi jmbg lekara je: " + l.getJmbg());
	}
	public void izmeniJmbgPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novi jmbg pacijenta: ");
		String unos = skener.nextLine();
		p.setJmbg(unos);
		System.out.println("Novi jmbg pacijenta je: " + p.getJmbg());
	}
	public void izmeniJmbgMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novi jmbg medicinske sestre: ");
		String unos = skener.nextLine();
		m.setJmbg(unos);
		System.out.println("Novi jmbg medicinske sestre je: " + m.getJmbg());
	}
	
	//POL
	public void izmeniPolLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi pol lekara: " + 
											"\n1)Muski" + 
											"\n2)Zenski");
		int unos = skener.nextInt(); 
		if(unos == 1) {
			Pol polM = Pol.MUSKI;
			l.setPol(polM);
		}else if (unos == 2){
			Pol polZ = Pol.ZENSKI;
			l.setPol(polZ);
		}else {
			System.out.println("Pogresan unos pola.");
			izmeniPolLekara();
		}
		System.out.println("Lekar sada ima pol: " + l.getPol());
	}
	public void izmeniPolPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi pol pacijenta: " + 
											"\n1)Muski" +
											"\n2)Zenski");
		int unos = skener.nextInt(); 
		if(unos == 1) {
			Pol polM = Pol.MUSKI;
			p.setPol(polM);
		}else if (unos == 2){
			Pol polZ = Pol.ZENSKI;
			p.setPol(polZ);
		}else {
			System.out.println("Pogresan unos pola.");
			izmeniPolPacijenta();
		}
		System.out.println("Pacijent sada ima pol: " + p.getPol());
	}
	public void izmeniPolMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi pol medicinske sestre: " + 
													"\n1)Muski" +
													"\n2)Zenski");
		int izbor = skener.nextInt(); 
		if(izbor == 1) {
			Pol polM = Pol.MUSKI;
			m.setPol(polM);
		}else if (izbor == 2){
			Pol polZ = Pol.ZENSKI;
			m.setPol(polZ);
		}else {
			System.out.println("Pogresan unos pola.");
			izmeniPolMedicinskeSestre();
		}
		System.out.println("Medicinska sestra sada ima pol: " + m.getPol());
	}
	
	//ADRESA
	public void izmeniAdresuLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novu adresu lekara: ");
		String unos = skener.nextLine();
		l.setAdresa(unos);
		System.out.println("Nova adresa lekara je: " + l.getAdresa());
	}
	public void izmeniAdresuPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novu adresu pacijenta: ");
		String unos = skener.nextLine();
		p.setAdresa(unos);
		System.out.println("Nova adresa pacijenta je: " + p.getAdresa());
	}
	public void izmeniAdresuMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novu adresu medicinske sestre: ");
		String unos = skener.nextLine();
		m.setAdresa(unos);
		System.out.println("Nova adresa medicinske sestre je: " + m.getAdresa());
	}
	
	//BROJ TELEFONA
	public void izmeniBrojTelefonaLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novi broj telefona lekara: ");
		String unos = skener.nextLine();
		l.setBrTel(unos);
		System.out.println("Novi broj telefona lekara je: " + l.getBrTel());
	}
	public void izmeniBrojTelefonaPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novi broj telefona pacijenta: ");
		String unos = skener.nextLine();
		p.setBrTel(unos);
		System.out.println("Novi broj telefona pacijenta je: " + p.getBrTel());
	}
	public void izmeniBrojTelefonaMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novi broj telefona medicinske sestre: ");
		String unos = skener.nextLine();
		m.setBrTel(unos);
		System.out.println("Novi broj telefona medicinske sestre je: " + m.getBrTel());
	}
	
	//KORISNICKO IME
	public void izmeniKorisnickoImeLekara() {
		System.out.println("Unesi korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novo korisnicko ime lekara: ");
		String unos = skener.nextLine();
		for(Lekar lekar: lekari) {
			while(lekar.getKorIme().equalsIgnoreCase(unos)) {
				System.out.println("To korisnicko ime vec postoji, pokusajte ponovo: ");
				izmeniKorisnickoImeLekara(); 
			}
		}
		l.setKorIme(unos);
		System.out.println("Novo korisnicko ime lekara je: " + l.getKorIme());
	}
	public void izmeniKorisnickoImePacijenta() {
		System.out.println("Unesi korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novo korisnicko ime pacijenta: ");
		String unos = skener.nextLine();
		for(Pacijent pacijent: pacijenti) {
			while(pacijent.getKorIme().equalsIgnoreCase(unos)) {
				System.out.println("To korisnicko ime vec postoji, pokusajte ponovo: ");
				izmeniKorisnickoImePacijenta();
			}
		}
		p.setKorIme(unos);
		System.out.println("Novo korisnicko ime pacijenta je: " + p.getKorIme());
	}
	public void izmeniKorisnickoImeMedicinskeSestre() {
		System.out.println("Unesi korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novo ime medicinske sestre: ");
		String unos = skener.nextLine();
		for(MedicinskaSestra ms : medicinskeSestre) {
			while(ms.getKorIme().equalsIgnoreCase(unos)) {
				System.out.println("To korisnicko ime vec postoji, pokusajte ponovo: ");
				izmeniKorisnickoImeMedicinskeSestre();
			}
		}
		m.setKorIme(unos);
		System.out.println("Novo korisnicko ime medicinske sestre je: " + m.getKorIme());
	}
	
	//LOZINKA
	public void izmeniLozinkuLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novu lozinku lekara: ");
		String unos = skener.nextLine();
		l.setLozinka(unos);
		System.out.println("Nova lozinka lekara je: " + l.getLozinka());
	}
	public void izmeniLozinkuPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi novu lozinku pacijenta: ");
		String unos = skener.nextLine();
		p.setLozinka(unos);
		System.out.println("Nova lozinka pacijenta je: " + p.getLozinka());
	}
	public void izmeniLozinkuMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novu lozinku medicinske sestre: ");
		String unos = skener.nextLine();
		m.setLozinka(unos);
		System.out.println("Nova lozinka medicinske sestre je: " + m.getLozinka());
	}
	
	//PLATA
	public void izmeniPlatuLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novi iznos plate lekara: ");
		double plata = skener.nextDouble();
		l.setPlata(plata);
		System.out.println("Nova plata lekara iznosi: " + l.getPlata());
	}
	public void izmeniPlatuMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Unesi novi iznos plate medicinske sestre: ");
		double plata = skener.nextDouble();
		m.setPlata(plata);
		System.out.println("Nova plata medicinske sestre je: " + m.getPlata());
	}
	
	//SLUZBA
	public void izmeniSluzbuLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Izaberite novu sluzbu lekara" 
												+ "\n1) Opste medicine"
												+ "\n2) Pravni i ekonomski poslovi"
												+ "\n3) Tehnicki poslovi"
												+ "\n4) Stomatoloska sluzba"
												+ "\n5) Zdravstvena zastita djece"
												+ "\n6) Zdravstvena zastita radnika"
												+ "\nUnesite broj: ");
		int izbor = skener.nextInt();
		if (izbor == 1) {
			Sluzba sluzbaOM = Sluzba.SLUZBA_OPSTE_MEDICINE;
			l.setSluzba(sluzbaOM);
		}else if(izbor == 2) {
			Sluzba sluzbaPiE = Sluzba.SLUZBA_ZA_PRAVNE_I_EKONOMSKE_POSLOVE;
			l.setSluzba(sluzbaPiE);
		}else if(izbor == 3) {
			Sluzba sluzbaT = Sluzba.SLUZBA_ZA_TEHNICKE_POSLOVE;
			l.setSluzba(sluzbaT);
		}else if(izbor == 4) {
			Sluzba sluzbaST = Sluzba.STOMATOLOSKA_SLUZBA;
			l.setSluzba(sluzbaST);
		}else if(izbor == 5) {
			Sluzba sluzbaZD = Sluzba.ZDRAVSTVENA_ZASTITA_DJECE;
			l.setSluzba(sluzbaZD);
		}else if(izbor == 6) {
			Sluzba sluzbaZR = Sluzba.ZDRAVSTVENA_ZASTITA_RADINKA;
			l.setSluzba(sluzbaZR);
		}else {
			System.out.println("Pogresan unos. Pokusajte ponovo: ");
			izmeniSluzbuLekara();
		}
		System.out.println("Nova sluzba lekara je: " + l.getSluzba());
	}
	
	public void izmeniSluzbuMedicinskeSestre() {
		System.out.println("Unesite korisnicko ime medicinske sestre: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		MedicinskaSestra m = nadjiMedSestru(korIme);
		System.out.println("Izaberite novu sluzbu medicinske sestre: " 
																+ "\n1) Opste medicine"
																+ "\n2) Pravni i ekonomski poslovi"
																+ "\n3) Tehnicki poslovi"
																+ "\n4) Stomatoloska sluzba"
																+ "\n5) Zdravstvena zastita djece"
																+ "\n6) Zdravstvena zastita radnika"
																+ "\nUnesite broj: ");
		int izbor = skener.nextInt();
		if (izbor == 1) {
			Sluzba sluzbaOM = Sluzba.SLUZBA_OPSTE_MEDICINE;
			m.setSluzba(sluzbaOM);
		}else if(izbor == 2) {
			Sluzba sluzbaPiE = Sluzba.SLUZBA_ZA_PRAVNE_I_EKONOMSKE_POSLOVE;
			m.setSluzba(sluzbaPiE);
		}else if(izbor == 3) {
			Sluzba sluzbaT = Sluzba.SLUZBA_ZA_TEHNICKE_POSLOVE;
			m.setSluzba(sluzbaT);
		}else if(izbor == 4) {
			Sluzba sluzbaST = Sluzba.STOMATOLOSKA_SLUZBA;
			m.setSluzba(sluzbaST);
		}else if(izbor == 5) {
			Sluzba sluzbaZD = Sluzba.ZDRAVSTVENA_ZASTITA_DJECE;
			m.setSluzba(sluzbaZD);
		}else if(izbor == 6) {
			Sluzba sluzbaZR = Sluzba.ZDRAVSTVENA_ZASTITA_RADINKA;
			m.setSluzba(sluzbaZR);
		}else {
			System.out.println("Pogresan unos. Pokusajte ponovo: ");
			izmeniSluzbuMedicinskeSestre();
		}
		System.out.println("Nova sluzba mes=dicinske sestre je: " + m.getSluzba());
	}
	
	//SPECIJALIZACIJA
	public void izmeniSpecijalizacijuLekara() {
		System.out.println("Unesite korisnicko ime lekara: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Lekar l = nadjiLekara(korIme);
		System.out.println("Unesi novu specijalizaciju lekara: ");
		String unos = skener.nextLine();
		l.setSpecijalizacija(unos);
		System.out.println("Nova specijalizacija lekara je: " + l.getSpecijalizacija());
	}
	
	//IZMENA LEKARA 
	public void izmeniLekaraKodPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi korisnicko ime novog lekara: ");
		String korImeLekara = skener.nextLine();
		Lekar lekar = nadjiLekara(korImeLekara);
		p.setLekar(lekar);
		System.out.println("Novi lekar ovog pacijenta je: " + p.getLekar().getId());
	}
	public void izmeniLekaraKodPregleda() {
		System.out.println("Unesi id pregleda: ");
		String scan = skener.nextLine();
		String id = skener.nextLine();
		Pregled p = nadjiPregled(id);
		System.out.println("Unesi korisnicko ime novog lekara: ");
		String korIme = skener.nextLine();
		Lekar lekar = nadjiLekara(korIme);
		p.setLekar(lekar);
		System.out.println("Novi lekar za ovu knjizicu je: " + p.getLekar().getId());
	}
	
	//IZMENA PACIJENTA
	public void izmeniPacijentaKodPregleda() {
		System.out.println("Unesi id pregleda: ");
		String scan = skener.nextLine();
		String id = skener.nextLine();
		Pregled p = nadjiPregled(id);
		System.out.println("Unesi korisnicko ime novog pacijenta: ");
		String korIme = skener.nextLine();
		Pacijent pacijent = nadjiPacijenta(korIme);
		p.setPacijent(pacijent);
		System.out.println("Novi pacijent je: " + p.getPacijent().getId());
	}
	
	//IZMENA KNJIZICE PACIJENTA
	public void izmeniKnjizicuPacijenta() {
		System.out.println("Unesite korisnicko ime pacijenta: ");
		String scan = skener.nextLine();
		String korIme = skener.nextLine();
		Pacijent p = nadjiPacijenta(korIme);
		System.out.println("Unesi id nove knjizice: ");
		String id = skener.nextLine();
		Knjizica knjizica = nadjiKnjizicu(id);
		p.setZdrKnjizica(knjizica);
		System.out.println("Nova knjizica za ovog pacijenta je: " + p.getZdrKnjizica().getId());
	}
	
	//IZMENA BROJA KNJIZICE
	public void izmeniBrojZdravstveneKnjzice() {
		System.out.println("Unesi id knjizice: ");
		String scan = skener.nextLine();
		String idKnj = skener.nextLine();
		Knjizica k = nadjiKnjizicu(idKnj);
		System.out.println("Unesi novi broj knjizice: ");
		int broj = skener.nextInt();
		k.setBroj(broj);
		System.out.println("Novi broj knjizice je: " + k.getBroj());
	}
	
	//DATUM 
	public void izmeniDatumKnjizice() {
		System.out.println("Unesi id knjizice: ");
		String scan = skener.nextLine();
		String idKnj = skener.nextLine();
		Knjizica k = nadjiKnjizicu(idKnj);
		System.out.println("Unesi novi datum: ");
		String datumS = skener.nextLine();
		k.setDatumIsteka(datumS);
		System.out.println("Novi datum je: " + k.getDatumIsteka());
	}
	public void izmeniTerminPregleda() {
		System.out.println("Unesi id pregleda: ");
		String scan = skener.nextLine();
		String id = skener.nextLine();
		Pregled p = nadjiPregled(id);
		System.out.println("Unesi novi termin: ");
		String datumS = skener.nextLine();
		p.setTermin(datumS);
		System.out.println("Novi termin za ovaj pregled je: " + p.getTermin());
	}
	
	//SOBA
	public void izmeniSobuPregleda() {
		System.out.println("Unesi id pregleda: ");
		String scan = skener.nextLine();
		String id = skener.nextLine();
		Pregled p = nadjiPregled(id);
		System.out.println("Unesi novu sobu za pregled: ");
		String soba = skener.nextLine();
		p.setSoba(soba);
		System.out.println("Nova soba za pregled je: " + p.getSoba());
	}
	
	//OPIS
	public void izmeniOpisPregleda() {
		System.out.println("Unesi id pregleda: ");
		String scan = skener.nextLine();
		String id = skener.nextLine();
		Pregled p = nadjiPregled(id);
		System.out.println("Unesi novi opis za ovaj pregled: ");
		String opis = skener.nextLine();
		p.setOpis(opis);
		System.out.println("Novi opis za ovaj pregled je: " + p.getOpis());
	}
	
	//STATUS PREGLEDA
	public void izmeniStatusPregleda() {
		System.out.println("Unesi id pregleda: ");
		String scan = skener.nextLine();
		String id = skener.nextLine();
		Pregled pr = nadjiPregled(id);
		System.out.println("Izaberite novi status ovog pregleda: " + "\n1)Zatrazen" 
																	+ "\n2)Zakazan"
																	+ "\n3)Otkazan"
																	+ "\n4)Zavrsen"
																	+"\nVas izbor je: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Status status1 = Status.ZATRAZEN;
			pr.setStatus(status1);
		}else if(izbor == 2) {
			Status status2 = Status.ZAKAZAN;
			pr.setStatus(status2);
		}else if(izbor == 3) {
			Status status3 = Status.OTKAZAN;
			pr.setStatus(status3);
		}else if(izbor == 4) {
			Status status4 = Status.ZAVRSEN;
			pr.setStatus(status4);
		}
		System.out.println("Status ovog pregleda je sada: " + pr.getStatus());
	}
	
	//KATEGORIJA KNJIZICE
	public void izmeniKategorijuKnjizice() {
		System.out.println("Unesi id knjizice: ");
		String scan = skener.nextLine();
		String idKnj = skener.nextLine();
		Knjizica k = nadjiKnjizicu(idKnj);
		System.out.println("Izaberi gategoriju knjizice:" +
												"\n1)Prva" +
												"\n2)Druga" +
												"\n3)Treca" +
												"\nVas izbor: ");
		int izbor = skener.nextInt();
		if(izbor == 1) {
			Kategorija kategorija = Kategorija.PRVA;
			k.setKategorija(kategorija);
		}else if(izbor == 2) {
			Kategorija kategorija = Kategorija.DRUGA;
			k.setKategorija(kategorija);
		}else if(izbor == 3) {
			Kategorija kategorija = Kategorija.TRECA;
			k.setKategorija(kategorija);
		}
		System.out.println("Kategorija knjizice je sada: " + k.getKategorija());
	}
	
	public Lekar nadjiLekara(String korIme) {
		for(Lekar lekar: lekari) {
			if(lekar.getKorIme().equals(korIme)) {
				return lekar;
			}
		}
		return null;
	}
	
	public Pacijent nadjiPacijenta(String korIme) {
		for(Pacijent pacijent: pacijenti) {
			if(pacijent.getKorIme().equals(korIme)) {
				return pacijent;
			}
		}
		return null;
	}
	
	public MedicinskaSestra nadjiMedSestru(String korIme) {
		for(MedicinskaSestra medSestra: medicinskeSestre) {
			if(medSestra.getKorIme().equals(korIme)) {
				return medSestra;
			}
		}
		return null;
	}

	public Knjizica nadjiKnjizicu(String id) {
		for(Knjizica knjizica : knjizice) {
			if(knjizica.getId().equals(id)) {
				return knjizica;
			}
		}
		return null;
	}
	
	public Pregled nadjiPregled(String id) {
		for(Pregled pregled : pregledi) {
			if(pregled.getId().equals(id)) {
				return pregled;
			}
		}
		return null;
	}
	
	public void ucitajLekare(String nazivFajla) {
		try {
			File file = new File("src/fajlovi/"+nazivFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String polString = split[4];
				Pol pol = Pol.valueOf(polString);
				String adresa = split[5];
				String brTel = split[6];
				String korIme = split[7];
				String lozinka = split[8];
				String ulogaString = split[9];
				Uloga uloga = Uloga.valueOf(ulogaString);
				String plataString = split[10];
				double plata = Double.valueOf(plataString);
				String sluzbaString = split[11];
				Sluzba sluzba = Sluzba.valueOf(sluzbaString);
				String specijalizacija = split[12];
				String activeString = split[13];
				boolean active = Boolean.valueOf(activeString);
				Lekar lekar = new Lekar(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga, plata, sluzba, specijalizacija,active);
				lekari.add(lekar);
			}
			reader.close();
		}catch(IOException e) {
			
			System.out.println("Greska prilikom snimanja podataka o lekarima.");
		}
	}

	public void ucitajPacijente(String nazivFajla) {
		try {
			File file = new File("src/fajlovi/"+nazivFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String polString = split[4];
				Pol pol = Pol.valueOf(polString);
				String adresa = split[5];
				String brTel = split[6];
				String korIme = split[7];
				String lozinka = split[8];
				String ulogaString = split[9];
				Uloga uloga = Uloga.valueOf(ulogaString);
				String lekarString = split[10];
				Lekar lekar = nadjiLekara(lekarString);
				String knjizicaString = split[11];
				Knjizica zdrKnjizicaa = nadjiKnjizicu(knjizicaString);
				String activeString = split[12];
				boolean active = Boolean.valueOf(activeString);
				Pacijent pacijent = new Pacijent(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga,lekar,zdrKnjizicaa, active);
				pacijenti.add(pacijent);
			//	System.out.println(pacijenti);
			}
			reader.close();
		}catch(IOException e) {	
			System.out.println("Greska prilikom snimanja podataka o pacijentima.");
		}
	}
	
	public void ucitajMedicinskeSestre(String nazivFajla) {
		try {
			File file = new File("src/fajlovi/"+nazivFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String polString = split[4];
				Pol pol = Pol.valueOf(polString);
				String adresa = split[5];
				String brTel = split[6];
				String korIme = split[7];
				String lozinka = split[8];
				String ulogaString = split[9];
				Uloga uloga = Uloga.valueOf(ulogaString);
				String plataString = split[10];
				double plata = Double.valueOf(plataString);
				String sluzbaString = split[11];
				Sluzba sluzba = Sluzba.valueOf(sluzbaString);
				String activeString = split[12];
				boolean active = Boolean.valueOf(activeString);
				MedicinskaSestra medicinskaSestra = new MedicinskaSestra(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga, plata, sluzba,active);
				medicinskeSestre.add(medicinskaSestra);
			}
			reader.close();
		}catch(IOException e) {
			
			System.out.println("Greska prilikom snimanja podataka o medicinskim sestrama.");
		}
	}
	
	public void ucitajPreglede(String nazivFajla) {
		try {
			File file = new File("src/fajlovi/"+nazivFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String pacijentString = split[1];
				Pacijent pacijent = nadjiPacijenta(pacijentString);
				String lekarString = split[2];
				Lekar lekar = nadjiLekara(lekarString);
				String termin = split[3];
				String soba = split[4];
				String opis = split[5];
				String statusString = split[6];
				Status status = Status.valueOf(statusString);
				String activeString = split[7];
				boolean active = Boolean.valueOf(activeString);
				Pregled pregled = new Pregled(id ,pacijent, lekar, termin, soba, opis, status,active);
				pregledi.add(pregled);
			}
			reader.close();
		}catch(IOException e) {
			
			System.out.println("Greska prilikom snimanja podataka o pregledima.");
		}
	}
	
	public void ucitajKnjizice(String nazivFajla) {
		try {
			File file = new File("src/fajlovi/"+nazivFajla);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String brojString = split[1];
				int broj = Integer.parseInt(brojString);
				String datumIsteka = split[2];
				String kategorijaString = split[3];
				Kategorija kategorija = Kategorija.valueOf(kategorijaString);
				String activeString = split[4];
				boolean active = Boolean.valueOf(activeString);
				
				Knjizica knjizica = new Knjizica(id, broj, datumIsteka, kategorija,active);
				knjizice.add(knjizica);
			}
			reader.close();
		}catch(IOException e) {
			
			System.out.println("Greska prilikom snimanja podataka o knjizicama.");
		}
	}

	public void snimiLekare(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Lekar lekar: lekari) {
				content += lekar.getId() + "|" + lekar.getIme() + "|" + lekar.getPrezime() + "|" + lekar.getJmbg() + "|" + 
						lekar.getPol() + "|" + lekar.getAdresa() + "|" + lekar.getBrTel() + "|" + lekar.getKorIme() + "|" + 
						lekar.getLozinka() + "|" + lekar.getUloga() + "|" + lekar.getPlata() + "|" + lekar.getSluzba() + "|" + 
						lekar.getSpecijalizacija() + "|" +lekar.getActive() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja lekara.");
		}
	}
	
	public void snimiPacijente(String nazivFajla) {
		try {
			File file = new File("src/fajlovi/" + nazivFajla);
			String content = "";
			for (Pacijent pacijent: pacijenti) {
				content += pacijent.getId() + "|" + pacijent.getIme() + "|" + pacijent.getPrezime() + "|" + pacijent.getJmbg() + "|" +
						pacijent.getPol() + "|" + pacijent.getAdresa() + "|" + pacijent.getBrTel() + "|" + pacijent.getKorIme() + "|" + 
						pacijent.getLozinka() + "|" + pacijent.getUloga() + "|" + pacijent.getLekar().getKorIme() + "|" +
						pacijent.getZdrKnjizica() + "|" + pacijent.getActive() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pacijenata.");
		}
	}
	
	public void snimiMedicinskeSestre(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (MedicinskaSestra medicinskaSestra : medicinskeSestre) {
				content += medicinskaSestra.getId() + "|" + medicinskaSestra.getIme() + "|" + medicinskaSestra.getPrezime() + "|" +
						medicinskaSestra.getJmbg() + "|" + medicinskaSestra.getPol() + "|" + medicinskaSestra.getAdresa() + "|" + 
						medicinskaSestra.getBrTel() + "|" + medicinskaSestra.getKorIme() + "|" + medicinskaSestra.getLozinka() + "|" + 
						medicinskaSestra.getUloga() + "|" + medicinskaSestra.getPlata() + "|" + medicinskaSestra.getSluzba() + 
						"|" + medicinskaSestra.getActive() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja medicinskih sestara.");
		}
	}
	
	public void snimiPreglede(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Pregled pregled:pregledi) {
				content += pregled.getId() + "|" + pregled.getPacijent().getKorIme() + "|" + pregled.getLekar().getKorIme() + "|" + pregled.getTermin() + "|" +
							pregled.getSoba() + "|" + pregled.getOpis() + "|" + pregled.getStatus() +"|"+ pregled.getActive() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pregleda.");
		}
	}
	
	public void snimiKnjizice(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Knjizica knjizica:knjizice) {
				content += knjizica.getId() + "|" + knjizica.getBroj() + "|" + knjizica.getDatumIsteka() + "|" + knjizica.getKategorija() + "|" +knjizica.getActive() +"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja knjizica.");
		}
	}
}
