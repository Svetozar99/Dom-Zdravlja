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
import osobe.Lekar;
import pregled.Knjizica;

public class KnjiziceProzor extends JFrame {

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
	
	public KnjiziceProzor(DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Knjizice");
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
				"ID", "Broj knjizice", "Datum isteka", "Kategorija"
		};
		Object[][] sadrzaj = new Object[domZdravlja.getKnjizice().size()][zaglavlje.length];
		
		DateFormat konverter = new SimpleDateFormat("dd.MM.yyyy");
		
		for(int i=0; i<domZdravlja.getKnjizice().size(); i++) {
			Knjizica knjizica = domZdravlja.getKnjizice().get(i);
			String datumIsteka = konverter.format(knjizica.getDatumIsteka());	
			sadrzaj[i][0] = knjizica.getId();
			sadrzaj[i][1] = knjizica.getBroj();
			sadrzaj[i][2] = datumIsteka;
			sadrzaj[i][3] = knjizica.getKategorija();
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
				KnjizicaDodavanje kd = new KnjizicaDodavanje(domZdravlja, null);
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
					Knjizica knjizica = domZdravlja.nadjiKnjizicu(id);
					if(knjizica != null) {
						KnjizicaDodavanje kdp = new KnjizicaDodavanje(domZdravlja, knjizica);
						kdp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu knjizicu!", "Greska!", JOptionPane.ERROR_MESSAGE);
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
					Knjizica knjizica = domZdravlja.nadjiKnjizicu(id);
					if(knjizica != null) {
						int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete knjizicu?" , knjizica.getId() + " - Potvrda brisanja" , JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							domZdravlja.getKnjizice().remove(knjizica);
							model.removeRow(red);
							domZdravlja.snimiKnjizice("knjizica.txt");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabranu knjizicu!","Greska!", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjiziceProzor.this.dispose();
				KnjiziceProzor kp = new KnjiziceProzor(domZdravlja);
				kp.setVisible(true);
				
			}
		});
	}
}
