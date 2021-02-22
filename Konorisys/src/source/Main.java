package source;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		URL fxmlURL = getClass().getResource("/resource/fxml/Main.fxml");

		Parent root = FXMLLoader.load(fxmlURL);

		primaryStage.setTitle("KonoriSys");
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
		Etudiant etudiant1 = new Etudiant("Alaoui", "Imad");
		System.out.println(etudiant1);

	}

}
