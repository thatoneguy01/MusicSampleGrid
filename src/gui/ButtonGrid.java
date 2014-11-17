package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonGrid extends JPanel implements Saveable{
	public SampleButton[][] grid;
	
	public ButtonGrid(int xSize,int ySize, int buttonWidth, int buttonHeight){
		GridLayout gl = new GridLayout(xSize,ySize);
		gl.setHgap(2);
		gl.setVgap(2);
		this.setLayout(gl);
		grid = new SampleButton[xSize][ySize];
		
		for(int i = 0; i < ySize; i++){
			for(int j = 0; j < xSize; j++){
				grid[i][j] = new SampleButton(buttonWidth,buttonHeight);
				this.add(grid[i][j]);
			}
		}
		
		this.setVisible(true);
	}

	@Override
	public String saveString() {
		String s = "Grid\n";
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				s += ((SampleAction) grid[i][j].pressAction).saveString();
			}
		}
		return null;
	}
}