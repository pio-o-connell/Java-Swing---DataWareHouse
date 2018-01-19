package WareHouse;

//----------------------------------------------------------------------------//
// Generate report interrogates the memory and generates a report
// Implement 'Report' functionality' in main window
// Launches Notepad with the results - 
// An enhancement would be to generate a HTML file with the results displayed in tabular form
//
// Note - ItemReport for date not implemented.
//-------------------------------------------------------------------------------------//
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

public class GenerateReport {

	ArrayList<Company> Company11= new ArrayList<Company>();
	
	Date dateFrom;
	Date dateTo;
	
	GenerateReport(ArrayList<Company> Company11) throws IOException{
		this.Company11 = Company11;
		File outputFile = new File("Report-JavaProject.txt");
		FileWriter out = new FileWriter(outputFile);
		PrintWriter outputStream = new PrintWriter(out);
		
		for(int i=0;i<Company11.size();i++){ // will be only one company here
			
			Date date = new Date();
			outputStream.println("Date"+date.toString());
			outputStream.print("Company Name: "+Company11.get(i).getCompanyName());
			outputStream.println("\tCompany Id: "+Company11.get(i).getCompanyId());
			
			
			for(int j=0;j<Company11.get(i).getItems().size();j++){
				outputStream.println("Item Name: \t\t\tItem Id: \t\t Item Quantity: \t\tItem Location: ");
				outputStream.println(Company11.get(i).getItems().get(j).getItemName()+"\t\t\t " +Company11.get(i).getItems().get(j).getItemId()+
						"\t\t\t" +Company11.get(i).getItems().get(j).getQuantity()+"\t\t\t\t"+Company11.get(i).getItems().get(j).getLocation());
			//	outputStream.print("\t\t\t " +Company11.get(i).getItems().get(j).getItemId());
			//	outputStream.print("\t\t\t" +Company11.get(i).getItems().get(j).getQuantity());
			//	outputStream.println("\t\t\t\t"+Company11.get(i).getItems().get(j).getLocation());
				outputStream.println("\t\t\tHistory Description: \t\t\tHistoryId:  \t\t Amount: \t\tSupplier: \t\tDelivery Date: ");
	    		for(int k=0;k<Company11.get(i).getItems().get(j).getHistory().size();k++){
	    			
	    			outputStream.println("\t\t\t "+ Company11.get(i).getItems().get(j).getHistory().get(k).getDescription()+"\t\t\t "+ Company11.get(i).getItems().get(j).getHistory().get(k).getHistoryId()+
	    					"\t\t"+Company11.get(i).getItems().get(j).getHistory().get(k).getAmount()+
	    					"\t\t  "+ Company11.get(i).getItems().get(j).getHistory().get(k).getSupplier()+
	    					"\t\t "+Company11.get(i).getItems().get(j).getHistory().get(k).getDeliveryDate()
	    					);
	    	//		outputStream.print("\t\t\t\t\t "+ Company11.get(i).getItems().get(j).getHistory().get(k).getHistoryId());
	    	//		outputStream.print("\t\t"+Company11.get(i).getItems().get(j).getHistory().get(k).getAmount());
	    	//		outputStream.print("\t\t  "+ Company11.get(i).getItems().get(j).getHistory().get(k).getSupplier());
	    	//		outputStream.println("\t\t "+Company11.get(i).getItems().get(j).getHistory().get(k).getDeliveryDate());
	    			
	    		}
	    	}
		}
		out.close();
			
	}
	
	@SuppressWarnings("unchecked")
	public void GenerateItemsDatesReport(Date dateFrom,Date dateTo) throws ParseException{

		ArrayList<Index> indexer= new ArrayList<Index>();
		Index index = new Index();
		
		
		this.dateFrom= (Date) dateFrom.clone();
		this.dateTo = (Date) dateTo.clone();
		
		Date currentDate = new Date();
		this.Company11 = Company11;
		// gets histories of all items transacted within the dates
		for(int i=0;i<Company11.size();i++){
			for(int j=0;j<Company11.get(i).getItems().size();j++){
				for(int k=0;k<Company11.get(i).getItems().get(j).getHistory().size();k++){
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
				    currentDate = format.parse(Company11.get(i).getItems().get(j).getHistory().get(k).getDeliveryDate());
					if ((currentDate.after (dateFrom)) && (currentDate.before (dateTo ))){
						index.setI (i);
						index.setJ(j);
						index.setK(k);
						index.setDated(currentDate) ;		
						indexer.add(index);
						
						System.out.println("Current date"+index.getDated());
						System.out.println("Date : "+ Company11.get(i).getItems().get(j).getHistory().get(k).getDeliveryDate());
						System.out.println("i,,j,k,date: "+indexer.get(i).getI()+
								indexer.get(i).getJ()+
						indexer.get(i).getK()+
						indexer.get(i).getDated());
					}
					
				}
			}
		}
		System.out.println("Before Sort"+indexer);
		Collections.sort(indexer,new DateComparator());
		System.out.println("After sort"+indexer.toString());
		
		for(int l=0;l<indexer.size();l++){
			int i = indexer.get(l).getI();
			int j = indexer.get(l).getJ();
			int k = indexer.get(l).getK();
			System.out.println("i,j,k"+i+j+k);
			System.out.println("Sorted Date : "+ Company11.get(i).getItems().get(j).getHistory().get(k).getDeliveryDate());
			
			
			
		}
		
		
		
		
		
		
		
		
	}

}