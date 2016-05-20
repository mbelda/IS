package commands;

import controller.Controller;

public class ExtractMaterialCommand implements Command {

	@Override
	public void execute(Controller c) {
		c.extractMaterial();
	}
}
