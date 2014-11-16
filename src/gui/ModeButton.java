package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Config;

public class ModeButton extends Button {

	public ModeButton(int xSize, int ySize) {
		super(xSize, ySize);
		this.pressAction = new ModeSwitchAction();
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				press();
				((Button)e.getSource()).setText(Config.editMode?("Edit Mode"):("Play Mode"));
				((Button)e.getSource()).setBackground(Config.editMode?(Color.red):(Color.white));
			}
		});
		this.setVisible(true);
	}

}