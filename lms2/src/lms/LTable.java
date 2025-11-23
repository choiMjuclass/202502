package lms;

import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import lms.LConstants.EIndexColumn;
import lms.LConstants.ETable;

public class LTable extends JScrollPane {
	// attributes
	private static final long serialVersionUID = 1L;
	private ETable eTable;
	// components
	private JTable table;
	private DefaultTableModel tableModel;
	// working 
	private Vector<Integer> columnsProjected;
	private Vector<String> vRows;
	// associations
	private LTable next;
	
	public LTable(ETable eTable, Vector<Integer> columnsProjected) {
		// set table type
		this.eTable = eTable;
		// set projected columns
		this.columnsProjected = columnsProjected;

		// create a table
		this.table = new JTable();
		// create a table model
		Vector<String> header = new Vector<String>();
		for (int columnIndex: this.columnsProjected) {
			header.add(this.eTable.getEColumns()[columnIndex].getText());
		}
		this.tableModel = new DefaultTableModel(null, header);
		// bind tabelModel to table
		table.setModel(tableModel);	
		// add event handler
		ListSelectionHandler listSselectionHandler = new ListSelectionHandler();
		this.table.getSelectionModel().addListSelectionListener(listSselectionHandler);
		// place a table into scroll pane 
		this.setViewportView(table);	
	}
	
	public void initialize(LTable next) {
		// associate next table
		this.next = next;
	}
	
	public void update(String fileName) {
		// fileName should be Vector<String>
		// get data from dao
		LDataAccessObject dao = new LDataAccessObject();
		this.vRows = dao.findAll(fileName);
		
		// update table data
		this.tableModel.setNumRows(0);
		for (String line: vRows) {
			Vector<String> row = new Vector<String>();
			for (int index: columnsProjected) {
				row.add(line.split(" ")[index]);
			}
			tableModel.addRow(row);		
		}
		// set default selection
		table.changeSelection(0, 0, true, false);
	}
	
	public void updateNext() {
        int[] selectedRows = table.getSelectedRows();
        if (selectedRows.length > 0) {
        		if (this.next != null) {
        			String[] row = this.vRows.get(selectedRows[0]).split(" ");
        			String fileName = row[EIndexColumn.eFileName.ordinal()];
        			this.next.update(fileName);
        		}
        }
	}
	
	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if (!e.getValueIsAdjusting()) {
				updateNext();
			}
		}
		
	}
}
