package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookListBack {
	
	ArrayList<BookList> Book = new ArrayList<BookList>();
	
	 public void add(BookList sb) {
	      Book.add(sb);
	 }
	 
	 public ArrayList<BookList> getBooks() {
	      return Book;
	   }
	 
	 public BookList get(int i) {
		 
		 return Book.get(i);
		 
	 }
	 
	 
	 public void readtextToArraylist(String filename) {
		 try {
	        	Scanner scan1 = new Scanner(new File(filename));
	        	

	        	String textline1;
	        	
				
				while(scan1.hasNextLine()) {
					textline1 = scan1.nextLine();
					String[] input1 = textline1.split(",");
					int pagenumber = Integer.parseInt(input1[2]);
					int copies = Integer.parseInt(input1[4]);

					BookList book= new BookList(input1[0], input1[1], pagenumber,input1[3],copies);
					Book.add(book);
					}
				scan1.close();
	
				}
	        
	        catch(FileNotFoundException e) {System.out.println("File not found!");
		    }
		 
	 }


}
