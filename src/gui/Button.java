package gui;
import java.awt.*;

import javax.swing.*;

public class Button extends JButton{
	
	protected Action pressAction;
	
	protected int x,y;
	
	public Button(int xSize,int ySize){
		x = xSize;
		y = ySize;
	}
	
	public void press(){
		pressAction.execute();
	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(x,y);
		
	}
}
