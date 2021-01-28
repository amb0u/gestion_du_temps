package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class EvenementController implements Initializable {
	@FXML
	private Button calendrier;
	@FXML
	private Button ajouter_evenement;
	@FXML
	private Button editer_emploi_du_temps;
	
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(0);
	}
	@FXML
	public void nouveauEvenement(ActionEvent event) {
		Main.setPane(4);
	}
	@FXML
	public void nouveauHoraire(ActionEvent event) {
		Main.setPane(5);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
