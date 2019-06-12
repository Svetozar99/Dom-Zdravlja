package gui.prozoriZaPrikaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domZdravlja.DomZdravlja;
import osobe.Korisnik;
import pregled.Pregled;

public class PreglediZaLekara extends JFrame {

	private JTable tabela;
	private DomZdravlja domZdravlja;
	private Korisnik korisnik;
	ArrayList<Pregled> pre = new ArrayList<Pregled>();
	
	public PreglediZaLekara(DomZdravlja domZdravlja,Korisnik korisnik) {
		this.domZdravlja = domZdravlja;
		this.korisnik = korisnik;
		setTitle("Pregledi");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
	}
		
	private void initGUI() {
		for(Pregled pregl:domZdravlja.getPregledi()) {
			if(pregl.getLekar().getKorIme().equalsIgnoreCase(korisnik.getKorIme())) {
				pre.add(pregl);
			}
		}
			
		String[] zaglavlje = new String[] {
				"Id", "Pacijent", "Lekar", "Termin", "Soba", "Opis", "Status"
		};
		
		Object[][] sadrzaj = new Object[this.pre.size()][zaglavlje.length];
		for(int i=0; i<this.pre.size(); i++) {
			
			Pregled pregled = this.pre.get(i);
			
			sadrzaj[i][0] = pregled.getId();
			sadrzaj[i][1] = pregled.getPacijent().getKorIme();
			sadrzaj[i][2] = pregled.getLekar().getKorIme();
			sadrzaj[i][3] = pregled.getTermin();
			sadrzaj[i][4] = pregled.getSoba();
			sadrzaj[i][5] = pregled.getOpis();
			sadrzaj[i][6] = pregled.getStatus();
			}
		DefaultTableModel model = new DefaultTableModel(sadrzaj, zaglavlje);
		tabela = new JTable(model);
		tabela = new JTable(model);
		tabela.setRowSelectionAllowed(true);
		tabela.setColumnSelectionAllowed(false);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setDefaultEditor(Object.class, null);
		
		JScrollPane scroll = new JScrollPane(tabela);
		add(scroll, BorderLayout.CENTER);
	}
}
