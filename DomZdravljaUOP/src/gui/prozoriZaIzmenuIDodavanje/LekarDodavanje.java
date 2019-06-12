package gui.prozoriZaIzmenuIDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domZdravlja.DomZdravlja;
import enumeracije.Pol;
import enumeracije.Sluzba;
import enumeracije.Uloga;
import net.miginfocom.swing.MigLayout;
import osobe.Lekar;

public class LekarDodavanje extends JFrame {

	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblBrTel = new JLabel("Broj telefona");
	private JTextField txtBrTel = new JTextField(20);
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField txtLozinka = new JPasswordField(20);
	private JLabel lblUloga = new JLabel("Uloga");
	private JComboBox<Uloga> cbUloga = new JComboBox<Uloga>(Uloga.values());
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblSluzba = new JLabel("Sluzba");
	private JComboBox<Sluzba> cbSluzba = new JComboBox<Sluzba>(Sluzba.values());
	private JLabel lblSpecijalizacija = new JLabel("Specijalizacija");
	private JTextField txtSpecijalizacija = new JTextField(20);
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private DomZdravlja domZdravlja;
	private Lekar lekar;
	
	public LekarDodavanje(DomZdravlja domZdravlja, Lekar lekar) {
		this.domZdravlja = domZdravlja;
		this.lekar = lekar;
		if(this.lekar == null) {
			setTitle("Dodavanje novog lekara");
		}else {
			setTitle("Izmena lekara: " + this.lekar.getKorIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
		setResizable(false);
		pack();
	}
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		
		if(this.lekar != null) {
			popuniPolja();
		}
		
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblPol);
		add(cbPol);
		add(lblAdresa);
		add(txtAdresa);
		add(lblBrTel);
		add(txtBrTel);
		add(lblKorIme);
		add(txtKorIme);
		add(lblLozinka);
		add(txtLozinka);
		add(lblUloga);
		add(cbUloga);
		add(lblPlata);
		add(txtPlata);
		add(lblSluzba);
		add(cbSluzba);
		add(lblSpecijalizacija);
		add(txtSpecijalizacija);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popuniPolja() {
		txtIme.setText(this.lekar.getIme());
		txtPrezime.setText(this.lekar.getPrezime());
		txtJmbg.setText(this.lekar.getJmbg());
		cbPol.setSelectedItem(this.lekar.getPol());
		txtAdresa.setText(this.lekar.getAdresa());
		txtBrTel.setText(this.lekar.getBrTel());
		txtKorIme.setText(this.lekar.getKorIme());
		txtLozinka.setText(this.lekar.getLozinka());
		cbUloga.setSelectedItem(this.lekar.getUloga());
		txtPlata.setText(String.valueOf(this.lekar.getPlata()));
		cbSluzba.setSelectedItem(this.lekar.getSluzba());
		txtSpecijalizacija.setText(this.lekar.getSpecijalizacija());
	}
	
	private void initListeners() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					Pol pol = (Pol) cbPol.getSelectedItem();
					String adresa = txtAdresa.getText().trim();
					String brTel = txtBrTel.getText().trim();
					String korIme = txtKorIme.getText().trim();
					String sifra = new String(txtLozinka.getPassword()).trim();
					Uloga uloga = (Uloga) cbUloga.getSelectedItem();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					Sluzba sluzba = (Sluzba) cbSluzba.getSelectedItem();
					String specijalizacija = txtSpecijalizacija.getText().trim();
					if(lekar == null) {
						lekar = new Lekar(ime, prezime, jmbg, pol, adresa, brTel, korIme, sifra, uloga, plata, sluzba, specijalizacija);
						domZdravlja.getLekari().add(lekar);
					}else {
						lekar.setIme(ime);
						lekar.setPrezime(prezime);
						lekar.setJmbg(jmbg);
						lekar.setPol(pol);
						lekar.setBrTel(brTel);
						lekar.setKorIme(korIme);
						lekar.setLozinka(sifra);
						lekar.setUloga(uloga);
						lekar.setPlata(plata);
						lekar.setSluzba(sluzba);
						lekar.setSpecijalizacija(specijalizacija);
					}
					domZdravlja.snimiLekare("lekari.txt");
					LekarDodavanje.this.dispose();
					LekarDodavanje.this.setVisible(false);
				}
			}
		});
	}
	
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime\n";
			ok = false;
		}
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime\n";
			ok = false;
		}
		if(txtJmbg.getText().trim().equals("")) {
			poruka += "- Unesite jmbg\n";
			ok = false;
		}
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
		}
		if(txtBrTel.getText().trim().equals("")) {
			poruka += "- Unesite broj telefona\n";
			ok = false;
		}
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}
		String sifra = new String(txtLozinka.getPassword()).trim();
		if(sifra.trim().equals("")) {
			poruka += "- Unesite lozinku\n";
			ok = false;
		}
		try {
			Double.parseDouble(txtPlata.getText().trim());
		}catch(NumberFormatException e) {
			poruka += "- Plata mora biti broj\n";
			ok = false;
		}
		if(txtSpecijalizacija.getText().trim().equals("")) {
			poruka += "- Unesite specijalizaciju\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
