package lms;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LTable extends JScrollPane {
	private static final long serialVersionUID = 1L;


	public LTable(Vector<String> header) {
		
		JTable table = new JTable();		
		DefaultTableModel tableModel = new DefaultTableModel(null, header);
		table.setModel(tableModel);
		
		this.setViewportView(table);
		
		Vector<String> row = new Vector<String>();
		row.add("data");

		tableModel.setNumRows(0);
		for (int i=0; i<3; i++) {
			tableModel.addRow(row);		
		}
	}

}
