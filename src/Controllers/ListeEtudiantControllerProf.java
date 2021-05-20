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

public class ListeEtudiantControllerProf implements Initializable {
	
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
    public TableColumn<StudentsModel, Boolean> loadedColumn ;
    

    public ListeEtudiantControllerProf()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
	    
	    
	    
    	
	    
	    
	    
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tbData.setItems(studentsModels);
        

        
        tbData.setRowFactory(tv -> {
        	
            TableRow<StudentsModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    StudentsModel rowData = row.getItem();
                    studentid = rowData.getStudentId();
                    System.out.println("Double click on: "+rowData.getStudentId());
                    
                    
                    URL coodiantURL = getClass().getResource("/resource/fxml/NoteEtudiant.fxml");
            		Parent coodiantParent = null;
					try {
						coodiantParent = FXMLLoader.load(coodiantURL);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		Scene coodiantScene = new Scene(coodiantParent);
            		Stage cooStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            		cooStage.setTitle("KonoriSys");
            		cooStage.setResizable(false);
            		cooStage.setScene(coodiantScene);
            		cooStage.show();
                }
            });
            
            return row ;
        });
        
        
    }
    
    

    private ObservableList<StudentsModel> studentsModels = FXCollections.observableArrayList(
    		
            new StudentsModel(1,"Imadeddine", "Alaoui Ismaili"),
            new StudentsModel(2,"Othmane", "Benchkroun"),
            new StudentsModel(3,"Othmane", "Zaim"),
            new StudentsModel(8,"Louchkou", "Hamid")
            
            
            
    );
    
    
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


    

}
