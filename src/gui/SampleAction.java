package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import core.Main;

public class SampleAction implements Action{

	//Has a sound
	File soundFile;
	
	public SampleAction(){
		String path = new File("").getAbsolutePath();
		path.concat("\\ext\\20CenFox.mid");
		soundFile = new File(path);
		try {
			Main.soundSystem.loadSound(soundFile.toURL(),"a");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path);
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//Play the sound
		Main.soundSystem.play("a");
		System.out.println("~~~SOUND~~~");

	}
	
}
