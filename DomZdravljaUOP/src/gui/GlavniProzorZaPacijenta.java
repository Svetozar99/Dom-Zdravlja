package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domZdravlja.DomZdravlja;
import gui.prozoriZaPrikaz.PreglediZaLekara;
import gui.prozoriZaPrikaz.PreglediZaPacijenta;
import osobe.Korisnik;

public class GlavniProzorZaPacijenta extends JFrame {

	private JMenuBar glavniMeni;
	private JMenu korisniciMenu;
	private JMenuItem lekariItem;
	private JMenuItem pacijentiItem;
	private JMenuItem medicinskeSestreItem;
	private JMenu preglediMenu;
	private JMenuItem preglediItem;
	private JMenu knjiziceMenu;
	private JMenuItem knjiziceItem;
	
	private DomZdravlja domZdravlja;
	private Korisnik prijavljeniKorisnik;
	
	public GlavniProzorZaPacijenta(DomZdravlja domZdravlja, Korisnik prijavljeniKorisnik) {
		this.domZdravlja = domZdravlja;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Dom zdravlja - " + prijavljeniKorisnik.getKorIme());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 500);
		setResizable(false);
		initMenu();
		initListeners();
	}
	private void initMenu() {
		
		this.glavniMeni = new JMenuBar();
		this.korisniciMenu = new JMenu("Korisnici");
		this.lekariItem = new JMenuItem("Lekari");
		this.pacijentiItem = new JMenuItem("Pacijenti");
		this.medicinskeSestreItem = new JMenuItem("Medicinske sestre");
		this.preglediMenu = new JMenu("Pregledi");
		this.preglediItem = new JMenuItem("Pregledi");
		this.knjiziceMenu = new JMenu("Knjizice");
		this.knjiziceItem = new JMenuItem("Knjizice");
		
		this.korisniciMenu.add(lekariItem);
		this.korisniciMenu.add(pacijentiItem);
		this.korisniciMenu.add(medicinskeSestreItem);
		
		this.preglediMenu.add(preglediItem);
		
		this.knjiziceMenu.add(knjiziceItem);
		
		this.glavniMeni.add(korisniciMenu);
		this.glavniMeni.add(preglediMenu);
		this.glavniMeni.add(knjiziceMenu);
		
		setJMenuBar(this.glavniMeni);
	}
	public void initListeners() {
		preglediItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreglediZaPacijenta pp = new PreglediZaPacijenta(domZdravlja, prijavljeniKorisnik);
				pp.setVisible(true);
				
			}
		});
		korisniciMenu.setEnabled(false);
		knjiziceMenu.setEnabled(false);
		
	}
}
