package gui;

import core.Config;
import core.Loop;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by Daniel on 11/12/14.
 */
public class LoopBuilderWindow extends JFrame
{

    Loop loop = new Loop();
    BeatButtonArray beats;

    public LoopBuilderWindow(final SampleLoopAction toNotify)
    {
        this.setLayout(new GridLayout(1, 2, 0, 20));
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(2,1));
        beats = new BeatButtonArray();
        left.add(beats);
        JPanel lowerLeft = new JPanel(new GridLayout(2,1));
        JTextArea infoPanel = new JTextArea();
        infoPanel.setEditable(false);
        lowerLeft.add(infoPanel);
        JPanel buttons = new JPanel(new GridLayout(1,2));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toNotify.setLoop(loop);
                dispose();
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toNotify.setLoop(null);
                dispose();
            }
        });
        buttons.add(saveButton);
        buttons.add(cancelButton);
        lowerLeft.add(buttons);
        left.add(lowerLeft);
        Button[][] playbackGrid = Config.mainWindow.buttonGrid.grid;
        SoundSelectorGrid soundGrid = new SoundSelectorGrid(playbackGrid.length, playbackGrid[0].length, Config.mainWindow, this);
        this.add(left);
        this.add(soundGrid);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocation(200, 150);
        this.setVisible(true);
    }

    public void build(Clip sound, String file)
    {
        int index = beats.activeIndex;
        if (index == -1)
            return;
        else
        {
            loop.addSound(index, sound, file);
            beats.buttonAt(beats.activeIndex).baseColor = Color.lightGray;
        }
    }

    public Loop finish() {
        this.setVisible(false);
        this.dispose();
        return loop;
    }
}
