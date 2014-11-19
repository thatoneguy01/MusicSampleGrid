package gui;

import core.Config;

/**
 * An action to switch between edit and play mode
 * @author Henry
 */
public class ModeSwitchAction implements Action {

	boolean nextMode = false;
	
	@Override
	public void execute() {
		Config.editMode = !Config.editMode;
	}
}
