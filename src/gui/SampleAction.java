package gui;

import java.io.File;
import java.io.IOException;

public class SampleAction implements Action{

	//Has a sound
	File soundFile;
	
	public SampleAction(){
		String path = new File("").getAbsolutePath();
		path.concat("\\ext\\20CenFox.mid");
		soundFile = new File(path);
		System.out.println(path);
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//Play the sound
		System.out.println("~~~SOUND~~~");

	}
	
}
