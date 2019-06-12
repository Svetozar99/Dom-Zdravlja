package pregled; 

import java.util.Date;

import enumeracije.Kategorija;

public class Knjizica {
	public String id; 
	public int broj;
	public Date datumIsteka; //Date
	public Kategorija kategorija;
	
	public Knjizica(){
		this.id = "";
		this.broj =0;
		this.datumIsteka = new Date();
		this.kategorija = Kategorija.PRVA;
	}
	public Knjizica(String id, int broj, Date datumIsteka, Kategorija kategorija) {
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

	public Date getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
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
		return "KNJIZICA \nId: " + getId() + "\nBroj: " + getBroj() + "\nDatum isteka: " + 
				getDatumIsteka() + "\nKategorija: " + getKategorija();
	}
}
