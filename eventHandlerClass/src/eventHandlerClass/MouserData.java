package eventHandlerClass;

import java.awt.Point;

public class MouserData {
	public Point pt;
	public int size;
	
	public MouserData() {
		pt = new Point();
		size = 40;
	}
	
	public MouserData(Point pt, int size) {
		this.pt=pt;
		this.size=size;
	}
	
	
}
