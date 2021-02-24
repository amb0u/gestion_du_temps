package application;



import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class JoursController implements Initializable{
	@FXML
	private Label datedujour;
	@FXML
	private TextArea infos;
	public void initData (LocalDate d){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");   
		String []jours= {"dimanche","lundi","mardi","mercredi","jeudi","vendredi","samedi"};
		datedujour.setText("Le "+jours[d.getDayOfWeek().getValue()]+" "+dtf.format(d));
	}
	@FXML
	private Button retour;
	@FXML
	public void retourner(ActionEvent event) {
		Main.setPane(0);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
