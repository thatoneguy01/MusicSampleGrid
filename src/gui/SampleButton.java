package gui;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SampleButton extends Button {
	
	public SampleButton(int x, int y){
		super(x, y);
		this.pressAction = new SampleAction();
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(Config.editMode){
					changeSound();
				}
				else{
					press();
				}
				System.out.println("pressed");
			}
		});
	}
	
	/**
	 * Changes the played sound to the desired sound.
	 */
	public void changeSound(/*The sound class*/){
		((SampleAction)this.pressAction).changeSound();
	}
}
