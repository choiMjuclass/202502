package lms;

import java.util.Vector;

import lms.LConstants.EIndex;
import lms.LConstants.IColumn;

public class LIndex extends LTable {
	private static final long serialVersionUID = 1L;

	private LTable next;
	
	public LIndex(Vector<IColumn> iColumns) {
		super(iColumns);
	}
	public void initialize(LTable next) {
		super.initialize();
		this.next = next;
	}
	
	public void select() {
		if (this.next != null) {
  			this.next.getVRows().clear();
	        int[] selectedRows = this.getTable().getSelectedRows();
 	        for (int i=0; i<selectedRows.length; i++) {
	        	String line = this.getVRows().get(selectedRows[i]);
				String[] row = line.split(" ");
	   			String fileName = row[EIndex.eFileName.ordinal()];
	   			this.next.setVRowsFromFile(fileName);
	        }       	
   			this.next.redraw();
       }
	}
}
