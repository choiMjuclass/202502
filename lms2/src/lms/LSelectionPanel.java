package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lms.LConstants.EGangjwaColumn;
import lms.LConstants.EIndexColumn;
import lms.LConstants.ETable;

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
			
			Vector<Integer> columnsProjected = new Vector<Integer>();
			columnsProjected.add(EIndexColumn.eName.ordinal());
			
			this.lCampus = new LTable(ETable.eCampus, columnsProjected);
			indexPanel.add(lCampus);
			
			this.lCollege = new LTable(ETable.eCollege, columnsProjected);		
			indexPanel.add(lCollege);
			
			this.lDepartment = new LTable(ETable.eDepartment, columnsProjected);		
			indexPanel.add(lDepartment);				
			
		this.add(indexPanel);	
		
		columnsProjected = new Vector<Integer>();
		for (int i=0; i<EGangjwaColumn.values().length; i++) {
			columnsProjected.add(i);
		}
		this.lLecture = new LTable(ETable.eSelection, columnsProjected);		
		this.add(lLecture);		
	}
	
	public void initialize() {
		this.lCampus.initialize(lCollege);
		this.lCollege.initialize(lDepartment);
		this.lDepartment.initialize(lLecture);
		this.lLecture.initialize(null);
		
		lCampus.update("root");		
	}
}
