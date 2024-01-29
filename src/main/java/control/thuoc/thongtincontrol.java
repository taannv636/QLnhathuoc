package control.thuoc;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import form.main.Mainframe;
import form.thuoc.tabkhothuoc;
import form.thuoc.themthuocform;
import form.thuoc.thongtinform;
import model.thuoc.id;
import model.thuoc.lothuoc;
import model.thuoc.thuoc;

public class thongtincontrol {
	public static void back() {
		tabkhothuoc.tabbedPane.setSelectedIndex(0);
	}
	public static void getthongtin(String ma,String hang,String donvi) {
		thuoc temp = null;
		for(thuoc a:Mainframe.kho.listthuoc)
		{
			if(a.getMathuoc().trim().equals(ma.trim())&&a.getHangthuoc().trim().equals(hang.trim())&&a.getDonvi().getTen().trim().equals(donvi.trim())) {
				temp=a;
				break;
			}
		}
		thongtinform.ma.setText(temp.getMathuoc());
		thongtinform.ten.setText(temp.getTenthuoc());
		thongtinform.hang.setText(temp.getHangthuoc());
		thongtinform.dv.setText(temp.getDonvi().getTen());
		thongtinform.hl.setText(temp.getHamluong());
		thongtinform.hc.setText(temp.getHoatchat());
		thongtinform.qd.setText(temp.getQuydoi()+"");
		thongtinform.gia.setText(temp.getGiaban()+"");
		DefaultTableModel model =new DefaultTableModel(new Object[][] {},
				new String[] { "Mã lô thuốc", "Sl","Ngay hết hạn"}) {
			boolean[] columnEditables = new boolean[] { false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		for(lothuoc a:temp.getLohang())
		{
			model.addRow(new Object[] {a.getMalothuoc(),a.getSl(),a.getHansudung()});
		}
		thongtinform.table.setModel(model);
		thongtinform.table.getTableHeader().setReorderingAllowed(false);
		
		DefaultComboBoxModel modelcb=new DefaultComboBoxModel();
		for(id a:Mainframe.listpl.list)
		{
			modelcb.addElement(a.getTen());
		}
		thongtinform.Phanloai.setModel(modelcb);
		thongtinform.Phanloai.setSelectedItem(temp.getPhanloai().getTen());
	}
	public static void update() {
		if(thongtinform.ten.getText().trim().equals("")||thongtinform.hc.getText().trim().equals("")||thongtinform.hl.getText().trim().equals("")||thongtinform.gia.getText().trim().equals("")||thongtinform.ten.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
			return;
		}
		String ma =thongtinform.ma.getText(); 
		String hang =thongtinform.hang.getText();
		String dvString =thongtinform.dv.getText();
		String ten =thongtinform.ten.getText();
		String hc =thongtinform.hc.getText();
		String hl =thongtinform.hl.getText();
		int qd =Integer.parseInt(thongtinform.qd.getText());
		int gb =Integer.parseInt(thongtinform.gia.getText());
		String plString=thongtinform.Phanloai.getSelectedItem().toString();
		id pl=new id(); 
		for(id a:Mainframe.listpl.list) {
			if(a.getTen().trim().equals(plString.trim())) {
				pl=a;
				break;
			}
		}
		id dv=new id(); 
		for(id a:Mainframe.listdv.list) {
			if(a.getTen().trim().equals(dvString.trim())) {
				dv=a;
				break;
			}
		}
		thuoc temp=new thuoc(ma, hang, ten, hc, hl, pl, dv, null, qd,gb);
		if(temp.updatett(ten,pl.getId(),hc, hl)&&
		temp.updateqdgb(qd, gb))
			JOptionPane.showMessageDialog(null,"Đã cập nhật thành công");
		Mainframe.kho.load();
		
		khothuoccontrol.newtable();
	}
}
