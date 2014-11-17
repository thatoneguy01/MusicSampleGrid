package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/16/14.
 */
public class SelectorButton extends Button {

    public SelectorButton(int xSize, int ySize, SoundSelectorGrid grid) {
        super(xSize, ySize);
        this.pressAction = new SoundSelectorAction(grid, this);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                press();
            }
        });
    }
}
