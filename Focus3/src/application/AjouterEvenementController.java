package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AjouterEvenementController implements Initializable {
	@FXML
	private Button enregistrer;
	@FXML
	private Button retour;
	
	
	@FXML
	public void enregistrer(ActionEvent event) {
		//Ici le code pour enregistrer le titre de l'évenement 
		//et la description dans la base de données
		Main.setPane(3);//On retourne dans la page Evenement
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(3);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
