package gui;
import java.awt.*;

import javax.swing.*;

/**
 * A simple button which has an action, and when it is pressed, it will execute the pressAction.
 * @author Henry
 *
 */
public class Button extends JButton{
	
	protected Action pressAction;
	protected int x,y;
	
	public Button(int xSize,int ySize){
		x = xSize;
		y = ySize;
		this.setBackground(Color.white);
	}
	
	public void press(){
		pressAction.execute();
	}
	
	/**
	 * Overriden so it will be my specified size.
	 */
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(x,y);
	}
}
