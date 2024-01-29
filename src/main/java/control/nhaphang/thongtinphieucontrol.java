package control.nhaphang;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import form.main.Mainframe;
import form.nhaphang.tabnhaphang;
import form.nhaphang.thongtinphieuform;
import model.phieunhap.chitiet;
import model.phieunhap.thongtinphieu;
import model.thuoc.id;

public class thongtinphieucontrol {

	public static void back() {
		tabnhaphang.tabbedPane.setSelectedIndex(0);
	}
	public static void load(String ma) {
		thongtinphieu temp = null; 
		for(thongtinphieu a: Mainframe.listp.list) {
			if(a.getMaphieu().trim().equals(ma)) {
				temp=a;
				break;
			}
		}
		thongtinphieuform.ma.setText(temp.getMaphieu());
		thongtinphieuform.nguoi.setText(temp.getPhutrach().getTen());
		thongtinphieuform.ngaynhap.setText(temp.getNgaynhap().toString());
		thongtinphieuform.ncc.setText(temp.getTennhacungcap());
		thongtinphieuform.tongcong.setText(temp.getTong()+"");
		DefaultTableModel model =new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Đơn vị","Số lượng" ,"Đơn giá","Ngày hết hạn"}) {
			boolean[] columnEditables = new boolean[] { false, false, false,false,false };
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		id tempid;
		for(chitiet a:temp.getChitiet() ) {
			tempid= new id();
			for(id b:Mainframe.listdv.list)
			{
				if(b.getId()==a.getIddonvi())
				{
					tempid=b;
					break;
				}
			}
			model.addRow(new Object[] {a.getMathuoc(),tempid.getTen().trim(),a.getSl(),a.getDongia(),a.getNgayhethan()});
		}
		thongtinphieuform.table.setModel(model);
		thongtinphieuform.table.getTableHeader().setReorderingAllowed(false);
	}
}
