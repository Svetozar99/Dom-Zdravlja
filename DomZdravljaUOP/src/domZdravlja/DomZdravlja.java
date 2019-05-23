package domZdravlja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public void dodajLekara(Lekar l) {
		this.lekari.add(l);
	}
	public void dodajPacijenta(Pacijent p) {
		this.pacijenti.add(p);
	}
	public void dodajMedSestru(MedicinskaSestra m) {
		this.medicinskeSestre.add(m);
	}
	public void dodajPreglede(Pregled p) {
		this.pregledi.add(p);
	}
	public void dodajKnjizice(Knjizica k) {
		this.knjizice.add(k);
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
				Lekar lekar = new Lekar(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga, plata, sluzba, specijalizacija);
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
				Knjizica zdrKnjizica = nadjiKnjizicu(knjizicaString);
				Pacijent pacijent =new Pacijent(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga, lekar, zdrKnjizica);
				pacijenti.add(pacijent);
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
				MedicinskaSestra medicinskaSestra = new MedicinskaSestra(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga, plata, sluzba);
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
				String pacijentString = split[0];
				Pacijent pacijent = nadjiPacijenta(pacijentString);
				String lekarString = split[1];
				Lekar lekar = nadjiLekara(lekarString);
				String termin = split[2];
				String soba = split[3];
				String opis = split[4];
				String statusString = split[5];
				Status status = Status.valueOf(statusString);
				Pregled pregled = new Pregled(pacijent, lekar, termin, soba, opis, status);
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
				
				Knjizica knjizica = new Knjizica(id, broj, datumIsteka, kategorija);
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
						lekar.getSpecijalizacija() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja lekara.");
		}
	}
	
	public void snimiPacijente(String imeFajla) {
		try {
			File file = new File("src/fajlovi/" + imeFajla);
			String content = "";
			for (Pacijent pacijent: pacijenti) {
				content += pacijent.getId() + "|" + pacijent.getIme() + "|" + pacijent.getPrezime() + "|" + pacijent.getJmbg() + "|" +
			pacijent.getPol() + "|" + pacijent.getAdresa() + "|" + pacijent.getBrTel() + "|" + pacijent.getKorIme() + "|" + 
						pacijent.getLozinka() + "|" + pacijent.getUloga() + "|" + pacijent.getLekar().getKorIme() + "|" + pacijent.getZdrKnjizica().getId() + "\n";
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
						medicinskaSestra.getUloga() + "|" + medicinskaSestra.getPlata() + "|" + medicinskaSestra.getSluzba() + "\n";
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
				content += pregled.getPacijent().getKorIme() + "|" + pregled.getLekar().getKorIme() + "|" + pregled.getTermin() + "|" +
							pregled.getSoba() + "|" + pregled.getOpis() + "|" + pregled.getStatus() + "\n";
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
				content += knjizica.getId() + "|" + knjizica.getBroj() + "|" + knjizica.getDatumIsteka() + "|" + knjizica.getKategorija() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja knjizica.");
		}
	}
}

