package Controllers;

import source.StudentsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListeEtudiantController implements Initializable {

    @FXML
    private TableView<StudentsModel> tbData;
    @FXML
    public TableColumn<StudentsModel, Integer> studentId;

    @FXML
    public TableColumn<StudentsModel, String> firstName;

    @FXML
    public TableColumn<StudentsModel, String> lastName;

    public ListeEtudiantController()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tbData.setItems(studentsModels);
    }

    private ObservableList<StudentsModel> studentsModels = FXCollections.observableArrayList(
            new StudentsModel(1,"Imadeddine", "Alaoui Ismaili"),
            new StudentsModel(2,"Othmane", "Benchkroun"),
            new StudentsModel(3,"Othmane", "Zaim"),
            new StudentsModel(4,"Louchkou", "Hamid")
            
    );
    
    
    @FXML
    void Retour(ActionEvent event) {

    }

    @FXML
    void listeEtudiant(ActionEvent event) {

    }

    @FXML
    void saisieNoteEcrit(ActionEvent event) {

    }

    @FXML
    void saisieNoteTP(ActionEvent event) {

    }


}
