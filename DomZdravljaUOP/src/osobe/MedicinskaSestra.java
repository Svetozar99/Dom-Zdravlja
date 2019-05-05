package osobe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import enumeracije.Pol;
import enumeracije.Sluzba;
import enumeracije.Uloga;

public class MedicinskaSestra extends Zaposleni {

	public MedicinskaSestra() {
		super();
	}

	public MedicinskaSestra(String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel,
			String korIme, String lozinka, Uloga uloga, double plata, Sluzba sluzba) {
		super(ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, Uloga.MEDICINSKA_SESTRA, plata, sluzba);
	}

	public MedicinskaSestra(Zaposleni original) {
		super(original);
	}
	public String toString() {
		return "MEDICINSKA SESTRA " + getIme() + " " + getPrezime() + "\nIma platu: " + getPlata();
	}
	public void upisiUFajlMedSestru() {
		try {
			File file = new File("src/fajlovi/medicinskeSestre.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(getIme() + "|" + getPrezime() + "|" + getBrTel() + "|" + getAdresa());
			writer.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajla");
		}
	}
	public static void citanjeIzFajla() {
		try {
			File file = new File("src/fajlovi/medicinskeSestre.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null){
				String[] dijelovi = line.split("\\|");
				String imeSestre = dijelovi[0];
				String prezimeSestre = dijelovi[1];
				String BrTelSestre = dijelovi[2];
				String adresaSestre = dijelovi[3];
				System.out.println("Medicinska sestra se zove: " + imeSestre + ", prezime je " + prezimeSestre + ", broj telefona je " + BrTelSestre + ", adresa: " + adresaSestre);
			}
			reader.close();
		}catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja medicinske sestre.");
		}
	}
}
