package lms;

import javax.swing.JFrame;

public class LFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private LPanel lPanel;
	
	public LFrame() {
		// set attributes
		this.setLocation(400, 100);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// components
		this.lPanel = new LPanel();
		this.add(this.lPanel);
	}

}
