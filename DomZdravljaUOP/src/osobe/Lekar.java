package osobe;

import enumeracije.Pol;
import enumeracije.Sluzba;
import enumeracije.Uloga;

public class Lekar extends Zaposleni {
	protected String specijalizacija;
	
	public Lekar() {
		super();
		this.specijalizacija = "";
	}

	public Lekar(String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel, String korIme,
			String lozinka, Uloga uloga, double plata, Sluzba sluzba, String specijalizacija) {
		super(ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, Uloga.LEKAR, plata, sluzba);
		this.specijalizacija = specijalizacija;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "LEKAR \nIma specijalizaciju: " + specijalizacija + "Njegova uloga: " + getUloga();
	}
	
}
