package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/12/14.
 */
public class BeatButton extends Button {

    public Color baseColor;

    public BeatButton(int xSize, int ySize) {
        super(xSize, ySize);
        baseColor = getBackground();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                press();
            }
        });
    }


}
