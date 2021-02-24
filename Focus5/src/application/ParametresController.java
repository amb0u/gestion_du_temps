package application;
	
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import login.MysqlConnect;




public class ParametresController implements Initializable{
	
	@FXML
	private TextArea texte;
	@FXML
	private Button retour;//aller vers le menu
	@FXML
	private Button envoyer;//aller vers le menu
	@FXML
	public void retour(ActionEvent event) {
		Main.setPane(0);
	}
	
	public void commenter() {
		if(texte.getText()!=null) {
		Connection conn = null;
		PreparedStatement pst=null;
		conn = MysqlConnect.ConnectDb();
		String sql = "insert into commentaire (id_utilisateur , texte) values (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Main.id);
			pst.setString(2, texte.getText());
			pst.execute();
			pst.executeUpdate(sql);
			pst.close();
			JOptionPane.showMessageDialog(null, "Envoyé avec succès, nous vous remercions!");
			AccueilController ac = new AccueilController();
			ActionEvent e = null;
			ac.aujourdhui(e);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
		else {
			JOptionPane.showMessageDialog(null, "Veuillez saisir votre commentaire!");
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
}