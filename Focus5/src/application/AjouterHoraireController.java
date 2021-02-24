package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.MysqlConnect;

public class AjouterHoraireController {
	@FXML
	private Button enregistrer;
	@FXML
	private Button retour;
	@FXML
	private TextField horaire_debut;
	@FXML
	private TextField horaire_fin;
	@FXML
	private TextField txt_activite;
	@FXML
	private TextField description;
	
	@FXML
	public void enregistrer(ActionEvent event) throws IOException {
		AddHoraire();
		AccueilController ac = new AccueilController();
		ActionEvent e = null;
		ac.aujourdhui(e);
		//Ici le code pour enregistrer l'horaire fournie 
		//et la description dans la base de données
		Main.setPane(3);//On retourne dans la page Evenement
	}
	
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(3);
	}
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	public void AddHoraire() {
		
		conn = MysqlConnect.ConnectDb();
		String sql = "insert into emploi_du_temps (horaire_debut,horaire_fin,titre,status,description,id_utilisateur)values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setTime(1, Time.valueOf( horaire_debut.getText()));
			pst.setTime(2, Time.valueOf( horaire_fin.getText()));
			pst.setString(3, txt_activite.getText());
			pst.setString(4, "inachevée");
			pst.setString(5, description.getText());
			pst.setInt(6,Main.id );
			pst.execute();
			pst.executeUpdate(sql);
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Horaire Ajouté avec succès");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
