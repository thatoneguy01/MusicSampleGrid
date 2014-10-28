package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class SampleGridWindow extends JFrame{
	public SampleGridWindow(){
		setLayout(new GridLayout(2,0));
		
		ButtonGrid grid = new ButtonGrid(4,4);
		
		this.add(grid);
		
		this.pack();
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		SampleGridWindow window = new SampleGridWindow();
		window.setVisible(true);
		System.out.println("done");
	}
}
