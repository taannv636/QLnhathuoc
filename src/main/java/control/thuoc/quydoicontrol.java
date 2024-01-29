package control.thuoc;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import databese.db;
import form.main.Mainframe;
import form.thuoc.quydoiform;
import form.thuoc.tabkhothuoc;
import model.thuoc.id;
import model.thuoc.thuoc;

public class quydoicontrol {

	public static void back() {
		tabkhothuoc.tabbedPane.setSelectedIndex(2);
	}
	public static void load(String ma,String hang,String donvi,String lo) {
		
		tabkhothuoc.tabbedPane.setSelectedIndex(3);
		DefaultComboBoxModel model=new DefaultComboBoxModel();
		for(thuoc a:Mainframe.kho.listthuoc) {
			if(a.getMathuoc().trim().equals(ma)&&a.getHangthuoc().trim().equals(hang)&&(!a.getDonvi().getTen().trim().equals(donvi))) {
				model.addElement(a.getDonvi().getTen());
			}
		}
		quydoiform.lo=lo;
		quydoiform.dvht=donvi;
		quydoiform.ma=ma;
		quydoiform.hang=hang;
		quydoiform.dv.setModel(model);
	}
	public static void quydoi() {
		if(quydoiform.sl.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập dầy đủ thông tin");
			return;
		}
		int sl =Integer.parseInt(quydoiform.sl.getText());
		int idnew=0;
		int idold=0;
		String dvdoi= quydoiform.dv.getSelectedItem().toString().trim();
		for(id a:Mainframe.listdv.list) {
			if(a.getTen().trim().equals(dvdoi)) {
				idnew=a.getId();
			}
			if(a.getTen().trim().equals(quydoiform.dvht)) {
				idold=a.getId();
			}
		}
		try {
			db.conect();
			CallableStatement callSt= db.con.prepareCall("{call quydoi(?,?,?,?,?,?)}");
			callSt.setString(1, quydoiform.ma);
			callSt.setString(2, quydoiform.lo);
			callSt.setString(3, quydoiform.hang);
			callSt.setInt(4, idold);
			callSt.setInt(5, idnew);
			callSt.setInt(6, sl);
			callSt.execute();			
			db.disconect();
			Mainframe.kho.load();
			thongtincontrol.getthongtin(quydoiform.ma,quydoiform.hang,quydoiform.dvht);
			JOptionPane.showMessageDialog(null,"Đã đổi thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
}
