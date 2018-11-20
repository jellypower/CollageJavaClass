package eventHandlerClass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import java.awt.*;

public class MouserMotionPanel extends JPanel{
	
	private Point pt1,pt2;
	private DrawListener myListener;
	
	public MouserMotionPanel() {
		setPreferredSize(new Dimension(600,600));
		setBackground(Color.white);
		
		myListener = new DrawListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	
	public void paintCompoenet(Graphics g) {
		super.paintComponent(g);
		g.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
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
			System.out.println("in");
			pt1 = arg0.getPoint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("out");
			pt2 = arg0.getPoint();
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
