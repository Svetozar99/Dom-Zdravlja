package pregled;

import java.util.Date;

import enumeracije.Status;
import osobe.Lekar;
import osobe.Pacijent;

public class Pregled {
	public String id;
	public Pacijent pacijent;
	public Lekar lekar;
	public Date termin;
	public String soba;
	public String opis;
	public Status status;
	
	public Pregled() {
		this.id = "";
		this.pacijent = new Pacijent();
		this.lekar = new Lekar();
		this.termin = new Date();
		this.soba = "";
		this.opis = "";
		this.status = Status.ZATRAZEN;
	}
	public Pregled(String id,Pacijent pacijent, Lekar lekar, Date termin, String soba, String opis, Status status) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.termin = termin;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getTermin() {
		return termin;
	}
	public void setTermin(Date termin) {
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
		return "PREGLED " + "\nId:" + getId() + "\nPacijent je: " + getPacijent().getId() + "\nLekar " + getLekar().getKorIme() + "\nSoba u kojoj se obavlja pregled " + getSoba()
			 + "\nTermin: " + getTermin() + "\nOpis: " + getOpis() + "\nStatus: " + getStatus();
	}
}
