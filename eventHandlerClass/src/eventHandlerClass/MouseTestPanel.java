package eventHandlerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MouseTestPanel extends JPanel{
	
	private static final boolean Point = false;
	private int size;
	private Point pt;
	private Color selectedColor;
	private DrawListener dl ;
	private boolean isDrawing;
	private DrawingDirectly dd;
	private JButton btnColor;
	private ArrayList<MouserData> ptList;
	
	private JTextField txtSize;
	
	public MouseTestPanel() {
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
		
		
		dl = new DrawListener();
		addMouseListener(dl);
		
		btnColor = new JButton("color");
		btnColor.addActionListener(new ColorListener());
		add(btnColor);
		
		size = 30;
		pt = new Point();
		pt.setLocation(10, 10);
		
		ptList = new ArrayList<MouserData>();
		
		Thread r=new Thread(dd);
		r.start();
		
		txtSize = new JTextField(10);
		txtSize.setText("0");
		add(txtSize);
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		

		for(MouserData tmpPT : ptList)
		{
			page.setColor(tmpPT.color);
			page.fillOval(tmpPT.pt.x-(tmpPT.size)/2, tmpPT.pt.y-(tmpPT.size)/2, tmpPT.size, tmpPT.size);
			
		}
		
		
	}
	
	private class DrawListener implements MouseListener{
		


		public void mouseClicked(MouseEvent event) {
			
			
		}
		public void mousePressed(MouseEvent event) {
			size = Integer.parseInt(txtSize.getText());
			
			pt=event.getPoint();
			ptList.add(new MouserData(event.getPoint(), size,selectedColor));
			isDrawing=true;
			repaint();
			
		}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		
	}
	
	public class ColorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectedColor=JColorChooser.showDialog(btnColor, "COLOR CHOOSER", selectedColor);
		}
		
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
