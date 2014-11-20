package gui;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SampleButton extends Button {

    Color pressColor = Color.yellow;
    public ButtonEditMenu edit = null;
	
	public SampleButton(int x, int y){
		super(x, y);
		this.pressAction = new SampleAction();
        SampleButton b = this;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(Config.editMode){
                    if (edit == null)
                        edit = new ButtonEditMenu(b);
                    boolean vis = edit.isVisible();
                    ButtonEditMenu.hideAll();
                    if (!vis)
                        edit.showMenu();
				}
				else{
                    setPressColor();
					press();
				}
				System.out.println("pressed");
                Config.mainWindow.requestFocusInWindow();
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
    public void setPressColor() {this.pressColor = edit.caller.pressColor;}

    @Override
    public void press() {
        super.press();
        if (((SampleAction)pressAction).clip == null)
            return;
        setBackground(pressColor);
        try {
            Thread.sleep(((SampleAction)pressAction).clip.getMicrosecondLength()/1005);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setBackground(Color.white);
    }
}
