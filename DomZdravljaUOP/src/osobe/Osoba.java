package osobe;

import enumeracije.Pol;

public abstract class Osoba {
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected Pol pol;
	protected String adresa;
	protected String brTel;
	
	public Osoba() {
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = Pol.ZENSKI;
		this.adresa = "";
		this.brTel = "";
	}
	public Osoba(String ime, String prezime, String jmbg,Pol pol, String adresa, String brTel) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brTel = brTel;
	}
	public Osoba(Osoba original) {
		this.ime = original.ime;
		this.prezime = original.prezime;
		this.jmbg = original.jmbg;
		this.pol = original.pol;
		this.adresa = original.adresa;
		this.brTel = original.brTel;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Pol getPol() {
		return pol;
	}
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrTel() {
		return brTel;
	}
	public void setBrTel(String brTel) {
		this.brTel = brTel;
	}
	@Override
	public String toString() {
		return "OSOBA /nIme: " + ime + "\nPrezime: " + prezime + "\nJMBG: " + jmbg + 
				"\nPol: " + pol + "\nAdresa: " + adresa + "\nBroj telefona: " + brTel;
	}
}
