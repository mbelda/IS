package commands;

import controller.Controller;

public class ExtractMaterialCommand implements Command {

	@Override
	public void execute(Controller c) {
		// TODO Auto-generated method stub
		c.extractMaterial();
	}

}
