package WareHouse;

/*-----------------------------------------------------------------------------------*/
// The 'Dummy' Class was used to 'build' in memory the Company data structure.
// The Dummy() constructor creates the data structure and once created can
// be accessed using getCompany11 and setCompany11 setters and getters
/*-----------------------------------------------------------------------------------*/





import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;


public class DummyClass


{
	private ArrayList<history> history11 = new ArrayList<history>();
	private ArrayList<Item> Items11 = new ArrayList<Item>();
	private ArrayList<Company> Company11 = new ArrayList<Company>();
	private ArrayList<User> User11 = new ArrayList<User>();

	
	DummyClass(){	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
	// To build first company entire - complete with user ,items and history -- 
		
		//First Company Ericksson --------------------------------
		
		history11.add(new history(10008177, 33008177, 100, "Rough rider", "Toshiba",  sdf.format(new Date(53, 0, 16)) ));		
		history11.add(new history(10008178, 33008177, 100, "Freler","Ericksson", sdf.format(new Date(53, 0, 16)) ));	
		history11.add(new history(10008179, 33008177, 100, "Hells Angel", "Bosch", sdf.format(new Date(43, 0, 16)) ));		
		history11.add(new history(10008180, 33008177, 100, "Ball", "Krupps", sdf.format(new Date(33, 0, 16)) ));
		history11.add(new history(10008181, 33008177, 100, "Hells Angel", "Sony", sdf.format(new Date(23, 0, 16)) ));
		history11.add(new history(10008182, 33008177, 100, "Chopper", "Sony", sdf.format(new Date(13, 0, 16)) ));
		history11.add(new history(10008183, 33008177, 100, "Slingshot", "Amdahl", sdf.format(new Date(63, 0, 16)) ));		
		history11.add(new history(10008184, 33008177, 100," Boss Hoss","Sony", sdf.format(new Date(64, 0, 16)) ));			 
		history11.add(new history(10008185, 33008177, 100,"Cruiser", "Sony", sdf.format(new Date(65, 0, 16)) ));			
		history11.add(new history(10008186, 33008177, 100, "Heley", "Hoover", sdf.format(new Date(66, 0, 16)) ));
		history11.add(new history(10008187, 33008177, 100, "Free Loadr", "IBM", sdf.format(new Date(66, 0, 16)) ));
		history11.add(new history(10008189, 33008177, 100, "Free Loadr", "IBM", sdf.format(new Date(66, 0, 16)) ));
		Items11.add(new Item(33008177,44008177,1200,"Electric Gear",history11));
		history11= new ArrayList<history>();
		
		history11 = new ArrayList<history>();
		history11.add(new history(10008190, 33008178, 100, "HeAngel", "Sony", sdf.format(new Date(23, 0, 16)) ));
		history11.add(new history(10008191, 33008178, 100, "Chopp", "Sony", sdf.format(new Date(13, 0, 16)) ));
		history11.add(new history(10008192, 33008178, 100, "Slingshot", "Amdahl", sdf.format(new Date(63, 0, 16)) ));		
		history11.add(new history(10008193, 33008178, 100," BosHoss","Sony", sdf.format(new Date(64, 0, 16)) ));			 
		history11.add(new history(10008194, 33008178, 100,"Cruiser", "Sony", sdf.format(new Date(65, 0, 16)) ));			
		history11.add(new history(10008195, 33008178, 100, "Heley", "Hoover", sdf.format(new Date(66, 0, 16)) ));
		Items11.add(new Item(33008178,44008177,600,"Electric Motor",history11));
		history11= new ArrayList<history>();
		
		history11 = new ArrayList<history>();
		history11.add(new history(10082000, 33008179, 100, "Hells Angel", "Sony", sdf.format(new Date(23, 0, 16)) ));
		history11.add(new history(10082001, 33008179, 100, "row 3","Sony", sdf.format(new Date(13, 0, 16)) ));
		history11.add(new history(10082002, 33008179, 100, "Slingshot", "Amdahl", sdf.format(new Date(63, 0, 16)) ));		
		history11.add(new history(10082003, 33008179, 100," Bo Hoss","Sony", sdf.format(new Date(64, 0, 16)) ));			 
		history11.add(new history(10082004, 33008179, 100,"Cruiser", "Sony", sdf.format(new Date(65, 0, 16)) ));			
		history11.add(new history(10082005, 33008179, 100, "Heley", "Hoover", sdf.format(new Date(66, 0, 16)) ));
		Items11.add(new Item(33008179,44008177,600,"Electric Engine",history11));
		history11= new ArrayList<history>();
		
		history11 = new ArrayList<history>();
		history11.add(new history(10082006, 33008180, 100, "row 1", "Sony", sdf.format(new Date(23, 0, 16)) ));
		history11.add(new history(10082007, 33008180, 100, "Chopper", "Sony", sdf.format(new Date(13, 0, 16)) ));
		history11.add(new history(10082008, 33008180, 100, "Slingshot", "Amdahl", sdf.format(new Date(63, 0, 16)) ));		
		history11.add(new history(10082009, 33008180, 100," Boss Hoss","Sony", sdf.format(new Date(64, 0, 16)) ));			 
		history11.add(new history(10082010, 33008180, 100,"Cruiser", "Sony", sdf.format(new Date(65, 0, 16)) ));			
		history11.add(new history(10082011, 33008180, 100, "Heley", "Hoover", sdf.format(new Date(66, 0, 16)) ));
		Items11.add(new Item(33008180,44008177,600,"Electric Gears",history11));
		history11=  new ArrayList<history>();
		
		
		User11.add(new User(1111,1111,"test","ferdia123"));
	
		Company11.add(new Company(44008177,"Ericksson",Items11,User11));
	
	//	Items11 = new ArrayList<Item>();
		
		// Second company Apple ----------------------------------------
		
/*		history11 = new ArrayList<history>();
		history11.add(new history(10008177, 10006177, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(20008177, 10006177, 100, "Free Spinner","Ericksson", new Date(53, 0, 16) ));	
		history11.add(new history(10008177, 10006177, 100, "Heavens Angel", "Bosch", new Date(43, 0, 16) ));		
		history11.add(new history(10008177, 10006177, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(10008177, 10006177, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(10008177, 10006177, 100, "Base Liner", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(10008177, 10006177, 100, "Slingkhot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(10008177, 10006177, 100," Boss Ross","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(10008177, 10006177, 100,"Crusher", "Sony", new Date(65, 0, 16) ));			
		
		Items11.add(new Item(10006177,44008177,"Tullamore",900,"Washers",history11));
		history11=  new ArrayList<history>();
		
		
		history11 = new ArrayList<history>();
		history11.add(new history(11119177, 10007177, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(11118177, 10007177, 100, "Chopper", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(11117177, 10007177, 100, "Slingshot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(11116177, 10007177, 100," Boss Hoss","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(11115177, 10007177, 100,"Cruiser", "Sony", new Date(65, 0, 16) ));			
		history11.add(new history(11114177, 10007177, 100, "Heley", "Hoover", new Date(66, 0, 16) ));
		Items11.add(new Item(10007177,44008177,"Belfast",600,"Hair Driers",history11));
		history11= new ArrayList<history>();
		
		history11 = new ArrayList<history>();
		history11.add(new history(10338177, 11998877, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(20338177, 11998877, 100, "Free Spinner","Ericksson", new Date(53, 0, 16) ));	
		history11.add(new history(30008177, 11998877, 100, "Heavens Angel", "Bosch", new Date(43, 0, 16) ));		
		history11.add(new history(40008177, 11998877, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		Items11.add(new Item(11998877,44008177,"Waterford",400,"Curling Tongs",history11));
		history11= new ArrayList<history>();
		
		history11 = new ArrayList<history>();
		history11.add(new history(10208277, 33008177, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(10308277, 33008177, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(10408277, 33008177, 100, "Base Liner", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(10508277, 33008177, 100, "Slingkhot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(10608277, 33008177, 100," Boss Ross","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(10708277, 33008177, 100,"Crusher", "Sony", new Date(65, 0, 16) ));	
		Items11.add(new Item(33008177,44008177,"Limerick",600,"Bearings",history11));
		history11= new ArrayList<history>();
		
		Company11.add(new Company(44008177,"Apple",Items11,User11));
		Items11=new ArrayList<Item>();
		
		
		
		// Third Company -- Krupps ------------------------------------------------
		history11 = new ArrayList<history>();
		history11.add(new history(10108177, 55008177, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(10208177, 55008177, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(10308177, 55008177, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(10408177, 55008177, 100, "Base Liner", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(10608177, 55008177, 100, "Slingkhot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(10708177, 55008177, 100," Boss Ross","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(10808177, 55008177, 100,"Crusher", "Sony", new Date(65, 0, 16) ));			
		Items11.add(new Item(55008177,44448177,"Galway",700,"Washing Machine",history11));
		history11= new ArrayList<history>();
		
		history11 = new ArrayList<history>();
		history11.add(new history(10008172, 33008177, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(10008173, 33008177, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(10008174, 33008177, 100, "Base Liner", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(10008175, 33008177, 100, "Slingkhot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(10008176, 33008177, 100," Boss Ross","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(10008179, 33008177, 100,"Crusher", "Sony", new Date(65, 0, 16) ));	
		Items11.add(new Item(33008177,44448177,"Tipperary",600,"Dish Washer",history11));
		history11= new ArrayList<history>();	
		
		history11 = new ArrayList<history>();
		history11.add(new history(10508177, 99008177, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(10608177, 99008177, 100, "Slingkhot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(10708177, 99008177, 100," Boss Ross","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(10808177, 99008177, 100,"Crusher", "Sony", new Date(65, 0, 16) ));	
		Items11.add(new Item(99008177,44448177,"WestMeath",400,"Tumble Drier",history11));
		history11=  new ArrayList<history>();	
		
		
		
		
		Company11.add(new Company(44448177,"Krupps",Items11,User11));
		Items11=new ArrayList<Item>();
		
	// Fourth Company -- Sony --------------------------------------------------------
		history11 = new ArrayList<history>();
		history11.add(new history(44008177, 34343434, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(45008177, 34343434, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(46008177, 34343434, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(47008177, 34343434, 100, "Base Liner", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(48008177, 34343434, 100, "Slingkhot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(44008277, 34343434, 100," Boss Ross","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(44008377, 34343434, 100,"Crusher", "Sony", new Date(65, 0, 16) ));	
		history11.add(new history(44008477, 34343434, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(44008577, 34343434, 100, "Free Spinner","Ericksson", new Date(53, 0, 16) ));	
		history11.add(new history(44008677, 34343434, 100, "Heavens Angel", "Bosch", new Date(43, 0, 16) ));	

		Items11.add(new Item(34343434,98989898,"London",1000,"Washers",history11));
		history11= new ArrayList<history>();	
		Company11.add(new Company(98989898,"Sony",Items11,User11));		
		Items11=new ArrayList<Item>();
		
		
		// Fifth Company -- KraftWerk --------------------------------------------------
		history11 = new ArrayList<history>();
		history11.add(new history(12231221, 54545454, 100, "Rough rider", "Toshiba",  new Date(63, 0, 16) ));		
		history11.add(new history(12231222, 54545454, 100, "Free Wheeler","Ericksson", new Date(53, 0, 16) ));	
		history11.add(new history(12231223, 54545454, 100, "Hells Angel", "Bosch", new Date(43, 0, 16) ));		
		history11.add(new history(12231224, 54545454, 100, "Bat out of hell", "Krupps", new Date(33, 0, 16) ));
		history11.add(new history(12231225, 54545454, 100, "Hells Angel", "Sony", new Date(23, 0, 16) ));
		history11.add(new history(12231226, 54545454, 100, "Chopper", "Sony", new Date(13, 0, 16) ));
		history11.add(new history(12231227, 54545454, 100, "Slingshot", "Amdahl", new Date(63, 0, 16) ));		
		history11.add(new history(12231230, 54545454, 100," Boss Hoss","Sony",new Date(64, 0, 16) ));			 
		history11.add(new history(12231231, 54545454, 100,"Cruiser", "Sony", new Date(65, 0, 16) ));			
		history11.add(new history(12231232, 54545454, 100, "Heley", "Hoover", new Date(66, 0, 16) ));
		history11.add(new history(12231233, 54545454, 100, "Free Loadr", "IBM", new Date(66, 0, 16) ));
		history11.add(new history(12231234, 54545454, 100, "Free Loadr", "IBM", new Date(66, 0, 16) ));			

		Items11.add(new Item(54545454,98989866,"Paris",1200,"Washers",history11));
		history11= new ArrayList<history>();
		Company11.add(new Company(98989866,"KraftWerk",Items11,User11));		
		Items11=new ArrayList<Item>();
		
		// Sixth Company -- Lidl -------------------------------------------------
		history11 = new ArrayList<history>();
		history11.add(new history(10005177, 34567654, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(10005178, 34567654, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		
		Items11.add(new Item(34567654,98989894,"San Francisco",200,"Washers",history11));
		history11= new ArrayList<history>();
		Company11.add(new Company(98989894,"KraftWerk",Items11,User11));	
		Items11=new ArrayList<Item>();
		
		// Seventh Company -- Aldi --------------------------------------------
		history11 = new ArrayList<history>();
		history11.add(new history(78876868, 56789453, 100, "Hard rider", "Apple",  new Date(63, 0, 16) ));		
		history11.add(new history(78876869, 56789453, 100, "Wombat out of hell", "Krupps", new Date(33, 0, 16) ));
		
		Items11.add(new Item(56789453,45657677,"Johannesburg",200,"Washers",history11));
		history11= new ArrayList<history>();
		Company11.add(new Company(45657677,"Aldi",Items11,User11));	
		Items11=new ArrayList<Item>();
		
		*/
	}

	public ArrayList<Company> getCompany11() {
		return Company11;
	}

	public void setCompany11(ArrayList<Company> company11) {
		Company11 = company11;
	}
	
 
	
	
        }	