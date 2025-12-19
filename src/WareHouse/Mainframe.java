
package WareHouse;


//import TableWindow1;

//import Mainframe;

//import TableFilterDemo1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

/*---------------------------------------------------------------------------------------
/*
 * The 'Mainframe' class gets on with the main business of rendering the frame.
 * It invokes 3 other classes DetailPanel for the new data to be entered.
 * and TableWindow1 and TableWindow2 for mirroring the data in the main classes
 * 
 ---------------------------------------------------------------------------------------*/


public class Mainframe extends JFrame {
		// Call this method after company selection changes
		public void updateCompanySelection(int newCompanyIndex) {
			companyIndex = newCompanyIndex;
			if (detailPanel != null) {
				String companyName = "";
				try {
					companyName = maindriver.Company.get(companyIndex).getName();
				} catch (Exception e) {}
							   // detailPanel.updateTxCompanyName(companyName); // removed field
			}
		}
	private static final long serialVersionUID = 1L;

	public static int companyIndex=0,itemIndex=0,historyIndex=0;
	
	
	public static TableWindow1 detailTable1; //  contains the company table and items table
	public static TableWindow2 detailTable2; //  contains the history table
	public static DetailsPanel detailPanel; // contains the table for new record entry

	public static int historyRecordNo=30;
	
	/*-------------------------------------------------------
	 * These could be implemented using an abstract class
	 --------------------------------------------------------*/

	
		
		public Mainframe(String title) throws Exception{
			super(title);
			// Set initial frame size for proper split
			setSize(1200, 700); // You can adjust this size as needed
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","ROOT");

			
			
			
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
			detailPanel = new DetailsPanel();
			detailPanel.addDetailListener(new DetailListener(){
				public void detailEventOccured(DetailEvent event){
					String text = event.getText();
					textArea.append(text);
				}});
			
			       detailTable1.setOpaque(true);
			       detailTable1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLUE, 3));
			       detailTable1.setPreferredSize(new java.awt.Dimension(300, 200));
			       detailTable1.add(new javax.swing.JLabel("TableWindow1 (WEST bottom)"));

			       detailTable2.setOpaque(true);
			       detailTable2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 3));
			       detailTable2.setPreferredSize(new java.awt.Dimension(300, 200));
			       detailTable2.add(new javax.swing.JLabel("TableWindow2 (EAST)"));

			       detailPanel.setOpaque(true);
			       detailPanel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GREEN, 3));
			       detailPanel.setPreferredSize(new java.awt.Dimension(300, 200));
			       detailPanel.add(new javax.swing.JLabel("DetailsPanel (WEST top)"));
			       detailPanel.addDetailListener(new DetailListener() {
				       public void detailEventOccured(DetailEvent event) {
					       String text = event.getText();
					       textArea.append(text);
				       }
			       });

			// Populate DetailsPanel with first company, item, and history record
			if (!maindriver.Company11.isEmpty()) {
				Company firstCompany = maindriver.Company11.get(0);
							   // detailPanel.updateTxCompanyName(firstCompany.getCompanyName()); // removed field
							   detailPanel.setCurrentCompanyField(firstCompany.getCompanyName());
				java.util.List<Item> items = firstCompany.getItems();
				if (items != null && !items.isEmpty()) {
					Item firstItem = items.get(0);
					String itemName = firstItem.getItemName();
					java.util.List<history> histories = firstItem.getHistory();
					if (histories != null && !histories.isEmpty()) {
						history firstHistory = histories.get(0);
						String supplier = firstHistory.getProvider();
						String location = firstHistory.getLocation();
						String delivery = firstHistory.getDeliveryDate();
						int amount = firstHistory.getAmount();
						detailPanel.setFields(itemName, location, supplier, delivery, String.valueOf(amount));
					} else {
						// No history, just fill item fields with item info
						String supplier = "";
						String location = "";
						String delivery = "";
						int amount = firstItem.getQuantity();
						detailPanel.setFields(itemName, location, supplier, delivery, String.valueOf(amount));
					}
				}
			}

			// Create scroll pane for DetailsPanel (WEST)
			javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(detailPanel);
			scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GREEN, 3));
			scrollPane.setPreferredSize(new java.awt.Dimension(800, 700)); // 2/3 of 1200 width

			// Create a panel to stack company and item tables vertically (EAST)

			// Ensure detailTable1 and detailTable2 are visible and not double-wrapped in scroll panes
			detailTable1.setPreferredSize(new java.awt.Dimension(400, 350));
			detailTable2.setPreferredSize(new java.awt.Dimension(Integer.MAX_VALUE, 350));
			detailTable2.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 350));
			detailTable2.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
			JPanel eastPanel = new JPanel();
			eastPanel.setLayout(new javax.swing.BoxLayout(eastPanel, javax.swing.BoxLayout.Y_AXIS));
			eastPanel.add(detailTable1);

			// Use JSplitPane to split WEST (DetailsPanel) and EAST (tables)
			javax.swing.JSplitPane splitPane = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, scrollPane, eastPanel);
			splitPane.setDividerLocation(800); // 2/3 of 1200
			splitPane.setResizeWeight(0.67); // WEST gets 2/3
			splitPane.setContinuousLayout(true);

			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			c.add(splitPane, BorderLayout.CENTER);
			c.add(detailTable2, BorderLayout.SOUTH);
		}
}







