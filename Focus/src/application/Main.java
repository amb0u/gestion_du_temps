package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	static AnchorPane root;//la fenetre principale
	static List <Pane> grid=new ArrayList<Pane>();
	private static int ind_c=0;
	@Override
	public void start(Stage primaryStage) {
	
		try {
		    root =(AnchorPane) FXMLLoader.load(getClass().getResource("/application/fond.fxml"));
			
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/accueil.fxml")));//0
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/parametres.fxml")));//1
			grid.add((Pane) FXMLLoader.load(getClass().getResource("/application/calendrier.fxml")));//2
			root.getChildren().add(grid.get(0));
			Scene scene = new Scene(root,700,700);
			scene.getStylesheets().add(getClass().getResource("application.css" ).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Pane getPane(int ind){
		return grid.get(ind);
	}
	public static void setPane(int ind){
		root.getChildren().remove(grid.get(ind_c));
		root.getChildren().add(grid.get(ind));
		ind_c=ind;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
