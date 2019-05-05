package main;

import enumeracije.*;
import listaZaposlenih.ListaZaposlenih;
import osobe.*;
import pregled.*;

public class DomZdravljaMain {
	


	public static void main(String[] args) {
		
		ListaZaposlenih lekari = new ListaZaposlenih();
		ListaZaposlenih pacijenti = new ListaZaposlenih();
		ListaZaposlenih medicinskeSestre = new ListaZaposlenih();
		ListaZaposlenih pregledi = new ListaZaposlenih();
		ListaZaposlenih knjizice = new ListaZaposlenih();
		
		Lekar lekar = new Lekar("Miso", "Misovic", "258741399", Pol.MUSKI, "NovisAD", "321548", "MisoMiso", "mismismsi", Uloga.LEKAR, 100000, Sluzba.SLUZBA_OPSTE_MEDICINE, "dr. MIso");
		Lekar lekar1 = new Lekar("Sveto", "Brboric", "2201999153960", Pol.MUSKI, "NoviSad21", "0644094513", "Svetozar99", "24092015", Uloga.LEKAR, 70000, Sluzba.SLUZBA_ZA_TEHNICKE_POSLOVE, "doktor");
		
		Knjizica knjizica = new Knjizica("1230", "1");
		Knjizica knjizica1 = new Knjizica("1547", "2");
		
		MedicinskaSestra medSestra = new MedicinskaSestra("Dijana", "Cuk", "85219467", Pol.ZENSKI, "Kraljevo87", "357489", "Dica14", "98446", Uloga.MEDICINSKA_SESTRA, 40000, Sluzba.SLUZBA_OPSTE_MEDICINE);
		MedicinskaSestra medSestra1 = new MedicinskaSestra("Milena", "Miskovic", "1236987458", Pol.ZENSKI, "Sipovo14", "654987", "Milenica44", "zmajzmaj", Uloga.MEDICINSKA_SESTRA, 40000, Sluzba.STOMATOLOSKA_SLUZBA);

		Pacijent pacijent = new Pacijent("Aco", "Acic", "123456", Pol.MUSKI, "Beograd21", "654789", "Aco97", "sifra", lekar, "knjizica");
		Pacijent pacijent1 = new Pacijent("Mladen", "Cetkovic", "2609975631854", Pol.MUSKI, "Sabac66", "4587962", "Cetko87", "sifrasifra", lekar1, "knjizica");
		
		Pregled pregled = new Pregled(pacijent, lekar, "24.09.2020", "14", "opis", Status.ZATRAZEN);
		Pregled pregled1 = new Pregled(pacijent1, lekar1, "25.12.2020", "4", "neki opis", Status.ZAKAZAN);
		
		lekari.dodajUListuLekara(lekar);
		lekari.dodajUListuLekara(lekar1);
		
		lekari.upisiUFajlLekar();
		lekari.iscitajIzFajlaLekar();
		
		System.out.println("---------------------------------------------------------");
		
		knjizice.dodajUListuKnjizice(knjizica);
		knjizice.dodajUListuKnjizice(knjizica1);
		
		knjizice.upisiUFajlKnjizica();
		knjizice.iscitajIzFajlaKnjizica();
		
		System.out.println("---------------------------------------------------------");
		
		medicinskeSestre.dodajUListuMedSestru(medSestra);
		medicinskeSestre.dodajUListuMedSestru(medSestra1);
		
		medicinskeSestre.upisiUFajlMedSestra();
		medicinskeSestre.iscitajIzFajlaMedSestra();
		
		System.out.println("---------------------------------------------------------");
		
		pacijenti.dodajUListuPacijenta(pacijent);
		pacijenti.dodajUListuPacijenta(pacijent1);
		
		pacijenti.upisiUFajlPacijent();
		pacijenti.iscitajIzFajlaPacijent();
		
		System.out.println("---------------------------------------------------------");
		
		pregledi.dodajUListuPreglede(pregled);
		pregledi.dodajUListuPreglede(pregled1);
		
		pregledi.upisiUFajlPregled();
		pregledi.iscitajIzFajlaPregled();
		}
}
