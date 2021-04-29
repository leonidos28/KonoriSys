package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import MySQLAccess.SqlAccessAutoFill;
import MySQLAccess.SqlAccessSaisieNote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController implements Initializable {
	

	
	@FXML
	private Label statusConnexion;

	@FXML
	protected void handleCoordinateur(ActionEvent e) throws IOException {
		URL coordinateurURL = getClass().getResource("/resource/fxml/LoginCoo.fxml");
		Parent coordinateurParent = FXMLLoader.load(coordinateurURL);
		Scene coordinateurScene = new Scene(coordinateurParent);
		Stage etuStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		etuStage.setTitle("KonoriSys");
		etuStage.setResizable(false);
		etuStage.setScene(coordinateurScene);
		etuStage.show();
	}

	@FXML
	protected void handleProfesseur(ActionEvent e) throws IOException {
		
		URL etudiantURL = getClass().getResource("/resource/fxml/LoginProf.fxml");
		Parent etudiantParent = FXMLLoader.load(etudiantURL);
		Scene etudiantScene = new Scene(etudiantParent);
		Stage etuStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		etuStage.setTitle("KonoriSys");
		etuStage.setResizable(false);
		etuStage.setScene(etudiantScene);
		etuStage.show();
		
	}
	@FXML
	protected void skip(ActionEvent e) throws Exception {
		
		
		URL profURL = getClass().getResource("/resource/fxml/ListeEtudiant.fxml");
		Parent profParent = FXMLLoader.load(profURL);
		Scene profScene = new Scene(profParent);
		Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		profStage.setTitle("KonoriSys");
		profStage.setResizable(false);
		profStage.setScene(profScene);
		profStage.show();

	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	};
	
	

