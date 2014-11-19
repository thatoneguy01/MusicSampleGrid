package gui;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * A Button which will play a sound sample when pressed.
 * @author Henry
 */
public class SampleButton extends Button {
	
	public SampleButton(){
		this(100,100);
	}
	
	public SampleButton(int x, int y){
		super(x, y);
		this.pressAction = new SampleAction();
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(Config.editMode){
                    //changeSound();
					loadSound();
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
//	public void changeSound(/*The sound class*/){
//		((SampleAction)this.pressAction).changeSound();
//	}
    public void loadSound() {((SampleAction) this.pressAction).loadSound();}
}
