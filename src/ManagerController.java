import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagerController implements Initializable {
	@FXML
	private Button LoginB ;
	@FXML
	private TextField inputmanager;
	@FXML
	private TextField inputpass;
	@FXML
	private Button RegisterB;
	@FXML
	private TextField inputname;
	@FXML
	private TextField inputsurname;
	@FXML
	private TextField inputPass;
	@FXML
	private TextField inputid;
	@FXML
	private Button back;
	@FXML
	 public void goBack(ActionEvent event) {
		 Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
			Scene sc = new Scene(root);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(sc);
			window.show();
	 } catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");	}}

	@FXML
	public void loginButton(ActionEvent e) {
				
		String user = inputmanager.getText();
		
		String password = inputpass.getText();
		
		File file= new File("..\\Market\\items\\Lmanager.txt");
		boolean inputs= false;
		try {
			Scanner sc= new Scanner(file);
			while (sc.hasNext()) {
			String username= sc.next();
			System.out.println(username);
			String passFile=sc.next();
			System.out.println(passFile);
			if(username.equalsIgnoreCase(user) && password.equals(passFile)) {
				
				inputs= true;
			}
			else if(!username.equalsIgnoreCase(user)) {
					//JOptionPane.showMessageDialog(null,"Wrong username!");
					inputs=false;
				}
				else if(!password.equals(passFile))
						{
					//JOptionPane.showMessageDialog(null,"Wrong password!");
					inputs=false;
				}
			if(inputs)
				break;
			}
			if(inputs) {
			  try {
					Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
					Scene scene = new Scene(root);
					Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
					window.setScene(scene);
					window.show();
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");
			}
				}
		
			
			else {
				JOptionPane.showMessageDialog(null,"Wrong inputs!");
			}
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"File not found.");
		//} catch (IOException e1) {
			//JOptionPane.showMessageDialog(null,"File has problems.");}
		}}
	

	@FXML
	public void registerButton(ActionEvent event) {
			try {
				String path="..\\Market\\items\\manager.txt";
				Manager m=new Manager(inputid.getText(),inputname.getText(),inputsurname.getText(),"Tirane,Albania"," ","Manager",80,false);
				m.setPath(path);
				m.createFile();
				PrintWriter loginFile = null;
				loginFile = new PrintWriter(new FileWriter("..\\Market\\items\\Lmanager.txt",true));
				loginFile.append("\n"+inputname.getText()+inputsurname.getText()+" "+inputPass.getText());
				//save.append("\n"+ m.getId() +";"+m.getName()+";"+m.getSurname()+";"+m.getAddress() +";"+ m.getPhone()+";"+m.getPosition()+";"+m.getWork_h()+";"+m.isFees_paid()+";"+m.salary()+";");
				System.out.print("Done ");
				loginFile.close();
				inputid.clear();inputname.clear();inputsurname.clear();inputPass.clear();
			}  catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"File not found.");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,"File has problems.");
			}
			
	}	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
