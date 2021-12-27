package hw5;

public class bookCustomer {

	private String title, lastname;
	
	
	
	bookCustomer(String lastname, String title){
		
		this.title=title;
		this.lastname=lastname;
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getlastname() {
		return this.lastname;
	}
	
	public String  tostring2() {
		return (this.getlastname()+ ","+ this.getTitle()); 
	}
	
	
}
