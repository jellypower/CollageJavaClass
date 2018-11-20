package eventHandlerClass;

import javax.swing.JFrame;

public class EventHandlerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MouseTestPanel primary = new MouseTestPanel();
		frame.getContentPane().add(primary);
		
		frame.pack();
		frame.setVisible(true);
	}

}
