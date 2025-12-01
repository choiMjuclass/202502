package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lms.LConstants.EGangjwa;
import lms.LConstants.EIndex;
import lms.LConstants.EIndexName;
import lms.LConstants.IColumn;

public class LSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private LTable lCampus;
	private LTable lCollege;
	private LTable lDepartment;
	private LTable lLecture;
	
	public LSelectionPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		JPanel indexPanel = new JPanel();		
			indexPanel.setLayout(new BoxLayout(indexPanel, BoxLayout.X_AXIS));
			
			Vector<IColumn> iColumns  = new Vector<IColumn>();
			iColumns.add(EIndex.eName);
			
			this.lCampus = new LTable(iColumns);
			indexPanel.add(lCampus);
			
			this.lCollege = new LTable(iColumns);		
			indexPanel.add(lCollege);
			
			this.lDepartment = new LTable(iColumns);		
			indexPanel.add(lDepartment);			
		this.add(indexPanel);	
		
		this.lLecture = new LTable(iColumns);		
		this.add(this.lLecture);
	}

	public void initialize() {
		this.lCampus.initialize(this.lCollege);
		this.lCollege.initialize(this.lDepartment);
		this.lDepartment.initialize(this.lLecture);
		this.lLecture.initialize(null);
		
		lCampus.update("root");
	}
}
