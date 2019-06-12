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
import enumeracije.Kategorija;
import net.miginfocom.swing.MigLayout;
import pregled.Knjizica;

public class KnjizicaDodavanje extends JFrame {
	private JLabel lblId = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lblBroj = new JLabel("Broj knjziice");
	private JTextField txtBroj = new JTextField(20);
	private JLabel lblDatum = new JLabel("Datum isteka");
	private JCalendar cbDatum = new JCalendar();
	private JLabel lblKategorija = new JLabel("Kategorija knjizice");
	private JComboBox<Kategorija> cbKategorija = new JComboBox<Kategorija>(Kategorija.values());

	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private DomZdravlja domZdravlja;
	private Knjizica knjizica;
	
	public KnjizicaDodavanje(DomZdravlja domZdravlja, Knjizica knjizica) {
		this.domZdravlja = domZdravlja;
		this.knjizica = knjizica;
		if(this.knjizica == null) {
			setTitle("Dodavanje nove knjizice");
		}else {
			setTitle("Izmena knjizice: " + this.knjizica.getId());
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
		
		if(this.knjizica != null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtID);
		add(lblBroj);
		add(txtBroj);
		add(lblDatum);
		add(cbDatum);
		add(lblKategorija);
		add(cbKategorija);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	private void popuniPolja() {
		txtID.setText(this.knjizica.getId());
		txtID.setEnabled(false);
		txtBroj.setText(String.valueOf(this.knjizica.getBroj()));
		cbDatum.setDate(this.knjizica.getDatumIsteka());
		cbKategorija.setSelectedItem(this.knjizica.getKategorija());
	}
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo vas da popravite sledece greske u unosu:\n";
		try {
			Integer.parseInt(txtBroj.getText().trim());
		}catch(NumberFormatException e) {
			poruka += "- Broj knjizice mora biti ceo broj\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	private void initListeners() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String id = txtID.getText().trim();
					int broj = Integer.parseInt(txtBroj.getText().trim());
					Date datum = cbDatum.getDate();
					Kategorija kategorija = (Kategorija) cbKategorija.getSelectedItem();
					if(knjizica == null) {
						knjizica = new Knjizica(id, broj, datum, kategorija);
						domZdravlja.getKnjizice().add(knjizica);
					}else {
						knjizica.setId(id);
						knjizica.setBroj(broj);
						knjizica.setDatumIsteka(datum);
						knjizica.setKategorija(kategorija);
					}
					domZdravlja.snimiKnjizice("knjizica.txt");
					KnjizicaDodavanje.this.dispose();
					KnjizicaDodavanje.this.setVisible(false);
				}
				
			}
		});
	}
}
