import java.util.ArrayList;

public class Rides {
	
	private ArrayList<String> FavAreas = new ArrayList<String>();
	private ArrayList<String> allRides = new ArrayList<String>();
	
	private ArrayList<String> RidesPrice = new ArrayList<String>();


	void addFavArea(String source, Driver driver) {
		this.FavAreas.add(source);

	}
	
	public ArrayList<String> getFavAreas() {

		return FavAreas;
	}

	void listAllRides(Driver driver) {
		for (int i = 0; i < this.allRides.size(); i++) {

			String[] rideInfo = this.allRides.get(i).split(" ");
			System.out.println(
					"Passenger:" + rideInfo[2] + " has requested a ride from " + rideInfo[0] + " to " + rideInfo[1]);

		}
	}

	public void setAllRides(String ride) {
		this.allRides.add(ride);
	}
	public ArrayList<String> getAllRides() {
		return this.allRides;
	}
	
	public int getRidesPrice(String source, String destination) {
		int price = 0;
		for(int i=0; i<this.RidesPrice.size(); i++) {
			String[] rideInfo = this.RidesPrice.get(i).split(" ");
			
			if(rideInfo[0].equals(source)&& rideInfo[1].equals(destination)) {
				price =  Integer.parseInt(rideInfo[2]);
				break;
			}
		}
		return price;
		
	}

	public void setRidesPrice(int rideprice, String PassengerName,String DriverName) {
		
		for (int i = 0; i < this.allRides.size(); i++) {
			String[] rideInfo = this.allRides.get(i).split(" ");
			
          if(rideInfo[2].equals(PassengerName)) {  //fe moshkla msh moshkla awy
        	  
        	  this.RidesPrice.add(rideInfo[0]+" "+ rideInfo[1]+" "+rideprice +" "+DriverName);
          }
			
		}
		
	}
	public String searchDriver(int price){
		String driver= "";
		for(int i = 0 ; i < this.RidesPrice.size();i++) {
			String[] rideInfo = this.RidesPrice.get(i).split(" ");
			
			if(Integer.parseInt(rideInfo[2] )== price) {
				driver = rideInfo[3];
			}
		}
		return driver;
	}
	

}
