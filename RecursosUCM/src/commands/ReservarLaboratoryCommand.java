package commands;

import controller.Controller;

public class ReservarLaboratoryCommand implements Command {

	@Override
	public void execute(Controller c) {
		c.reservarLaboratory();
	}

}
