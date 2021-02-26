package login;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class InfosCompteController implements Initializable {

	@FXML
	private TextField identifiant;
	@FXML
	private TextField email;
	@FXML
	private TextField age;
	@FXML
	private TextField date;
	@FXML
	public void retour(ActionEvent event) {
		new Main().son2();
		Main.setPane(0);
	}
	public void initData(Login l) {
		identifiant.setText(l.getIdentifiant());
		email.setText(l.getEmail());
		age.setText(String.valueOf(l.getAge()));
		date.setText(l.getDate_creation().toString());
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	

}
