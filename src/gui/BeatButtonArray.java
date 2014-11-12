package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 11/12/14.
 */
public class BeatButtonArray extends JPanel
{
    public int activeIndex = -1;
    private BeatButton[] buttons = new BeatButton[16];

    public BeatButtonArray()
    {
        this.setLayout(new GridLayout(1, 16));
        for (int i = 0; i < 16; i++)
        {
            BeatButton button = new BeatButton(10, 30);
            button.pressAction = new BeatButtonAction(i, button, this);
            buttons[i] = button;
            this.add(button);
        }

    }

    public BeatButton buttonAt(int index)
    {
        return buttons[index];
    }
}
