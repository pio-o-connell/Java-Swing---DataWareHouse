package WareHouse;


import java.util.Date;

/*---------------------------------------------------------------------------------------
/*
 * A Dummy structure structure - with delivery date stored as a date - normally string
 * 
 ---------------------------------------------------------------------------------------*/
public class DummyHistory {
	private int historyId,itemId,amount;
	private String description;
	private String supplier;
	private Date deliveryDate;
	
	
	public DummyHistory(int historyId,int itemId,int amount,String description,String supplier,Date deliverydate){
		this.historyId=historyId;
		this.itemId=itemId;
		this.deliveryDate=deliverydate;
		this.description=description;
		this.amount=amount;	
		this.supplier=supplier;
		
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
}
