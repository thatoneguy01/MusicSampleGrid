package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import core.Config;
import core.KeyBinder;
import core.Main;

import java.awt.GridLayout;
import java.awt.event.*;

/**
 * The main window for the project, which has a button grid on the right and options on the left.
 * @author Henry
 *
 */
public class SampleGridWindow extends JFrame{
	
	public ButtonGrid grid;
	public LeftPanel leftPanel;
	
	/**
	 * Creates the Window and grid.
	 */
	public SampleGridWindow(){
		setLayout(new GridLayout(0,2));
		
		grid = new ButtonGrid(4,4,100,100);
		leftPanel = new LeftPanel();
		
		this.add(leftPanel);
		this.add(grid);
		
		this.pack();
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		SampleGridWindow window = new SampleGridWindow();
		window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Config.keyBinds.put(new Character('y'), window.grid.grid[0][0]);
        window.setFocusable(true);
        window.addKeyListener(new KeyBinder());
        Config.mainWindow = window;
		System.out.println("done");
	}
}
