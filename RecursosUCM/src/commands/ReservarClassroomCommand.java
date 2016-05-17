package commands;

import controller.Controller;

public class ReservarClassroomCommand implements Command {

	@Override
	public void execute(Controller c) {
		// TODO Auto-generated method stub
		c.reservarClassroom();
	}

}
