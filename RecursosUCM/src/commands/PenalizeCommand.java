package commands;

import controller.Controller;

public class PenalizeCommand implements Command {

	@Override
	public void execute(Controller c) {
		c.penalize();
	}

}
