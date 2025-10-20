package lms;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;
	JRadioButton radioButton4;
	
	public LPanel() {
		this.radioButton1 = new JRadioButton("=>");
		this.add(this.radioButton1);
		this.radioButton2 = new JRadioButton("r2");
		this.add(this.radioButton2);
		this.radioButton3 = new JRadioButton("r3");
		this.add(this.radioButton3);
		this.radioButton4 = new JRadioButton("r4");
		this.add(this.radioButton4);
	}

}
