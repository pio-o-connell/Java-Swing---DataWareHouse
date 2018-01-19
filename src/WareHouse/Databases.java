package WareHouse;
//-------------------------------------------------------------------
///
// Loads the database into the memory structure.
// Also handled deletions and insertions into the database
// No code here to modify the records
//-------------------------------------------------------------------
//import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public final class Databases {

    Connection con;
    ArrayList<Company> Company11 = new ArrayList<Company>();
    ArrayList<history> history11 = new ArrayList<history>();
    ArrayList<Item> Item11 = new ArrayList<Item>();
    ArrayList<User> User11 = new ArrayList<User>();

    Databases(Connection con) throws Exception {

        this.con = con;

    }

    public void setup(Connection con1, ArrayList<Company> Company11) throws SQLException {
        this.con = con1;
        this.Company11 = Company11;

        //select distinct items for the company
        try {

            String query = "SELECT DISTINCT ITEM_ID from ITEM";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT * from ITEM");
            ResultSet itemsResult = statement.executeQuery();

            while (itemsResult.next()) {
                PreparedStatement statement1 = (PreparedStatement) con.prepareStatement("SELECT * FROM HISTORY WHERE ITEM_ID="
                        + itemsResult.getInt(1) + "");
                ResultSet historyResult = statement1.executeQuery();
                history11 = new ArrayList<history>();
                while (historyResult.next()) {

                    history11.add(new history(historyResult.getInt(1), historyResult.getInt(2), historyResult.getInt(3), historyResult.getString(4), historyResult.getString(5), historyResult.getString(6)));

                }

                Item11.add(new Item(itemsResult.getInt(1), itemsResult.getInt(2), itemsResult.getString(5), itemsResult.getInt(3), itemsResult.getString(4), history11));

            }
            // Create the users - only one
            PreparedStatement statement3 = (PreparedStatement) con.prepareStatement("select * from users ");
            ResultSet result3 = statement3.executeQuery();
            while (result3.next()) {
                User11.add(new User(result3.getInt(1), result3.getInt(4), result3.getString(2), result3.getString(3)));
            }

            // Create the Company - only one
            PreparedStatement statement4 = (PreparedStatement) con.prepareStatement("select * from company ");
            ResultSet result4 = statement4.executeQuery();
            while (result4.next()) {
                System.out.println("\n" + result4.getInt(1) + " name:" + result4.getString(2));
                Company11.add(new Company(result4.getInt(1), result4.getString(2), Item11, User11));
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }

    }

    public void deleteItemTransintoDatabase(Connection con1, ArrayList<Company> Company11) throws SQLException {

        try {

            ArrayList<Item> itemPointer = Company11.get(Mainframe.companyIndex).getItems();

            itemPointer.remove(Mainframe.itemIndex);
            // remove from databases	
            // item database
            String query = "delete from item where Item_id = ?";
            PreparedStatement preparedStmt1 = (PreparedStatement) con.prepareStatement(query);
            preparedStmt1.setInt(1, itemPointer.get(Mainframe.historyIndex).getItemId());
            preparedStmt1.execute();

            //history database
            String query1 = "delete from history where item_id = ?";

            PreparedStatement preparedStmt11 = (PreparedStatement) con.prepareStatement(query1);
            preparedStmt11.setInt(1, itemPointer.get(Mainframe.itemIndex).getItemId());
            preparedStmt11.execute();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHistoryTransintoDatabase(Connection con1, ArrayList<Company> Company11) throws SQLException {
        this.con = con1;
        try {

            ArrayList<history> historyPointer = Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getHistoryItem();
            System.out.println("history  pointer..>" + historyPointer.get(Mainframe.historyIndex).getHistoryId());
            historyPointer.remove(Mainframe.historyIndex);
            // remove from history database
            String query = "delete from history where history_id = ?";
            PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
            preparedStmt.setInt(1, historyPointer.get(Mainframe.historyIndex).getHistoryId());

            preparedStmt.execute();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertTransactionintoDatabase(Connection con1, ArrayList<Company> Company11) throws SQLException {

        try {
            PreparedStatement statement;
            statement = (PreparedStatement) con.prepareStatement("INSERT  INTO  history(ITEM_id,AMOUNT,DESCRIPTION,SUPPLIER,DELIVERY_DATE)  VALUES  (?,?,?,?,?)");
            //String name = DetailsPanel.nameField.getText();
            int temp = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getItemId();
            String description = DetailsPanel.descriptionField.getText();
            String supplier = DetailsPanel.supplierField.getText();
            String delivery = DetailsPanel.deliveryField.getText();
            String tempAmount = DetailsPanel.amountField.getText();

            int Amount = Integer.parseInt(tempAmount);

            statement.setInt(1, maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getItemId());
            statement.setInt(2, Amount);
            statement.setString(3, description);
            statement.setString(4, supplier);
            statement.setString(5, delivery);
            statement.executeUpdate();
            int total = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getQuantity();
            total = total + Amount;

            maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).setQuantity(Amount);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertNewItemTransintoDatabase(Connection con1, ArrayList<Company> Company11) throws SQLException {

        try {

            PreparedStatement statement = (PreparedStatement) con.prepareStatement("INSERT  INTO  item(company_id,quantity,itemName,Location)  VALUES  (?,?,?,?)");
            int companyId = maindriver.Company11.get(Mainframe.companyIndex).getCompanyId();

            String tempAmount = DetailsPanel.amountField.getText();
            int Amount = Integer.parseInt(tempAmount);
            String itemName = DetailsPanel.nameField.getText();
            String location = DetailsPanel.locationField.getText();

            statement.setInt(1, companyId);
            statement.setInt(2, Amount);
            statement.setString(3, itemName);
            statement.setString(4, location);
            statement.executeUpdate();

            // update Item Array
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Now need to determine autogenerated item_id
        int item_id = 0;
        try {
            //		String query = "select * from item where item_id=last_insert_id()";
            String query = "select item_id from item order by item_id desc";
            PreparedStatement statement3 = (PreparedStatement) con.prepareStatement(query);
            ResultSet result3 = statement3.executeQuery();

            while (result3.next()) {
                item_id = result3.getInt(1);
                break;
            }

            System.out.println("Auto generated id" + item_id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Item(int itemId,int companyId,String Location,int quantity,String itemName,ArrayList<history> historyItem)
        // now to add the item to the items array
        int companyId = maindriver.Company11.get(Mainframe.companyIndex).getCompanyId();
        String tempAmount = DetailsPanel.amountField.getText();
        int Amount = Integer.parseInt(tempAmount);
        String itemName = DetailsPanel.nameField.getText();
        String location = DetailsPanel.locationField.getText();
        ArrayList<history> tempHistory = new ArrayList<history>();

        Item tempItem = new Item(item_id, companyId, location, Amount, itemName, tempHistory);
        ArrayList<Item> currentItemPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems();
        currentItemPointer.add(tempItem);
        Mainframe.itemIndex = (Company11.get(Mainframe.companyIndex).getItems().size());

        // Now to create entry in the history database
        try {
            PreparedStatement statement;
            statement = (PreparedStatement) con.prepareStatement("INSERT  INTO  history(ITEM_id,AMOUNT,DESCRIPTION,SUPPLIER,DELIVERY_DATE)  VALUES  (?,?,?,?,?)");
            //String name = DetailsPanel.nameField.getText();

            int temp = item_id;
            String description = DetailsPanel.descriptionField.getText();
            String supplier = DetailsPanel.supplierField.getText();
            String delivery = DetailsPanel.deliveryField.getText();
            String tempAmount1 = DetailsPanel.amountField.getText();
            int Amount1 = Integer.parseInt(tempAmount);
            System.out.println("5 total" + temp + description + supplier + delivery + tempAmount1);
            //		 statement.setInt(1, maindriver.Company11.get(Mainframe.companyIndex).getItems().get(Mainframe.itemIndex).getItemId());
            statement.setInt(1, item_id);
            statement.setInt(2, Amount);
            statement.setString(3, description);
            statement.setString(4, supplier);
            statement.setString(5, delivery);
            statement.executeUpdate();
            // Now to retrieve the auto generated history_id

            int history_id = 0;
            //	String query = "select * from history where history_id=last_insert_id()";
            String query = "select item_id from item order by item_id desc";
            PreparedStatement statement3 = (PreparedStatement) con.prepareStatement(query);
            ResultSet result3 = statement3.executeQuery();

            while (result3.next()) {
                history_id = result3.getInt(1);
                break;
            }

            // update history array
            int itemSize = maindriver.Company11.get(Mainframe.companyIndex).getItems().size();
            ArrayList<history> currentItemHistoryPointer = maindriver.Company11.get(Mainframe.companyIndex).getItems().get(itemSize - 1).getHistory();

            /*	  currentItemHistoryPointer.get(0).getHistoryId();
						  currentItemHistoryPointer.get(0).setItemId(item_id);
						  currentItemHistoryPointer.get(0).setAmount(Amount);
						  currentItemHistoryPointer.get(0).setDescription(description);
						  currentItemHistoryPointer.get(0).setSupplier(supplier);
						  currentItemHistoryPointer.get(0).setDeliveryDate(delivery);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
