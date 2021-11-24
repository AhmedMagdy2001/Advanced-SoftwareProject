

public class Admin extends User {
	
	Db b;
	adminSuspend suspend = new adminSuspend(b);
	driverListRegisteration verify = new driverListRegisteration();

	Admin(String username, String mobileNumber, 
			String email,String password, adminSuspend suspend,driverListRegisteration verify) {
		
		super(username, mobileNumber, email, password);
		this.suspend = suspend;
		this.verify = verify;

	}

}