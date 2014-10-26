package gui;
import java.awt.*;

import javax.swing.*;

public class Button extends JButton{
	
	private Action pressAction;
	
	public void press(){
		pressAction.execute();
	}
}
