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
import osobe.MedicinskaSestra;

public class MedicinskaSestraDodavanje extends JFrame {

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
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private DomZdravlja domZdravlja;
	private MedicinskaSestra medicinskaSestra;
	
	public MedicinskaSestraDodavanje(DomZdravlja domZdravlja, MedicinskaSestra medicinskaSestra) {
		this.domZdravlja = domZdravlja;
		this.medicinskaSestra = medicinskaSestra;
		if(this.medicinskaSestra == null) {
			setTitle("Dodavanje nove medicinske sestre");
		}else {
			setTitle("Izmena medicinske sestre: " + this.medicinskaSestra.getKorIme());
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
		
		if(this.medicinskaSestra != null) {
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
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popuniPolja() {
		txtIme.setText(this.medicinskaSestra.getIme());
		txtPrezime.setText(this.medicinskaSestra.getPrezime());
		txtJmbg.setText(this.medicinskaSestra.getJmbg());
		cbPol.setSelectedItem(this.medicinskaSestra.getPol());
		txtAdresa.setText(this.medicinskaSestra.getAdresa());
		txtBrTel.setText(this.medicinskaSestra.getBrTel());
		txtKorIme.setText(this.medicinskaSestra.getKorIme());
		txtLozinka.setText(this.medicinskaSestra.getLozinka());
		cbUloga.setSelectedItem(this.medicinskaSestra.getUloga());
		txtPlata.setText(String.valueOf(this.medicinskaSestra.getPlata()));
		cbSluzba.setSelectedItem(this.medicinskaSestra.getSluzba());
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
					if(medicinskaSestra == null) {
						medicinskaSestra = new MedicinskaSestra(ime, prezime, jmbg, pol, adresa, brTel, korIme, sifra, uloga, plata, sluzba);
						domZdravlja.getMedicinskeSestre().add(medicinskaSestra);
					}else {
						medicinskaSestra.setIme(ime);
						medicinskaSestra.setPrezime(prezime);
						medicinskaSestra.setJmbg(jmbg);
						medicinskaSestra.setPol(pol);
						medicinskaSestra.setBrTel(brTel);
						medicinskaSestra.setKorIme(korIme);
						medicinskaSestra.setLozinka(sifra);
						medicinskaSestra.setUloga(uloga);
						medicinskaSestra.setPlata(plata);
						medicinskaSestra.setSluzba(sluzba);
					}
					domZdravlja.snimiMedicinskeSestre("medicinskeSestre.txt");
					MedicinskaSestraDodavanje.this.dispose();
					MedicinskaSestraDodavanje.this.setVisible(false);
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
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
