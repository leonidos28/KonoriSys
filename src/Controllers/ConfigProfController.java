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

public class ConfigProfController implements Initializable  {
	ObservableList<String> choixSessionList = FXCollections.observableArrayList("Session Normale","Session Rattrapage");
	
	String valueCoefEcrit="0";
	String valueNbSeanceTP="0";
	String valueCoefTP="0";
	
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
		
		
		URL coodiantURL = getClass().getResource("/resource/fxml/Main.fxml");
		Parent coodiantParent = FXMLLoader.load(coodiantURL);
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
		

	}
	
	@FXML
	protected void saisieNoteTP(ActionEvent e) throws Exception {
		
		
		URL coodiantURL = getClass().getResource("/resource/fxml/SaisieNoteTP.fxml");
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
		
		URL profURL = getClass().getResource("/resource/fxml/listeEtudiantProf.fxml");
		Parent profParent = FXMLLoader.load(profURL);
		Scene profScene = new Scene(profParent);
		Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		profStage.setTitle("KonoriSys");
		profStage.setResizable(false);
		profStage.setScene(profScene);
		profStage.show();
		

	}
	
	@FXML
	protected void abscence(ActionEvent e) throws Exception {
		
		URL profURL = getClass().getResource("/resource/fxml/Abscence.fxml");
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
	
	
	@FXML
	protected void valider(ActionEvent e) throws Exception {
		
		if (!coefEcrit.getText().isEmpty()||!nbSeanceTp.getText().isEmpty()||
				!coefTP.getText().isEmpty()){

			saveDataMatiere("coefTP",coefTP.getText());
			saveDataMatiere("nbSeanceTp",nbSeanceTp.getText());
			saveDataMatiere("coefEcrit",coefEcrit.getText());
			status.setText("Informations Enregistrés");
		}
		else {status.setText("Veillez remplir les informations");}
		
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sessionBox.getItems().add(0, "-Session-");
		sessionBox.getSelectionModel().select(0);
		fillChoiceBox(choixSessionList,sessionBox);
		
		
	}
	
	private void fillChoiceBox(ObservableList<String> list, ChoiceBox<String> choiceBox) {
	
		choiceBox.getItems().addAll(list);
	}
	
	private void saveDataMatiere(String idColumn,String value) throws Exception {
		SqlAccessProf access = new SqlAccessProf();
		String[] data = MainProfController.data;;
		
		String semestre = data[0];
		String filere = data[1] ;
		String module = data[2];
		String matiere = data[3];
		
		access.SavetoDataBaseIDMatiere(idColumn,value,matiere,filere,module);

		
	}
	
}


	

