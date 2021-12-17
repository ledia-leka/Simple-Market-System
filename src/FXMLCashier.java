import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLCashier extends Application {

	
		@Override
		public void start(Stage stg1) throws Exception {
			try {
				Parent root = FXMLLoader.load(FXMLCashier.class.getResource("CashierFXML.fxml"));
				stg1.setTitle("Cashier Site");
				Scene scene= new Scene(root);
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
