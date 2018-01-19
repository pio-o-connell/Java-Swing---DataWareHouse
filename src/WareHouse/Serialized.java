package WareHouse;

//----------------------------------------------------------------------------
// Serialized implements the 'Save Settings' and 'Restore' buttons
// The objects state are saved to file to be subsequently restored
//
//------------------------------------------------------------------------
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialized {
	private ArrayList<Company> Company11;
	
	public Serialized(ArrayList<Company> Company11){
	
		this.Company11 = Company11;
		try {
			if(Company11!=null){
			FileOutputStream fileStream = new FileOutputStream("Company11.ser");
			ObjectOutputStream os=new ObjectOutputStream(fileStream);
			
			os.writeObject(Company11);
			
			os.close();
			fileStream.close();
			}
			else
			{
				System.out.println("Null Object");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	public void restoreSerialized(ArrayList<Company> company11) {
		this.Company11 = company11;
		try {
			FileInputStream fileStream= new FileInputStream("Company11.ser");
			ObjectInputStream os = new ObjectInputStream(fileStream);
			
			company11 =(ArrayList<Company> )os.readObject();
			System.out.println("Desc"+(String) company11.get(0).getItems().get(0).getHistory().get(0).getDescription());
	
			
			os.close();
			fileStream.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}