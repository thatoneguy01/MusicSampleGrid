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
				press();
				System.out.println("pressed");
                SampleButton source = (SampleButton)e.getSource();
                if (Config.editMode)
                {
                    File clip = FileAccess.choseFile();
                    String clipPath = clip.getAbsolutePath();
                    source = (SampleButton)e.getSource();
                    source.soundAlias = clipPath;
                    AudioPlaybackSystem.loadClip(source.soundAlias, clip);
                }
                else
                {
                    AudioPlaybackSystem.playClip(source.soundAlias);
                }
			}
		});
	}
	
	/**
	 * Changes the played sound to the desired sound.
	 */
	public void changeSound(/*The sound class*/){
		
	}
}
