package osobe;

import enumeracije.Pol;

public class Pacijent extends Korisnik {
	private Lekar lekar;
	private String zdrKnjizica;

	public Pacijent() {
		super();
		this.lekar = new Lekar();
		this.zdrKnjizica = "";
	}

	public Pacijent(String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel, String korIme,
			String lozinka,Lekar lekar, String zdrKnjizica) {
		super(ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka);
		this.lekar=lekar;
		this.zdrKnjizica=zdrKnjizica;
	}
	public Lekar getLekar() {
		return lekar;
	}
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	public String getZdrKnjizica() {
		return zdrKnjizica;
	}
	public void setZdrKnjizica(String zdrKnjizica) {
		this.zdrKnjizica = zdrKnjizica;
	}
	@Override
	public String toString() {
		return "PACIJENT " + getIme() + " " + getPrezime() + "\nNjegov lekar je: " + lekar.getIme() + " " + lekar.getPrezime() +
				" a zdravstvena knjizica: " + zdrKnjizica;
	}
}
