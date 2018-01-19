package WareHouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/*---------------------------------------------------------------------------------------
/*
 * The 'Item' class is used to hold the particular item in stock by particular manufacturer
 * together with link to historical data associated with past transactions by particular suppliers
 * 
 ---------------------------------------------------------------------------------------*/


public class Item implements Serializable {
	

	private int itemId,companyId,quantity,historyId;
	private String itemName,Location;
	private ArrayList<history> historyItem = new ArrayList<history>();
	Date date = new Date();
	
	
	public Item(int itemId,int companyId,String Location,int quantity,String itemName,ArrayList<history> historyItem){
		
		
		this.itemId = itemId;
		this.companyId = companyId;
		this.quantity = quantity;
		this.itemName= itemName;
		this.historyItem=historyItem;
		this.Location=Location;
	}
	
	
	public Item(){
		
	}
	
	public ArrayList<history> getHistoryItem() {
		return historyItem;
	}


	public void setHistoryItem(ArrayList<history> historyItem) {
		this.historyItem = historyItem;
	}
	public void updateItem(int i){
	//	add-history
	};
	
	public void getDelivery(){
		
	}
	
	public void makeDelivery(){
		
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getItemId(){
		return itemId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getLocation(){
		return Location;
	}
	
	public void setLocation(String Location){
		this.Location=Location;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ArrayList<history> getHistory() {
		return historyItem;
	}

	public void addHistory(history history1) {
	//	this.historyItem.add( history( this.historyId,this.itemId,this.quantity,this.itemName,this.companyId,this.date)) ;
		
	}

	
	


	
	
	
	
	
	
	
}
