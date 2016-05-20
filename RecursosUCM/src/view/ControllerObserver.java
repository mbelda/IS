package view;

import view.login.LoginMemento;

public interface ControllerObserver {
	public void onPrintingMessage(String message);

	public void onPrintingErrorMessage(String message);
	
	public void refreshLogin(LoginMemento loginMemento);
}
