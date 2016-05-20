package commands;

import controller.Controller;

public class ReturnMaterialCommand implements Command {

	@Override
	public void execute(Controller c) {
		c.returnMaterial();
	}

}
