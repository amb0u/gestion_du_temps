package application;
	
import java.io.File;
import java.util.ArrayList;

import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	
	public static AnchorPane root;//la fenetre principale
	public static List <Pane> grid=new ArrayList<Pane>(); //grid est une pile de type d'objet de type Pane.
	private static int ind_c=0;
	public static int id=0;
	
	//sons
	public static String chemin1="C:\\Users\\user\\eclipse-workspace\\Focus\\src\\resources\\audio\\theme.wav";
	public static String chemin2="C:\\Users\\user\\eclipse-workspace\\Focus\\src\\resources\\audio\\retour.wav";
	public static Media media1=new Media(new File(chemin1).toURI().toString());
	public static Media media2=new Media(new File(chemin2).toURI().toString());
	public static String chemin3="C:\\Users\\user\\eclipse-workspace\\Focus\\src\\resources\\audio\\bdd.wav";
	public static Media media3=new Media(new File(chemin3).toURI().toString());
	public static MediaPlayer mp1=new MediaPlayer(media1);
	public static MediaPlayer mp2=new MediaPlayer(media2);
	public static MediaPlayer mp3=new MediaPlayer(media3);
	public static void son1() {
		mp1.play();
		mp1.seek(mp1.getStartTime());
	}
	public static void son2() {
		mp2.play();
		mp2.seek(mp2.getStartTime());
	}
	public static void son3() {
		mp3.play();
		mp3.seek(mp3.getStartTime());
	}
	public static void setInd_c(int ind_c) {
		Main.ind_c = ind_c;
	}
	private static String user="";
	@Override
	public void start(Stage primaryStage) {
	
		try {
		    root =(AnchorPane) FXMLLoader.load(getClass().getResource("/application/fond.fxml"));
			Scene scene = new Scene(root,700,700);
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/accueil.fxml")));//0
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/parametres.fxml")));//1
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/calendrier.fxml")));//2
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/Evenement.fxml")));//3
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/AjouterEvenement.fxml")));//4
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/AjouterHoraire.fxml")));//5
		    grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/Accueil.fxml")));//6	
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/Inscription.fxml")));//7
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/Login.fxml")));//8
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/InscriptionError.fxml")));//9
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("../login/LoginError.fxml")));//10
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/jours.fxml")));//11
			grid.add((AnchorPane) FXMLLoader.load(getClass().getResource("/application/actus.fxml")));//12
			root.getChildren().add(grid.get(6));
			
			scene.getStylesheets().add(getClass().getResource("application.css" ).toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Projet focus");
			primaryStage.getIcons().add(new Image("/resources/images/icon.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//La m�thode suivante n'est pas utilis�e 
	public static Pane getPane(int ind){
		return grid.get(ind);
	}
	public static void setPane(int ind){
		root.getChildren().remove(grid.get(ind_c));
		root.getChildren().add(grid.get(ind));
		ind_c=ind;
		
		
	}
	public static String getUser() {
		return user;//le dernier connect�
	}
	public static void setUser(String u) {
		user = u;
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
