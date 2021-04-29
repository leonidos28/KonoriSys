package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import MySQLAccess.SqlAccessCooAuth;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.Stage;

public class ConfigCooController implements Initializable {





	static String[] data = { "0", "0", "0", "0" };

	@FXML
	public ChoiceBox<String> choixFiliereBox;
	@FXML
	public ChoiceBox<String> choixSemestreBox;

	private Label moduleLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		choixSemestreBox.getItems().add(0, "-Semestre-");
		choixSemestreBox.getSelectionModel().select(0);

		choixFiliereBox.getItems().add(0, "-Filiere-");
		choixFiliereBox.getSelectionModel().select(0);


		fillChoiceBox(loadDataOb("filiereCoo"), choixFiliereBox);
		fillChoiceBox(dependData("idSemestre"), choixSemestreBox);
	}

	@FXML
	protected void Retour(ActionEvent e) throws Exception {

		URL profURL = getClass().getResource("/resource/fxml/Main.fxml");
		Parent profParent = FXMLLoader.load(profURL);
		Scene profScene = new Scene(profParent);
		Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		profStage.setTitle("KonoriSys");
		profStage.setResizable(false);
		profStage.setScene(profScene);
		profStage.show();

	}

	@FXML
	protected void valider(ActionEvent e) throws Exception {

		if (!choixSemestreBox.getSelectionModel().isEmpty()) {

			String semestre = choixSemestreBox.getSelectionModel().getSelectedItem();
			
			String filere = choixFiliereBox.getSelectionModel().getSelectedItem();


			data[0] = semestre;
			data[1] = filere;


			URL profURL = getClass().getResource("/resource/fxml/MainCoo.fxml");
			Parent profParent = FXMLLoader.load(profURL);
			Scene profScene = new Scene(profParent);
			Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			profStage.setTitle("KonoriSys");
			profStage.setResizable(false);
			profStage.setScene(profScene);
			profStage.show();
		} else {
			moduleLabel.setText("Veillez remplir les informations");
		}

	}

	public void changelabel(String value) {
		moduleLabel.setText(value);
	}

	public ObservableList<String> loadDataOb(String id) {
		ArrayList<String> list = new ArrayList<String>();
		SqlAccessCooAuth access = new SqlAccessCooAuth();
		try {

			list = access.readDataBaseList(id);

		} catch (Exception e) {

			e.printStackTrace();
		}
		ObservableList<String> obList = FXCollections.observableArrayList(list);
		return obList;
	}
	
	public ObservableList<String> dependData(String id) {
		ArrayList<String> list = new ArrayList<String>();
		SqlAccessCooAuth access = new SqlAccessCooAuth();
		try {

			list = access.DataBaseDependencies(id);

		} catch (Exception e) {

			e.printStackTrace();
		}
		ObservableList<String> obList = FXCollections.observableArrayList(list);
		return obList;
	}
	

	private void fillChoiceBox(ObservableList<String> list, ChoiceBox<String> choiceBox) {
		if (choiceBox.getValue() != "-Filiere-" && choiceBox.getValue() != "-Semestre-" ) {
			choiceBox.getItems().clear();
		}
		
		choiceBox.getItems().addAll(list);
		
	}

}


