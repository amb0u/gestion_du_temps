package login;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InscriptionController implements Initializable {
	@FXML
	private Button confirm;
	@FXML
	private Button retour;
	@FXML
	public void confirmation(ActionEvent event) {
		
		//si l'utilisateur remplit correctement les champs, il va se diriger dans la page login ---->Main.setPane(2)
		//si l'utilisateur commet une erreur sur les mots de passe, alors 
		Main.setPane(9);
	}
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(6);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
