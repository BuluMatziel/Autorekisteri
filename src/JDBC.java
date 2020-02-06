import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JDBC {
	
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313469";

		// Database credentials
		static final String USER = "sql7313469";
		static final String PASS = "uziHuDxUXI";
		
		public static void tallennaAuto(Autot uusiAuto) {

			String rekisteriNro = uusiAuto.getRekisteriNro();
			String autoMerkki = uusiAuto.getAutoMerkki();
			String autoMalli = uusiAuto.getAutoMalli();

			Connection conn = null;
			Statement stmt = null;
			try {

				System.out.println("Connecting to database...");

				// Luodaan yhteys tietokantaan
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// SQL Lausekkeen esittely, k‰ytet‰‰n ? muuttuvien tietojen kohdalla
				String sql = "INSERT INTO Autorekisteri (auto_id, Rekisterinumero, Merkki, Malli) values (?,?,?,?)";

				// T‰ydennet‰‰n SQL-lauseisiin puuttuvat muuttujat
				PreparedStatement preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setString(1, null);
				preparedStmt.setString(2, rekisteriNro);
				preparedStmt.setString(3, autoMerkki);
				preparedStmt.setString(4, autoMalli);

				// Suorittaa SQL lauseen

				preparedStmt.execute();
							
				System.out.println("Saving data...");
				lataaAutot(); //P‰ivitt‰‰ taulukon

			} catch (SQLException se) {
				// K‰sitell‰n tietokantavirheet
				se.printStackTrace();
			} catch (Exception e) {
				// Muut virheet
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try

		}// end main

		public static void lataaAutot() {

			Connection conn = null;
			Statement stmt = null;
			try {

				// Luodaan yhteys
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				System.out.println("Haetaan dataa...");

				// Suoritetaan SQL kysely
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Autorekisteri");

				// 
				DefaultTableModel model = new DefaultTableModel(new String[]{"Auto id", "Rek Nro", "Merkki", "Malli"}, 0);
				
				// K‰yd‰‰n l‰pi tulosjoukko silmukassa
				while (rs.next()){
					 System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
					 model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
					 
					 autorekisteri.table.setModel(model);
					    
					   
				     
						
						
				}
				// Otetaan mahdolliset virheet kiinni
			} catch (SQLException se) {
				 
				se.printStackTrace();
			} catch (Exception e) {
				 
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
		 
		}// end main

		public static void poistaAutot() {
				//Katsoo mik‰ rivi on valittu ja mik‰ sen auton id on
			   DefaultTableModel model = (DefaultTableModel) autorekisteri.table.getModel();
			   int row = autorekisteri.table.getSelectedRow();
			   String value = model.getValueAt(row, 0).toString();
			   
			   Connection conn = null;
				Statement stmt = null;
				try {

					// Luodaan yhteys
					System.out.println("Connecting to database...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					System.out.println("Haetaan dataa...");

					// Suoritetaan SQL kysely
					stmt = conn.createStatement();
							ResultSet rs = stmt.executeQuery("SELECT * FROM Autorekisteri WHERE auto_id =" +value);					
							while (rs.next()){
								JOptionPane.showMessageDialog(autorekisteri.contentPane, "Poistettu seuraava rivi: " + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
								 System.out.println("Poistettu seuraava rivi: " + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
						 
							}
					stmt.executeUpdate("DELETE FROM Autorekisteri WHERE auto_id = "+value);
											    						   					     														
					
					// Otetaan mahdolliset virheet kiinni
				} catch (SQLException se) {
					 
					se.printStackTrace();
				} catch (Exception e) {
					 
					e.printStackTrace();
				} finally {
					// finally block used to close resources
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					} // nothing we can do
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					} // end finally try
				} // end try
			 
			}// end main		
}
