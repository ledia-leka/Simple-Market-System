import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Manager extends Employees {
	
	Manager(){
		super();
		
		
	}
	
	Manager(String id,String name,String surname,String address,String phone,String position,int work_h, boolean fees_paid){
		super(id,name,surname,address,phone,position, work_h, fees_paid);
		}
	Manager(String id, String name, String surname, String address, String phone){
		super(id,name,surname,address,phone);
		
		
	}
	
	@Override
	public double salary() {
		double salary = this.getWork_h() * 15;
		return salary;
	}
	@Override
	public PrintWriter createFile() {
		PrintWriter newfile=null;
		try {
			newfile = new PrintWriter(new FileWriter(this.getPath(),true));
			newfile.append("\n"+this.getId()+";"+this.getName()+";"+this.getSurname()+";"+this.getAddress()+";"+ this.getPhone()+";"+this.getPosition()+";"+this.getWork_h()+";"+this.isFees_paid()+";"+this.salary()+";");
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
