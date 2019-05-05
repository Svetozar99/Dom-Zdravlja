package pregled;

import java.util.Date;

public class Knjizica {
	protected String broj;
	protected Date datumIsteka;
	protected String kategorija;
	
	public Knjizica(){
		this.broj = "";
		this.datumIsteka = new Date();
		this.kategorija = "";
	}
	public Knjizica(String broj, Date datumIsteka, String kategorija) {
		super();
		this.broj = broj;
		this.datumIsteka = datumIsteka;
		this.kategorija = kategorija;
	}
	public Knjizica(String broj, String kategorija) {
		super();
		this.broj = broj;
		this.kategorija = kategorija;
	}
	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Date getDatumIsteka() {
		return datumIsteka;
	}

	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	@Override
	public String toString() {
		return "KNJIZICA \nBroj: " + broj + "\nDatum isteka: " + 
				datumIsteka + "\nKategorija: " + kategorija;
	}
}
