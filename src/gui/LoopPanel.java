package gui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class LoopPanel extends JPanel{
	
	Button[] loopButtons;
	
	public LoopPanel(int n){
		setLayout(new GridLayout(n,0));
		
		loopButtons = new Button[n];
		
		for(int i = 0; i < n; i++){
			loopButtons[i] = new LoopButton();
			add(loopButtons[i]);
		}
		this.setVisible(true);
	}

}
