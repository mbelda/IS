package daos.users;

public class DAOUsersMemento {

	private int lastIndexLooked;

	/*
	 * Everything is protected because we need to ensure a narrow interface for
	 * external classes (classes that are not directly linked with the
	 * Originator) while providing a wide interface to DAOUsers.
	 */
	protected DAOUsersMemento(int lastIndexLooked) {
		this.lastIndexLooked = lastIndexLooked;
	}

	protected int getState() {
		return lastIndexLooked;
	}

	protected void setState(int lastIndexLooked) {
		this.lastIndexLooked = lastIndexLooked;
	}

}
