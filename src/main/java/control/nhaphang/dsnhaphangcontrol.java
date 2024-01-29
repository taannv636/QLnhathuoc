package control.nhaphang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.NewsAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import databese.db;
import form.main.Mainframe;
import form.nhaphang.dsnhaphangform;
import form.nhaphang.tabnhaphang;
import form.thuoc.khothuocform;
import model.nhacungcap.nhacungcap;
import model.phieunhap.thongtinphieu;

public class dsnhaphangcontrol {

	public static void add() {
		tabnhaphang.tabbedPane.setSelectedIndex(1);
	}
	public static void load(String ma) {
		tabnhaphang.tabbedPane.setSelectedIndex(2);
		thongtinphieucontrol.load(ma);
	}
	
	public static void newtable() {

		dsnhaphangform.table.getTableHeader().setReorderingAllowed(false);
		dsnhaphangform.model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phiếu", "Nhà cung cấp","Người phụ trách" ,"Ngày nhập"}) {
			boolean[] columnEditables = new boolean[] { false, false, false,false };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		for(thongtinphieu a:Mainframe.listp.list) {
			dsnhaphangform.model.addRow(new Object[] {a.getMaphieu(),a.getTennhacungcap(),a.getPhutrach().getTen(),a.getNgaynhap() });
		}
		dsnhaphangform.table.setModel(dsnhaphangform.model);
		dsnhaphangform.table.getColumnModel().getColumn(0).setResizable(false);
		dsnhaphangform.table.getColumnModel().getColumn(1).setResizable(false);
		dsnhaphangform.table.getColumnModel().getColumn(2).setResizable(false);
		dsnhaphangform.sorter=new TableRowSorter(dsnhaphangform.table.getModel());
		dsnhaphangform.table.setRowSorter(dsnhaphangform.sorter);
	}
	public static void newcombo() {
		DefaultComboBoxModel cbhang = new DefaultComboBoxModel(new String[] { "Tất cả" });
		for(nhacungcap a:Mainframe.listcc.list)
		{
			cbhang.addElement(a.getMa());
		}
		dsnhaphangform.Hang.setModel(cbhang);
	}
	public static void filter(String ma,String hang,Date ngay) {
		if(hang=="Tất cả")
			hang="";
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
		filters.add(RowFilter.regexFilter(hang, 1));
		filters.add(RowFilter.regexFilter(ngayvao,3));
		rf = RowFilter.andFilter(filters);
		dsnhaphangform.sorter.setRowFilter(rf);
	}
	public static void clear() {
		dsnhaphangform.maphieu.setText("");
		dsnhaphangform.Hang.setSelectedIndex(0);
		dsnhaphangform.ngaynhap.setDate(null);
		dsnhaphangcontrol.filter(dsnhaphangform.maphieu.getText().trim(),dsnhaphangform.Hang.getSelectedItem().toString(),dsnhaphangform.ngaynhap.getDate());
	}
	
}