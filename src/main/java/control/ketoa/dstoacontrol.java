package control.ketoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import control.nhaphang.dsnhaphangcontrol;
import databese.db;
import form.ketoa.dstoaform;
import form.ketoa.tabketoa;
import form.main.Mainframe;
import form.nhaphang.dsnhaphangform;
import model.nhacungcap.nhacungcap;
import model.user.duocsi;
import model.user.nhanvien;

public class dstoacontrol {

	public static void add() {
		tabketoa.tabbedPane.setSelectedIndex(1);
	}
	public static void load(String ma) {
		tabketoa.tabbedPane.setSelectedIndex(2);
		thongtintoacontrol.load(ma);
	}
	public static void newtable() {

		dstoaform.table.getTableHeader().setReorderingAllowed(false);
		dstoaform.model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã toa","Người kê", "Ngày kê"}) {
			boolean[] columnEditables = new boolean[] { false, false, false };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		ResultSet res = db.getquery("SELECT* FROM dbo.fn_getListToa()");
		try {
			while (res.next()) {
				dstoaform.model.addRow(new Object[] { res.getString(1).trim(), res.getString(2).trim(),res.getString(3).trim()});
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dstoaform.table.setModel(dstoaform.model);
		dstoaform.table.getColumnModel().getColumn(0).setResizable(false);
		dstoaform.table.getColumnModel().getColumn(1).setResizable(false);
		dstoaform.table.getColumnModel().getColumn(2).setResizable(false);
		dstoaform.sorter=new TableRowSorter(dstoaform.table.getModel());
		dstoaform.table.setRowSorter(dstoaform.sorter);
	}
	public static void newcombo() {
		DefaultComboBoxModel cbhang = new DefaultComboBoxModel(new String[] { "Tất cả" });
		for(nhanvien a:Mainframe.listnv.list)
		{
			if(a.getClass()==duocsi.class)
			cbhang.addElement(a.getTen());
		}
		dstoaform.user.setModel(cbhang);
	}
	public static void filter(String ma,String ten,Date ngay) {
		if(ten=="Tất cả")
			ten="";
		String ngayvao;
		if(ngay==null)
			ngayvao="";
		else
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			ngayvao = dateFormat.format(ngay);  
		}
		RowFilter rf=null;
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter(ma, 0));
		filters.add(RowFilter.regexFilter(ten, 1));
		filters.add(RowFilter.regexFilter(ngayvao,2));
		rf = RowFilter.andFilter(filters);
		dstoaform.sorter.setRowFilter(rf);
	}
	public static void clear() {
		dstoaform.ma.setText("");
		dstoaform.user.setSelectedIndex(0);
		dstoaform.date.setDate(null);
		filter(dstoaform.ma.getText().trim(),dstoaform.user.getSelectedItem().toString(),dstoaform.date.getDate());
	}
}
