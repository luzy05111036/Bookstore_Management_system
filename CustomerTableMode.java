package hw5;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomerTableMode  extends AbstractTableModel {
	
	
	private String[] columnNames = {"Fistname","Lastname","Email", "Phone#"};
	private ArrayList<Customerlist> myList;
	
	public CustomerTableMode (CustomerlistBack cList) {
		this.myList = cList.getCustomers();
	}
	
	public int getColumnCount() {
	      return columnNames.length;
	   }
	
	
	public int getRowCount() {
	      int size;
	      if (myList == null) {
	         size = 0;
	      }
	      else {
	         size = myList.size();
	      }
	      return size;
	}
	
     public void addRow(Customerlist c) {
		
		this.myList.add(c);
        
        this.fireTableDataChanged();
        }
	
	public Object getValueAt(int row, int col) {
	      Object temp = null;
	      if (col == 0) {
	         temp = myList.get(row).getFirstname();
	      }
	      else if (col == 1) {
	         temp = myList.get(row).getLasttname();
	      }
	      else if (col == 2) {
	         temp = myList.get(row).getEmail();
	      }
	      else if (col == 3) {
		         temp = myList.get(row).getPhonenumber();
	      }
	      
	         
	      return temp;
		  }
			         
	
	public String getColumnName(int col) {
	      return columnNames[col];
	   }

}
