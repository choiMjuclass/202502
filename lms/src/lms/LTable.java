package lms;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import lms.LConstants.EIndex;
import lms.LConstants.IColumn;

public class LTable extends JScrollPane {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private ListSelectionHandler listSselectionHandler;
	private DefaultTableModel tableModel;
	
	private Vector<String> vRows;
	private Vector<IColumn> iColumns;
	private LTable next;
	
	public LTable(Vector<IColumn> iColumns) {
		this.iColumns = iColumns;
		// create a table
		this.table = new JTable();
		this.listSselectionHandler = new ListSelectionHandler();
		this.table.getSelectionModel().addListSelectionListener(listSselectionHandler);
		// create a table model
		Vector<String> header = new Vector<String>();
		for (IColumn column: this.iColumns) {
			header.add(column.getText());
		}
		this.tableModel = new DefaultTableModel(null, header);
		this.table.setModel(tableModel);	
		// place a table
		this.setViewportView(table);	
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
			for (IColumn column: this.iColumns) {
				projectRow.add(row[column.getIndex()]);
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
