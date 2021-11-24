import java.util.ArrayList;

public class Db {

	private ArrayList<Driver> PendingRegistrations = new ArrayList<Driver>();
	private ArrayList<User> users = new ArrayList<User>();

	public void setPendingRegistrations(ArrayList<Driver> pendingRegistrations) {
		PendingRegistrations = pendingRegistrations;
	}

	public ArrayList<Driver> getPendingRegistrations() {
		return PendingRegistrations;
	}

	public void addNewDriver(Driver driver) {
		this.PendingRegistrations.add(driver);
	}

	public void setUsers(User user) {
		this.users.add(user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void listDrivers() {
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i) instanceof Driver) {
				System.out.println("Driver's name: " + users.get(i).getUsername());
			}
		}
	}

	public User SearchDriver(String username) {
		User user = null;
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i) instanceof Driver && users.get(i).getUsername().equals(username)) {
				user = users.get(i);
			}
		}
		return user;
	}

}
