
public class Passenger extends User {

	public Passenger(String username, String mobileNumber, String email, String password) {

		super(username, mobileNumber, email, password);

	}

	void requestAride(String source, String destination, Db d) {
		boolean RideAdded = false;
		String ride = source.concat(" ").concat(destination).concat(" ").concat(this.getUsername());

		for (int i = 0; i < d.getUsers().size(); i++) { // loop for all drivers
			if (d.getUsers().get(i) instanceof Driver) {
				Driver driver = (Driver) d.getUsers().get(i);

				for (int j = 0; j < driver.getRides().getFavAreas().size(); j++) {

					if (driver.getRides().getFavAreas().get(j).equals(source)) {

						driver.getRides().setAllRides(ride);
						RideAdded = true;
						break;

					}
				}

			}
			if (RideAdded == true) {
				break;
			}

		}

	}

}