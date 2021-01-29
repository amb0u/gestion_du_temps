package login;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LoginController implements Initializable{
	@FXML
	private Button connect;
	@FXML
	private Button retour;
	@FXML
	public void connexion(ActionEvent e) {
		//Si les champs sont bien renseignés, alors on va aller directement sur l'application
		//Si les informations sont erronées, alors on aura la page suivante:
		//Main.setPane(10);
		Main.setPane(0);
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
