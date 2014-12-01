package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Config;

/**
 * Button to change between edit and play modes.
 * @author Henry
 */
public class ModeButton extends Button {

	public ModeButton(int xSize, int ySize) {
		super(xSize, ySize);
		this.pressAction = new ModeSwitchAction();
		
		//Add an action listener to change color and text.
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				press();
				Button b = ((Button)e.getSource());
				b.setText(Config.editMode?("Edit Mode"):("Play Mode"));
				b.setBackground(Config.editMode?(Color.red):(Color.white));
                Config.mainWindow.requestFocusInWindow();
			}
		});
        this.setBackground(Color.red);
        this.setText("Edit Mode");
		this.setVisible(true);
	}

}
