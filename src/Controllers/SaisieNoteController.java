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

public class SaisieNoteController implements Initializable {

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
	private TextField noteEtu;

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
	protected void validerEtuTP(ActionEvent e) throws Exception {
		SqlAccessSaisieNote.existDataBase("idEtudiant",cneEtu.getText(),"idMatiere",MainProfController.data[3]);
		if(!SqlAccessSaisieNote.exist) {
			SqlAccessSaisieNote.FillDataBase(cneEtu.getText(),MainProfController.data[3]);
			System.out.println("created");
		}else {System.out.println("exist");}
		
		if (!noteEtu.getText().isEmpty()) {
			
			SqlAccessSaisieNote.SavetoDataBaseNote(noteEtu.getText(),cneEtu.getText(),"TP",MainProfController.data[3]);

			status.setText("Informations Enregistrés");
		} else {
			System.out.println("Empty");
		}


	}
	@FXML
	protected void validerEtuEcrit(ActionEvent e) throws Exception {
		SqlAccessSaisieNote.existDataBase("idEtudiant",cneEtu.getText(),"idMatiere",MainProfController.data[3]);
		if(!SqlAccessSaisieNote.exist) {
			SqlAccessSaisieNote.FillDataBase(cneEtu.getText(),MainProfController.data[3]);
			System.out.println("created");
		}else {System.out.println("exist");}
		
		if (!noteEtu.getText().isEmpty()) {
			
			SqlAccessSaisieNote.SavetoDataBaseNote(noteEtu.getText(),cneEtu.getText(),"ECRIT",MainProfController.data[3]);

			status.setText("Informations Enregistrés");
		} else {
			System.out.println("Empty");
		}
		

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomEtu.setEditable(false);
		prenomEtu.setEditable(false);
		cneEtu.setEditable(false);
		filiereEtu.setEditable(false);

	}


	@FXML
	private void afficherEtu() throws Exception {
		noteEtu.setText(null);
		SqlAccessSaisieNote access = new SqlAccessSaisieNote();
		nomEtu.setText(access.readDataBase("nom", 1, 1));
		prenomEtu.setText(access.readDataBase("prenom", 1, 1));
		filiereEtu.setText(access.readDataBase("filiereEtu", 1, 1));
		cneEtu.setText(access.readDataBase("cne", 1, 1));
		i = 2;
	}

	@FXML
	private void suivantEtu() throws Exception {
		noteEtu.setText(null);
		SqlAccessSaisieNote access = new SqlAccessSaisieNote();
		if (i <= 3) {
				i++;
				nomEtu.setText(access.readDataBase("nom", i, 0));
				prenomEtu.setText(access.readDataBase("prenom", i, 0));
				filiereEtu.setText(access.readDataBase("filiereEtu", i, 0));
				cneEtu.setText(access.readDataBase("cne", i, 0));
				
				status.setText("");
	
		} else {
			status.setText("Fin de la liste");
		}

	}

	@FXML
	private void precedentEtu() throws Exception {
		noteEtu.setText(null);
		SqlAccessSaisieNote access = new SqlAccessSaisieNote();
		if (i <= 4 && i>2) {
			i--;
			nomEtu.setText(access.readDataBase("nom", i, 0));
			prenomEtu.setText(access.readDataBase("prenom", i, 0));
			filiereEtu.setText(access.readDataBase("filiereEtu", i, 0));
			cneEtu.setText(access.readDataBase("cne", i, 0));
			status.setText("");
			

	} else {
		status.setText("Fin de la liste");
	}
	}

}
