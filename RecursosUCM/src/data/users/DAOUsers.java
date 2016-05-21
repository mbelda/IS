package data.users;

import java.util.List;

import data.DAOClassroom;
import model.material.Classroom;
import model.users.User;

public class DAOUsers {
	
	private static DAOUsers theDaoUsers;
	private List<User> users;
	private int lastIndexLooked;
	

	private DAOUsers(List<User> users) {
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
	
	public static DAOUsers getDaoUsers(List <User> l) {
		if ( theDaoUsers == null) {
			theDaoUsers = new  DAOUsers(l);
		}
		return  theDaoUsers;
	}
}
