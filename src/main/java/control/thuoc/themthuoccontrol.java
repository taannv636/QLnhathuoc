package control.thuoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import databese.db;
import form.main.Mainframe;
import form.nhaphang.nhaphangform;
import form.thuoc.*;
import model.nhacungcap.nhacungcap;
import model.thuoc.id;
import model.thuoc.listphanloai;
import model.thuoc.thuoc;
public class themthuoccontrol {

	public static void back() {
		tabkhothuoc.tabbedPane.setSelectedIndex(0);
	}
	public static void clear() {
		
	}
	public static void newlist() {
		themthuocform.cbphanloai = new DefaultComboBoxModel();
		Mainframe.listpl.load();
		Mainframe.listdv.load();
		Mainframe.listcc.load();
		
		for(id a:Mainframe.listpl.list)
		{
			themthuocform.cbphanloai.addElement(a.getTen());}
		themthuocform.Phanloai.setModel(themthuocform.cbphanloai);

		themthuocform.cbdonvi = new DefaultComboBoxModel();
		for(id a:Mainframe.listdv.list)
		{			themthuocform.cbdonvi.addElement(a.getTen());
			}
		themthuocform.Donvi.setModel(themthuocform.cbdonvi);
		
		themthuocform.cbhang = new DefaultComboBoxModel();
		for(nhacungcap a:Mainframe.listcc.list)
		{
			themthuocform.cbhang.addElement(a.getMa());
		}
		themthuocform.Hang.setModel(themthuocform.cbhang);
	}
	public static void themdv() {
		String dvmoi=JOptionPane.showInputDialog(null,"Nhập đơn vị mới cần thêm", "Thêm đơn vị",JOptionPane.YES_NO_OPTION);
		if(dvmoi==null||dvmoi.trim().equals(""))
			return;
		if(dvmoi==null||dvmoi.trim().equals("")){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập phân loại mới");
			return;
		}
		for(id a:Mainframe.listpl.list) {
		if(a.getTen().trim().equals(dvmoi.trim())) {
			JOptionPane.showMessageDialog(null,"Phân loại này đã tồn tại");
			return;
		}
		}
		String sql="INSERT INTO DONVITHUOC VALUES(?)";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setString(1,dvmoi);
			pres.execute();
			db.disconect();
			JOptionPane.showMessageDialog(null,"Thêm đơn vị thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Thêm đơn vị thất bại");
		}
		Mainframe.listpl.load();
		newlist();
		khothuoccontrol.newlist();
	}
	public static void thempl() {
		String plmoi=JOptionPane.showInputDialog(null,"Nhập phân loại mới cần thêm", "Thêm phân loại",JOptionPane.YES_NO_OPTION);
		if(plmoi==null||plmoi.trim().equals("")){
				JOptionPane.showMessageDialog(null,"Vui lòng nhập phân loại mới");
				return;
			}
		for(id a:Mainframe.listpl.list) {
			if(a.getTen().trim().equals(plmoi.trim())) {
				JOptionPane.showMessageDialog(null,"Phân loại này đã tồn tại");
				return;
			}
		}
		String sql="INSERT INTO PHANLOAI VALUES(?)";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setString(1,plmoi);
			pres.execute();
			db.disconect();
			JOptionPane.showMessageDialog(null,"Thêm phân loại thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Thêm phân loại thất bại");
		}
		Mainframe.listpl.load();
		newlist();
		khothuoccontrol.newlist();
	}
	public static void add() {
		if(themthuocform.masp.getText().equals("")||themthuocform.tensp.getText().equals("")||themthuocform.hoatchat.getText().equals("")||themthuocform.hamluong.getText().equals("")||themthuocform.quydoi.getText().equals("")||themthuocform.gia.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
			return;
		}
		String ma =themthuocform.masp.getText();
		String ten =themthuocform.tensp.getText();
		String hc =themthuocform.hoatchat.getText();
		String hl =themthuocform.hamluong.getText();
		int qd =Integer.parseInt(themthuocform.quydoi.getText());
		int gb =Integer.parseInt(themthuocform.gia.getText());
		String dvString =themthuocform.Donvi.getSelectedItem().toString();
		String plString =themthuocform.Phanloai.getSelectedItem().toString();
		String hang =themthuocform.Hang.getSelectedItem().toString();
		id pl=new id(); 
		id dv=new id(); 
		for(id a:Mainframe.listpl.list) {
			if(a.getTen().trim().equals(plString.trim())) {
				pl=a;
				break;
			}
		}
		for(id a:Mainframe.listdv.list) {
			if(a.getTen().trim().equals(dvString.trim())) {
				dv=a;
				break;
			}
		}
		thuoc temp=new thuoc(ma, hang, ten, hc, hl, pl, dv, null, qd,gb);
		temp.add();
		Mainframe.kho.load();
		khothuoccontrol.newtable();
	}
}
