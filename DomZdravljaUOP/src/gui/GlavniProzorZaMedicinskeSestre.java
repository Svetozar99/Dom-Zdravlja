package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import domZdravlja.DomZdravlja;
import gui.prozoriZaPrikaz.KnjiziceProzor;
import gui.prozoriZaPrikaz.LekarProzor;
import gui.prozoriZaPrikaz.MedicinskaSestraProzor;
import gui.prozoriZaPrikaz.PacijentProzor;
import gui.prozoriZaPrikaz.PreglediProzor;
import osobe.Korisnik;
import osobe.Lekar;

public class GlavniProzorZaMedicinskeSestre extends JFrame {

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
	
	public GlavniProzorZaMedicinskeSestre(DomZdravlja domZdravlja, Korisnik prijavljeniKorisnik) {
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
	private void initListeners() {
		lekariItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LekarProzor lp = new LekarProzor(domZdravlja);
				lp.setVisible(true);
			}
		});
		pacijentiItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PacijentProzor pp = new PacijentProzor(domZdravlja);
				pp.setVisible(true);
			}
		});
		medicinskeSestreItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MedicinskaSestraProzor mp = new MedicinskaSestraProzor(domZdravlja);
				mp.setVisible(true);
			}
		});
		preglediItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreglediProzor pp = new PreglediProzor(domZdravlja);
				pp.setVisible(true);
			}
		});
		knjiziceItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjiziceProzor kp = new KnjiziceProzor(domZdravlja);
				kp.setVisible(true);
			}
		});
	}
}
