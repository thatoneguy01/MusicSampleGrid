package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;
import core.Main;

import javax.sound.sampled.Clip;

public class SampleAction implements Action{

	//Has a sound
	File soundFile;
	String soundAlias;
    Clip clip;
	
	public SampleAction(){

	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//Play the sound
		//AudioPlaybackSystem.playClip(soundAlias);
        if (this.clip != null)
            AudioPlaybackSystem.playJSClip(this.clip);
        System.out.println("~~~SOUND~~~");

	}

//	public void changeSound() {
//		File clip = FileAccess.choseFile();
//        String clipPath = clip.getAbsolutePath();
//        this.soundAlias = clip.getName();
//        AudioPlaybackSystem.loadClip(soundAlias, clip);
//        System.out.println(clipPath + " " + soundAlias);
//	}

    public void loadSound()
    {
        File clip = FileAccess.choseFile();
        if (clip == null)
            return;
        this.clip = AudioPlaybackSystem.createJSClip(clip);
        Config.mainWindow.requestFocusInWindow();
        //assert clip != null;
    }

    public Clip getClip()
    {
        return clip;
    }
}
