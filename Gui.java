package hw5;

import javax.swing.*;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.im.InputContext;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.event.*;

public class Gui extends JFrame implements  ListSelectionListener {
	
	private JTable table;
	
	private TableRowSorter<BookTableModel>  sorter;
	private JTextField filterText,filterText1, showbookcustomer, searchcustomer,inputbook,inputcustomer; 
	
	private JList CList,BList,BCList;
	private JButton button1, button2,button3,button4,button5,button6, button7,addbookbutton,addcustomerbutton;
	private JLabel JL1,JL2,JL3,JL4;
	private ArrayList<String> CMList, BKList;
	private  CustomerlistBack myList1;
	private  BookListBack myList,BLB;
	private BookCustomerList BCLo,BCLo1,BCLo2;
	private BookList BL;
	private Customerlist CL;
	private PrintWriter pw,pw1,pw2;
	private DefaultListModel<String> BkCuList;
	
	
	
	
	public Gui(String title) {
		super(title);
		setBounds(10,10,400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// build JTabbedPane        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        JPanel panel1 = new JPanel();
//        
        panel1 .setPreferredSize(new Dimension(800, 650));
        
        tabbedPane.addTab("Books", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JPanel panel3 = new JPanel();
        panel3 .setPreferredSize(new Dimension(800, 650));
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_3);
        tabbedPane.addTab("Rent & Return", panel3);
        
        JPanel panel2 = new JPanel();;
        tabbedPane.addTab("Customer", panel2);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        
        
		
//		table for the booklist
		
		myList = new BookListBack();
        myList.readtextToArraylist("Booklist.txt");
        
        BookTableModel tableModel = new BookTableModel(myList);
        TableRowSorter<BookTableModel>  sorter = new TableRowSorter<BookTableModel>(tableModel);
        
        JTable table = new JTable(tableModel);
        table.setRowSorter(sorter);
        table.getTableHeader().setFont(new Font("Segoe UI", 1 , 12));
//        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(600,500));
//        table.setFillsViewportHeight(true);
        JPanel panel12 = new JPanel();
        panel12.add(scrollPane);
        
   // set the filter function for search book
        
      
        
        
        JLabel l1 = new JLabel("Search book by title:");
        panel1.add(l1);
        filterText = new JTextField(15);
       button1 = new JButton("Search");
        button1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
            
            RowFilter<BookTableModel, Object> rf = RowFilter.regexFilter(text);
            sorter.setRowFilter(rf);
            
          }
        });
        
        button2 = new JButton("Back to Booklist");
        button2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  sorter.setRowFilter(null);
          }
        });
        
        // add new book
        
        addbookbutton = new JButton("Add new book");
        inputbook = new JTextField("Input new book information here, delimit by , ", 30);
        
        JButton clearbutton2=new JButton("Clear");
        clearbutton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	inputbook.setText(" ");
            }
            });
        addbookbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	
    			// update the Booklist.txt when you add a book
//    		    BLB = new BookListBack();
//            	BLB.readtextToArraylist("Booklist.txt");
            	
            	String [] input =inputbook.getText().toString().split(",");//            	myList.add(new BookList(input[0],input[1],Integer.parseInt(input[2]),input[3],Integer.parseInt(input[4])));
            	
            	tableModel.addRow(new BookList(input[0],input[1],Integer.parseInt(input[2]),input[3],Integer.parseInt(input[4])));
            	
                
                
            	try {
    				pw = new PrintWriter("Booklist.txt");
    			} catch (FileNotFoundException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	for(BookList b: myList.getBooks())
            	 {
            	     pw.println(b.tostring2());       
            	 }
            	pw.close();
            	
            	JOptionPane.showMessageDialog(panel1, "Success!");
            }
        });
        
        
        // add components to panel
        
        JPanel panel11 = new JPanel();
        JPanel panel13 = new JPanel();
        panel11.setLayout(new FlowLayout());
        panel11.add(l1);
        panel11.add(filterText);
       panel11.add(button1);
       panel11.add(button2);
        
       panel13.setLayout(new FlowLayout());
       panel13.add(inputbook);
       panel13.add(addbookbutton);
       panel13.add(clearbutton2);
       
       panel11 .setPreferredSize(new Dimension(600, 50));
       panel12 .setPreferredSize(new Dimension(600, 400));
       panel13 .setPreferredSize(new Dimension(600, 30));
