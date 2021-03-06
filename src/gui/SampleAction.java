package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;
import core.Main;

import javax.sound.sampled.Clip;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

//import com.sun.xml.internal.txw2.Document;

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
       // System.out.println(saveString());

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
	public void save(Document doc, Element parentElement) {
		try{
			Element child = doc.createElement("SampleAction");
			if(soundFile != null){
				child.setAttribute("file", soundFile.getCanonicalPath());
				child.setAttribute("volume", volume+"");
			}
			parentElement.appendChild(child);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void load(Element node) {
		
		String filePath = "";
		
		if(node.hasAttribute("volume")){
			filePath = node.getAttribute("file");
			File f = new File(filePath);
			soundFile = f; 
			setClip(f);
		}
			
		int v = 5;
		
		if(node.hasAttribute("volume")){
			v = Integer.parseInt(node.getAttribute("volume"));
			volume = v;	
		}
		
		System.out.println("Sample Action: " + filePath + " " + v);
		
	}
}
