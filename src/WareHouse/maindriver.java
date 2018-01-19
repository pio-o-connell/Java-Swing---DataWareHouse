package WareHouse;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*---------------------------------------------------------------------------------------
/*
 * The 'maindriver' class is the entry point of the program.
 * After password clearance,user is then shown the main window viz. "Main Inventory System".
 * 
 ---------------------------------------------------------------------------------------*/

public class maindriver{
	public static ArrayList<Company> Company11 = new ArrayList<Company>();
//	private static DummyClass dummyclass = new DummyClass();
	
	
	
	
	//Necessary for initial table window display
	final ArrayList<Company> tableCompanyPointer = Company11;  //pointer to first element of Company data structure
	final ArrayList<Item>tableItemPointer = Company11.get(Mainframe.companyIndex).getItems(); 

	
	public static void main(String[] args) throws Exception{
		
		
	//	Company11 = dummyclass.getCompany11(); // build the data structure
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse","root","root");
		
/*		Class.forName("com.mysql.jdbc.Driver");
		Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse","root","root");
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select * from company ");
		ResultSet result = statement.executeQuery();
		while(result.next()){
			System.out.println("\n"+result.getDate(1)+" name:"+result.getString(2));
		}*/
		Databases db = new Databases(con);
		db.setup(con,Company11);
	//	System.out.println("hello");
	//	DatabaseBackup dbBackup = new DatabaseBackup(con);
	//	dbBackup.backup(con,Company11);

		String dateString1 = "2002-03-03";
	    String dateString2 = "2012-03-10";

	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	    Date dateFrom = format.parse(dateString1);
	    Date dateTo = format.parse(dateString2);	
		
		
	 GenerateReport report= new GenerateReport(Company11);
	 report.GenerateItemsDatesReport(dateFrom, dateTo);
		
		
		
	//	Serialized serial = new Serialized(Company11);
	//	history testHistory= new history(10008182, 33008177, 100, "Chopper", "Sony","2014-10-10");
	//	serial.restoreSerialized(Company11);
	//	System.out.println(testHistory.getDescription());
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				String user = JOptionPane.showInputDialog(null,"User"); // dialog requests username
				String password = JOptionPane.showInputDialog(null,"Password"); // dialog requests password
				
				if ("root".equals(user) && "root".equals(password)){
					JOptionPane.showMessageDialog(null,"login okay");
					JFrame frame;
					try {
						frame = new Mainframe("Warehouse Inventory System");
						frame.setSize(800,100);
						frame.setResizable(true);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.pack();
						frame.setVisible(true);
					} catch (Exception e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					} // main window is created
				}
				else
				
				{
					JOptionPane.showMessageDialog(null,"login not okay");	
				}
			}
		});
		// pointer to first item element of the first company record element
//		final ArrayList<history> tableHistorypointer =Company11.get(Mainframe.companyIndex).getItems().get(itemIndex).getHistory();
		// pointer to the history records for the first item of the first company
	}
}