//       panel12.setLocation(10, 150);
        panel1.add(panel11, BorderLayout.NORTH);
        panel1.add(panel12,BorderLayout.CENTER);
        panel1.add(panel13,BorderLayout.SOUTH);
//    -------------------
        // table for customerlist
        
        myList1 = new CustomerlistBack();
        myList1.readtextToArraylist("Customerlist.txt");
        
        CustomerTableMode tableModel1 = new CustomerTableMode(myList1);
        TableRowSorter<CustomerTableMode>  sorter1 = new TableRowSorter<CustomerTableMode>(tableModel1);
        
        JTable table1 = new JTable(tableModel1);
        table1.setRowSorter(sorter1);
        table1.getTableHeader().setFont(new Font("Segoe UI", 1 , 12));
//        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        
        scrollPane1.setPreferredSize(new Dimension(600,450));
//        table.setFillsViewportHeight(true);
        panel2.add(scrollPane1);
        
      // filter for search function
        
      //Create a separate form for filterText and statusText
        
        JLabel l2 = new JLabel("Search Customer by name:", SwingConstants.TRAILING);
        
        filterText1 = new JTextField(15);
        button3 = new JButton("Search");
        button3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String text1 = filterText1.getText();
            
            RowFilter<CustomerTableMode, Object> rf1 = RowFilter.regexFilter(text1);
            sorter1.setRowFilter(rf1);
            
          }
        });
        
        button4 = new JButton("Back to Customerlist");
        button4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  sorter1.setRowFilter(null);
          }
        });
        
 // add new Customer
        
        addcustomerbutton = new JButton("Add new Customer");
        JButton clearbutton1=new JButton("Clear");
        clearbutton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	inputcustomer.setText(" ");
            }
            });
        
        inputcustomer = new JTextField("Input new customer information here, delimit by ,",30);
        addcustomerbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	
    			// update the Booklist.txt when you add a book
