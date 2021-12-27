package hw5;

public class Customerlist {
	
	private String firstname, lastname, email, phone;
	
	
	public Customerlist() {
		
		
		
	}
	
	
	public void setFirstname(String firstname) {
		this.firstname=firstname;
		
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname=lastname;
		
	}
	
	public String getLasttname() {
		return this.lastname;
	}
	
	public void setEmail(String email) {
		this.email=email;
		
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPhonenumber(String phone) {
		this.phone=phone;
		
	}
	
	public String getPhonenumber() {
		return this.phone;
	}
	
	public String  tostring2() {
		return (this.getFirstname() +  "," + this.getLasttname() + "," + this.getEmail()+ "," + this.getPhonenumber()); 
	}

}
