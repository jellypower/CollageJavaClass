package eventHandlerClass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.*;

public class MouserMotionPanel extends JPanel{
	
	//private Point pt1,pt2;
	private ArrayList<Mouse2Data> mouse2DataList;
	private Mouse2Data draggedData;
	private DrawListener myListener;
	
	public MouserMotionPanel() {
		setPreferredSize(new Dimension(600,600));
		setBackground(Color.white);
		
		//pt1 = new Point();
		//pt2 = new Point();
		
		mouse2DataList = new ArrayList<Mouse2Data>();
		draggedData = new Mouse2Data();
		
		myListener = new DrawListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D page2 = (Graphics2D)g;
		page2.setStroke(new BasicStroke(10));
		
		/*g.drawRect(draggedData.pt1.x, draggedData.pt1.y,
				draggedData.pt2.x-draggedData.pt1.x, 
				draggedData.pt2.y-draggedData.pt1.y);*/
		
		makeRect(g,draggedData.pt1,draggedData.pt2);
		for(Mouse2Data iter: mouse2DataList)
			makeRect(g,iter.pt1,iter.pt2);
		//g.drawRect(iter.pt1.x,iter.pt1.y, iter.pt2.x-iter.pt1.x, iter.pt2.y-iter.pt1.y);
	}
	
	private void makeRect(Graphics g, Point pt1, Point pt2) {
		
		int x,y,width,height;
		
		if(pt1.x>pt2.x) {
			x=pt2.x;
			width = pt1.x-pt2.x;
		}
		else {
			x=pt1.x;
			width = pt2.x-pt1.x;
		}
		if(pt1.y>pt2.y) {
			y=pt2.y;
			height = pt1.y-pt2.y;
		}
		else {
			y=pt1.y;
			height = pt2.y-pt1.y;
		}
		
		g.drawRect(x, y, width, height);
	}
	
	private class DrawListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			draggedData.pt1 = arg0.getPoint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			draggedData.pt2 = arg0.getPoint();
			mouse2DataList.add(new Mouse2Data(draggedData));
			
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			draggedData.pt2 = e.getPoint();
			repaint();
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
