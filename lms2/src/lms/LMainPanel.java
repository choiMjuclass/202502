package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lms.LConstants.EGangjwaColumn;
import lms.LConstants.ETable;

public class LMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private LSelectionPanel lSelectionPanel;
	private LControlPanel lControlPanel1;
	private LTable lMiridamgi;
	private LControlPanel lControlPanel2;
	private LTable lSincheong;
	
	public LMainPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.lSelectionPanel = new LSelectionPanel();
		this.add(this.lSelectionPanel);
		
		this.lControlPanel1 = new LControlPanel();
		this.add(this.lControlPanel1);

		Vector<Integer> columnsProjected = new Vector<Integer>();
		for (int i=0; i<EGangjwaColumn.values().length; i++) {
			columnsProjected.add(i);
		}
		this.lMiridamgi = new LTable(ETable.eMiridamgi, columnsProjected);
		this.add(this.lMiridamgi);
		
		this.lControlPanel2 = new LControlPanel();
		this.add(this.lControlPanel2);
		
		this.lSincheong = new LTable(ETable.eSelection, columnsProjected);
		this.add(this.lSincheong);
	}
	
	public void initialize() {
		this.lSelectionPanel.initialize();
		this.lControlPanel1.initialize();
		this.lMiridamgi.initialize(null);
		this.lControlPanel2.initialize();
		this.lSincheong.initialize(null);
	}


}
