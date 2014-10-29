package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoopButton extends Button{
	public LoopButton(){
		super(100,50);
		
		//Make pressAction a looping sound.
		this.pressAction = new SampleAction();
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				press();
				System.out.println("pressed");
			}
		});
		
		this.setVisible(true);
	}
}
