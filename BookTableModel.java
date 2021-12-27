package hw5;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel{
	
	private String[] columnNames = {"Title","Author","Page#", "Publisher","Copies in store"};
	private ArrayList<BookList> myListarr;
	
	public BookTableModel(BookListBack bkList) {
		this.myListarr = bkList.getBooks();
	}
	
	public int getColumnCount() {
	      return this.columnNames.length;
	   }
	
	
	public int getRowCount() {
	      int size;
	      if (this.myListarr == null) {
	         size = 0;
	      }
	      else {
	         size = this.myListarr.size();
	      }
	      return size;
	}
	
	public void addRow(BookList b) {
		
		this.myListarr.add(b);
        
        this.fireTableDataChanged();
        }
	
	
	public Object getValueAt(int row, int col) {
	      Object temp = null;
	      if (col == 0) {
	         temp = this.myListarr.get(row).getTitle();
	      }
	      else if (col == 1) {
	         temp = this.myListarr.get(row).getAuthor();
	      }
	      else if (col == 2) {
	         temp = this.myListarr.get(row).getpageNumber();
	      }
	      else if (col == 3) {
		         temp = this.myListarr.get(row).getPublisher();
	      }
		         
		  else if (col == 4) {
			  temp = this.myListarr.get(row).getCopies();  
		  }
			         
	      return temp;
	   }
	
	public String getColumnName(int col) {
	      return this.columnNames[col];
	   }

}
