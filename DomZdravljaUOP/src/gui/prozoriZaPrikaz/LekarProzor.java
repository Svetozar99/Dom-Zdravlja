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
import enumeracije.Uloga;
import gui.prozoriZaIzmenuIDodavanje.LekarDodavanje;
import osobe.Lekar;

public class LekarProzor extends JFrame {
	
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
	
	public LekarProzor(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Lekari");
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
				"Ime", "Prezime", "Jmbg", "Pol", "Adresa", "Broj telefona", "Korisnicko ime", "Lozinka", "Plata", "Sluzba", "Specijalizacija"
		};
		Object[][] sadrzaj = new Object[domZdravlja.getLekari().size()][zaglavlje.length];
		
		for(int i=0; i<domZdravlja.getLekari().size(); i++) {
			Lekar lekar = domZdravlja.getLekari().get(i);
			sadrzaj[i][0] = lekar.getIme();
			sadrzaj[i][1] = lekar.getPrezime();
			sadrzaj[i][2] = lekar.getJmbg();
			sadrzaj[i][3] = lekar.getPol();
			sadrzaj[i][4] = lekar.getAdresa();
			sadrzaj[i][5] = lekar.getBrTel();
			sadrzaj[i][6] = lekar.getKorIme();
			sadrzaj[i][7] = lekar.getLozinka();
			sadrzaj[i][8] = lekar.getPlata();
			sadrzaj[i][9] = lekar.getSluzba();
			sadrzaj[i][10] = lekar.getSpecijalizacija();
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
				LekarDodavanje ld = new LekarDodavanje(domZdravlja, null);
				ld.setVisible(true);
				
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
					Lekar lekar = domZdravlja.nadjiLekara(korIme);
					if(lekar != null) {
						LekarDodavanje ldp = new LekarDodavanje(domZdravlja, lekar);
						ldp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog lekara!" ,"Greska", JOptionPane.ERROR_MESSAGE);
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
					Lekar lekar = domZdravlja.nadjiLekara(korIme);
					if(lekar != null) {
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete lekara?" , lekar.getKorIme() + " - Potvrda brisanja" , JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							domZdravlja.getLekari().remove(lekar);
							model.removeRow(red);
							domZdravlja.snimiLekare("lekari.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog lekara!","Greka!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LekarProzor.this.dispose();
				LekarProzor lp = new LekarProzor(domZdravlja);
				lp.setVisible(true);
			}
		});
	}
	
}
