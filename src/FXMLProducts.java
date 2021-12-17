import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLProducts extends Application {

	@Override
	public void start(Stage window) throws Exception {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("Products.fxml"));
			Scene sc = new Scene(root);
			window.setTitle("Manager Site");
			window.setScene(sc);
			window.show();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");
		}
	}

	
	public static void main(String[] args) {
		launch(args);

	}

}
