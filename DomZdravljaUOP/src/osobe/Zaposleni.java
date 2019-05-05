package osobe;

import enumeracije.Pol;
import enumeracije.Sluzba;
import enumeracije.Uloga;

public abstract class Zaposleni extends Korisnik {
	private double plata;
	private Sluzba sluzba;
	
	public Zaposleni() {
		super();
		this.plata = 0;
		this.sluzba = Sluzba.SLUZBA_OPSTE_MEDICINE;
	}
	public Zaposleni(String ime, String prezime, String jmbg, Pol pol, String adresa, String brTel, String korIme,
			String lozinka, Uloga uloga,double plata, Sluzba sluzba) {
		super(ime, prezime, jmbg, pol, adresa, brTel, korIme, lozinka, uloga);
		this.plata = plata;
		this.sluzba = sluzba;
	}
	public Zaposleni(Zaposleni original) {
		super(original);
		this.plata = original.plata;
		this.sluzba = original.sluzba;
	}
	public double getPlata() {
		return plata;
	}
	public void setPlata(double plata) {
		this.plata = plata;
	}
	public Sluzba getSluzba() {
		return sluzba;
	}
	public void setSluzba(Sluzba sluzba) {
		this.sluzba = sluzba;
	}
	@Override
	public String toString() {
		return "ZAPOSLENI \nIma platu: " + getPlata() + "\nNjegova sluzba je: " + getSluzba();
	}
}
