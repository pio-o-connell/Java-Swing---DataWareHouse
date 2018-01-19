package WareHouse;

import java.io.Serializable;
import java.util.Date;

/*---------------------------------------------------------------------------------------
/*
 * The 'History class holds all the historical data associated with past transactions 
 * for particular item being stocked by particular manufacturer and said suppliers.
 * 
 ---------------------------------------------------------------------------------------*/
public class history implements Serializable{
	private int historyId,itemId,amount;
	private String description;
	private String supplier;
	private String deliveryDate;
	
	
	public history(int historyId,int itemId,int amount,String description,String supplier,String deliverydate){
		this.historyId=historyId;
		this.itemId=itemId;
		this.deliveryDate=deliverydate;
		this.description=description;
		this.amount=amount;	
		this.supplier=supplier;
		
	}
	
	public history(){
		
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
