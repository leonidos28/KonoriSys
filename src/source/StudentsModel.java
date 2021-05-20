package source;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentsModel {

    private SimpleIntegerProperty studentId;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty noteEcrit;
    private SimpleStringProperty noteTP;
    
    private final StringProperty  name   = new SimpleStringProperty();
    private final BooleanProperty delete = new SimpleBooleanProperty();

    public StudentsModel( String nm, boolean del ) {
       name  .set( nm  );
       delete.set( del );
    }

    public StringProperty  nameProperty  () { return name;   }
    public BooleanProperty deleteProperty() { return delete; }

    public StudentsModel(Integer studentId, String firstName, String lastName) {
        this.studentId = new SimpleIntegerProperty(studentId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }
    
    public StudentsModel(Integer studentId, String firstName,String lastName, String noteEcrit,String noteTP) {
        this.studentId = new SimpleIntegerProperty(studentId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.noteEcrit=new SimpleStringProperty(noteEcrit);
        this.noteTP=new SimpleStringProperty(noteTP);
    }

    public int getStudentId() {
        return studentId.get();
    }

    public void setStudentId(int studentId) {
        this.studentId = new SimpleIntegerProperty(studentId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

	public String getNoteEcrit() {
		return noteEcrit.get();
	}

	public void setNoteEcrit(String noteEcrit) {
		this.noteEcrit = new SimpleStringProperty(noteEcrit);
		
	}

	public String getNoteTP() {
		return noteTP.get();
	}

	public void setNoteTP(String noteTP) {
		this.noteTP = new SimpleStringProperty(noteTP);
		
	}
}