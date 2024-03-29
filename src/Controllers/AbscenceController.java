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
import javafx.scene.control.Label;
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

public class AbscenceController implements Initializable {

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
    
    @FXML
	private Label status;

    public AbscenceController()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
	    
	    
	    
    	
	    
	    loadedColumn.setCellValueFactory( new PropertyValueFactory<>( "delete" ));
	    loadedColumn.setCellFactory( tc -> new CheckBoxTableCell<>());
	    
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tbData.setItems(studentsModels);
        
        final var delBtn = new Button( "Delete" );
	      delBtn.setMaxWidth( Double.MAX_VALUE );
	      delBtn.setOnAction( e -> {
	         final var del = new HashSet<StudentsModel>();
	         for( final var StudentsModel : tbData.getItems()) {
	            if( StudentsModel.deleteProperty().get()) {
	               del.add( StudentsModel );
	            }
	         }
	         tbData.getItems().removeAll( del ); 
	      });
        
	    tbData.setEditable( true );
        
        tbData.setRowFactory(tv -> {
        	
            TableRow<StudentsModel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    StudentsModel rowData = row.getItem();
                    System.out.println("Double click on: "+rowData.getFirstName());
                }
            });
            return row ;
        });
        
        
    }

    private ObservableList<StudentsModel> studentsModels = FXCollections.observableArrayList(
            new StudentsModel(1,"Imadeddine", "Alaoui Ismaili"),
            new StudentsModel(2,"Othmane", "Benchkroun"),
            new StudentsModel(3,"Othmane", "Zaim"),
            new StudentsModel(4,"Louchkou", "Hamid"),
            new StudentsModel(6,"Mohamed", "Bakati"),
            new StudentsModel(7,"Mehdi", "Taxista"),
            new StudentsModel(8,"Samir", "Statstsatsfit"),
            new StudentsModel(9,"Samir", "SSSekkkoumi"),
            new StudentsModel(10,"Nabil", "Taha"),
            new StudentsModel(11,"Naoufe", "idkbro"),
            new StudentsModel(12,"Hakima", "Se9at"),
            new StudentsModel(13,"Adam", "Zaim"),
            new StudentsModel(14,"Mohamed", "BOhi"),
            new StudentsModel(15,"Mickael", "Emond")
            
            
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

	@FXML
	protected void confirmer(ActionEvent e) throws Exception {
	
			status.setText("Informations Enregistrés");

	}
    

}
