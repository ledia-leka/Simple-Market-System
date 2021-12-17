import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CashierController implements Initializable {
	 @FXML
	    private TableView<Products> table;
	 @FXML
	 private TextArea bill;
	 	@FXML
	 	private Button back;
	 	@FXML
	 	private Button SB;
	 	@FXML
	 	private Button AddToBill;			
	    @FXML
	    private TextField search;
	    @FXML
	    private TextField numberProd;
	    @FXML
	    private Button getBill;
	 	@FXML
	    private TableColumn<Products, String> Id;
	 	@FXML
	 	private TextField totPrice;
	 	@FXML
	 	private Button printbill;
	    @FXML
	    private TableColumn<Products, String> Name;

	    @FXML
	    private TableColumn<Products, Double> Price;
	    
	    @FXML
	    ObservableList<Products> list;
	    int noProd=0;
	    double totalPrice=0;
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		@FXML
	    public void addToFile() {
			
			try {PrintWriter file=null;
				//file = new PrintWriter(new FileWriter("..\\Market\\items\\bills.txt",true));
			 ObservableList<Products> allProd;
			
			Products selected;
			allProd= table.getItems();
			selected = table.getSelectionModel().getSelectedItem();
			String id=selected.getProduct_id();
			String name=selected.getProduct_name();
			Double price=selected.getPrice();
			//selected.getProduct_id()+";"+selected.getProduct_name()+";"+selected.getPrice()+";"
			//file.write(id+";"+name+";"+price+";");
			noProd++;
			totalPrice+=price;
			numberProd.clear();
			numberProd.appendText(""+noProd);
			totPrice.clear();
			totPrice.appendText(totalPrice+" Lek");
			bill.appendText(name+"\t\t"+ price+"\n");
			//file.close();
			
		//	} catch (FileNotFoundException e) {
			//	JOptionPane.showMessageDialog(null,"File not found.");
			//} catch (IOException e1) {
				//JOptionPane.showMessageDialog(null,"File has problems.");
			}catch( RuntimeException e2){
				JOptionPane.showMessageDialog(null,"Cannot get information.");
			}
}
	   @FXML
	   public void getBill() {
		 
		   bill.appendText("\n___________________________");
		   bill.appendText("\nTotal price: "+ totPrice.getText());
		   bill.appendText("\n___________________________");
		   bill.appendText("\nThank you for shopping in our market.");
		   bill.appendText("\nAddress: Tirane Albania.");
		   bill.appendText("\nPhone: 063258965");
	   }
	@FXML
	public void loadProducts()  {
		File fileR= new File("..\\Market\\items\\receipt.txt");
				fileR.delete();
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
	    	
	    	double new_price=Double.parseDouble(price);
	    	Products prd = new Products( id, name,new_price);
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
	
	
	@FXML
	    public void search() {
	    	String searchId=search.getText();
	    	System.out.print(searchId);
	    	
	    	
	    	  
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
		    	
		    	double new_price=Double.parseDouble(price);
		    	Products prd = new Products( id, name,new_price);
		    	list.add(prd);
		    table.setItems(list);
	    	
	    	
	    	  FilteredList<Products> filteredData = new FilteredList<>(list, b -> true);
	  		
	  		search.textProperty().addListener((observable, oldValue, newValue) -> {
	  			filteredData.setPredicate(Products -> {
	  							
	  				if (newValue == null || newValue.isEmpty()) {
	  					return true;
	  				}
	  				
	  				String lowerCaseFilter = newValue.toLowerCase();
	  				
	  				if (Products.getProduct_id().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
	  					return true; 
	  				} else if (Products.getProduct_name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
	  					return true;
	  				}
	  				     else  
	  				    	 return false; 
	  			});
	  		});
	  		
	  		// 3. Wrap the FilteredList in a SortedList. 
	  		SortedList<Products> sortedList = new SortedList<>(filteredData);
	  		
	  		// 4. Bind the SortedList comparator to the TableView comparator.
	  		// 	  Otherwise, sorting the TableView would have no effect.
	  		sortedList.comparatorProperty().bind(table.comparatorProperty());
	  		
	  		
	  		table.setItems(sortedList);
		    }}catch (FileNotFoundException e2) {
	  			JOptionPane.showMessageDialog(null,"File not found.");
	  		} catch (IOException e) {
	  			JOptionPane.showMessageDialog(null,"File has problems.");
	  		}catch(NoSuchElementException e2) {
	  			JOptionPane.showMessageDialog(null,"Check file for empty spaces.");
	  		}catch(NumberFormatException e2) {
	  			JOptionPane.showMessageDialog(null,"Check your input.");
	  			}                
	          
	      }    
	@FXML
		public void print(ActionEvent event) {
	 {try {
				String text = bill.getText();
				PrintWriter newfile = new PrintWriter(new FileWriter("..\\Market\\items\\receipt.txt",true));
				newfile.append(text);
				newfile.close();
				Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));
				Scene sc = new Scene(root);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(sc);
				window.show();
			}catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Something not pleasant has happened to this program.");
			}}
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadProducts();
		search();
		 Id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
	      Name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
	      Price.setCellValueFactory(new PropertyValueFactory<>("price"));
	      bill.appendText("\n\t"+ dtf.format(now)+"\n");
	}
	
	

}
