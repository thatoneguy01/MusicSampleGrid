package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class LeftPanel extends JPanel{
	
	//The panel which holds the mode toggle button
	public ModePanel mPanel;
	
	//The panel which holds the loop buttons.
	public LoopPanel lPanel;
	
	public LeftPanel(){
		this.setLayout(new GridLayout(2,0));
		mPanel = new ModePanel();
		lPanel = new LoopPanel(4);
		this.add(mPanel);
		this.add(lPanel);
		this.setVisible(true);
	}
}
