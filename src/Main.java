
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stg1) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
			stg1.setTitle("Welcome to Market");
			Scene scene= new Scene(root,690,400);
			stg1.setScene(scene);
			stg1.show();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
