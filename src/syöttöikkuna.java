import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class syöttöikkuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			syöttöikkuna dialog = new syöttöikkuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public syöttöikkuna() {
		setTitle("Auton sy\u00F6tt\u00F6ohjelma");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Sy\u00F6t\u00E4 auton tiedot:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.BOLD, 24));
			label.setBounds(10, 11, 414, 43);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Rekisterinumero:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 65, 155, 32);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(219, 65, 120, 32);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(219, 108, 120, 32);
			contentPanel.add(textField_1);
		}
		{
			JLabel label = new JLabel("Auton merkki:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 108, 155, 32);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Auton malli:");
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			label.setBounds(54, 151, 155, 32);
			contentPanel.add(label);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(219, 151, 120, 32);
			contentPanel.add(textField_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sy\u00F6t\u00E4 auto tietokantaan");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Luodaan uusi olio
						Autot uusiAuto = new Autot();	
						
						String uusiReknro = textField.getText();
						String uusiMerkki = textField_1.getText();
						String uusiMalli = textField_2.getText();
												
						uusiAuto.setRekisteriNro(uusiReknro);
						uusiAuto.setAutoMerkki(uusiMerkki);
						uusiAuto.setAutoMalli(uusiMalli);
						
						JDBC.tallennaAuto(uusiAuto);
						JOptionPane.showMessageDialog(contentPanel, "Lisätty tietokantaan: " + uusiAuto);
						
						//Tyhjennetään kentät uutta lisäystä varten
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sulje");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
