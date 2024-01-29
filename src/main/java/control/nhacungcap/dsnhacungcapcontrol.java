package control.nhacungcap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import databese.db;
import form.ketoa.dstoaform;
import form.main.Mainframe;
import form.nhacungcap.dsnhacungcapform;
import form.nhacungcap.tabnhacungcap;
import model.nhacungcap.nhacungcap;

public class dsnhacungcapcontrol {

	public static void add() {
		tabnhacungcap.tabbedPane.setSelectedIndex(1);
	}
	public static void load(String ma) {
		tabnhacungcap.tabbedPane.setSelectedIndex(2);
		thongtinnhacungcapcontrol.load(ma);
	}

	public static void newtable() {

		dsnhacungcapform.table.getTableHeader().setReorderingAllowed(false);
		dsnhacungcapform.model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhà cung cấp","Tên nhà cung cấp", "Địa chỉ văn phòng" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		Mainframe.listcc.load();
		for(nhacungcap a:Mainframe.listcc.list)
		{
			dsnhacungcapform.model.addRow(new Object[] {a.getMa(),a.getTen(),a.getDc()});
		}
		
		dsnhacungcapform.table.setModel(dsnhacungcapform.model);
		dsnhacungcapform.table.getColumnModel().getColumn(0).setResizable(false);
		dsnhacungcapform.table.getColumnModel().getColumn(1).setResizable(false);
		dsnhacungcapform.table.getColumnModel().getColumn(2).setResizable(false);
		dsnhacungcapform.sorter=new TableRowSorter(dsnhacungcapform.table.getModel());
		dsnhacungcapform.table.setRowSorter(dsnhacungcapform.sorter);
	}
	public static void filter(String ma,String ten) {
		RowFilter rf=null;
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter(ma, 0));
		filters.add(RowFilter.regexFilter(ten, 1));
		rf=RowFilter.andFilter(filters);
		dsnhacungcapform.sorter.setRowFilter(rf);
	}
	public static void reset() {
		dsnhacungcapform.ma.setText("");;
		dsnhacungcapform.ten.setText("");
		filter("","");
	}
}
