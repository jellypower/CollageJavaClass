package eventHandlerClass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import java.awt.*;

public class MouserMotionPanel extends JPanel{
	
	private Point pt1,pt2;
	
	
	public MouserMotionPanel() {
		setPreferredSize(new Dimension(600,600));
		setBackground(Color.white);
		
		pt1 = new Point();
		pt1 = new Point();
		
		
	}
}
