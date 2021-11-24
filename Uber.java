
import java.util.Scanner;

//ArrayList<String> User = new ArrayList<String>();

public class Uber {

	public static void main(String[] args) {

		Db database = new Db();
		Rides rides = new Rides();
		adminSuspend Asuspend = new adminSuspend(database);
		driverListRegisteration verify = new driverListRegisteration();
		Admin admin = new Admin("menna", "123456", "email menna", "123456", Asuspend, verify);

		Login login = new Login(database);
		database.setUsers(admin);

		Ratings rating = new Ratings();

		ArrayRegistrations register = new ArrayRegistrations(database);

		int mainChoice, rChoice, passengerChoice, driverChoice, AdminChoice, rate, price;
		String username, mobileNumber, email, password, DriverLicense, NationalId, favArea, Source, Destination,
				verifyDriver, accept;

		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("1- Register \n2- Login \n3- Exit");
			mainChoice = Integer.parseInt(scan.nextLine());

			if (mainChoice == 1) { // register

				System.out.println("Would you like to Register as: \n1- Driver \n2- Passenger");
				rChoice = Integer.parseInt(scan.nextLine());

				if (rChoice == 1) { // register as a driver
					System.out.println("Enter the credentials: ");
					System.out.println("username: ");
					username = scan.nextLine();
					System.out.println("Email(Optional): ");
					email = scan.nextLine();
					System.out.println("MobileNumber: ");
					mobileNumber = scan.nextLine();
					System.out.println("Password: ");
					password = scan.nextLine();
					System.out.println("DriverLicense: ");
					DriverLicense = scan.nextLine();
					System.out.println("NationalID: ");
					NationalId = scan.nextLine();

					User driver = new Driver(username, mobileNumber, email, password, DriverLicense, NationalId, rides);

					register.Register(driver);

				} else if (rChoice == 2) { // register as a passenger
					System.out.println("Enter the credentials: ");
					System.out.println("username: ");
					username = scan.nextLine();
					System.out.println("Email(Optional): ");
					email = scan.nextLine();
					System.out.println("MobileNumber: ");
					mobileNumber = scan.nextLine();
					System.out.println("Password: ");
					password = scan.nextLine();

					User passenger = new Passenger(username, password, mobileNumber, email);

					register.Register(passenger);

				}

			} else if (mainChoice == 2) { // login

				System.out.println("username: ");
				username = scan.nextLine();
				System.out.println("Password: ");
				password = scan.nextLine();

				if (login.login(username, password) != null) {
					User user = login.login(username, password);

					if (user instanceof Driver) { // if the user is a driver

						Driver driver = (Driver) user;

						System.out.println("Welcome " + driver.getUsername() + " !");
						System.out.println("<---------->");
						while (true) {

							System.out.println("1- add your favourite areas");
							System.out.println("2- list all rides");
							System.out.println("3- list User Ratings");
							System.out.println("4- SignOut");

							driverChoice = Integer.parseInt(scan.nextLine());

							if (driverChoice == 1) {

								System.out.println("Enter your area:");
								favArea = scan.nextLine();
								rides.addFavArea(favArea, driver);

							} else if (driverChoice == 2) {

								rides.listAllRides(driver);
								if (rides.getAllRides().size() != 0) {
									System.out.println("Suggest a price: ");
									price = Integer.parseInt(scan.nextLine());
									System.out.println("Enter the passenger's username: ");
									username = scan.nextLine();
									driver.getRides().setRidesPrice(price, username, driver.getUsername());

								}

							} else if (driverChoice == 3) {

								driver.listUsersRatings();

							} else if (driverChoice == 4) {

								break;
							}
						}

					} else if (user instanceof Passenger) { // if the user is a passenger

						Passenger passenger = (Passenger) user;
						System.out.println("Welcome " + passenger.getUsername() + " !");
						System.out.println("<---------->");

						while (true) {
							System.out.println("1- Request a ride.");
							System.out.println("2- check a ride's offer.");
							System.out.println("3- check a driver's average rating.");
							System.out.println("4- logout.");

							passengerChoice = Integer.parseInt(scan.nextLine());

							if (passengerChoice == 1) {

								System.out.println("Enter Source:");
								Source = scan.nextLine();
								System.out.println("Enter Destination:");
								Destination = scan.nextLine();

								passenger.requestAride(Source, Destination, database);

							} else if (passengerChoice == 2) {

								System.out.println("Enter source: ");
								Source = scan.nextLine();
								System.out.println("Enter destination: ");
								Destination = scan.nextLine();

								System.out.println("ride's offer: "
										+ String.valueOf(rides.getRidesPrice(Source, Destination)) + "$");
								System.out.println("accept ride ?(y/n)");
								accept = scan.nextLine();

								if (accept.equals("y")) {

									System.out.println("rate the driver (1:5) : ");
									rate = Integer.parseInt(scan.nextLine());
									rating.rateDriver(rate, passenger, database.SearchDriver(
											rides.searchDriver(rides.getRidesPrice(Source, Destination))));
								}

							} else if (passengerChoice == 3) {
								database.listDrivers();
								System.out.println("Enter the name of the driver: ");
								username = scan.nextLine();

								rating.checkDriverAvgRating(database.SearchDriver(username));

							}

							else if (passengerChoice == 4) {
								break;
							}
						}

					} else if (user instanceof Admin) { // checks if the login info belongs to the admin
						Admin adminObj = (Admin) user;
						System.out.println("Welcome admin " + adminObj.getUsername() + " !");
						System.out.println("<----------------->");

						while (true) {
							System.out.println("1- list Pending Registerations.");
							System.out.println("2- verify driver registration. ");
							System.out.println("3- Suspend a User Account.");
							System.out.println("4- unSuspend a User Account.");
							System.out.println("5- logout");

							AdminChoice = Integer.parseInt(scan.nextLine());

							if (AdminChoice == 1) {

								verify.ListdriverRegistrations(database);

							} else if (AdminChoice == 2) {
								System.out.println("Enter driver's Username to be verified : ");
								verifyDriver = scan.nextLine();

								verify.verifydriverRegistration(verifyDriver, database);

							} else if (AdminChoice == 3) {

								System.out.println("Enter User's Username to be suspend : ");
								verifyDriver = scan.nextLine();
								Asuspend.suspend(verifyDriver);

							} else if (AdminChoice == 4) {
								System.out.println("Enter User's Username to be unsuspend : ");
								verifyDriver = scan.nextLine();
								Asuspend.unsuspend(verifyDriver);
							} else if (AdminChoice == 5) {
								break;
							}

						}

					} else if (user == null) { // if the driver is not verified by the admin
						System.out.println("You haven't been verified yet !!");
					} else { // if the login info is incorrect
						System.out.println("Wrong credintials");
					}

				}

			} else if (mainChoice == 3) { // logout
				break;
			}
		}
		scan.close();
	}
}
