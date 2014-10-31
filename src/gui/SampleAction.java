package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;
import core.Main;

public class SampleAction implements Action{

	//Has a sound
	File soundFile;
	String soundAlias;
	
	public SampleAction(){

	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//Play the sound
		AudioPlaybackSystem.playClip(soundAlias);
        System.out.println("~~~SOUND~~~");

	}

	public void changeSound() {
		File clip = FileAccess.choseFile();
        String clipPath = clip.getAbsolutePath();
        this.soundAlias = clip.getName();
        AudioPlaybackSystem.loadClip(soundAlias, clip);
        System.out.println(clipPath + " " + soundAlias);
	}
	
}
