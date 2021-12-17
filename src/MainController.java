import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController implements Initializable {
	@FXML
	private Button manager;
	
	@FXML
	private Button cashier;
	@FXML
	public void managerButton(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));
			Scene sc = new Scene(root);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(sc);
			window.show();
		}catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");
		}
		}
	public void cashierButton(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CashierFXML.fxml"));
			Scene sc = new Scene(root);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(sc);
			window.show();
		}catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");
		}
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}}
