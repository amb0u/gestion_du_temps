package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

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
	private TextField txt_horaire;
	@FXML
	private TextField txt_activite;
	
	@FXML
	public void enregistrer(ActionEvent event) {
		AddHoraire();
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
		String sql = "insert into emploi_du_temps (horaire, titre)values(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt_horaire.getText());
			pst.setString(2, txt_activite.getText());
			pst.execute();
			
			//JOptionPane.showMessageDialog(null, "Horaire Ajouté avec succès");
		} catch (Exception e) {
			
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
