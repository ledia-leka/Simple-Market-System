import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ReceiptController implements Initializable {
 @FXML
 private TextArea tareaBill;
 @FXML 
 private Button exit;
 @FXML
 public void exit(ActionEvent event) {
	 Parent root;
	try {
		root = FXMLLoader.load(getClass().getResource("CashierFXML.fxml"));
	
		Scene sc = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(sc);
		window.show();
 } catch (IOException e) {
		JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");	}}
 @FXML
 public void getText() {
	
	try {File file= new File("..\\Market\\items\\receipt.txt");
        Scanner sc;
        
		sc = new Scanner(file);
		while(sc.hasNextLine()) {
    	tareaBill.appendText(sc.nextLine()+"\n");
    }
	   }catch (FileNotFoundException e2) {
 			JOptionPane.showMessageDialog(null,"File not found.");
 		} catch (IOException e) {
 			JOptionPane.showMessageDialog(null,"File has problems.");
 		}catch(NoSuchElementException e2) {
 			JOptionPane.showMessageDialog(null,"Check file for empty spaces.");
 		}catch(NumberFormatException e2) {
 			JOptionPane.showMessageDialog(null,"Check your input.");
 			}                
    };
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		getText();
	}


}