//    		    CLB= new CustomerlistBack();
//    		    		
//            	CLB.readtextToArraylist("Customerlist.txt");
            	CL= new Customerlist();
            	String [] input =inputcustomer.getText().toString().split(",");
            	
            	CL.setFirstname(input[0]);
            	CL.setLastname(input[1]);
            	CL.setEmail(input[2]);
            	CL.setPhonenumber(input[3]);
            	
            	tableModel1.addRow(CL);
            	
            	
            	try {
    				pw = new PrintWriter("Customerlist.txt");
    			} catch (FileNotFoundException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	for(Customerlist b: myList1.getCustomers())
            	 {
            	     pw.println(b.tostring2());       
            	 }
            	pw.close();
            	
            	JOptionPane.showMessageDialog(panel2, "Success!");
            }
        });
        
        
        // add components to panel2
        
        JPanel panel21 = new JPanel();
        JPanel panel22 = new JPanel();
        
        panel21.setLayout(new FlowLayout());
        panel21.add(l2);
        panel21.add(filterText1);
        
       panel21.add(button3, BorderLayout.SOUTH);
       panel21.add(button4, BorderLayout.CENTER);

       panel22.setLayout(new FlowLayout());
       panel22.add(inputcustomer);
       panel22.add(addcustomerbutton);
       panel22.add(clearbutton1);
         
       
        panel21.setPreferredSize(new Dimension(800,50));
        panel22.setPreferredSize(new Dimension(800,50));
        panel2.add(panel21, BorderLayout.NORTH);
        panel2.add(scrollPane1,BorderLayout.CENTER);
        panel2.add(panel22, BorderLayout.SOUTH);
     // Jlist1 and Jlist2 for display the Lastname and book titles
        CMList= new ArrayList<String>();
        BKList= new ArrayList<String>();
        
        
        
        for(Customerlist c: myList1.getCustomers()) {
        	CMList.add(c.getFirstname()+ ","+ c.getLasttname());
        }
        
        for(BookList b: myList.getBooks()) {
        	BKList.add(b.getTitle());
        }
        	
        
        CList = new JList(CMList.toArray());
        BList = new JList(BKList.toArray());
        JL1 = new JLabel("Book List");
        JL2 = new JLabel("Customer List");
        
        CList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        BList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
        
        showbookcustomer = new JTextField("                      " +"|" ,15);
        
        CList.addListSelectionListener(this);
        BList.addListSelectionListener(this);
        
        // set the rent function for rent books
        button5= new JButton();
        
  
        button5.setText("Rent book");
        
        button5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int copynumber=0;
        		
        		int k=0;
            	for(int p=0;p<myList.getBooks().size();p++) {
            		
                	if(myList.get(p).getTitle().equals(BList.getSelectedValue())) {
                		copynumber=copynumber + myList.get(p).getCopies();
                		k=p;
                	}
                	System.out.println(myList.getBooks().get(k).getTitle()+ "=" + BList.getSelectedValue());
                	System.out.println(k);
                }
                		if(copynumber>0) {
                			JOptionPane.showMessageDialog(panel3, "Success!");
                			
                			myList.get(k).rentCopies();
                			
                			// update the BookCustomerlist.txt when you rent a book
                			BCLo = new BookCustomerList();
                        	BCLo.readtextToArraylist("BookCustomerlist.txt");
                        	BookCustomer bc;
                        	String [] clickname =CList.getSelectedValue().toString().split(",");
                        	bc = new BookCustomer(clickname[1],BList.getSelectedValue().toString());
                        	BCLo.add(bc);
                        	
                        	try {
                				pw1 = new PrintWriter("BookCustomerlist.txt");
                			} catch (FileNotFoundException e1) {
                				// TODO Auto-generated catch block
                				e1.printStackTrace();
                			}
                        	
                        	for( BookCustomer bb:BCLo.getBookCustomers())
                        	 {
                        	     pw1.println(bb.tostring2());       
                        	 }
                        	pw1.close();
                        	
                		}
                		else JOptionPane.showMessageDialog(panel3, "Fail!");
                    		
            	
            	
    			try {
    				pw = new PrintWriter("Booklist.txt");
    			} catch (FileNotFoundException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	for(BookList b: myList.getBooks())
            	 {
            	     pw.println(b.tostring2());       
            	 }
            	pw.close();
            	
            	
            }
        	
        	
        });
        
     // set the return function for return book
        button6= new JButton();
        
        
        button6.setText("Return book");
        
        button6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// check your rent and update the arraylist BLC2, which store your bookcustomer information 
            	BCLo2 = new BookCustomerList();
            	BCLo2.readtextToArraylist("BookCustomerlist.txt");
            	int checkyourrent=0;
            	String [] clickname =CList.getSelectedValue().toString().split(",");
            	for(int i = 0; i < BCLo2.size(); i++)
            	 {
            		if(BCLo2.get(i).getlastname().equals(clickname[1]) && BCLo2.get(i).getTitle().equals(BList.getSelectedValue())) {
            			BCLo2.remove(BCLo2.get(i));
            			checkyourrent++;
            			
            		}
            	}
            	
            // determine whether update Booklist.txt and BookCustomerlist.txt
            	
            	if(checkyourrent>0) {
            		
            		
            		
            		// update copies numbers
            		
            		for(BookList b: myList.getBooks()) {
                        
                		
                    	if(b.getTitle().equals(BList.getSelectedValue())) {
                    		b.returnCopies();
                    		
                        	}	
                	}
            		
            		//write the update to BookList.txt file-----
        			try {
        				pw = new PrintWriter("Booklist.txt");
        			} catch (FileNotFoundException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                	for(BookList b: myList.getBooks())
                	 {
                	     pw.println(b.tostring2());       
                	 }
                	pw.close();
                	//----------
                	
                	// update the BookCustomer.txt(remove this book from record)
                	
                	try {
        				pw2 = new PrintWriter("BookCustomerlist.txt");
        			} catch (FileNotFoundException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                	
                	for( BookCustomer bbb:BCLo2.getBookCustomers())
                	 {
                	     pw2.println(bbb.tostring2());       
                	 }
                	pw2.close();
                	//---------
                	
                	JOptionPane.showMessageDialog(panel3, "Return succeed!"); // notify users
            		
            	}
            	 // notify the users if  the book that you are returning is not from our store
            	else {
            		JOptionPane.showMessageDialog(panel3, "You don't borrow this book");
            	}
            	
           
            	
            }
        	
        	
        	
        });
        
   // Jlist for displaying the search customers for his rent book
        
        JL3= new JLabel("Your rent book");
        BkCuList = new DefaultListModel<String>();
        
        searchcustomer = new JTextField(8);
       
        BCList= new JList(BkCuList);
        
  	    
        
        
        button7 = new JButton("Search ");
        
        button7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		BCLo1 = new BookCustomerList();
                BCLo1.readtextToArraylist("BookCustomerlist.txt");
        		
        		
        		BkCuList.clear();
        		
              for(BookCustomer bc:BCLo1.getBookCustomers()) {
              	if(bc.getlastname().equals(searchcustomer.getText())) {
              		
              		
              		BkCuList.addElement(bc.getTitle());
              		
              		
              	}
              	
              }
               
        	 
              
            }
        	
        	 
        	
        });
        
         
       //      add the elements to panel3(rent panel)  
        
        JPanel panel31 = new JPanel();
        panel31.setLayout(new FlowLayout());
        panel31.add(showbookcustomer);
        panel31.add(button5);
        panel31.add(button6);
        panel31.add(searchcustomer);
        panel31.add(button7);
        panel31.setPreferredSize(new Dimension(850,40));
        
        JPanel panel32 = new JPanel();
        panel32.setLayout(new BorderLayout());;
        JScrollPane JS1= new JScrollPane(BList);
        JS1.setPreferredSize(new Dimension(180,450));
