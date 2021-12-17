import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Products {
	private String product_id;
	private String product_name;
	private int quantity;
	private double price;
	private String type;
	private int added_prod;
	private String path;
	
	public Products(String product_id, String product_name, int quantity, double price, String type, int added_prod,String path) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.added_prod = added_prod;
		this.quantity = quantity+this.added_prod;
		this.price = price;
		this.type = type;
		
		this.path= path;
	}
	public Products(String product_id,String product_name, int quantity, double price,String type) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
	}
	public Products(String product_id,String product_name, double price) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
	}
	public Products() {
		
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String string) {
		this.product_id = string;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity+this.getAdded_prod();
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAdded_prod() {
		return added_prod;
	}

	public void setAdded_prod(int added_prod) {
		this.added_prod = added_prod;
	}
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PrintWriter createFile() {
		PrintWriter newfile=null;
		try {
			newfile = new PrintWriter(new FileWriter(this.getPath(),true));
			newfile.append("\n"+this.getProduct_id() +";"+this.getProduct_name()+";"+this.getQuantity()+";"+this.getPrice()+";"+this.getType()+";");
			System.out.print("Done");
			newfile.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"File not found.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"File has problems.");
		}
		return newfile;
		
	}
	
}
