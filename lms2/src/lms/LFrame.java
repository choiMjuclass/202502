package lms;

import javax.swing.JFrame;

import lms.LConstants.EFrame;

public class LFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private LMainPanel lMainPanel;
	
	public LFrame() {
		// set attributes
		this.setLocation(EFrame.eX.value(), EFrame.eY.value());
		this.setSize(EFrame.eW.value(), EFrame.eH.value());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// set components
		this.lMainPanel = new LMainPanel();
		this.add(this.lMainPanel);
	}
	
	public void initialize() {
		// set associations
		this.lMainPanel.initialize();
	}
}
