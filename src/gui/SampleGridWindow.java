package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.Config;
import core.KeyBinder;
import core.Main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * The main window for the project, which has a button grid on the right and options on the left.
 * @author Henry
 */
public class SampleGridWindow extends JFrame{
	
	public ButtonGrid buttonGrid;
	public JPanel leftPanel;
	public JPanel modePanel;
	public JPanel loopPanel;
	
	public Button[][] grid;
	public Button[] loopButtons;
	
	/**
	 * Creates the Window and grid.
	 */
	public SampleGridWindow(){
		FlowLayout fl = new FlowLayout();
		fl.setHgap(10);
		fl.setVgap(10);
		setLayout(fl);
		
		//Set up the basic window.
		buttonGrid = new ButtonGrid(4,4,100,100);
		this.grid = buttonGrid.grid;
		leftPanel = (JPanel) setupLeftPanel();
		//leftPanel.setLayout(new GridLayout(2,0));
		
		this.add(leftPanel);
		this.add(Box.createHorizontalStrut(10));
		this.add(buttonGrid);
		
		this.pack();
		
		this.setVisible(true);
	}
	
	/**
	 * Sets-up and returns the left panel, with both the mode
	 * button and the loop buttons
	 * @return the leftPanel as a JPanel
	 */
	Container setupLeftPanel(){
		Container p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		
		JPanel modePanel = new JPanel();
		JPanel loopPanel = new JPanel();
		
		//Setup the modePanel
		ModeButton editToggle = new ModeButton(100,50);
		modePanel.add(new JLabel("Mode"));
		modePanel.add(editToggle);
		modePanel.setVisible(true);
		
        SpinnerModel tempo = new SpinnerNumberModel(138, 30, 480, 1);
        final JSpinner tempoDisplay = new JSpinner(tempo);
        JPanel tempoPanel = new JPanel();
        tempoDisplay.setSize(100, 50);
        tempoDisplay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Config.tempo = ((SpinnerNumberModel)tempoDisplay.getModel()).getNumber().intValue();
            }
        });
        tempoPanel.setAlignmentY(CENTER_ALIGNMENT);
        tempoPanel.add(new JLabel("Tempo"));
		tempoPanel.add(tempoDisplay);
		tempoPanel.setVisible(true);
		
		//Setup the loopPanel
		int n = 4;
		GridLayout gl = new GridLayout(n+1,0);
		gl.setHgap(2);
		gl.setVgap(2);
		loopPanel.setLayout(gl);
		loopButtons = new Button[n];
		loopPanel.add(new JLabel("Loops"));
		for(int i = 0; i < n; i++){
			loopButtons[i] = new LoopButton();
			loopPanel.add(loopButtons[i]);
		}
		loopPanel.setVisible(true);
        loopPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		p.add(modePanel);
		p.add(tempoPanel);
		p.add(loopPanel);
		p.setVisible(true);
		pack();
		return p;
	}
	
	public static void main(String[] args){
		SampleGridWindow window = new SampleGridWindow();
        window.setJMenuBar(new TopMenuBar());
        window.setSize(window.getWidth(), window.getHeight() + 30);
		window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setFocusable(true);
        window.requestFocusInWindow();
        window.addKeyListener(new KeyBinder());
        Config.mainWindow = window;
        Config.buildKeyBinds();
		System.out.println("done");
	}
}
