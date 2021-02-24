package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import application.Emploi_du_temps;
import application.Evenement;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MysqlConnect {
	 Connection conn = null;
	 
	 public static Connection ConnectDb(){
	    
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/focus","root","");
	            //JOptionPane.showMessageDialog(null, "Connection Established");
	            return conn;
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	   }
	}
	 
	    public static ObservableList<Evenement> getDataEvenement(){
			Connection conn = ConnectDb();
			String sql = "select * from evenement where id_utilisateur= ?";
			ObservableList<Evenement> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,Main.id );
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Evenement(rs.getString("titre"),rs.getTime("heure"),rs.getString("description")));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public static ObservableList<Emploi_du_temps> getDataEmploi_du_temps(){
			Connection conn = ConnectDb();
			String sql = "select * from emploi_du_temps where id_utilisateur= ?";
			ObservableList<Emploi_du_temps> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, Main.id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					list.add(new Emploi_du_temps(rs.getInt("id"),rs.getInt("id_utilisateur"),rs.getTime("horaire_debut"),rs.getTime("horaire_fin"),rs.getString("status"),rs.getString("titre"),rs.getString("description")));
				}
			} catch(Exception e) {
				
			}
			return list;
		}
		//mettre a jour le status
		public static int MAJEmploi(Emploi_du_temps em){
			Connection conn = ConnectDb();
			String sql = "update emploi_du_temps set status=? where id=?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, em.getStatus());
				ps.setInt(2, em.getId());
				ps.execute();
			} catch(Exception e) {
				
			}
			return 0;
		}
		//calculer le ratio de taches accomplies
		public static double calcRatio(int uid) {
			double p=0,total=0,faites=0;
			Connection conn = ConnectDb();
			String sql = "select * from emploi_du_temps where id_utilisateur=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, uid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					total++;
					if(rs.getString("status").equals("achevée")) {
						faites++;
					}
				}
				p=(faites/total)*100;
			} catch(Exception e) {
				e.printStackTrace();
			}
			return p;
		}

}
