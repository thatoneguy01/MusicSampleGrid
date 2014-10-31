package gui;

import core.Config;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ModePanel extends JPanel {
	ModeButton editToggle;
	public ModePanel(){
		editToggle = new ModeButton(100,50);
        editToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.editMode = !Config.editMode;
                System.out.println("switched to edit mode" + Config.editMode);
            }
        });
		this.add(editToggle);
		this.setVisible(true);
	}
}
