package osobe;

import enumeracije.Pol;
import enumeracije.Uloga;

public abstract class Korisnik extends Osoba {
	protected String korIme;
	protected String lozinka;
	protected Uloga uloga;
	
	public Korisnik() {
		super();
		this.korIme = "";
		this.lozinka = "";
		this.uloga = Uloga.PACIJENT;
	}
	public Korisnik(String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel,String korIme, String lozinka, Uloga uloga) {
		super(ime, prezime, jmbg, pol, adresa, brTel);
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}
	public Korisnik(Korisnik original) {
		super(original);
		this.korIme = original.korIme;
		this.lozinka = original.lozinka;
		this.uloga = original.uloga;
	}
	public Korisnik(String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel, String korIme,
			String lozinka) {
		super(ime, prezime, jmbg, pol, adresa, brTel);
		this.korIme=korIme;
		this.lozinka=lozinka;
	}
	public String getKorIme() {
		return korIme;
	}
	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	@Override
	public String toString() {
		return "KORISNIK \nKorisnicno ime: " + korIme + "\nLozinka: " + lozinka + "\nUloga: " + uloga;
	}
}
