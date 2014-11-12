package core;

import gui.Button;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Daniel on 11/12/14.
 */
public class KeyBinder implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            Character keyPressed = new Character(e.getKeyChar());
            System.out.println(keyPressed + " pressed");
            Button toPress = Config.keyBinds.get(keyPressed);
            toPress.press();
        }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
