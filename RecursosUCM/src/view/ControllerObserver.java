package view;

public interface ControllerObserver {
	public void onPrintingMessage(String message);

	public void onPrintingErrorMessage(String message);
}
