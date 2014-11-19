package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * A 2d array of buttons which can be saved and embedded in other JPanels.
 * @author Henry
 */
public class ButtonGrid extends JPanel implements Saveable{
	public SampleButton[][] grid;
	
	/**
	 * Simple Constructor which only takes number of x and y
	 * @param xSize the width of the grid
	 * @param ySize the height of the grid
	 */
	public ButtonGrid(int xSize, int ySize){
		this(xSize,ySize,100,100);
	}
	
	/**
	 * A constructor which sets up the entire grid, taking the size and pixel size of each button.
	 * @param xSize the width of grid
	 * @param ySize the height of the grid
	 * @param buttonWidth the width of a button
	 * @param buttonHeight the height of a button
	 */
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
	
	//Saveable

	@Override
	public String saveString() {
		//Surround with 'Grid'
		String s = "Grid\n";
		//Include the save string of each button. seperated by '::'
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				s += ((SampleAction) grid[i][j].pressAction).saveString() + "::";
			}
		}
		s += "Grid\n";
		return s;
	}

	@Override
	public Saveable fromString(String s) {
		ButtonGrid bg = new ButtonGrid(4,4);
		
		//Remove the Grids on either side
		if(!s.contains("Grid\n") || !(s.replaceFirst("Grid\n", "")).contains("Grid")){
			return null;
		}
		s = s.replaceAll("Grid\n", "");
		
		//Split along those '::' we added
		String[] lines = s.split("::"); 
		if(lines.length != 16){
			return null;
		}
		
		//Loop through to recreate the buttons
		for(int i = 0; i < 16; i++){
			SampleButton b = new SampleButton();
			SampleAction sa = new SampleAction();
			b.pressAction = (Action) sa.fromString(lines[i]);
			bg.grid[i/4][i%4] = b;
		}
		return bg;
	}
}