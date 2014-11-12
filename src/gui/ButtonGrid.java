package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonGrid extends JPanel{
	Button[][] grid;
	
	public ButtonGrid(int xSize,int ySize, int buttonWidth, int buttonHeight){
		this.setLayout(new GridLayout(xSize,ySize));
		grid = new Button[xSize][ySize];
		
		for(int i = 0; i < ySize; i++){
			for(int j = 0; j < xSize; j++){
				grid[i][j] = new SampleButton(buttonWidth,buttonHeight);
				this.add(grid[i][j]);
			}
		}
		
		this.setVisible(true);
	}
}
