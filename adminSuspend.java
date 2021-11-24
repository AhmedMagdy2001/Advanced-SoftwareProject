

public class adminSuspend {
	Db data;

	public adminSuspend(Db data) {
		this.data = data;
	}

	public void suspend(String username) {
		for (int i = 0; i < data.getUsers().size(); i++) {
			if (data.getUsers().get(i).getUsername().equals(username)) {

				data.getUsers().get(i).setSuspend(true);

				break;
			}
		}
	}
	public void unsuspend(String username) {
		for (int i = 0; i < data.getUsers().size(); i++) {
			if (data.getUsers().get(i).getUsername().equals(username)) {

				data.getUsers().get(i).setSuspend(false);

				break;
			}
		}
	}

	public void suspendedList() {
		for (int i = 0; i < data.getUsers().size(); i++) {
			if (data.getUsers().get(i).getSuspend()) {
				System.out.println("suspended users \n" + (i + 1) + "- " + data.getUsers().get(i).getUsername());
			}

		}
	}

}
