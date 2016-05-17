package commands;

import controller.Controller;

public class ReservarLaboratoryCommand implements Command {

	@Override
	public void execute(Controller c) {
		// TODO Auto-generated method stub
		c.reservarLaboratory();
	}

}
