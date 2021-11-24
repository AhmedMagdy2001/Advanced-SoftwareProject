
public class ArrayRegistrations implements UserRegisteration {

	Db data;

	public ArrayRegistrations(Db data) {
		this.data = data;
	}

	public void Register(User user) {
		
		if (user instanceof Driver) {

			Driver driver = (Driver) user;
			data.addNewDriver(driver);

		}
		
		else if(user instanceof Passenger) {
			data.getUsers().add(user);
		}
		

	}

}
