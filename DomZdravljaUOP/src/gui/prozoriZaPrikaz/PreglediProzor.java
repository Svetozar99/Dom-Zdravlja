package gui.prozoriZaPrikaz;

import java.awt.BorderLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import gui.prozoriZaIzmenuIDodavanje.KnjizicaDodavanje;
import gui.prozoriZaIzmenuIDodavanje.PreglediDodavanje;
import pregled.Knjizica;
import pregled.Pregled;

public class PreglediProzor extends JFrame {

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
	
	public PreglediProzor(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Pregledi");
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
				"ID", "Lekar", "Pacijent", "Termin", "Soba", "Opis", "Status"
		};
		Object[][] sadrzaj = new Object[domZdravlja.getPregledi().size()][zaglavlje.length];
		
		DateFormat konverter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		
		for(int i=0; i<domZdravlja.getPregledi().size(); i++) {
			Pregled pregled = domZdravlja.getPregledi().get(i);
			String termin = konverter.format(pregled.getTermin());
			sadrzaj[i][0] = pregled.getId();
			sadrzaj[i][1] = pregled.getLekar().getKorIme();
			sadrzaj[i][2] = pregled.getPacijent().getKorIme();
			sadrzaj[i][3] = termin;
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
	private void initListeners() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreglediDodavanje kd = new PreglediDodavanje(domZdravlja, null);
				kd.setVisible(true);
				
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
					String id = model.getValueAt(red, 0).toString();
					Pregled pregled = domZdravlja.nadjiPregled(id);
					if(pregled != null) {
						PreglediDodavanje kdp = new PreglediDodavanje(domZdravlja, pregled);
						kdp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabrani pregled!", "Greska!", JOptionPane.ERROR_MESSAGE);
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
					String id = model.getValueAt(red, 0).toString();
					Pregled pregled = domZdravlja.nadjiPregled(id);
					if(pregled != null) {
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete pregled?" , pregled.getId() + " - Potvrda brisanja" , JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							domZdravlja.getPregledi().remove(pregled);
							model.removeRow(red);
							domZdravlja.snimiPreglede("pregledi.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabrani pregled!","Greska!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreglediProzor.this.dispose();
				PreglediProzor kp = new PreglediProzor(domZdravlja);
				kp.setVisible(true);
				
			}
		});
	}
}
