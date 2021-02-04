package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EvenementController implements Initializable {
	@FXML
	private Button accueil;
	@FXML
	private Button add_evenement_button;
	@FXML
	private Button add_horaire_button;
	@FXML
	private Label datedujour;
	
	@FXML
	public void nouveauEvenement(ActionEvent event) {
		Main.setPane(4);
	}
	@FXML
	public void nouveauHoraire(ActionEvent event) {
		Main.setPane(5);
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(0);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		datedujour.setText(formatter.format(date));
		
	}

}