//        JL1.setPreferredSize(new Dimension(150,30));
        panel32.add(JL1, BorderLayout.NORTH);
        panel32.add(JS1, BorderLayout.CENTER);
        
        JPanel panel33 = new JPanel();
        panel33.setLayout(new BorderLayout());
        JScrollPane JS2= new JScrollPane(CList);
        JS2.setPreferredSize(new Dimension(180,450));
//        JL2.setPreferredSize(new Dimension(150,30));
        panel33.add(JL2,BorderLayout.NORTH);
        panel33.add(JS2,BorderLayout.CENTER);
        
        JPanel panel34 = new JPanel();
        panel34.setLayout(new BorderLayout());
        JScrollPane JS3= new JScrollPane(BCList);
//        JL3.setPreferredSize(new Dimension(150,30));
        JS3.setPreferredSize(new Dimension(180,450));
        panel34.add(JL3,BorderLayout.NORTH);
        panel34.add(JS3,BorderLayout.CENTER);
        
        
        JPanel panel3234 = new JPanel();
        panel3234.setLayout(new FlowLayout());
        
        panel3234.add(panel33);
        panel3234.add(panel32);
        
        panel3234.add(panel34);
        
        ((FlowLayout)panel3234.getLayout()).setHgap(30);
        panel3234.setPreferredSize(new Dimension(800,450));
        
        
        panel3.setLayout(new BorderLayout());
        
        panel3.add(panel31, BorderLayout.NORTH);
        
        panel3.add(panel3234, BorderLayout.CENTER);
        
        
        
        
        //------------------
        
  // add the tabbedpane to JFrame
        
        add(tabbedPane);
        setSize(new Dimension(850,650));
    
	}
	
        public void valueChanged(ListSelectionEvent e)
        {
            //set the text of JTextField to the selected value of lists
            showbookcustomer.setText(CList.getSelectedValue() + " | " + BList.getSelectedValue());
             
        }
        

        
	public static void main(String[] args) {
	      Gui myApp = new Gui("Book system");
	      
	      myApp.setVisible(true);
	      
	      
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
