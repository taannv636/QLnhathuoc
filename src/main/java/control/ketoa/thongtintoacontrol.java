package control.ketoa;

import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import form.ketoa.tabketoa;
import form.ketoa.thongtintoaform;
import form.main.Mainframe;
import form.nhaphang.tabnhaphang;
import model.thuoc.id;
import model.toathuoc.chitiet;
import model.toathuoc.thongtintoa;

public class thongtintoacontrol {

	public static void back() {
		tabketoa.tabbedPane.setSelectedIndex(0);
	}
	public static void load(String ma) {
		thongtintoa temp=null;
		for(thongtintoa a:Mainframe.listt.list) {
			if(a.getMaphieu().trim().equals(ma)) {
				temp=a;
				break;
			}
		}
		thongtintoaform.ma.setText(ma);
		thongtintoaform.ngay.setText(temp.getNgayke().toString());
		thongtintoaform.tong.setText(temp.getTong()+"");
		thongtintoaform.nguoi.setText(temp.getDs().getTen());
		DefaultTableModel model =new DefaultTableModel(new Object[][] {},
				new String[] { "Mã thuốc","Hãng","Mã lô thuốc","Đơn vị", "Số lượng","Ghi chú"}) {
			boolean[] columnEditables = new boolean[] { false, false,false, false ,false,false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		id tempid;
		for(chitiet a :temp.getChitiet()) {
			tempid= new id();
			for(id b:Mainframe.listdv.list)
			{
				if(b.getId()==a.getIddonvi())
				{
					tempid=b;
					break;
				}
			}
			model.addRow(new Object[] {a.getMathuoc(),a.getHangthuoc(),a.getMalothuoc(),tempid.getTen(),a.getSl(),a.getGhichu()});
		}
		thongtintoaform.table.setModel(model);
		thongtintoaform.table.getTableHeader().setReorderingAllowed(false);
	}
}
