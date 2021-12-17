import java.io.PrintWriter;

public abstract class Employees {
	private String id;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String position;
	private int work_h;
	private boolean fees_paid;
	private String path;
	
	
	
	public Employees(String id, String name, String surname, String address, String phone, String position, int work_h, boolean fees_paid) {
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.position = position;
		this.work_h = work_h;
		this.fees_paid= fees_paid;
		
	}

	public Employees() {
		this.id=id;
		this.fees_paid= false;
	}
	


	public Employees(String id2, String name2, String surname2, String address2, String phone2) {
		this.id=id2;
		this.name=name2;
		this.surname=surname2;
		this.address=address2;
		this.phone=phone2;
		this.position="Manager";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getPosition() {
		return position;
	}

	public int getWork_h() {
		return work_h;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public void setId(String id) {
		this.id = id ;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setWork_h(int work_h) {
		this.work_h = work_h;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isFees_paid() {
			return fees_paid;
		
	}

	public void setFees_paid(String fees_paid) {
		if (fees_paid.equals("Paid"))
			this.fees_paid = true;
	}

	public abstract double salary();
	public abstract PrintWriter createFile() ;

	

	}

	

