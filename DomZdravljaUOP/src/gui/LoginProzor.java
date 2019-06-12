package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import domZdravlja.DomZdravlja;
import enumeracije.Uloga;
import gui.prozoriZaPrikaz.LekarProzor;
import gui.prozoriZaPrikaz.MedicinskaSestraProzor;
import gui.prozoriZaPrikaz.PacijentProzor;
import net.miginfocom.swing.MigLayout;
import osobe.Korisnik;
import osobe.Lekar;
public class LoginProzor extends JFrame {

	private JLabel lblPozdrav;
	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;
	private JLabel lblSifra;
	private JPasswordField txtSifra;
	private JButton btnPrijava;
	private JButton btnOtkazi;
	private DomZdravlja domZdravlja;
	
	public LoginProzor(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initListeners();
		pack();
	}
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		
		this.lblPozdrav = new JLabel("Dobrodosli. Molimo da se prijavite.");
		this.lblKorisnickoIme = new JLabel("Korisnicko ime");
		this.txtKorisnickoIme = new JTextField(20);
		this.lblSifra = new JLabel("Sifra");
		this.txtSifra = new JPasswordField(20);
		this.btnPrijava = new JButton("Prijava");
		this.btnOtkazi = new JButton("Otkazi");
		
		this.getRootPane().setDefaultButton(btnPrijava);
		
		add(lblPozdrav , "span 2");
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblSifra);
		add(txtSifra);
		add(new JLabel());
		add(btnPrijava, "split 2");
		add(btnOtkazi);
	}
	
	private void initListeners() {
		btnPrijava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(txtSifra.getPassword()).trim();
				
				if(korisnickoIme.equals("") || txtSifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke");
				}else {
				
					Korisnik prijavljen = domZdravlja.login(korisnickoIme, sifra);
					if(prijavljen == null) {
						JOptionPane.showMessageDialog(null, "Neispravni login podaci", "Greska", JOptionPane.WARNING_MESSAGE);
					}else if(prijavljen.getUloga() == Uloga.MEDICINSKA_SESTRA){
						LoginProzor.this.dispose();
						GlavniProzorZaMedicinskeSestre mp = new GlavniProzorZaMedicinskeSestre(domZdravlja, prijavljen);
						mp.setVisible(true);
					}else if(prijavljen.getUloga() == Uloga.LEKAR){
						LoginProzor.this.dispose();
						GlavniProzorZaLekare lp = new GlavniProzorZaLekare(domZdravlja, prijavljen);
						lp.setVisible(true);
					}else if(prijavljen.getUloga() == Uloga.PACIJENT){
						LoginProzor.this.dispose();
						GlavniProzorZaPacijenta pp = new GlavniProzorZaPacijenta(domZdravlja, prijavljen);
						pp.setVisible(true);
					}
				}
			}
		});
		btnOtkazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.setVisible(false);
				LoginProzor.this.dispose();
			}
		});
	}
}
