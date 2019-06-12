package osobe;

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
	public boolean getActive() {
		return this.active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String toString() {
		return "MEDICINSKA SESTRA " +"\nId: " + getId() + "\nIme:" +  getIme() + "\nPrezime: " + getPrezime() + 
				"\nJMBG: " + getJmbg() + "\nPol: " + getPol() + "\nAdresa: " + getAdresa() + "\nBroj telefona: " + getBrTel() +
				"\nKorisnicko ime: " + getKorIme() + "\nLozinka: " + getLozinka() + "\nUloga: " + getUloga() + 
				"\nPlata: " + getPlata() + "\nSluzba: " + getSluzba();
	}
}
