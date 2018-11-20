package eventHandlerClass;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;


public class MouseTestPanel extends JPanel{
	
	private static final boolean Point = false;
	private int size;
	private Point pt;
	private DrawListener dl ;
	private boolean isDrawing;
	private DrawingDirectly dd;
	private ArrayList<MouserData> ptList;
	
	private JTextField txtSize;
	
	public MouseTestPanel() {
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
		
		dl = new DrawListener();
		addMouseListener(dl);
		
		
		
		size = 30;
		pt = new Point();
		pt.setLocation(10, 10);
		
		ptList = new ArrayList<MouserData>();
		
		Thread r=new Thread(dd);
		r.start();
		
		txtSize = new JTextField(10);
		add(txtSize);
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		

		for(MouserData tmpPT : ptList)
		{
			page.fillOval(tmpPT.pt.x-(tmpPT.size)/2, tmpPT.pt.y-(tmpPT.size)/2, tmpPT.size, tmpPT.size);
			
		}
		
		
	}
	
	private class DrawListener implements MouseListener{
		


		public void mouseClicked(MouseEvent event) {
			
			
		}
		public void mousePressed(MouseEvent event) {
			size = Integer.parseInt(txtSize.getText());
			
			pt=event.getPoint();
			ptList.add(new MouserData(event.getPoint(), size));
			isDrawing=true;
			repaint();
			
		}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		
	}
	
	private class DrawingDirectly implements Runnable{

		@Override
		public void run() {
			while(true) {
					pt=getMousePosition();
					System.out.println(""+getMousePosition().x);
					repaint();
			}
			
		}
		
	}
	
}
