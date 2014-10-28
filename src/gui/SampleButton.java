package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleButton extends Button {
	
	public SampleButton(int x, int y){
		super(x, y);
		this.pressAction = new SampleAction();
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				press();
				System.out.println("pressed");
			}
		});
	}
	
	/**
	 * Changes the played sound to the desired sound.
	 */
	public void changeSound(/*The sound class*/){
		
	}
}
