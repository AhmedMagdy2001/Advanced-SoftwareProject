import java.util.ArrayList;

public class Driver extends User {

	private String drivingLicense = "";
	private String NationalId = "";
	private Rides rides;

	private boolean verified = false;

	private ArrayList<String> ratings = new ArrayList<String>();

	public Driver(String username, String mobileNumber, String email, String password, String drivingLicense,
			String nationalId, Rides rides) {

		super(username, mobileNumber, email, password);

		this.rides = rides;
		this.drivingLicense = drivingLicense;
		NationalId = nationalId;

	}

	

	void listUsersRatings() {

		for (int i = 0; i < this.ratings.size(); i++) {
			
			
			System.out.println(this.ratings.get(i));

		}

	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public String getNationalId() {
		return NationalId;
	}

	public Rides getRides() {
		return rides;
	}

	public void setRatings(int rating, Passenger passenger) {
		this.ratings.add(passenger.getUsername() + " " + String.valueOf(rating));
	}

	public ArrayList<String> getRatings() {
		return ratings;
	}

	public boolean isVerify() {
		return verified;
	}

	public void setVerify(boolean verify) {
		this.verified = verify;
	}
}