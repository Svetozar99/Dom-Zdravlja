package pregled;

import enumeracije.Status;
import osobe.Lekar;
import osobe.Pacijent;

public class Pregled {
	protected String id;
	protected Pacijent pacijent;
	protected Lekar lekar;
	protected String termin;
	protected String soba;
	protected String opis;
	protected Status status;
	protected boolean active;
	
	public Pregled() {
		this.id = "";
		this.pacijent = new Pacijent();
		this.lekar = new Lekar();
		this.termin = "";
		this.soba = "";
		this.opis = "";
		this.status = Status.ZATRAZEN;
		this.active = false;
	}
	public Pregled(String id,Pacijent pacijent, Lekar lekar, String termin, String soba, String opis, Status status,boolean active) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.termin = termin;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
		this.active = active;
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
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "PREGLED " + "\nId:" + getId() + "\nPacijent je: " + getPacijent().getId() + "\nLekar " + getLekar().getKorIme() + "\nSoba u kojoj se obavlja pregled " + getSoba()
			 + "\nTermin: " + getTermin() + "\nOpis: " + getOpis() + "\nStatus: " + getStatus();
	}
}
