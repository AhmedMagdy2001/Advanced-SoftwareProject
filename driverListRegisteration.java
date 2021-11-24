
public class driverListRegisteration {

	public void verifydriverRegistration(String username, Db data) {

		for (int i = 0; i < data.getPendingRegistrations().size(); i++) {
			
			if (data.getPendingRegistrations().get(i).getUsername().equals(username)) {
				
				data.getPendingRegistrations().get(i).setVerify(true);
				
				User user = (User)data.getPendingRegistrations().get(i);
				
				data.setUsers(user);
				
				data.getPendingRegistrations().remove(data.getPendingRegistrations().get(i));
				break;
			}
		}
	}

	public void ListdriverRegistrations(Db users) {

		for (int i = 0; i < users.getPendingRegistrations().size(); i++) {

			System.out.println("|' Username: "+users.getPendingRegistrations().get(i).getUsername());
			System.out.println("|  Nationalid:"+ users.getPendingRegistrations().get(i).getNationalId());
			System.out.println("|' Drivinglicense: "+users.getPendingRegistrations().get(i).getDrivingLicense()+"\n");
		}

	}

}
