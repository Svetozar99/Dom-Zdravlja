package gui.prozoriZaIzmenuIDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import domZdravlja.DomZdravlja;
import enumeracije.Status;
import net.miginfocom.swing.MigLayout;
import osobe.Korisnik;
import osobe.Lekar;
import osobe.Pacijent;
import pregled.Pregled;

public class PreglediDodavanjePacijent extends JFrame {

	private JLabel lblId = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lblPacijent = new JLabel("Pacijent");
	private JComboBox<String> cbPacijent = new JComboBox<String>();
	private JLabel lblLekar = new JLabel("Lekar");
	private JComboBox<String> cbLekar = new JComboBox<String>();
	private JLabel lblTermin = new JLabel("Termin");
	private JCalendar cbTermin = new JCalendar();
	private JLabel lblSoba = new JLabel("Soba");
	private JTextField txtSoba = new JTextField(20);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblStatus = new JLabel("Status");
	private JComboBox<Status> cbStatus = new JComboBox<Status>(Status.values());
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private DomZdravlja domZdravlja;
	private Pregled pregled;
	private Korisnik korisnik;
	
	
	public PreglediDodavanjePacijent(DomZdravlja domZdravlja,Pregled pregled, Korisnik korisnik) {
		this.domZdravlja = domZdravlja;
		this.korisnik = korisnik;
		this.pregled = pregled;
		if(this.pregled == null) {
			setTitle("Dodavanje novog pregleda");
		}else {
			setTitle("Izmena pregleda: " + this.pregled.getId());
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
		
		if(this.pregled != null) {
			popuniPolja();
		}
		cbPacijent.addItem(korisnik.getKorIme());
		for(Lekar lekar:this.domZdravlja.getLekari()) {
			cbLekar.addItem(lekar.getKorIme());
		}
		
		add(lblId);
		add(txtID);
		add(lblPacijent);
		add(cbPacijent);
		add(lblLekar);
		add(cbLekar);
		add(lblTermin);
		add(cbTermin);
		add(lblSoba);
		add(txtSoba);
		add(lblOpis);
		add(txtOpis);
		add(lblStatus);
		add(cbStatus);
		add(new JLabel());
		add(btnOK , "split 2");
		add(btnCancel);
	}
	private void popuniPolja() {
		txtID.setText(this.pregled.getId());
		txtID.setEnabled(false);
		cbPacijent.setSelectedItem(this.korisnik.getKorIme());
		cbPacijent.setEnabled(false);
		cbLekar.setSelectedItem(this.pregled.getLekar());
		cbLekar.setEnabled(false);
		cbTermin.setDate(this.pregled.getTermin());
		cbTermin.setEnabled(false);
		txtSoba.setText(this.pregled.getSoba());
		txtSoba.setEnabled(false);
		txtOpis.setText(this.pregled.getOpis());
		cbStatus.setSelectedItem(this.pregled.getStatus());
		cbStatus.setEnabled(false);
	}
	private void initListeners() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {
					String id = txtID.getText().trim();
					//String pacijentKorIme = cbPacijent.getSelectedItem().toString();
					Pacijent pacijent = domZdravlja.nadjiPacijenta(korisnik.getKorIme());
					String lekarKorIme = cbLekar.getSelectedItem().toString();
					Lekar lekar = domZdravlja.nadjiLekara(lekarKorIme);
					Date termin = cbTermin.getDate();
					String soba = txtSoba.getText().trim();
					String opis = txtOpis.getText().trim();
					Status status = (Status) cbStatus.getSelectedItem();
					if(pregled == null) {
						pregled = new Pregled(id, pacijent, lekar, termin, soba, opis, status);
					domZdravlja.getPregledi().add(pregled);
					}else {
						pregled.setId(id);
						pregled.setPacijent(pacijent);
						pregled.setLekar(lekar);
						pregled.setTermin(termin);
						pregled.setSoba(soba);
						pregled.setOpis(opis);
						pregled.setStatus(status);
					}
					domZdravlja.snimiPreglede("pregledi.txt");
					PreglediDodavanjePacijent.this.dispose();
					PreglediDodavanjePacijent.this.setVisible(false);
				}
			}
		});
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popunite sledece greske u unosu:\n";
		
		if(txtSoba.getText().trim().equals("")) {
			poruka += "- Unesite sobu";
			ok = false;
		}
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Unesite opis";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
