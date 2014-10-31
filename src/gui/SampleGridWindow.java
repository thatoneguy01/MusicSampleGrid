package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

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
		new Main();
		Main.setupSoundSystem();
		Main.testPlay();
		setLayout(new GridLayout(0,2));
		
		grid = new ButtonGrid(4,4);
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
		System.out.println("done");
	}
}
