package pregled;

import enumeracije.Kategorija;

public class Knjizica {
	protected String id; 
	protected int broj;
	protected String datumIsteka; //Date
	protected Kategorija kategorija;
	
	public Knjizica(){
		this.broj =0;
		this.datumIsteka = "";//new Date();
		this.kategorija = Kategorija.PRVA;
	}
	public Knjizica(String id, int broj, String datumIsteka, Kategorija kategorija) {
		super();
		this.id = id;
		this.broj = broj;
		this.datumIsteka = datumIsteka;
		this.kategorija = kategorija;
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
	@Override
	public String toString() {
		return "KNJIZICA \nId: " + id + "\nBroj: " + broj + "Datum isteka: " + 
				datumIsteka + "\nKategorija: " + kategorija;
	}
}
