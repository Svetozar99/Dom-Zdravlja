package pregled;

import enumeracije.Kategorija;

public class Knjizica {
	protected String id; 
	protected int broj;
	protected String datumIsteka; //Date
	protected Kategorija kategorija;
	protected boolean active;
	
	public Knjizica(){
		this.id = "";
		this.broj =0;
		this.datumIsteka = "";//new Date();
		this.kategorija = Kategorija.PRVA;
		this.active = false;
	}
	public Knjizica(String id, int broj, String datumIsteka, Kategorija kategorija, boolean active) {
		super();
		this.id = id;
		this.broj = broj;
		this.datumIsteka = datumIsteka;
		this.kategorija = kategorija;
		this.active = active;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(String datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "KNJIZICA \nId: " + getId() + "\nBroj: " + getBroj() + "\nDatum isteka: " + 
				getDatumIsteka() + "\nKategorija: " + getKategorija();
	}
}
