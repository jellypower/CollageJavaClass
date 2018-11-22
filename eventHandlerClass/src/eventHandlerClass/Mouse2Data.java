package eventHandlerClass;

import java.awt.Point;

public class Mouse2Data {

	protected Point pt1,pt2;
	
	
	Mouse2Data(){
		pt1 = new Point();
		pt2 = new Point();
	}
	
	Mouse2Data(Point pt1,Point pt2) {
		this.pt1=pt1;
		this.pt2=pt2;
	}
	
	Mouse2Data(Mouse2Data cloneed){

		this.pt1 = new Point(cloneed.pt1.x,cloneed.pt1.y);
		this.pt2 = new Point(cloneed.pt2.x,cloneed.pt2.y);
	}
	
}
