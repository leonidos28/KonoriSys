package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import source.Coordinateur;

public class LoginCooController {

	@FXML
	private Label status;
	@FXML
	private TextField identifiant;
	@FXML
	private TextField mdp;

	@FXML
	protected void Connexion(ActionEvent e) throws Exception {
		Coordinateur coordinateur = new Coordinateur(identifiant.getText());

		System.out.println(coordinateur.getidmdpCoo(identifiant.getText()));

		if (mdp.getText().equals(coordinateur.getidmdpCoo(identifiant.getText()))) {
			URL coordinateurURL = getClass().getResource("/resource/fxml/MainCoo.fxml");
			Parent coordinateurParent = FXMLLoader.load(coordinateurURL);
			Scene coordinateurScene = new Scene(coordinateurParent);
			Stage etuStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			etuStage.setTitle("KonoriSys");
			etuStage.setResizable(false);
			etuStage.setScene(coordinateurScene);
			etuStage.show();
		} else {
			status.setText("Mdp ou identifiant Incorrect ");
		}

	}
	@FXML
	protected void Retour(ActionEvent e) throws IOException {

		URL coordinateurURL = getClass().getResource("/resource/fxml/Main.fxml");
		Parent coordinateurParent = FXMLLoader.load(coordinateurURL);
		Scene coordinateurScene = new Scene(coordinateurParent);
		Stage etuStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		etuStage.setTitle("KonoriSys");
		etuStage.setResizable(false);
		etuStage.setScene(coordinateurScene);
		etuStage.show();

	}
}
