import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class autorekisteri extends JFrame {

	static JPanel contentPane;
	static JTable table;
	syöttöikkuna syöttö = new syöttöikkuna();
	About tiedot = new About();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					autorekisteri frame = new autorekisteri();					
					frame.setVisible(true);
					JDBC.lataaAutot();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	/**
	 * Create the frame.
	 */
	public autorekisteri() {
		setTitle("Autorekisteri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmAutonSyttohjelma = new JMenuItem("Auton sy\u00F6tt\u00F6ohjelma");
		mntmAutonSyttohjelma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				syöttö.setVisible(true);
			}
		});
		mnTiedosto.add(mntmAutonSyttohjelma);
		
		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);
		
		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiedot.setVisible(true);
			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLisAuto = new JButton("Lis\u00E4\u00E4 uusi auto tietokantaan");
		btnLisAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Uusi Jdialog avautuu (syöttöohjelma)
				syöttö.setVisible(true);
				}
		});
		
		btnLisAuto.setBounds(10, 241, 412, 23);
		contentPane.add(btnLisAuto);
		//Päivitä taulukko
		JButton btnPivitTaulukko = new JButton("P\u00E4ivit\u00E4 taulukko");
		btnPivitTaulukko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//päivittää tietokantaa
				JDBC.lataaAutot();
			}
		});
		btnPivitTaulukko.setBounds(10, 206, 412, 23);
		contentPane.add(btnPivitTaulukko);
		//Poista valittu rivi
		JButton btnPoistaValittu = new JButton("Poista valittu rivi tietokannasta");
		btnPoistaValittu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBC.poistaAutot();
				   DefaultTableModel model = (DefaultTableModel) table.getModel();
				   int[] rows = table.getSelectedRows();
				   											   
				   for(int i=0;i<rows.length;i++){						   
				     model.removeRow(rows[i]-i);						     
				   }
			}
		});
		btnPoistaValittu.setBounds(10, 276, 412, 23);
		contentPane.add(btnPoistaValittu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		DefaultTableModel model = new DefaultTableModel(new String[]{"Auto id", "Rek Nro", "Merkki", "Malli"}, 0);
		table.setModel(model);
		scrollPane.setViewportView(table);
			
	}
	
}
	
