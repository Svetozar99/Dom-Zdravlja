package osobe;

import enumeracije.Pol;
import enumeracije.Uloga;
import pregled.Knjizica;

public class Pacijent extends Korisnik {
	private Lekar lekar;
	private Knjizica zdrKnjizica;

	public Pacijent() {
		super();
		this.lekar = new Lekar();
		this.zdrKnjizica = new Knjizica();
	}

	public Pacijent(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel,
			String korIme, String lozinka, Uloga uloga,Lekar lekar, Knjizica zdrKnjizica, boolean active) {
		super(id, ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga,active);
		this.lekar = lekar;
		this.zdrKnjizica = zdrKnjizica;
	}
	public Lekar getLekar() {
		return lekar;
	}
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	public Knjizica getZdrKnjizica() {
		return zdrKnjizica;
	}
	public void setZdrKnjizica(Knjizica zdrKnjizica) {
		this.zdrKnjizica = zdrKnjizica;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "PACIJENT " +"\nId: " + getId() + "\nIme:" +  getIme() + "\nPrezime: " + getPrezime() + 
				"\nJMBG: " + getJmbg() + "\nPol: " + getPol() + "\nAdresa: " + getAdresa() + "\nBroj telefona: " + getBrTel() +
				"\nKorisnicko ime: " + getKorIme() + "\nLozinka: " + getLozinka() + "\nUloga: " + getUloga() + 
				"\nLekar: " + getLekar().getKorIme() + "\nZdravstvena knjizica: " + getZdrKnjizica();
	}
}
