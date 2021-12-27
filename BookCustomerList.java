package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookCustomerList  {
	
	ArrayList<BookCustomer> BKC = new ArrayList<BookCustomer>();
	
	public void add(BookCustomer bkc) {
	      BKC.add(bkc);
	     
	 }
	
	public void remove(BookCustomer bkc) {
	      BKC.remove(bkc);
	}
	      
	public int size() {
		      return BKC.size();    
	     
	 }
	
	public  BookCustomer get(int i) {
	      return BKC.get(i);    
   
}
	
	
	public ArrayList<BookCustomer> getBookCustomers() {
	      return BKC;
	   }
	 
	 
	 public void readtextToArraylist(String filename) {
		 try {
	        	Scanner scan1 = new Scanner(new File(filename));
	        	

	        	String textline1;
	        	
				
				while(scan1.hasNextLine()) {
					textline1 = scan1.nextLine();
					String[] input1 = textline1.split(",");
					

					BookCustomer bkc= new BookCustomer(input1[0], input1[1]);
					BKC.add(bkc);
					}
				scan1.close();
	
				}
	        
	        catch(FileNotFoundException e) {System.out.println("File not found!");
		    }
		 
	 }

}
