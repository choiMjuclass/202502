package lms;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import lms.LConstants.EIndex;
import lms.LConstants.ETable;
import lms.LConstants.IColumn;

public class LTable extends JScrollPane {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel tableModel;
	
	private Vector<String> vRows;
	private ETable eTable;
	private LTable next;
	
	public LTable(ETable eTable) {
		this.eTable = eTable;
		// create a header and bind
		Vector<String> header = new Vector<String>();
		for (IColumn eColumn: this.eTable.getIColumns()) {
			header.add(eColumn.getText());
		}
		this.tableModel = new DefaultTableModel(null, header);
		
		// create a table
		this.table = new JTable();
		this.table.getSelectionModel().addListSelectionListener(new ListSelectionHandler());
		this.table.setModel(tableModel);	
		
		// place a table
		this.setViewportView(table);		

		// set preferred size
		int i=0;
		for (IColumn eColumn: this.eTable.getIColumns()) {
			this.table.getColumnModel().getColumn(i++).setPreferredWidth(eColumn.getPreferredWidth());
		}
	}
	public void initialize(LTable next) {
		this.next = next;
	}
	
	public void update(String fileName) {	
		// get data from file
		LDataAccessObject dao = new LDataAccessObject();
		this.vRows = dao.findAll(fileName);

		// project 
		tableModel.setNumRows(0);
		for (String line: vRows) {
			String[] row  = line.split(" ");
			Vector<String> projectRow = new Vector<String>();
			for (IColumn column: this.eTable.getIColumns()) {
				projectRow.add(row[column.getOrdianl()]);
			}
			tableModel.addRow(projectRow);		
		}
		this.table.changeSelection(0, 0, true, false);
	}
	
	public void updateNext() {
		if (this.next != null) {
	        int[] selectedRows = table.getSelectedRows();
	        if (selectedRows.length > 0) {
	        	String line = this.vRows.get(selectedRows[0]);
				String[] row = line.split(" ");
	   			String fileName = row[EIndex.eFileName.ordinal()];
	   			this.next.update(fileName);
	        }       	
        }
	}
	
	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				updateNext();
			}
		}
	}
}
