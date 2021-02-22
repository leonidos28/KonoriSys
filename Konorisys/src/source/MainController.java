package source;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.StringBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public class MainController implements Initializable {
	
	private String name;
	
	
	
	@FXML
	private Label statusConnexion;

	@FXML
	protected void handleConnexionButtonAction(ActionEvent e) {
		System.out.println("Connxeion button pressed");
	}

	@FXML
	protected void handleInscriptionButtonAction(ActionEvent e) {
		
		
	}

	@FXML
	protected void handleMdpOublieeButtonAction(ActionEvent e) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	StringBinding stringBinding = new StringBinding() {

		@Override
		protected String computeValue() {
			// TODO Auto-generated method stub
			return "erreur";
		}
		
	};
	
	

}
