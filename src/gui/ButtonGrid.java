package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonGrid extends JPanel{
	Button[][] grid;
	
	public ButtonGrid(int xSize,int ySize){
		this.setLayout(new GridLayout(xSize,ySize));
		grid = new Button[xSize][ySize];
		
		for(int i = 0; i < xSize; i++){
			for(int j = 0; j < ySize; j++){
				grid[i][j] = new SampleButton(50,50);
				this.add(grid[i][j]);
			}
		}
		
		this.setVisible(true);
	}
}
