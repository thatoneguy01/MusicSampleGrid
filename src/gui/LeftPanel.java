package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class LeftPanel extends JPanel{
	public LeftPanel(){
		this.setLayout(new GridLayout(2,0));
		this.add(new ModePanel());
		this.add(new LoopPanel(4));
		this.setVisible(true);
	}
}
