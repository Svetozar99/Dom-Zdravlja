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

	public Lekar(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel, String korIme,
			String lozinka, Uloga uloga, double plata, Sluzba sluzba, String specijalizacija,boolean active) {
		super(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, Uloga.LEKAR, plata, sluzba,active);
		this.specijalizacija = specijalizacija;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "LEKAR " +"\nId: " + getId() + "\nIme:" +  getIme() + "\nPrezime: " + getPrezime() + 
				"\nJMBG: " + getJmbg() + "\nPol: " + getPol() + "\nAdresa: " + getAdresa() + "\nBroj telefona: " + getBrTel() +
				"\nKorisnicko ime: " + getKorIme() + "\nLozinka: " + getLozinka() + "\nUloga: " + getUloga() + 
				"\nPlata: " + getPlata() + "\nSluzba: " + getSluzba() + "\nSpecijalizacija: " + getSpecijalizacija();
	}
	
}
