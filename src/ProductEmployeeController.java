import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProductEmployeeController implements Initializable {
	@FXML
	private Button addF ;
	@FXML
	private Button addB ;
	@FXML
	private Button addO, loadButton ;
	@FXML
	private TextField FId;
	@FXML
	private TextField BId;
	@FXML
	private TextField OId;
	@FXML
	private TextField Fname;
	@FXML
	private TextField Bname;
	@FXML
	private TextField Oname;
	@FXML
	private TextField foodQ;
	@FXML
	private TextField BQ;
	@FXML
	private TextField OtherQ;
	@FXML
	private TextField foodP;
	@FXML
	private TextField Bp;
	@FXML
	private TextField OtherP;
	@FXML
	private TextField TypeF;
	@FXML
	private TextField TypeB;
	@FXML
	private TextField TypeO;
	@FXML
	private TableView<Products> table;
	    @FXML
	    private TableColumn<Products, String> Id;

	    @FXML
	    private TableColumn<Products, String> Name;

	    @FXML
	    private TableColumn<Products, Integer> Quantity;

	    @FXML
	    private TableColumn<Products, Double> Price;

	    @FXML
	    private TableColumn<Products, String> Type;
	    @FXML
	    private Button add;

	    @FXML
	    private TextField tf_id;

	    @FXML
	    private TextField tf_name;

	    @FXML
	    private TextField tf_surname;

	    @FXML
	    private TextField tf_phone;

	    @FXML
	    private TextField tf_workh;

	    @FXML
	    private TextField tf_address;

	    @FXML
	    private ChoiceBox<String> chbox;

	    @FXML
	    private ChoiceBox<String> feeBox;
	    @FXML
	    private TableView<Employees> tableemps;
	    @FXML
	    private TableColumn<Employees, String> EmpId;
	    @FXML
	    private TableColumn<Employees, String> fullname;

	    @FXML
	    private TableColumn<Employees, String> fname;

	    @FXML
	    private TableColumn<Employees, String> lname;

	    @FXML
	    private TableColumn<Employees, String> address;

	    @FXML
	    private TableColumn<Employees, String> phone;

	    @FXML
	    private TableColumn<Employees, String> position;

	    @FXML
	    private TableColumn<Employees, Integer> workH;

	    @FXML
	    private TableColumn<Employees, Boolean> booleAN;

	    @FXML
	    private Button loadW;
	    @FXML
	    private Button back;
	    @FXML
	    private Button back1;
	    @FXML
	    private Button back2;
	    @FXML
	    private Button Delete;
	    @FXML
	    private Button DeleteB;

	@FXML
	public void deleteEmp() {
		ObservableList<Employees> selected, allEmps;
		allEmps= tableemps.getItems();
		selected = tableemps.getSelectionModel().getSelectedItems();
		selected.forEach(allEmps::remove);
		
	}
	@FXML
	public void saveButton() {
	  	String position = chbox.getValue();
	  	try {
	  	if (position.equals("Manager")) {
	  		Employees emp= new Manager();
	  		emp.setId(tf_id.getText());
	  		emp.setName(tf_name.getText());
	  		emp.setSurname(tf_surname.getText());
	  		emp.setAddress(tf_address.getText());
	  		emp.setPhone(tf_phone.getText());
	  		emp.setPosition(chbox.getValue());
	  		emp.setWork_h(Integer.parseInt(tf_workh.getText()) );
	  		emp.setFees_paid(feeBox.getValue());
	  		emp.setPath("..\\Market\\items\\manager.txt");
	  		PrintWriter file=emp.createFile();
	  		loadEmployees();}	  
	  	else {
	  		Employees emp= new Worker();
	  		emp.setId(tf_id.getText());
	  		emp.setName(tf_name.getText());
	  		emp.setSurname(tf_surname.getText());
	  		emp.setAddress(tf_address.getText());
	  		emp.setPhone(tf_phone.getText());
	  		emp.setPosition(chbox.getValue());
	  		emp.setWork_h(Integer.parseInt(tf_workh.getText()) );
	  		emp.setFees_paid(feeBox.getValue());
	  		emp.setPath("..\\Market\\items\\workers.txt");
	  		PrintWriter file=emp.createFile();
	  		loadEmployees();
	  	}
	  	}catch(NumberFormatException e) {
	  		JOptionPane.showMessageDialog(null,"Error in your inputs.Check again.");
	  		
	  	}catch(NullPointerException e) {
	  		JOptionPane.showMessageDialog(null,"Fill all the fields.");
	  	}catch(IllegalArgumentException e) {
	  		JOptionPane.showMessageDialog(null,"Error! Error!");
	  	}
	  	tf_id.clear();
	  		tf_name.clear();
	  		tf_surname.clear();
	  		tf_address.clear();
	  		tf_phone.clear();
	  		tf_workh.clear();
}
	public void loadEmployees()  {
		  String[] paths= {"..\\Market\\items\\manager.txt","..\\Market\\items\\workers.txt"};
		    
		    ObservableList<Employees> listemp = FXCollections.observableArrayList();
		    String id, name,surname,address, phone,position;
			boolean paid;
			int workh;
			try {for (int i=0;i<2;i++) {
			File file= new File(paths[i]);
		    Scanner sc= new Scanner(file);
		    sc.useDelimiter(";");
		    
		    while(sc.hasNext()) {
		    	id=sc.next();
		    	name=sc.next();
		    	surname=sc.next();
		    	address=sc.next();
		    	phone=sc.next();
		    	position=sc.next();
		    	workh = Integer.parseInt(sc.next());
		    	paid=Boolean.parseBoolean(sc.next());
		    	String salary = sc.next(); 
		    	System.out.print(id+" "+ name+" " +surname+" " +address+" " + phone+" " +position+" " +workh+" " +paid+" " +salary+" ");
		    	if (i==0) {
		    	Employees emp= new Worker(id,name,surname,address,phone,position,workh,paid);
		    	listemp.add(emp);
		     }
		    	else {
		    	Employees emp= new Manager(id,name,surname,address,phone,position,workh,paid);
		    	listemp.add(emp);
		    	}
		    	
		    }
		    	   
	
		    	tableemps.setItems(listemp);}}
			catch (FileNotFoundException e) {
		JOptionPane.showMessageDialog(null,"File not found.");
	} catch (IOException e) {
		JOptionPane.showMessageDialog(null,"File has problems.");
	}catch(NoSuchElementException e) {
		JOptionPane.showMessageDialog(null,"Check file for empty spaces.");
	}catch(NumberFormatException e) {
		JOptionPane.showMessageDialog(null,"Check your input.");}
	}
	public void deleteProd() {
		ObservableList<Products> selected, allProd;
		allProd= table.getItems();
		selected = table.getSelectionModel().getSelectedItems();
		selected.forEach(allProd::remove);
		
	}
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
	public void AddFood(ActionEvent e) {
			Products product = new Products();
	  		
	  		product.setProduct_id(FId.getText());
	  		product.setProduct_name(Fname.getText());
	  		product.setAdded_prod(Integer.parseInt(foodQ.getText()));
	  		product.setPrice(Double.parseDouble(foodP.getText()));
	  		product.setType("Food");
	  		try {
	  		product.setPath("..\\Market\\items\\Products.txt");
	  		PrintWriter file=product.createFile();
		}catch(NumberFormatException e1) {
		  		JOptionPane.showMessageDialog(null,"Error in your inputs.Check again.");
		  		
		  	}catch(NullPointerException e1) {
		  		JOptionPane.showMessageDialog(null,"Fill all the fields.");
		  	}catch(IllegalArgumentException e1) {
		  		JOptionPane.showMessageDialog(null,"Error! Error!");
		  	}
		  		FId.clear();
		  		Fname.clear();
		  		foodQ.clear();
		  		foodP.clear();
		  		}
	  
	
	public void AddBeverage(ActionEvent e) {
		Products product = new Products();
  		product.setProduct_id(BId.getText());
  		product.setProduct_name(Bname.getText());
  		product.setAdded_prod(Integer.parseInt(BQ.getText()));
  		product.setPrice(Double.parseDouble(Bp.getText()));
  		product.setType("Beverages");
  		try {
  		product.setPath("..\\Market\\items\\Products.txt");
  		PrintWriter file=product.createFile();}
  		catch(NumberFormatException e2) {
	  		JOptionPane.showMessageDialog(null,"Error in your inputs.Check again.");
	  		
	  	}catch(NullPointerException e2) {
	  		JOptionPane.showMessageDialog(null,"Fill all the fields.");
	  	}catch(IllegalArgumentException e2) {
	  		JOptionPane.showMessageDialog(null,"Error! Error!");
	  	}
  		BId.clear();
  		Bname.clear();
  		BQ.clear();
  		Bp.clear();
}
  
	public void AddOther(ActionEvent e) {
		Products product = new Products();
  		
  		product.setProduct_id(OId.getText());
  		product.setProduct_name(Oname.getText());
  		product.setAdded_prod(Integer.parseInt(OtherQ.getText()));
  		product.setPrice(Double.parseDouble(OtherP.getText()));
  		product.setType("Other");
  		try {
  	  		product.setPath("..\\Market\\items\\Products.txt");
  	  		PrintWriter file=product.createFile();}
  	  		catch(NumberFormatException e2) {
  		  		JOptionPane.showMessageDialog(null,"Error in your inputs.Check again.");
  		  		
  		  	}catch(NullPointerException e2) {
  		  		JOptionPane.showMessageDialog(null,"Fill all the fields.");
  		  	}catch(IllegalArgumentException e2) {
  		  		JOptionPane.showMessageDialog(null,"Error! Error!");
  		  	}
  	  		OId.clear();
  	  		Oname.clear();
  	  		OtherQ.clear();
  	  		OtherP.clear();
}

	public void loadProducts()  {
		  
			  String path= "..\\Market\\items\\Products.txt";
		    
		    ObservableList<Products> list = FXCollections.observableArrayList();
		    String id, name, type,quantity,price;
			try {
			File file= new File(path);
		    Scanner sc= new Scanner(file);
		    sc.useDelimiter(";");
		    
		    while(sc.hasNext()) {
		    	id=sc.next();
		    	name=sc.next();
		    	quantity =sc.next();
		    	price=sc.next();
		    	type=sc.next();
		    	
		    	System.out.print(id+" "+ name+" " +quantity+" " +price+" " + type+" " );
		    	int new_quantity=Integer.parseInt(quantity);
		    	double new_price=Double.parseDouble(price);
		    	Products prd = new Products( id, name,new_quantity,new_price,type);
		    	list.add(prd);
		    	
		     }
		    	
		    	table.setItems(list);}
			catch (FileNotFoundException e2) {
		JOptionPane.showMessageDialog(null,"File not found.");
	} catch (IOException e) {
		JOptionPane.showMessageDialog(null,"File has problems.");
	}catch(NoSuchElementException e2) {
		JOptionPane.showMessageDialog(null,"Check file for empty spaces.");
	}catch(NumberFormatException e2) {
		JOptionPane.showMessageDialog(null,"Check your input.");
		}
		   }
		  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		  Id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
	      Name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
	      Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	      Price.setCellValueFactory(new PropertyValueFactory<>("price"));
	      Type.setCellValueFactory(new PropertyValueFactory<>("type"));
	      EmpId.setCellValueFactory(new PropertyValueFactory<>("id"));
	      fname.setCellValueFactory(new PropertyValueFactory<>("name"));
	      lname.setCellValueFactory(new PropertyValueFactory<>("surname"));
	      address.setCellValueFactory(new PropertyValueFactory<>("address"));
	      phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
	      position.setCellValueFactory(new PropertyValueFactory<>("position"));
	      workH.setCellValueFactory(new PropertyValueFactory<>("work_h"));
	      booleAN.setCellValueFactory(new PropertyValueFactory<>("fees_paid"));
	      chbox.getItems().addAll("Manager","Cashier", "Helper");
	      chbox.setValue("Manager");
	      feeBox.getItems().addAll("Paid","Not");
			feeBox.setValue("Not");
			loadEmployees();
			loadProducts();}
}
