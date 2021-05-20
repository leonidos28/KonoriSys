package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import MySQLAccess.SqlAccessFiliere;
import Controllers.MainProfController;
import MySQLAccess.SqlAccessProf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainCooController implements Initializable  {
	ObservableList<String> choixSessionList = FXCollections.observableArrayList("Session Normale","Session Rattrapage");
	

	
	@FXML
	private Label status;
	@FXML
	private TextField coefEcrit;
	@FXML
	private TextField nbSeanceTp;
	@FXML
	private TextField coefTP;
	@FXML
	public ChoiceBox<String> sessionBox;
	
	@FXML
	protected void Retour(ActionEvent e) throws Exception {
		
		
		URL coodiantURL = getClass().getResource("/resource/fxml/ConfigProf.fxml");
		Parent coodiantParent = FXMLLoader.load(coodiantURL);
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
		

	}
	
	@FXML
	protected void listeNote(ActionEvent e) throws Exception {
		
		
		URL coodiantURL = getClass().getResource("/resource/fxml/listeNote.fxml");
		Parent coodiantParent = FXMLLoader.load(coodiantURL);
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
		

	}
	@FXML
	protected void emploiduTemp (ActionEvent e) throws Exception {
		
		
		URL coodiantURL = getClass().getResource("/resource/fxml/Timetable.fxml");
		Parent coodiantParent = FXMLLoader.load(coodiantURL);
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
		

	}
	@FXML
	protected void listeEtudiant(ActionEvent e) throws Exception {
		
		URL profURL = getClass().getResource("/resource/fxml/listeEtudiantCoo.fxml");
		Parent profParent = FXMLLoader.load(profURL);
		Scene profScene = new Scene(profParent);
		Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		profStage.setTitle("KonoriSys");
		profStage.setResizable(false);
		profStage.setScene(profScene);
		profStage.show();
		

	}
	@FXML
	protected void saisieNoteEcrit(ActionEvent e) throws Exception {
		
		
		URL coodiantURL = getClass().getResource("/resource/fxml/SaisieNoteEcrit.fxml");
		Parent coodiantParent = FXMLLoader.load(coodiantURL);
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

		
	
	

}


	

