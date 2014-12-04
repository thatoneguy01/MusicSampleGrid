package gui;

import core.AudioPlaybackSystem;
import core.Config;
import core.FileAccess;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Daniel on 11/19/14.
 */
public class ButtonEditMenu extends JPopupMenu {

    SampleButton caller = null;
    VolSlider slider = null;

    public ButtonEditMenu(final SampleButton button)
    {
        caller = button;

        JMenuItem source = new JMenuItem("Load Sound");
        source.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                button.loadSound();
            }
        });
        JMenuItem rec = new JMenuItem("Record Sound");
        rec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FileAccess.createClip();
            }
        });
        JMenuItem color = new JMenuItem("Choose Press Color");
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                caller.pressedColor = JColorChooser.showDialog(new JPanel(), "Choose press color", button.pressedColor);
            }
        });
        /*JMenuItem volume = new JMenuItem("Volume");

        volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AudioPlaybackSystem.setVolume(((SampleAction)caller.pressAction).clip);
            }
        });*/
//        MenuSlider volume;
//        if (((SampleAction)caller.pressAction).clip != null) {
//            volume = new MenuSlider(AudioPlaybackSystem.getVolPercent(((SampleAction) caller.pressAction).clip));
//        }
//        else
//        {
//            volume = new MenuSlider();
//        }
//        volume.js.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                float percent = volume.getPercent();
//                if (((SampleAction)caller.pressAction).clip != null)
//                    AudioPlaybackSystem.setVolume(((SampleAction)caller.pressAction).clip, percent);
//            }
//        });
        JMenuItem volume = new JMenuItem();
        slider = new VolSlider();
        if (((SampleAction)caller.pressAction).clip != null) {
            slider = new VolSlider(AudioPlaybackSystem.getVolPercent(((SampleAction) caller.pressAction).clip));
        }
        slider.setVisible(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float percent = slider.getPercent();
                if (((SampleAction)caller.pressAction).clip != null)
                    AudioPlaybackSystem.setVolume(((SampleAction)caller.pressAction).clip, percent);
            }
        });
        volume.add(slider);
        this.add(source);
        this.add(rec);
        this.add(color);
        this.addSeparator();
        this.add(new JMenuItem("Volume"));
        this.add(volume);
        Config.mainWindow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!contains(e.getX(), e.getY()))
                    setVisible(false);
            }
        });
        //Point p = MouseInfo.getPointerInfo().getLocation();
        //this.setLocation(p);
        //this.show(button, (int)p.getX(), (int)p.getY());
        //this.setVisible(true);
    }

    public void showMenu()
    {
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation((int)p.getX(), (int)p.getY());
        this.setVisible(true);
    }

    public static void hideAll() {
        for (int i = 0; i < Config.mainWindow.grid.length; i++) {
            for (int j = 0; j < Config.mainWindow.grid[i].length; j++) {
                if (((SampleButton)Config.mainWindow.grid[i][j]).edit != null)
                    ((SampleButton)Config.mainWindow.grid[i][j]).edit.setVisible(false);
            }
        }
    }
}
