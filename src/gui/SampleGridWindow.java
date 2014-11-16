package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import core.Config;
import core.KeyBinder;
import core.Main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * The main window for the project, which has a button grid on the right and options on the left.
 * @author Henry
 *
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
		leftPanel = setupLeftPanel();
		leftPanel.setLayout(new GridLayout(2,0));
		
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
	JPanel setupLeftPanel(){
		JPanel p = new JPanel();
		JPanel modePanel = new JPanel();
		JPanel loopPanel = new JPanel();
		
		//Setup the modePanel
		ModeButton editToggle = new ModeButton(100,50);
		modePanel.add(editToggle);
		modePanel.setVisible(true);
		
		//Setup the loopPanel
		int n = 4;
		GridLayout gl = new GridLayout(n,0);
		gl.setHgap(2);
		gl.setVgap(2);
		loopPanel.setLayout(gl);
		loopButtons = new Button[n];
		for(int i = 0; i < n; i++){
			loopButtons[i] = new LoopButton();
			loopPanel.add(loopButtons[i]);
		}
		loopPanel.setVisible(true);
		
		p.add(modePanel);
		p.add(loopPanel);
		p.setVisible(true);
		return p;
	}
	
	public static void main(String[] args){
		SampleGridWindow window = new SampleGridWindow();
		window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Config.keyBinds.put(new Character('y'), window.grid[0][0]);
        window.setFocusable(true);
        window.addKeyListener(new KeyBinder());
        Config.mainWindow = window;
		System.out.println("done");
	}
}
