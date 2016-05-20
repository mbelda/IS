package view.login;

public class LoginMemento {

	private String lastValidUserName;

	public LoginMemento(String lastValidUserName) {
		this.lastValidUserName = lastValidUserName;
	}

	protected String getState() {
		return this.lastValidUserName;
	}

	protected void setState(String state) {
		this.lastValidUserName = state;
	}
}
