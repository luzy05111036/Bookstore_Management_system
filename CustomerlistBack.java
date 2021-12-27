package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerlistBack {
	

	
	ArrayList<Customerlist> Customer= new ArrayList<Customerlist>();
	
	 public void add(Customerlist cl) {
	      Customer.add(cl);
	 }
	 
	 
	 
	 public ArrayList<Customerlist> getCustomers() {
	      return Customer;
	   }
	 
	 
	 public void readtextToArraylist(String filename) {
		 try {
	        	Scanner scan = new Scanner(new File(filename));
	        	

	        	String textline;
	        	
				
	        	while(scan.hasNextLine()) {
					textline = scan.nextLine();
					String[] input = textline.split(",");
					

					Customerlist customer= new Customerlist();
					
					customer.setFirstname(input[0]);
					customer.setLastname(input[1]);
					customer.setEmail(input[2]);
					customer.setPhonenumber(input[3]);
					
					Customer.add(customer);
					}
				scan.close();
	
				}
	        
	        catch(FileNotFoundException e) {System.out.println("File not found!");
		    }
		 
	 }
	 
	 

}


