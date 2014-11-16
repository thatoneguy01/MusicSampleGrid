package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonGrid extends JPanel{
	public Button[][] grid;
	
	public ButtonGrid(int xSize,int ySize, int buttonWidth, int buttonHeight){
		GridLayout gl = new GridLayout(xSize,ySize);
		gl.setHgap(2);
		gl.setVgap(2);
		this.setLayout(gl);
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