package gui;

import java.io.File;

import javax.sound.sampled.Clip;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import core.AudioPlaybackSystem;
import core.Config;
import core.Loop;

/**
 * Created by Daniel on 11/12/14.
 */
public class SampleLoopAction implements Action, Saveable {

    private Loop loop = null;//Loop.sampleLoop();

    @Override
    public void execute() {
        if (Config.editMode) {
            LoopBuilderWindow loopBuilderWindow = new LoopBuilderWindow(this);
        }
        else {
            if (loop != null) {
                if (loop.isLooping()) {
                    loop.endLoop();
                } else {
                    new Thread(loop).start();
                }
            }
            Config.mainWindow.requestFocusInWindow();
        }
    }

    public void setLoop(Loop l)
    {
        if (l != null)
            this.loop = l;
    }

	@Override
	public void load(Element node) {
		NodeList nodes = node.getElementsByTagName("Node");
		loop.endLoop();
		loop = new Loop();
		for(int index = 0; index < loop.files.length; index++){
			Element e = (Element) nodes.item(index);
			if(e != null){
				String file = e.getAttribute("clip");
				
				if(file != null && file.length() > 0){
					Clip clip = AudioPlaybackSystem.createJSClip(new File(file));
					
					loop.addSound(index, clip, file);
				}
			}
		}
	}

	@Override
	public void save(Document doc, Element parentElement) {

		Element e = doc.createElement("Loop");
		if(loop != null){
			String[] files = loop.getFiles();
			for(int i = 0; i < files.length; i++){
				String s = files[i];
				Element n = doc.createElement("Node");
				if(s != null && s.length() > 0)
					n.setAttribute("clip",s);
				e.appendChild(n);
			}
		}
		parentElement.appendChild(e);
	}
}
