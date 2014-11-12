package gui;

import core.Loop;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 11/12/14.
 */
public class LoopBuilderWindow extends JFrame
{

    Loop loop = new Loop();
    BeatButtonArray beats;

    public LoopBuilderWindow()
    {
        this.setLayout(new GridLayout(1, 2, 0, 20));
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(2,1));
        beats = new BeatButtonArray();
        left.add(beats);
        JTextArea infoPanel = new JTextArea();
        infoPanel.setEditable(false);
        left.add(infoPanel);
        ButtonGrid soundGrid = new ButtonGrid(4,4,40,40);
        this.add(left);
        this.add(soundGrid);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(200, 150);
        this.setVisible(true);
    }

    public void build(Clip sound)
    {
        int index = beats.activeIndex;
        if (index == -1)
            return;
        else
        {
            loop.addSound(index, sound);
        }
    }

    public Loop finish()
    {
        this.setVisible(false);
        this.dispose();
        return loop;
    }

}
