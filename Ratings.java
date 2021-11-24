
public class Ratings {

	
	void rateDriver(int rate, Passenger passenger,User user) {
		
		Driver driver = (Driver) user;
		if(rate >=1 && rate <=5 ) {
			
			driver.setRatings(rate, passenger);
			
		}
		else {
			System.out.println("Rating is only from 1 to 5 !!");
		}
		

	}

	void checkDriverAvgRating(User user) {
		
		Driver driver = (Driver) user;
		int numOfRates = driver.getRatings().size();
		double avg = 0 ;
		
		for (int i = 0; i < numOfRates ; i++) {
			
			String[] ratings = driver.getRatings().get(i).split(" ");
			avg += Integer.parseInt(ratings[1]);
			
		}
		avg = avg/numOfRates;

		System.out.println(driver.getUsername()+" got : " + avg );
	}
}
