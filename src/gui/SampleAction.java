package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;
import core.Main;

import javax.sound.sampled.Clip;

/**
 * An action to play a sound sample.
 * @author Henry
 */
public class SampleAction implements Action, Saveable{

	//Has a sound
	File soundFile;
	String soundAlias;
    Clip clip;
    int volume = 5;
	
	public SampleAction(){

	}

    public File getSoundFile() {
        return soundFile;
    }

	@Override
	public void execute() {
		//Play the sound
		//AudioPlaybackSystem.playClip(soundAlias);
        if (this.clip != null) {
            AudioPlaybackSystem.playJSClip(this.clip);
        }
        System.out.println("~~~SOUND~~~");
        System.out.println(saveString());

	}

	/**
	 * Open a file chooser for the user to setup the action
	 */
    public void loadSound()
    {
        File clip = FileAccess.choseFile();
        soundFile = clip;
        if (clip == null)
            return;
        setClip(clip);
    }

    /**
     * Gets the clip attached the this action.
     * @return The clip.
     */
    public Clip getClip()
    {
        return clip;
    }
    
    /**
     * Sets the clip for this action, loading it into the play back system.
     * @param f The file to attach to this action.
     */
    public void setClip(File f){
    	if (f == null)
            return;
        this.clip = AudioPlaybackSystem.createJSClip(f);
    }

	@Override
	public String saveString() {
		String s = "SampleAction: ";
		if(soundFile != null){
			s += soundFile.getAbsolutePath() + "\n";
		}
		else{
			s += "no file\n";
		}
		return s;
	}

	@Override
	public Saveable fromString(String s) {
		SampleAction sa = new SampleAction();
		if(!s.contains("SampleAction: ")){
			return null;
		}
		
		s = s.replace("SampleAction ", "");
		s = s.replace("\n", "");
		
		File f = new File(s);
		sa.setClip(f);
		
		return sa;
	}
}
