package pregled;

import enumeracije.Status;
import osobe.Lekar;
import osobe.Pacijent;

public class Pregled {
	private Pacijent pacijent;
	private Lekar lekar;
	private String termin;
	private String soba;
	private String opis;
	private Status status;
	
	public Pregled() {
		this.pacijent = new Pacijent();
		this.lekar = new Lekar();
		this.termin = "";
		this.soba = "";
		this.opis = "";
		this.status = Status.ZATRAZEN;
	}
	public Pregled(Pacijent pacijent, Lekar lekar, String termin, String soba, String opis, Status status) {
		super();
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.termin = termin;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pacijent getPacijent() {
		return pacijent;
	}
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
	public Lekar getLekar() {
		return lekar;
	}
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	public String getTermin() {
		return termin;
	}
	public void setTermin(String termin) {
		this.termin = termin;
	}
	public String getSoba() {
		return soba;
	}
	public void setSoba(String soba) {
		this.soba = soba;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PREGLED " + "\nPacijent je: " + getPacijent().getKorIme() + "\nLekar " + getLekar().getKorIme() + "\nSoba u kojoj se obavlja pregled " + getSoba()
			 + "\nTermin: " + getTermin() + "\nOpis: " + getOpis() + "\nStatus: " + getStatus();
	}

}
