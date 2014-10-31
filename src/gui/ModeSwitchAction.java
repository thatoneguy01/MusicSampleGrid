package gui;

import core.Config;

public class ModeSwitchAction implements Action {

	boolean nextMode = false;
	
	@Override
	public void execute() {
		Config.editMode = nextMode;
		nextMode = !nextMode;
	}

}
