package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lms.LConstants.EGangjwa;

public class LSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public LSelectionPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		JPanel indexPanel = new JPanel();		
			indexPanel.setLayout(new BoxLayout(indexPanel, BoxLayout.X_AXIS));			
			Vector<String> header;			
			header = new Vector<String>();
			header.add("lCampus");		
			LTable lCampus = new LTable(header);		
			indexPanel.add(lCampus);
			
			header = new Vector<String>();
			header.add("lCampus");		
			LTable lCollege = new LTable(header);		
			indexPanel.add(lCollege);
			
			header = new Vector<String>();
			header.add("lDepartment");		
			LTable lDepartment = new LTable(header);		
			indexPanel.add(lDepartment);			
		this.add(indexPanel);	
		
		header = new Vector<String>();
		for (EGangjwa eGangjwa: EGangjwa.values()) {
			header.add(eGangjwa.getText());
		}
		LTable lLecture = new LTable(header);		
		this.add(lLecture);
	}
}
