package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import MySQLAccess.SqlAccessSaisieNote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import source.StudentsModel;

public class AddStudentController implements Initializable {

	int i = 1;

	@FXML
	private Label status;
	@FXML
	private TextField nomEtu;
	@FXML
	private TextField prenomEtu;
	@FXML
	private TextField cneEtu;
	@FXML
	private TextField filiereEtu;
	@FXML
	private TextField anneeEtu;

	@FXML
	protected void Retour(ActionEvent e) throws Exception {

		URL coodiantURL = getClass().getResource("/resource/fxml/ListeEtudiantCoo.fxml");
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


	}


	@FXML
	protected void validerEtu(ActionEvent e) throws Exception {
		ListeEtudiantControllerCoo.studentsModels.addAll(new StudentsModel(9,"Samir", "Tastift"));
	}


	@FXML
	private void ajouterEtu() throws Exception {
		
	}


}
