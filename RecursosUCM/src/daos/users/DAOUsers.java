package daos.users;

import java.util.List;

import model.users.User;

public class DAOUsers {
	private List<User> users;
	private int lastIndexLooked;

	public DAOUsers(List<User> users) {
		this.users = users;
		this.lastIndexLooked = 0;
	}

	public boolean exists(String id) {
		for (int i = 0; i < users.size(); i++) {
			lastIndexLooked = i;
			if (users.get(i).getId().equals(id))
				return true;
		}
		return false;
	}

	public User getUserOfLastIndexLooked() {
		return this.users.get(this.lastIndexLooked);
	} 

	public DAOUsersMemento requestMemento() {
		return new DAOUsersMemento(this.lastIndexLooked);
	}

	public void restoreToMemento(DAOUsersMemento memento) {
		this.lastIndexLooked = memento.getState();
	}
	
	public User get(String id){	
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id))
				return users.get(i);
		}
		return null;		
	}
}
