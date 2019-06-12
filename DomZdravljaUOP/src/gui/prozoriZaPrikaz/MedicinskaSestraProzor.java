package gui.prozoriZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domZdravlja.DomZdravlja;
import gui.prozoriZaIzmenuIDodavanje.LekarDodavanje;
import gui.prozoriZaIzmenuIDodavanje.MedicinskaSestraDodavanje;
import osobe.Lekar;
import osobe.MedicinskaSestra;

public class MedicinskaSestraProzor extends JFrame {

	private JToolBar toolbar = new JToolBar();
	private ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
	private JButton btnAdd = new JButton(addIcon);
	private ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
	private JButton btnEdit = new JButton(editIcon);
	private ImageIcon removeIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
	private JButton btnRemove = new JButton(removeIcon);
	private ImageIcon refreshIcon = new ImageIcon("Osvezi");
	private JButton btnRefresh = new JButton(refreshIcon);
	
	private JTable tabela;
	private DomZdravlja domZdravlja;
	
	public MedicinskaSestraProzor(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Medicinske sestre");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
	}
	
	private void initGUI() {
		toolbar.add(btnAdd);
		toolbar.add(btnEdit);
		toolbar.add(btnRemove);
		toolbar.add(btnRefresh);
		add(toolbar, BorderLayout.NORTH);
		
		String[] zaglavlje = new String[] {
				"Ime", "Prezime", "Jmbg", "Pol", "Adresa", "Broj telefona", "Korisnicko ime", "Lozinka", "Plata", "Sluzba"
		};
		Object[][] sadrzaj = new Object[domZdravlja.getMedicinskeSestre().size()][zaglavlje.length];
		
		for(int i=0; i<domZdravlja.getMedicinskeSestre().size(); i++) {
			MedicinskaSestra medicinskaSestra = domZdravlja.getMedicinskeSestre().get(i);
			sadrzaj[i][0] = medicinskaSestra.getIme();
			sadrzaj[i][1] = medicinskaSestra.getPrezime();
			sadrzaj[i][2] = medicinskaSestra.getJmbg();
			sadrzaj[i][3] = medicinskaSestra.getPol();
			sadrzaj[i][4] = medicinskaSestra.getAdresa();
			sadrzaj[i][5] = medicinskaSestra.getBrTel();
			sadrzaj[i][6] = medicinskaSestra.getKorIme();
			sadrzaj[i][7] = medicinskaSestra.getLozinka();
			sadrzaj[i][8] = medicinskaSestra.getPlata();
			sadrzaj[i][9] = medicinskaSestra.getSluzba();
		}
		DefaultTableModel model = new DefaultTableModel(sadrzaj, zaglavlje);
		tabela = new JTable(model);
		tabela = new JTable(model);
		tabela.setRowSelectionAllowed(true);
		tabela.setColumnSelectionAllowed(false);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setDefaultEditor(Object.class, null);
	//	tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scroll = new JScrollPane(tabela);
		add(scroll, BorderLayout.CENTER);
	}
	
	private void initListeners() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MedicinskaSestraDodavanje md = new MedicinskaSestraDodavanje(domZdravlja, null);
				md.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)tabela.getModel();
					String korIme = model.getValueAt(red, 6).toString();
					MedicinskaSestra medicinskaSestra = domZdravlja.nadjiMedSestru(korIme);
					if(medicinskaSestra != null) {
						MedicinskaSestraDodavanje mdp = new MedicinskaSestraDodavanje(domZdravlja, medicinskaSestra);
						mdp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog medicinsku sestru!" ,"Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);	
				}else {
					DefaultTableModel model = (DefaultTableModel)tabela.getModel();
					String korIme = model.getValueAt(red, 6).toString();
					MedicinskaSestra medicinskaSestra = domZdravlja.nadjiMedSestru(korIme);
					if(medicinskaSestra != null) {
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete medicinsku sestru?" , medicinskaSestra.getKorIme() + " - Potvrda brisanja" , JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							domZdravlja.getMedicinskeSestre().remove(medicinskaSestra);
							model.removeRow(red);
							domZdravlja.snimiMedicinskeSestre("medicinskeSestre.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu medicinsku sestru!","Greska!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MedicinskaSestraProzor.this.dispose();
				MedicinskaSestraProzor mp = new MedicinskaSestraProzor(domZdravlja);
				mp.setVisible(true);
			}
		});
	}
}
