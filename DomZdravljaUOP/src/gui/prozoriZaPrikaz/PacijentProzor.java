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
import gui.prozoriZaIzmenuIDodavanje.PacijentDodavanje;
import osobe.Pacijent;

public class PacijentProzor extends JFrame {

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
	
	public PacijentProzor(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Pacijenti");
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
				"Ime", "Prezime", "Jmbg", "Pol", "Adresa", "Broj telefona", "Korisnicko ime", "Lozinka", "Lekar", "Knjizica"
		};
		Object[][] sadrzaj = new Object[domZdravlja.getPacijenti().size()][zaglavlje.length];
		
		for(int i=0; i<domZdravlja.getPacijenti().size(); i++) {
			Pacijent pacijent = domZdravlja.getPacijenti().get(i);
			sadrzaj[i][0] = pacijent.getIme();
			sadrzaj[i][1] = pacijent.getPrezime();
			sadrzaj[i][2] = pacijent.getJmbg();
			sadrzaj[i][3] = pacijent.getPol();
			sadrzaj[i][4] = pacijent.getAdresa();
			sadrzaj[i][5] = pacijent.getBrTel();
			sadrzaj[i][6] = pacijent.getKorIme();
			sadrzaj[i][7] = pacijent.getLozinka();
			sadrzaj[i][8] = pacijent.getLekar().getKorIme();
			sadrzaj[i][9] = pacijent.getZdrKnjizica().getId();
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
				PacijentDodavanje pd = new PacijentDodavanje(domZdravlja, null);
				pd.setVisible(true);
				
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
					Pacijent pacijent = domZdravlja.nadjiPacijenta(korIme);
					if(pacijent != null) {
						PacijentDodavanje pdp = new PacijentDodavanje(domZdravlja, pacijent);
						pdp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog pacijenta!" ,"Greska", JOptionPane.ERROR_MESSAGE);
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
					Pacijent pacijent = domZdravlja.nadjiPacijenta(korIme);
					if(pacijent != null) {
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete pacijenta?" , pacijent.getKorIme() + " - Potvrda brisanja" , JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							domZdravlja.getPacijenti().remove(pacijent);
							model.removeRow(red);
							domZdravlja.snimiPacijente("pacijenti.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranog pacijenta!","Greka!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PacijentProzor.this.dispose();
				PacijentProzor pp = new PacijentProzor(domZdravlja);
				pp.setVisible(true);
			}
		});
	}
}
