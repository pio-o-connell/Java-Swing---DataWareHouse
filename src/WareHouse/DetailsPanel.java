package WareHouse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

//import com.mysql.jdbc.Connection;

/*------------------------------------------------------------------------------------------------------------------*/
// DetailsPanel Class facilitates the entry of item purchased transaction in the WareHouse Class.
// It's necessary to select a Supplier,then select an item from the item tables.
// Unfortunately, there are issues setting a default selection in the windows on startup - this would guarantee the
// system is in a steady state.It is but just not displayed.
//						The particular row selected in both the history and item tables 
//would be reflected in the 'New Inventory to add' panel to facilitate easy entry by the user.Selecting an item from 
//the History table has the effect of updating the edit controls.
// 												Most Suppliers are normally'returning' customers i.e. historically 
//a particular manufacturer's item purchased is normally from a previous supplier.
// So,selecting a row in the History table has the effect of updating the data entry controls. 
//
// 
// There should be discounts for returning customers(loyalty schemes in operation) so the application could prove useful.
// An 'Add' button facilitates the entry of new transaction to the system.
// 
// An 'Update' button facilitates the updating of an existing record.This is still not implemented.The database elements
// are non-editable. Clicking the update button should have the effect of displaying a custom modal dialog, where user is
// restricted in allowable entries.
//
// There is no validity checks on 'New Transactions/Itms To Add'. This should have been implemented using custom controls i.e.
// data spinner especially.
//
// It's not possible to manually edit the table fields, risk of data inconsistency very high.
// A 'New Stock Item' allows the user to enter a new item of a particular manufacturer from a particular supplier.
// 
// A  New Item button allows user to enter new company details and item details from said company.Adding a 'New Item'
// is logically very similiar to adding a transaction. User creates new item only when there is a definite transaction.
// Both history and items databases then updated to reflect this.
//
// If the User Interface was fully completed it should include a calendar on the dash. The date has proven v.difficult
// with JTextStrings.
/*-------------------------------------------------------------------------------------------------------------------*/
public class DetailsPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private EventListenerList listenerList = new EventListenerList();

    // new
    static JTextField nameField = new JTextField(10);
    static JTextField locationField = new JTextField(10);
    static JTextField supplierField = new JTextField(10);
    static JTextField deliveryField = new JTextField(10);
    static JTextField amountField = new JTextField(10);

    static JTextField reportDeliveryFrom = new JTextField(8);
    static JTextField reportDeliveryTo = new JTextField(8);

    static JLabel statusLabel = new JLabel("Status: Waiting ");
    static JLabel spacerLabel = new JLabel("                ");

    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 270;
        //	size.height=100;

        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("New Transaction/Item To Add:"));
        //	JLabel transactionLabel = new JLabel("Transaction");
        JLabel nameLabel = new JLabel("Item Name: ");
        JLabel locationLabel = new JLabel("Location: ");
        JLabel supplierLabel = new JLabel("Supplier Name: ");
        JLabel amountLabel = new JLabel("Quantity: ");
        JLabel deliveryLabel = new JLabel("Delivery Date: ");
        JLabel deliveryFrom = new JLabel("From: ");
        JLabel deliveryTo = new JLabel("To: ");

        final int amount1, RecordNo, itemId1;
        final String location, supplier, name;
        final String date1;

        statusLabel.setForeground(Color.RED);

        //	final int listSize = currentItemHistoryPointer.size();
        final int itemId = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getItemId();
        Mainframe.historyRecordNo++;

        JButton addBtn = new JButton("Add Tx");
        //  tempHistory=new history(1,1,1,"test","test",new Date(99, 0, 99));

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Add Transaction: Beginning ");
                //		try{
                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = (String) deliveryField.getText();
                String amount = amountField.getText();
                int quantity = Integer.parseInt(amount);

                String text = Mainframe.historyRecordNo + ":  " + itemId + "  :" + quantity + "  :" + location + "   " + supplier + "   " + "   \n";
                // history tempHistory=new history(Mainframe.historyRecordNo,itemId,quantity,location,supplier,delivery);
                history tempHistory = new history(Mainframe.historyRecordNo, itemId, quantity, location, supplier, delivery);
                //	final ArrayList<history>currentItemHistoryPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getHistory();
                ArrayList<history> currentItemHistoryPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getHistory();
                currentItemHistoryPointer.add(tempHistory);
                try {
                    Connection con;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "ROOT");
                    Databases db = new Databases(con);
                    db.insertTransactionintoDatabase(con, maindriver.Company11);
                } catch (ClassNotFoundException e3) {
                    statusLabel.setText("Insertion: Error ");
                    e3.printStackTrace();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (Exception e2) {
                    statusLabel.setText("Insertion: Error ");
                    e2.printStackTrace();
                } finally {
                    statusLabel.setText("Insertion: Completed ");
                }

                /*		} catch(Exception e1){
					statusLabel.setText( "Add Transaction: Error-possible duplicate ");
				} finally{
					statusLabel.setText( "Add Transaction: Error-possible duplicate ");
				}*/
                //	fireDetailEvent(new DetailEvent(this,text));
            }
        });

        JButton removeBtn = new JButton("Remove Tx");
        //  tempHistory=new history(1,1,1,"test","test",new Date(99, 0, 99));

        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Tx: Beginning ");
                //		try{
                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = (String) deliveryField.getText();
                String amount = amountField.getText();
                // 	String location = locationField.getText();
                int quantity = Integer.parseInt(amount);

                String text = Mainframe.historyRecordNo + ":  " + itemId + "  :" + quantity + "  :" + location + "   " + supplier + "   " + "   \n";
                // history tempHistory=new history(Mainframe.historyRecordNo,itemId,quantity,location,supplier,delivery);
                history tempHistory = new history(Mainframe.historyRecordNo, itemId, quantity, location, supplier, delivery);
                //	final ArrayList<history>currentItemHistoryPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getHistory();
                ArrayList<history> currentItemHistoryPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getHistory();
                currentItemHistoryPointer.add(tempHistory);
                try {
                    Connection con;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "ROOT");
                    Databases db = new Databases(con);
                    db.deleteHistoryTransintoDatabase(con, maindriver.Company11);
                } catch (ClassNotFoundException e3) {
                    statusLabel.setText("Deletion: Error ");
                    e3.printStackTrace();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (Exception e2) {
                    statusLabel.setText("Deletion: Error ");
                    e2.printStackTrace();
                } finally {
                    statusLabel.setText("Deletion: Completed ");
                }

                /*		} catch(Exception e1){
						statusLabel.setText( "Add Transaction: Error-possible duplicate ");
					} finally{
						statusLabel.setText( "Add Transaction: Error-possible duplicate ");
					}*/
                //	fireDetailEvent(new DetailEvent(this,text));
            }
        });
        JButton updateBtn = new JButton(" Create Item");

        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Creating.. ");
                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();
                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   \n";
                try {
                    Connection con;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "ROOT");
                    Databases db = new Databases(con);
                    db.insertNewItemTransintoDatabase(con, maindriver.Company11);
                } catch (ClassNotFoundException e3) {
                    statusLabel.setText("Creation: Error ");
                    e3.printStackTrace();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (Exception e2) {
                    statusLabel.setText("Creation: Error ");
                    e2.printStackTrace();
                } finally {
                    statusLabel.setText("Creation: Completed ");
                }
                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        final JButton updateItemBtn = new JButton("UpdateItem");

        updateItemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        JButton deleteBtn = new JButton(" Deletion Item");

        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Deletion.. ");

                try {
                    Connection con;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "ROOT");
                    Databases db = new Databases(con);
                    db.deleteItemTransintoDatabase(con, maindriver.Company11);
                } catch (ClassNotFoundException e3) {
                    statusLabel.setText("Deletion: Error ");
                    e3.printStackTrace();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (Exception e2) {
                    statusLabel.setText("Deletion: Error ");
                    e2.printStackTrace();
                } finally {
                    statusLabel.setText("Deletion: Completed ");
                }
                //	fireDetailEvent(new DetailEvent(this,text));
            }
        });
        JButton itemReportBtn = new JButton("Item Report");

        itemReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Item Report: Beginning ");
                try {
                    GenerateReport report = new GenerateReport(maindriver.Company11);
                    ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Report-JavaProject.txt");
                    pb.start();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    statusLabel.setText("Item Report: Error ");
                    e1.printStackTrace();
                } finally {
                    statusLabel.setText("Item Report: Completed ");
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        JButton itemDeliveredReportBtn = new JButton("Item Report");

        itemDeliveredReportBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Items Delivered Report: Beginning ");
                try {
                    GenerateReport report = new GenerateReport(maindriver.Company11);
                    ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "Report-JavaProject.txt");
                    pb.start();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    statusLabel.setText("Items Delivered Report: Error ");
                    e1.printStackTrace();
                } finally {
                    statusLabel.setText("Items Delivered Report: Completed ");
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        JButton backupBtn = new JButton("Backup");

        backupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Backup Database: Beginning ");
                try {
                    Connection con;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "ROOT");
                    DatabaseBackup dbBackup;
                    dbBackup = new DatabaseBackup(con);
                    dbBackup.backup(con, maindriver.Company11);

                } catch (ClassNotFoundException e3) {
                    statusLabel.setText("Backup Database: Error ");
                    e3.printStackTrace();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (Exception e2) {
                    statusLabel.setText("Backup Database Error: Complelted ");
                    e2.printStackTrace();
                } finally {
                    statusLabel.setText("Backup Database: Completed ");
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        JButton restoreBtn = new JButton("Restore");

        restoreBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Restore Database: Beginning ");
                try {
                    Connection con;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/warehouse?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "ROOT");
                    Databases db = new Databases(con);
                    db.setup(con, maindriver.Company11);
                } catch (ClassNotFoundException e3) {

                    e3.printStackTrace();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                } catch (Exception e2) {

                    e2.printStackTrace();
                } finally {
                    statusLabel.setText("Restore: Completed ");
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        JButton serialBackupBtn = new JButton("Save Settings");

        serialBackupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Save Settings: Beginning ");

                try {
                    Serialized serial = new Serialized(maindriver.Company11);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    statusLabel.setText("Save Settings: Error ");
                } finally {
                    statusLabel.setText("Save Settings: Completed ");
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        JButton serialRestoreBtn = new JButton("Restore");

        serialRestoreBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Restore Settings: Beginning ");
                try {
                    Serialized serial = new Serialized(maindriver.Company11);
                    serial.restoreSerialized(maindriver.Company11);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    statusLabel.setText("Restore Settings: Error ");
                } finally {
                    statusLabel.setText("Restore Settings: Completed ");
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String supplier = supplierField.getText();
                String delivery = deliveryField.getText();
                String amount = amountField.getText();

                String text = name + ":  " + location + "  :" + supplier + "  :" + delivery + "   " + amount + "   " + "   \n";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        ///new	
        setLayout(new BorderLayout());
        //old
        //   setLayout(new GridBagLayout());

        //new	
        JPanel topPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;

        //	topPanel.add(transactionLabel,gc);
        gc.gridx = 0;
        gc.gridy = 1;
        topPanel.add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        topPanel.add(locationLabel, gc);

        gc.gridx = 0;
        gc.gridy = 3;

        topPanel.add(supplierLabel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        topPanel.add(deliveryLabel, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        topPanel.add(amountLabel, gc);

        gc.gridx = 0;
        gc.gridy = 6;

        gc.gridx = 0;
        gc.gridy = 7;
        topPanel.add(statusLabel, gc);

        gc.weighty = 10;

        gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 1;
        gc.gridy = 1;
        topPanel.add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        topPanel.add(locationField, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        topPanel.add(supplierField, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        topPanel.add(deliveryField, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        topPanel.add(amountField, gc);

        gc.gridx = 1;
        gc.gridy = 6;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;

        gc.gridx = 0;
        gc.gridy = 20;
        topPanel.add(addBtn, gc);

        gc.gridx = 1;
        gc.gridy = 20;
        topPanel.add(updateItemBtn, gc);

        // Removed locationLabel and locationField (no longer used)
        gc.gridx = 0;
        gc.gridy = 24;
        topPanel.add(updateBtn, gc);

        gc.gridx = 1;
        gc.gridy = 24;
        topPanel.add(updateItemBtn, gc);

        gc.gridx = 1;
        gc.gridy = 25;
        topPanel.add(deleteBtn, gc);

        gc.gridx = 1;
        gc.gridy = 26;
        topPanel.add(removeBtn, gc);

        add(topPanel, BorderLayout.NORTH);

        //new 
        JPanel centerPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gcc = new GridBagConstraints();
        gcc = new GridBagConstraints();

        gcc.anchor = GridBagConstraints.LINE_START;
//	gcc.weightx = 0.1;
        gcc.weightx = 1.0;
        gcc.weighty = 0.1;

        gcc.gridx = 0;
        gcc.gridy = 0;
        centerPanel.add(statusLabel, gcc);

        gcc.gridx = 0;
        gcc.gridy = 1;
            // topPanel.add(locationLabel, gc);
            // topPanel.add(locationField, gc);

        centerPanel.add(backupBtn, gcc);

        gcc.gridx = 1;
        gcc.gridy = 2;

        centerPanel.add(restoreBtn, gcc);

        gcc.gridx = 0;
        gcc.gridy = 3;
        centerPanel.add(spacerLabel, gcc);

        gcc.gridx = 0;
        gcc.gridy = 4;
        centerPanel.add(itemReportBtn, gcc);

        gcc.gridx = 0;
        gcc.gridy = 5;
        centerPanel.add(deliveryFrom, gcc);

        gcc.gridx = 0;
        gcc.gridy = 6;
        centerPanel.add(reportDeliveryFrom, gcc);

        gcc.gridx = 1;
        gcc.gridy = 5;
        centerPanel.add(deliveryTo, gcc);

        gcc.gridx = 1;
        gcc.gridy = 6;
        centerPanel.add(reportDeliveryTo, gcc);

        gcc.gridx = 0;
        gcc.gridy = 7;
        centerPanel.add(itemDeliveredReportBtn, gcc);

        gcc.gridx = 0;
        gcc.gridy = 9;
        centerPanel.add(serialBackupBtn, gcc);

        gcc.gridx = 1;
        gcc.gridy = 9;
        centerPanel.add(serialRestoreBtn, gcc);

        add(centerPanel, BorderLayout.SOUTH);
    }

    public void fireDetailEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == DetailListener.class) {
                ((DetailListener) listeners[i + 1]).detailEventOccured(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener) {
        listenerList.add(DetailListener.class, listener);
    }

    public void removeDetailListener(DetailListener listener) {
        listenerList.remove(DetailListener.class, listener);
    }

    public Date convertStringToDate(String dateString) {
        Date date = null;
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s = formatter.format(date);

        return date;

    }

}
