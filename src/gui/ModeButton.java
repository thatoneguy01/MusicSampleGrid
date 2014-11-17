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
				Button b = ((Button)e.getSource());
				b.setText(Config.editMode?("Edit Mode"):("Play Mode"));
				b.setBackground(Config.editMode?(Color.red):(Color.white));
			}
		});
        this.setBackground(Color.red);
		this.setVisible(true);
	}

}
