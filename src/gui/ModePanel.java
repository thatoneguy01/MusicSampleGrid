package gui;

import java.awt.Component;

import javax.swing.JPanel;

public class ModePanel extends JPanel {
	ModeButton editToggle;
	public ModePanel(){
		editToggle = new ModeButton(100,50);
		this.add(editToggle);
		this.setVisible(true);
	}
}
