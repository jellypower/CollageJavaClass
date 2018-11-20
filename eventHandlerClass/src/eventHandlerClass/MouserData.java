package eventHandlerClass;

import java.awt.*;
import javax.swing.*;

public class MouserData {
	public Point pt;
	public int size;
	public Color color;
	
	public MouserData() {
		pt = new Point();
		size = 40;
	}
	
	public MouserData(Point pt, int size, Color color) {
		this.pt=pt;
		this.size=size;
		this.color = color;
	}
	
	
}
