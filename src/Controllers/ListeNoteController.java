package Controllers;

import source.StudentsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class ListeNoteController implements Initializable {
	
	int studentid = 0;

    @FXML
    private TableView<StudentsModel> tbData;
    @FXML
    public TableColumn<StudentsModel, Integer> studentId;

    @FXML
    public TableColumn<StudentsModel, String> firstName;

    @FXML
    public TableColumn<StudentsModel, String> lastName;
    
    @FXML
    public TableColumn<StudentsModel, String> noteEcrit;
    
    @FXML
    public TableColumn<StudentsModel, String> noteTP;
    
    @FXML
    public TableColumn<StudentsModel, Boolean> loadedColumn ;
    

    public ListeNoteController()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
	    
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        noteEcrit.setCellValueFactory(new PropertyValueFactory<>("noteEcrit"));
        noteTP.setCellValueFactory(new PropertyValueFactory<>("noteTP"));
        tbData.setItems(studentsModels);
        tbData.isEditable();
        

        
        tbData.setRowFactory(tv -> {
        	
            TableRow<StudentsModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    StudentsModel rowData = row.getItem();
                    studentid = rowData.getStudentId();
                    System.out.println("Double click on: "+rowData.getStudentId());

                }
            });
            
            return row ;
        });
        
        
    }
    
    

    public static ObservableList<StudentsModel> studentsModels = FXCollections.observableArrayList(
    		
            new StudentsModel(1,"Imadeddine", "Alaoui Ismaili","12","15"),
            new StudentsModel(2,"Othmane", "Benchkroun","13","15"),
            new StudentsModel(3,"Othmane", "Zaim","7","2"),
            new StudentsModel(8,"Louchkou", "Hamid","10","17")
            
       
    );
    @FXML
    void noteEtu(ActionEvent e)throws IOException{
    	URL coodiantURL = getClass().getResource("/resource/fxml/NoteEtudiant.fxml");
		Parent coodiantParent = null;
		try {
			coodiantParent = FXMLLoader.load(coodiantURL);
		} catch (IOException event) {
			// TODO Auto-generated catch block
			event.printStackTrace();
		}
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
    }
    
    
    
    @FXML
    void Retour(ActionEvent e) throws IOException {
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
    void listeEtudiant(ActionEvent e) throws IOException {
    	URL profURL = getClass().getResource("/resource/fxml/listeEtudiant.fxml");
		Parent profParent = FXMLLoader.load(profURL);
		Scene profScene = new Scene(profParent);
		Stage profStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		profStage.setTitle("KonoriSys");
		profStage.setResizable(false);
		profStage.setScene(profScene);
		profStage.show();
    }

    @FXML
    void saisieNoteEcrit(ActionEvent e) throws IOException {
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
    void saisieNoteTP(ActionEvent e) throws IOException {
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
    void addStudent(ActionEvent e) throws IOException {
		URL coodiantURL = getClass().getResource("/resource/fxml/AddStudent.fxml");
		Parent coodiantParent = FXMLLoader.load(coodiantURL);
		Scene coodiantScene = new Scene(coodiantParent);
		Stage cooStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		cooStage.setTitle("KonoriSys");
		cooStage.setResizable(false);
		cooStage.setScene(coodiantScene);
		cooStage.show();
    }

}
