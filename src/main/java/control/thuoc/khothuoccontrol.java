package control.thuoc;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import databese.db;
import form.main.Mainframe;
import form.thuoc.*;
import model.nhacungcap.nhacungcap;
import model.thuoc.id;
import model.thuoc.listdonvi;
import model.thuoc.thuoc;

public class khothuoccontrol {

	public static void newtable() {

		khothuocform.table.getTableHeader().setReorderingAllowed(false);
		khothuocform.model = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã thuốc", "Tên thuốc", "Hãng", "Phân loại", "Đơn vị", "Hoạt chất", "Hàm lượng" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		Mainframe.kho.load();
		for(thuoc a:Mainframe.kho.listthuoc) {
		khothuocform.model.addRow(new Object[] {a.getMathuoc(),a.getTenthuoc(),a.getHangthuoc(),a.getPhanloai().getTen(),a.getDonvi().getTen(),a.getHoatchat(),a.getHamluong()});
		}
		khothuocform.table.setModel(khothuocform.model);
		khothuocform.table.getColumnModel().getColumn(0).setResizable(false);
		khothuocform.table.getColumnModel().getColumn(1).setResizable(false);
		khothuocform.table.getColumnModel().getColumn(2).setResizable(false);
		khothuocform.table.getColumnModel().getColumn(3).setResizable(false);
		khothuocform.table.getColumnModel().getColumn(4).setResizable(false);
		khothuocform.table.getColumnModel().getColumn(5).setResizable(false);
		khothuocform.table.getColumnModel().getColumn(6).setResizable(false);
		khothuocform.sorter=new TableRowSorter(khothuocform.table.getModel());
		khothuocform.table.setRowSorter(khothuocform.sorter);
		filter(khothuocform.mathuoc.getText().trim(),khothuocform.tenthuoc.getText().trim(),khothuocform.Hang.getSelectedItem().toString(),khothuocform.Phanloai.getSelectedItem().toString(),khothuocform.Donvi.getSelectedItem().toString(),khothuocform.hoatchat.getText().trim());
	}


	public static void newlist() {
		khothuocform.cbphanloai = new DefaultComboBoxModel(new String[] { "Tất cả" });
		Mainframe.listpl.load();
		Mainframe.listdv.load();
		Mainframe.listcc.load();
		for(id a:Mainframe.listpl.list)
		{
			khothuocform.cbphanloai.addElement(a.getTen());
		}
		khothuocform.Phanloai.setModel(khothuocform.cbphanloai);
//
		khothuocform.cbdonvi = new DefaultComboBoxModel(new String[] { "Tất cả" });
		for(id a:Mainframe.listdv.list)
		{
			khothuocform.cbdonvi.addElement(a.getTen());
		}
		khothuocform.Donvi.setModel(khothuocform.cbdonvi);
//
		khothuocform.cbhang = new DefaultComboBoxModel(new String[] { "Tất cả" });
		for(nhacungcap a:Mainframe.listcc.list)
		{
			khothuocform.cbhang.addElement(a.getMa());
		}
		khothuocform.Hang.setModel(khothuocform.cbhang);

	}
	
	public static void info() {
		tabkhothuoc.tabbedPane.setSelectedIndex(2);
		int i=khothuocform.table.getSelectedRow();
		thongtincontrol.getthongtin(khothuocform.table.getValueAt(i, 0).toString(),khothuocform.table.getValueAt(i, 2).toString(), khothuocform.table.getValueAt(i, 4).toString());
	}
	public static void addpanel() {
		tabkhothuoc.tabbedPane.setSelectedIndex(1);
	}
	public static void filter(String ma,String ten,String hang,String pl,String dv,String hc) {
		RowFilter rf=null;
		if(dv.contains("Tất cả"))
			dv="";
		if(pl.contains("Tất cả"))
			pl="";
		if(hang.contains("Tất cả"))
			hang="";
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter(ma, 0));
		filters.add(RowFilter.regexFilter(ten, 1));
		filters.add(RowFilter.regexFilter(hang, 2));
		filters.add(RowFilter.regexFilter(pl, 3));
		filters.add(RowFilter.regexFilter(dv, 4));
		filters.add(RowFilter.regexFilter(hc, 5));
		rf = RowFilter.andFilter(filters);
		khothuocform.sorter.setRowFilter(rf);
	}
	public static void reset() {
		khothuocform.mathuoc.setText("");
		khothuocform.tenthuoc.setText("");
		khothuocform.hoatchat.setText("");
		khothuocform.Hang.setSelectedIndex(0);
		khothuocform.Donvi.setSelectedIndex(0);
		khothuocform.Phanloai.setSelectedIndex(0);
		filter(khothuocform.mathuoc.getText().trim(),khothuocform.tenthuoc.getText().trim(),khothuocform.Hang.getSelectedItem().toString(),khothuocform.Phanloai.getSelectedItem().toString(),khothuocform.Donvi.getSelectedItem().toString(),khothuocform.hoatchat.getText().trim());
	}
}
