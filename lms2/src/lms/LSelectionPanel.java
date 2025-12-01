package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lms.LConstants.EGangjwa;
import lms.LConstants.ETable;
import lms.LConstants.IColumn;

public class LSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private LTable lCampus;
	private LTable lCollege;
	private LTable lDepartment;
	private LTable lGangjwa;
	
	public LSelectionPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		JPanel indexPanel = new JPanel();		
			indexPanel.setLayout(new BoxLayout(indexPanel, BoxLayout.X_AXIS));
			
			this.lCampus = new LTable(ETable.eCampus);
			indexPanel.add(lCampus);
			
			this.lCollege = new LTable(ETable.eCollege);		
			indexPanel.add(lCollege);
			
			this.lDepartment = new LTable(ETable.eDepartment);		
			indexPanel.add(lDepartment);			
		this.add(indexPanel);	
		
		this.lGangjwa = new LTable(ETable.eGangjwa);		
		this.add(this.lGangjwa);
	}

	public void initialize() {
		this.lCampus.initialize(this.lCollege);
		this.lCollege.initialize(this.lDepartment);
		this.lDepartment.initialize(this.lGangjwa);
		this.lGangjwa.initialize(null);
		
		lCampus.update(LConstants.FILENAME_ROOT);
	}
}
