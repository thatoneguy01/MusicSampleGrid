package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

	@Override
	public void save(Document doc, Element parentElement) {
		Element child = doc.createElement("ButtonGrid");
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				((SampleAction)grid[i][j].pressAction).save(doc, child);
			}
		}
		
		parentElement.appendChild(child);
	}

	@Override
	public void load(String s) {
		// TODO Auto-generated method stub
		
	}
	

	
}