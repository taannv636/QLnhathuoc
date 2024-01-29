package control.nhanvien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import databese.db;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import form.main.Mainframe;
import form.nhanvien.dsnhanvienform;
import form.nhanvien.tabnhanvien;
import model.user.duocsi;
import model.user.nhanvien;

public class dsnhanviencontrol {
	public static void add() {
		tabnhanvien.tabbedPane.setSelectedIndex(1);
	}
	public static void newtable() {

		dsnhanvienform.table.getTableHeader().setReorderingAllowed(false);
		dsnhanvienform.model = new DefaultTableModel(new Object[][] {},
				new String[] { "Tên nhân viên", "Phái","Ngày vào làm","Chức vụ","Email" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,false,false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		Mainframe.listnv.load();
		for(nhanvien a :Mainframe.listnv.list)
		{
			String p=null;
			if(a.isPhai())
				p="nam";
			else 
				p="nữ";			
			String cv=null;
			if(a.getClass()==duocsi.class) {
				cv="Dược sĩ";
			}
			else if (a.isAdmin()) {
				cv="Admin";
			}
			else {
				cv="Nhân viên";
			}
			dsnhanvienform.model.addRow(new Object[] {a.getTen(),p,a.getNgayvao().toString(),cv,a.getEmail()});	 
		}
		dsnhanvienform.table.setModel(dsnhanvienform.model);
		dsnhanvienform.table.getColumnModel().getColumn(0).setResizable(false);
		dsnhanvienform.table.getColumnModel().getColumn(1).setResizable(false);
		dsnhanvienform.table.getColumnModel().getColumn(2).setResizable(false);
		dsnhanvienform.sorter=new TableRowSorter(dsnhanvienform.table.getModel());
		dsnhanvienform.table.setRowSorter(dsnhanvienform.sorter);
	}
	public static void filter(String ten,String cv,Date ngay) {
		RowFilter rf=null;
		if(cv=="Tất cả")
		 cv="";
		String ngayvao;
		if(ngay==null)
			ngayvao="";
		else
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			ngayvao = dateFormat.format(ngay);  
		}
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter(ten, 0));
		filters.add(RowFilter.regexFilter(cv, 3));
		filters.add(RowFilter.regexFilter(ngayvao,2));
		rf = RowFilter.andFilter(filters);
		dsnhanvienform.sorter.setRowFilter(rf);
	}
	public static void clear() {
	dsnhanvienform.ten.setText("");
	dsnhanvienform.cv.setSelectedIndex(0);;
	dsnhanvienform.ngay.setDate(null);
	filter(dsnhanvienform.ten.getText().trim(),dsnhanvienform.cv.getSelectedItem().toString(),dsnhanvienform.ngay.getDate());
	}
}
