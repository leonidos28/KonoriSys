package Controllers;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import source.Professeur;

public class LoginProfController {
	
	public static String idprof = "";
	
	@FXML
	private Label status;
	@FXML
	private TextField identifiant;
	@FXML
	private TextField mdp;

	@FXML
	protected void Connexion(ActionEvent e) throws Exception {
		Professeur professeur = new Professeur(identifiant.getText());

		System.out.println(professeur.getidmdpProf(identifiant.getText()));

		if (mdp.getText().equals(professeur.getidmdpProf(identifiant.getText()))) {
			idprof = identifiant.getText() ;
			URL profURL = getClass().getResource("/resource/fxml/MainProf.fxml");
			Parent profParent = FXMLLoader.load(profURL);
			Scene profScene = new Scene(profParent);
			Stage etuStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			etuStage.setTitle("KonoriSys");
			etuStage.setResizable(false);
			etuStage.setScene(profScene);
			etuStage.show();
		} else {
			idprof = "";
			status.setText("Mdp ou identifiant Incorrect ");
		}

	}

	@FXML
	protected void Retour(ActionEvent e) throws IOException {

		URL profURL = getClass().getResource("/resource/fxml/Main.fxml");
		Parent profParent = FXMLLoader.load(profURL);
		Scene profScene = new Scene(profParent);
		Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		profStage.setTitle("KonoriSys");
		profStage.setResizable(false);
		profStage.setScene(profScene);
		profStage.show();

	}

}
