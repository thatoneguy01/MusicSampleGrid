package gui;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * A button which will play a sound sample.
 * @author Henry
 *
 */
public class SampleButton extends Button {

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
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                UIManager.put("Button.select", pressedColor);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                UIManager.put("Button.select", Config.selectColor);
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
    public void setPressColor() {this.pressedColor = edit.caller.pressedColor;}

    @Override
    public void press() {
        if (((SampleAction)pressAction).clip == null)
            return;

        super.press();
    }
}
