package gui;

import core.Config;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniel on 11/19/14.
 */
public class TempoPanel extends JPanel {

    SpinnerModel display;

    public TempoPanel()
    {
        this.setLayout(new GridLayout(1,2));
        //JPanel buttons = new JPanel(new GridLayout(2,1));
        display = new SpinnerNumberModel(138, 480, 30, 1);
//        JButton increment = new JButton("+");
//        increment.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Config.tempo++;
//                display.setText("" + Config.tempo);
//            }
//        });
//        JButton decrement = new JButton("-");
//        decrement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Config.tempo--;
//                display.setText("" + Config.tempo);
//            }
//        });
//        display.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                Config.tempo = Integer.getInteger(display.getText());
//            }
//        });
    }
}
