package application;
	
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import login.Utilisateur;




public class AccueilController implements Initializable{
	private Utilisateur u;
	public void initData (Utilisateur user){
		u=user;
		utilisateurs.setText(utilisateurs.getText()+u.getLogin());
		ident.setText(ident.getText()+String.valueOf(user.getId()));
	}
	@FXML
	private Label ident;//id de l'utilisateur connecté
	@FXML
	private Label utilisateurs;//utilisateurs connectés
	@FXML
	private Button param;//aller vers parametres
	@FXML
	private Button cal;//aller vers le calendrier
	@FXML
	private Button today;
	@FXML
	private Button quitter;//aller vers le calendrier
	@FXML
	public void affichercal(ActionEvent event) {
		Main.setPane(2);
	}
	@FXML
	public void aujourdhui(ActionEvent event) throws IOException {
		//Main.root.getChildren().remove(Main.grid.get(0));
		FXMLLoader le=new FXMLLoader();
		le.setLocation(getClass().getResource( "/application/Evenement.fxml"));
		Object tableViewParent=le.load();
		application.EvenementController ec=le.getController();
		ec.initData(Main.id);
		Main.root.getChildren().add((Pane)tableViewParent);
		
		Main.grid.set(3,(Pane)tableViewParent);
        Main.setInd_c(3);
		Main.root.getChildren().remove(Main.grid.get(0));
	}
	@FXML
	public void quitter(ActionEvent event) {
		Platform.exit();
	}
	@FXML
	public void button_param(ActionEvent event) {
		Main.setPane(1);
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle rb) {
		
		
	}

	
	
}