package lms;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import lms.LConstants.IColumn;

public abstract class LTable extends JScrollPane {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel tableModel;
	private ListSelectionHandler listSelectionHandler;
	
	private Vector<String> vRows;
	private Vector<IColumn> iColumns;
	
	public LTable(Vector<IColumn> iColumns) {
		this.iColumns = iColumns;
		// create a table
		this.table = new JTable();
		// create a table model
		Vector<String> header = new Vector<String>();
		for (IColumn column: this.iColumns) {
			header.add(column.getText());
		}
		this.tableModel = new DefaultTableModel(null, header);
		this.table.setModel(tableModel);
		// add listener
		// create a table
		this.listSelectionHandler = new ListSelectionHandler();
		this.getTable().getSelectionModel().addListSelectionListener(listSelectionHandler);

		// place a table
		this.setViewportView(table);
		
		// initialize vRows
		this.vRows = new Vector<String>();
	}
	public void initialize() {
	}
	
	protected JTable getTable() {
		return this.table;
	}
	protected Vector<String> getVRows() {
		return this.vRows;
	}
	
	public void redraw() {
		// project 
		tableModel.setNumRows(0);
		for (String line: this.vRows) {
			String[] row  = line.split(" ");
			Vector<String> projectedRow = new Vector<String>();
			for (IColumn iColumn: this.iColumns) {
				projectedRow.add(row[iColumn.getIndex()]);
			}
			tableModel.addRow(projectedRow);		
		}
		this.table.changeSelection(0, 0, true, false);
	}
	
	public void setVRowsFromFile(String fileName) {
		// get data from file
		LDataAccessObject dao = new LDataAccessObject();
		this.getVRows().addAll(dao.findAll(fileName));	
	}
	
	public void select() {}
	
	private class ListSelectionHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				select();
			}
		}
	}

}
