package commands;

import controller.Controller;

public class ReturnMaterialCommand implements Command {

	@Override
	public void execute(Controller c) {
		// TODO Auto-generated method stub
		c.returnMaterial();
	}

}
