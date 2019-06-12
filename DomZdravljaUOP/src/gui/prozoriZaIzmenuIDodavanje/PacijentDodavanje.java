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
import enumeracije.Uloga;
import net.miginfocom.swing.MigLayout;
import osobe.Lekar;
import osobe.Pacijent;
import pregled.Knjizica;

public class PacijentDodavanje extends JFrame {
	
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
	private JLabel lblLekar = new JLabel("Lekar");
	private JComboBox<String> cbLekar = new JComboBox<String>();
	private JLabel lblKnjizica = new JLabel("Knjizica");
	private JComboBox<String> cbKnjizica = new JComboBox<String>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private DomZdravlja domZdravlja;
	private Pacijent pacijent;
	
	public PacijentDodavanje(DomZdravlja domZdravlja, Pacijent pacijent) {
		this.domZdravlja = domZdravlja;
		this.pacijent = pacijent;
		if(this.pacijent == null) {
			setTitle("Dodavanje novog pacijenta");
		}else {
			setTitle("Izmena pacijenta: " + this.pacijent.getKorIme());
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
		
		if(this.pacijent != null) {
			popuniPolja();
		}
		for(Lekar lekar:this.domZdravlja.getLekari()) {
			cbLekar.addItem(lekar.getKorIme());
		}
		for(Knjizica knjizica:this.domZdravlja.getKnjizice()) {
			cbKnjizica.addItem(knjizica.getId());
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
		add(lblLekar);
		add(cbLekar);
		add(lblKnjizica);
		add(cbKnjizica);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popuniPolja() {
		txtIme.setText(this.pacijent.getIme());
		txtPrezime.setText(this.pacijent.getPrezime());
		txtJmbg.setText(this.pacijent.getJmbg());
		cbPol.setSelectedItem(this.pacijent.getPol());
		txtAdresa.setText(this.pacijent.getAdresa());
		txtBrTel.setText(this.pacijent.getBrTel());
		txtKorIme.setText(this.pacijent.getKorIme());
		txtLozinka.setText(this.pacijent.getLozinka());
		cbUloga.setSelectedItem(this.pacijent.getUloga());
		cbLekar.setSelectedItem(this.pacijent.getLekar());
		cbKnjizica.setSelectedItem(this.pacijent.getZdrKnjizica());
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
					String lekarKorIme = cbLekar.getSelectedItem().toString();
					Lekar lekar = domZdravlja.nadjiLekara(lekarKorIme);
					String knjizicaS = cbKnjizica.getSelectedItem().toString();
					Knjizica knjizica = domZdravlja.nadjiKnjizicu(knjizicaS);
					if(pacijent == null) {
						pacijent = new Pacijent(ime, prezime, jmbg, pol, adresa, brTel, lekarKorIme, sifra, uloga, lekar, knjizica);
						domZdravlja.getPacijenti().add(pacijent);
					}else {
						pacijent.setIme(ime);
						pacijent.setPrezime(prezime);
						pacijent.setJmbg(jmbg);
						pacijent.setPol(pol);
						pacijent.setBrTel(brTel);
						pacijent.setKorIme(korIme);
						pacijent.setLozinka(sifra);
						pacijent.setUloga(uloga);
						pacijent.setLekar(lekar);
						pacijent.setZdrKnjizica(knjizica);
					}
					domZdravlja.snimiPacijente("pacijenti.txt");
					PacijentDodavanje.this.dispose();
					PacijentDodavanje.this.setVisible(false);
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
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
