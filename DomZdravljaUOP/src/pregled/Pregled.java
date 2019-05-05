package pregled;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import enumeracije.Status;
import osobe.Lekar;
import osobe.Pacijent;

public class Pregled {
	private Pacijent pacijent;
	private Lekar lekar;
	private String termin;
	private String soba;
	private String opis;
	private Status status;
	
	public Pregled() {
		this.pacijent = new Pacijent();
		this.lekar = new Lekar();
		this.termin = "";
		this.soba = "";
		this.opis = "";
		this.status = Status.ZATRAZEN;
	}
	public Pregled(Pacijent pacijent, Lekar lekar, String termin, String soba, String opis, Status status) {
		super();
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.termin = termin;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pacijent getPacijent() {
		return pacijent;
	}
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
	public Lekar getLekar() {
		return lekar;
	}
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	public String getTermin() {
		return termin;
	}
	public void setTermin(String termin) {
		this.termin = termin;
	}
	public String getSoba() {
		return soba;
	}
	public void setSoba(String soba) {
		this.soba = soba;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PREGLED \nPacijent je: " + getPacijent() + ", lekar " + getLekar() + ", soba u kojoj se obavlja pregled " + getSoba();
	}
	public void upisiUFajlPregled() {
		try {
			File file = new File("src/fajlovi/pregledi.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(getLekar().getKorIme() + "|" + getPacijent().getKorIme() + "|" + getSoba());
			writer.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public static void citanjeIzFajla() {
		try {
			File file = new File("src/fajlovi/pregledi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String lekarIme = dijelovi[0];
				String pacijentIme = dijelovi[1];
				String soba = dijelovi[2];
				System.out.println("Lekar se zove: " + lekarIme + ", pacijent je " + pacijentIme + ", soba u kojoj ce biti pregled " + soba);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja pregelda.");
		}
	}
}
