package gui;

import core.Config;

import javax.swing.*;
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

    public ButtonEditMenu(SampleButton button)
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
        JMenuItem color = new JMenuItem("Choose Press Color");
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                caller.pressColor = JColorChooser.showDialog(new JPanel(), "Choose press color", button.pressColor);
            }
        });
        JMenuItem volume = new JMenuItem("Volume");
        volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        this.add(source);
        this.add(color);
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
