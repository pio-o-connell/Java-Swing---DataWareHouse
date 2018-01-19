package WareHouse;


//import TableWindow1;

//import Mainframe;

//import TableFilterDemo1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

/*---------------------------------------------------------------------------------------
/*
 * The 'Mainframe' class gets on with the main business of rendering the frame.
 * It invokes 3 other classes DetailPanel for the new data to be entered.
 * and TableWindow1 and TableWindow2 for mirroring the data in the main classes
 * 
 ---------------------------------------------------------------------------------------*/


public class Mainframe extends JFrame {
	private static final long serialVersionUID = 1L;
	private DetailsPanel detailsPanel;
//	private TableFilterDemo detailTable;

	/* These static Array is used to keep all the records read in from Dummy class */
	/* The static variables hold the current selections in the 3 selection windows */
	/* Because the window is laid out across different files, static variables were used /*
	 *  Without implementing abstract classes it was necessary to use static arrays,variables etc */
	
//	public static ArrayList<history> history11 = new ArrayList<history>();
// static ArrayList<Item> Items11 = new ArrayList<Item>();
//	public static ArrayList<Company> Company11 = new ArrayList<Company>();
	public static int companyIndex=0,itemIndex=0,historyIndex=0;
	
	/* Dummy Class builds the entire structure 'correctly' as specified in the Assignment Semester 2 */
	
//	private DummyClass dummyclass = new DummyClass();
	
	
	public static TableWindow1 detailTable1; //  contains the company table and items table
	public static TableWindow2 detailTable2; //  contains the history table
	public static DetailsPanel detailPanel; // contains the table for new record entry

	public static int historyRecordNo=30;
	
	/*-------------------------------------------------------
	 * These could be implemented using an abstract class
	 --------------------------------------------------------*/

	
		
		public Mainframe(String title) throws Exception{
			super(title);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse","root","root");
	//		maindriver.Company11 = dummyclass.getCompany11(); // build the data structure
			
			
			
			//Necessary for initial table window display
			final ArrayList<Company> tableCompanyPointer = maindriver.Company11;  //pointer to first element of Company data structure
			final ArrayList<Item>tableItemPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems(); 
			// pointer to first item element of the first company record element
			final ArrayList<history> tableHistorypointer = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(itemIndex).getHistory();
			// pointer to the history records for the first item of the first company
			
			
			

			
			
			
			// display the table panels for company and items panels
			final TableWindow1 detailTable1= new TableWindow1(tableItemPointer,tableCompanyPointer,tableHistorypointer);
			detailTable1.setOpaque(true); //content panes must be opaque
			
			// display the history panels
			final TableWindow2 detailTable2= new TableWindow2(tableItemPointer,tableCompanyPointer,tableHistorypointer);
			detailTable2.setOpaque(true); //content panes must be opaque
			
			
			setLayout(new BorderLayout());

			
			final JTextArea textArea = new JTextArea();
			
			
			// display the 'new inventory to add' panel and add event listener for 'Add'
			detailsPanel = new DetailsPanel();
			detailsPanel.addDetailListener(new DetailListener(){
				public void detailEventOccured(DetailEvent event){
					String text = event.getText();
					
					
					
					textArea.append(text);			
					}});
			
			Container c = getContentPane();
			
			
	//		c.add(textArea,BorderLayout.NORTH);  // hook for updating the data
			c.add(detailsPanel,BorderLayout.WEST); // add the 'New inventory to add' to the WEST Panel
	
			c.add(detailTable1,BorderLayout.EAST); // add the Company and Items table
			c.add(detailTable2,BorderLayout.SOUTH);
			
	}}





