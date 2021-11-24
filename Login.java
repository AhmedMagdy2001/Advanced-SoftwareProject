
public class Login {
	Db data;
	

	public Login(Db data ) {

		this.data = data;
	}

	User login(String username, String Password) {
		User user = null;

		for (int i = 0; i < data.getUsers().size(); i++) {

			if (data.getUsers().get(i).getUsername().equals(username) && 
					data.getUsers().get(i).getPassword().equals(Password)
					&&! data.getUsers().get(i).getSuspend()) {
				
				user = data.getUsers().get(i);
				break;
			}

		}
		for (int i = 0; i < data.getPendingRegistrations().size(); i++) {

			if (data.getPendingRegistrations().get(i).getUsername().equals(username) && 
					data.getPendingRegistrations().get(i).getPassword().equals(Password)) {

				System.out.println("You haven't been verified yet !!");
				break;
			}

		}
		for (int i = 0; i < data.getUsers().size(); i++) {

			if (data.getUsers().get(i).getUsername().equals(username) && data.getUsers().get(i).getSuspend() ) {
                user = null;
				System.out.println("You have been Suspended !!!");
				break;
			}

		}

		return user;

	}

}
