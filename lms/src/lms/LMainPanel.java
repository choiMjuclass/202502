package lms;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lms.LConstants.EGangjwa;
import lms.LConstants.EIndex;
import lms.LConstants.IColumn;

public class LMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private LSelectionPanel lSelectionPanel;
	private LControlPanel lControlPanel1;
	private LTable lMiridamgi;
	private LControlPanel lControlPanel2;
	private LTable lSincheong;
	
	public LMainPanel() {
		// attributes
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		// components
		this.lSelectionPanel = new LSelectionPanel();
		this.add(this.lSelectionPanel);
		
		this.lControlPanel1 = new LControlPanel();
		this.add(this.lControlPanel1);

		Vector<IColumn> iColumns  = new Vector<IColumn>();
		iColumns.add(EIndex.eName);
		
		this.lMiridamgi = new LTable(iColumns);
		this.add(this.lMiridamgi);
		
		this.lControlPanel2 = new LControlPanel();
		this.add(this.lControlPanel2);
		
		this.lSincheong = new LTable(iColumns);
		this.add(this.lSincheong);
	}

	public void initialize() {
		this.lSelectionPanel.initialize();
//		this.lControlPanel1.initialize();
//		this.lMiridamgi.initialize();
//		this.lControlPanel2.initialize();
//		this.lSincheong.initialize();		
	}
}
