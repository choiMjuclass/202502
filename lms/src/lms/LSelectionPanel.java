package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class LSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public LSelectionPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		JPanel indexPanel = new JPanel();		
			indexPanel.setLayout(new BoxLayout(indexPanel, BoxLayout.X_AXIS));			
			Vector<String> header;			
			header = new Vector<String>();
			header.add("캠퍼스");		
			LTable lCampus = new LTable(header);		
			indexPanel.add(lCampus);
			
			header = new Vector<String>();
			header.add("대학");		
			LTable lCollege = new LTable(header);		
			indexPanel.add(lCollege);
			
			header = new Vector<String>();
			header.add("학과");		
			LTable lDepartment = new LTable(header);		
			indexPanel.add(lDepartment);			
		this.add(indexPanel);	
		
		header = new Vector<String>();
		header.add("강좌명");	
		header.add("학점");	
		header.add("시간");	
		LTable lLecture = new LTable(header);		
		this.add(lLecture);
	}
}
