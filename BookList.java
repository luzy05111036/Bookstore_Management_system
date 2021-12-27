package hw5;

public class BookList {
	private String title,author, publisher;
	private int pageNumber, copies;
	
	// constuctor
	
	public BookList(String title, String author, int pageNumber, String publisher, int copies) {
		this.title=title;
		this.author=author;
		this.pageNumber=pageNumber;
		this.publisher=publisher;
		this.copies=copies;	
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;

	}
	
	public int getpageNumber() {
		return this.pageNumber;
	}
	
	
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public int getCopies() {
		return this.copies;
		
	}
	
	public void rentCopies() {
		this.copies = this.getCopies()-1;
	};
	
	public void returnCopies() {
		this.copies = this.getCopies()+1;
	};
	
	public String  tostring2() {
		return (this.getTitle() +  "," + this.getAuthor() + "," + this.getpageNumber()+ "," + this.getPublisher()+ "," + this.getCopies()); 
	}

}
