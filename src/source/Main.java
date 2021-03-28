package source;

import java.io.IOException;
import java.net.URL;

import MySQLAccess.SqlAccessCoo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage Stage) throws Exception {

		URL fxmlURL = getClass().getResource("/resource/fxml/Main.fxml");

		Parent root = FXMLLoader.load(fxmlURL);

		Stage.setTitle("KonoriSys");
		Scene scene = new Scene(root);

		Stage.setScene(scene);
		Stage.setResizable(false);
		Stage.show();

	}


	public static void main(String[] args) throws Exception {
		launch(args);
	
			
		}
			
		
	}


