package listaZaposlenih;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import osobe.Lekar;
import osobe.MedicinskaSestra;
import osobe.Pacijent;
import pregled.Knjizica;
import pregled.Pregled;

public class ListaZaposlenih {
	
	private List<Lekar> listaLekara;
	private List<Pacijent> listaPacijenata;
	private List<MedicinskaSestra> medicinskeSestre;
	private List<Pregled> listaPregleda;
	private List<Knjizica> listaKnjizica;
	
	public ListaZaposlenih() {
		this.listaLekara = new ArrayList<Lekar>();
		this.listaPacijenata = new ArrayList<Pacijent>();
		this.medicinskeSestre = new ArrayList<MedicinskaSestra>();
		this.listaPregleda = new ArrayList<Pregled>();
		this.listaKnjizica = new ArrayList<Knjizica>();
	}
	
	public void dodajUListuLekara(Lekar l) {
		this.listaLekara.add(l);
	}
	public void dodajUListuPacijenta(Pacijent p) {
		this.listaPacijenata.add(p);
	}
	public void dodajUListuMedSestru(MedicinskaSestra m) {
		this.medicinskeSestre.add(m);
	}
	public void dodajUListuPreglede(Pregled p) {
		this.listaPregleda.add(p);
	}
	public void dodajUListuKnjizice(Knjizica k) {
		this.listaKnjizica.add(k);
	}
	
	public void upisiUFajlLekar() {
		try {
			FileWriter fw = new FileWriter("src/fajlovi/lekari.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<Lekar> iter = this.listaLekara.iterator();
			
			while(iter.hasNext()) {
				Lekar l = iter.next();
				
				bw.write(l.getIme()+"|"+l.getPrezime()+"|"+l.getBrTel()+"|"+l.getAdresa());
				bw.newLine();
			}
			bw.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public void iscitajIzFajlaLekar() {
		try {
			File file = new File("src/fajlovi/lekari.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String imeLekara = dijelovi[0];
				String prezimeLekara = dijelovi[1];
				String BrTelLekara = dijelovi[2];
				String adresaLekara = dijelovi[3];
				System.out.println("Lekar se zove: " + imeLekara + ", prezva se " + prezimeLekara + ", broj telefona " + BrTelLekara + ", adresa: " + adresaLekara);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja lekara.");
		}
	}
	public void upisiUFajlPacijent() {
		try {
			FileWriter fw = new FileWriter("src/fajlovi/pacijenti.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<Pacijent> iter = this.listaPacijenata.iterator();
			
			while(iter.hasNext()) {
				Pacijent p = iter.next();
				
				bw.write(p.getIme()+"|"+p.getPrezime()+"|"+p.getKorIme());
				bw.newLine();
			}
			bw.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public void iscitajIzFajlaPacijent() {
		try {
			File file = new File("src/fajlovi/pacijenti.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String imePacijenta = dijelovi[0];
				String prezimePacijenta = dijelovi[1];
				String korImePacijenta = dijelovi[2];
				System.out.println("Pacijent se zove: " + imePacijenta + ", prezva se " + prezimePacijenta + ", korisnickoIme: " + korImePacijenta);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja pacijenta.");
		}
	}
	public void upisiUFajlMedSestra() {
		try {
			FileWriter fw = new FileWriter("src/fajlovi/medicinskeSestre.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<MedicinskaSestra> iter = this.medicinskeSestre.iterator();
			
			while(iter.hasNext()) {
				MedicinskaSestra m = iter.next();
				
				bw.write(m.getIme()+"|"+m.getPrezime()+"|"+m.getBrTel()+"|"+m.getAdresa());
				bw.newLine();
			}
			bw.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public void iscitajIzFajlaMedSestra() {
		try {
			File file = new File("src/fajlovi/medicinskeSestre.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String imeMedSestre = dijelovi[0];
				String prezimeMedSestre = dijelovi[1];
				String brTelMedSestre = dijelovi[2];
				String adresaMedSestre = dijelovi[3];
				System.out.println("Medicinska sestra se zove: " + imeMedSestre + ", prezva se " + prezimeMedSestre + ", broj telefona " + brTelMedSestre + ", adresa " + adresaMedSestre);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja medicinske sestre.");
		}
	}
	public void upisiUFajlPregled() {
		try {
			FileWriter fw = new FileWriter("src/fajlovi/pregledi.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<Pregled> iter = this.listaPregleda.iterator();
			
			while(iter.hasNext()) {
				Pregled pr = iter.next();
				
				bw.write(pr.getLekar().getIme() +" " + pr.getLekar().getPrezime()+"|"+pr.getPacijent().getIme()+ " " + pr.getPacijent().getPrezime()+"|"+pr.getSoba());
				bw.newLine();
			}
			bw.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public void iscitajIzFajlaPregled() {
		try {
			File file = new File("src/fajlovi/pregledi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String lekarp = dijelovi[0];
				String pacijentp = dijelovi[1];
				String soba = dijelovi[2];
				System.out.println("U ovom pregledu lekar je " + lekarp + ", pacijent je " + pacijentp + ", obavlja se u sobi br. " + soba);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja medicinske sobe.");
		}
	}
	public void upisiUFajlKnjizica() {
		try {
			FileWriter fw = new FileWriter("src/fajlovi/knjizica.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator<Knjizica> iter = this.listaKnjizica.iterator();
			
			while(iter.hasNext()) {
				Knjizica kn = iter.next();
				
				bw.write(kn.getBroj() +"|"+ kn.getKategorija());
				bw.newLine();
			}
			bw.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public void iscitajIzFajlaKnjizica() {
		try {
			File file = new File("src/fajlovi/knjizica.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String broj = dijelovi[0];
				String katgorija = dijelovi[1];
				System.out.println("Ova knjizica ima broj " + broj + " i kategoriju " + katgorija);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja knjizice.");
		}
	}
}
