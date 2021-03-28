package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import MySQLAccess.SqlAccessFiliere;
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

public class MainProfController implements Initializable {

	ArrayList<String> listModule = new ArrayList<String>();

	ObservableList<String> choixFiliereList = FXCollections.observableArrayList();
	ObservableList<String> choixSemestreList = FXCollections.observableArrayList();
	ObservableList<String> choixModuleList = FXCollections.observableArrayList();

	static String[] data = { "0", "0", "0", "0" };

	@FXML
	public ChoiceBox<String> choixFiliereBox;
	@FXML
	public ChoiceBox<String> choixSemestreBox;
	@FXML
	public ChoiceBox<String> choixModuleBox;
	@FXML
	public ChoiceBox<String> choixMatiereBox;
	@FXML
	private Label moduleLabel;

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

		if (!choixMatiereBox.getSelectionModel().isEmpty()) {

			String semestre = choixSemestreBox.getSelectionModel().getSelectedItem();
			String filere = choixFiliereBox.getSelectionModel().getSelectedItem();
			String module = choixModuleBox.getSelectionModel().getSelectedItem();
			String matiere = choixMatiereBox.getSelectionModel().getSelectedItem();

			data[0] = semestre;
			data[1] = filere;
			data[2] = module;
			data[3] = matiere;

			URL profURL = getClass().getResource("/resource/fxml/ConfigProf.fxml");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		choixFiliereBox.getItems().add(0, "-Filiere-");
		choixFiliereBox.getSelectionModel().select(0);

		choixSemestreBox.getItems().add(0, "-Semsetre-");
		choixSemestreBox.getSelectionModel().select(0);

		fillChoiceBox(loadDataOb("filiere"), choixFiliereBox);
		fillChoiceBox(loadDataOb("semestre"), choixSemestreBox);

		choixSemestreBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> selected, String fil, String module) {
				// TODO Auto-generated method stub
				System.out.println("choiceSemestrebox changed");

				fillChoiceBox(loadDataModule(), choixModuleBox);

			}
		});

		choixModuleBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				fillChoiceBox(loadDataMatiere(4), choixMatiereBox);

			}

		});

		choixModuleBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					String value = SqlAccessFiliere.readDataBase(choixSemestreBox.getValue(),
							choixFiliereBox.getValue(), "nomModule", choixModuleBox.getValue()).toString();

					changelabel(value);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	public void changelabel(String value) {
		moduleLabel.setText(value);
	}

	public ArrayList<String> loadDataModule() {

		SqlAccessFiliere access = new SqlAccessFiliere();
		try {

			listModule = access.readDataBaseModule(choixSemestreBox.getValue(), choixFiliereBox.getValue());

		} catch (Exception e) {

			e.printStackTrace();
		}

		return listModule;
	}

	public ArrayList<String> loadDataMatiere(int id) {
		ArrayList<String> list = new ArrayList<String>();
		SqlAccessFiliere access = new SqlAccessFiliere();
		try {
			

				list.addAll(access.readDataBaseList(choixSemestreBox.getValue(), choixFiliereBox.getValue(),
						"idMatiere", choixModuleBox.getValue()));

			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<String> loadData(String id) {
		ArrayList<String> list = new ArrayList<String>();
		SqlAccessFiliere access = new SqlAccessFiliere();
		try {

			list = access.readDataBaseList(id);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	public ObservableList<String> loadDataOb(String id) {
		ArrayList<String> list = new ArrayList<String>();
		SqlAccessFiliere access = new SqlAccessFiliere();
		try {

			list = access.readDataBaseList(id);

		} catch (Exception e) {

			e.printStackTrace();
		}
		ObservableList<String> obList = FXCollections.observableArrayList(list);
		return obList;
	}

	private void fillChoiceBox(ObservableList<String> list, ChoiceBox<String> choiceBox) {
		
		choiceBox.getItems().addAll(list);
	}

	private void fillChoiceBox(ArrayList<String> list, ChoiceBox<String> choiceBox) {
		choiceBox.getItems().clear();
		choiceBox.getItems().addAll(list);
	}

}
