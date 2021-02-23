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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class JoursController implements Initializable{
	@FXML
	private Label datedujour;
	@FXML
	private WebView infos;
	@FXML
	private WebView meteo;
	WebEngine engine=null;
	WebEngine engine2=null;
	public void initData (LocalDate d){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");   
		String []jours= {"dimanche","lundi","mardi","mercredi","jeudi","vendredi","samedi"};
		datedujour.setText("Le "+jours[d.getDayOfWeek().getValue()-1]+" "+dtf.format(d));
	}
	@FXML
	private Button retour;
	@FXML
	public void retourner(ActionEvent event) {
		Main.son2();
		Main.setPane(0);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		engine=infos.getEngine();
		engine.load("https://www.lemonde.fr/actualite-en-continu/");

	}
	

}
