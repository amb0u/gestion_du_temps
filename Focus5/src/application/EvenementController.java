package application;


import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.sun.jdi.connect.spi.Connection;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import login.MysqlConnect;


public class EvenementController implements Initializable {
	@FXML
	Label date;
	@FXML
	Label ratio;
	@FXML
	ObservableList<Evenement> listE;
	@FXML
	ObservableList<Emploi_du_temps> listEmploi;
	@FXML
	private ListView<Evenement> col_evenement;
	@FXML
	private TableView<Emploi_du_temps> table_horaire;
	@FXML
	private TableColumn<Emploi_du_temps,Time> col_horaire_debut;
	@FXML
	private TableColumn<Emploi_du_temps,Time> col_horaire_fin;
	@FXML
	private TableColumn<Emploi_du_temps,String> col_desc;
	@FXML
	private TableColumn<Emploi_du_temps,String> col_titre;
	@FXML
	private TableColumn<Emploi_du_temps,String> col_statut;
	@FXML
	private Button accueil_button;
	@FXML
	private Button add_evenement_button;
	@FXML
	private Button add_horaire_button;
	@FXML
	private HBox footer;
	@FXML
	private Label label2;
	@FXML
	public void nouveauEvenement(ActionEvent event) {
		new Main().son1();;
		Main.setPane(4);
	}
	@FXML
	public void nouveauHoraire(ActionEvent event) {
		new Main().son1();;
		Main.setPane(5);
	}
	@FXML
	public void retour(ActionEvent event) {
		new Main().son2();
		Main.setPane(0);
	}
	//mettre a jour le status

	public int changeStatus(@SuppressWarnings("rawtypes") CellEditEvent edittedCell)
    {
		new Main().son3();
		String val=edittedCell.getNewValue().toString();
		if(val.equals("achev�e")||val.equals("inachev�e")) {
			Emploi_du_temps even =  table_horaire.getSelectionModel().getSelectedItem();
			even.setStatus(edittedCell.getNewValue().toString());
			MysqlConnect.MAJEmploi(even);
			initData(Main.id);
			return 0;
		}
        JOptionPane.showMessageDialog(null, "entrez achev�e ou inachev�e");
			return -1;
    }
	//calculer le ratio de taches
	//private Utilisateur u;
	public void initData (int id){
		DecimalFormat d=new DecimalFormat(".##");
		ratio.setText(d.format(MysqlConnect.calcRatio(id)) +"%");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		date.setText(dtf.format(now));
		col_horaire_debut.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,Time>("horaire_debut"));
		col_horaire_fin.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,Time>("horaire_fin"));
		col_titre.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,String>("titre"));
		col_desc.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,String>("description"));
		col_statut.setCellValueFactory(new PropertyValueFactory<Emploi_du_temps,String>("status"));
		listEmploi = MysqlConnect.getDataEmploi_du_temps();
		table_horaire.setItems(listEmploi);
		table_horaire.setEditable(true);
		col_statut.setCellFactory(TextFieldTableCell.forTableColumn());
		
		listE = MysqlConnect.getDataEvenement();
		col_evenement.setItems(listE);
	}
	public void updateTable() {
		listEmploi = MysqlConnect.getDataEmploi_du_temps();
		table_horaire.setItems(listEmploi);
		listE = MysqlConnect.getDataEvenement();
		col_evenement.setItems(listE);
	}
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle rb) {
		
		
	}
	
	
}
