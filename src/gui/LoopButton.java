package gui;

import core.Config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopButton extends Button{
	public LoopButton(){
		super(100,50);
		
		//Make pressAction a looping sound.
		this.pressAction = new SampleLoopAction();
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				press();
				System.out.println("pressed");
                Config.mainWindow.requestFocusInWindow();
			}
		});
		
		this.setVisible(true);
	}
}
