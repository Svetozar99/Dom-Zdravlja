package osobe;

import enumeracije.Pol;

public abstract class Osoba {
	protected String id;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected Pol pol;
	protected String adresa;
	protected String brTel;
	protected boolean active;
	
	public Osoba() {
		this.id = "";
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = Pol.ZENSKI;
		this.adresa = "";
		this.brTel = "";
		this.active = false;
	}
	public Osoba(String id, String ime, String prezime, String jmbg,Pol pol, String adresa, String brTel, boolean active) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brTel = brTel;
		this.active = active;
	}
	public Osoba(Osoba original) {
		this.id = original.id;
		this.ime = original.ime;
		this.prezime = original.prezime;
		this.jmbg = original.jmbg;
		this.pol = original.pol;
		this.adresa = original.adresa;
		this.brTel = original.brTel;
		this.active = original.active;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "OSOBA /nId:" + getId() + "Ime: " + getIme() + "\nPrezime: " + getPrezime() + "\nJMBG: " + getJmbg() + 
				"\nPol: " + getPol() + "\nAdresa: " + getAdresa() + "\nBroj telefona: " + getBrTel();
	}
}
