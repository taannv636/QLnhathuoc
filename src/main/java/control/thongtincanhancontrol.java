package control;

import java.awt.Menu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.nhaphang.nhaphangcontrol;
import form.thongtincanhanform;
import form.main.Mainframe;
import model.user.duocsi;
import model.user.nhanvien;

public class thongtincanhancontrol {

	public static void load() {
		nhanvien a=Mainframe.user;
		thongtincanhanform.ten.setText(a.getTen());
		thongtincanhanform.email.setText(a.getEmail());
		thongtincanhanform.date.setText(a.getNgayvao().toString());
		String cv=null;
		String sh=null;
		String gt=null;
		if(a.isPhai())
		gt="Nam";
		else
		gt="Nữ";
		if(a.getClass()==duocsi.class) {
			cv="Dược sĩ";
			duocsi b=(duocsi) a;
			sh=b.getMahieu();
			thongtincanhanform.lblsohieu.setVisible(true);
			thongtincanhanform.sh.setVisible(true);
		}
		else if (a.isAdmin()) {
			cv="Admin";
			thongtincanhanform.lblsohieu.setVisible(false);
			thongtincanhanform.sh.setVisible(false);
		}
		else {
			cv="Nhân viên";
			thongtincanhanform.lblsohieu.setVisible(false);
			thongtincanhanform.sh.setVisible(false);
		}
		thongtincanhanform.cv.setText(cv);
		thongtincanhanform.gt.setText(gt);
		thongtincanhanform.sh.setText(sh);
	}
	public static void suatt() {
		String ten=thongtincanhanform.ten.getText().trim();
		String email=thongtincanhanform.email.getText().trim();
		if(ten.equals("")||email.equals("")) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ");
			return;
		}
		if(!checkemail(email)) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập email đúng định dạng");
			return;
		}
		Mainframe.user.changeInfo(ten,email);
		
		Mainframe.listnv.load();
		nhaphangcontrol.newtable();
		Mainframe.lblUser.setText(Mainframe.user.getTen());
		load();
		JOptionPane.showMessageDialog(null,"Đã cập nhật thông tin mới");
	}
	public static void doimk() {
		String mk= new String( thongtincanhanform.password.getPassword()).trim();
		String xn= new String( thongtincanhanform.comfirm.getPassword()).trim();
		if(mk.equals("")||xn.equals("")) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ");
			return;
		}
		if(!mk.equals(xn)) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập xác nhận mật khẩu giống mật khẩu mới");
			return;
		}
		Mainframe.user.changePass(mk);
		Mainframe.listnv.load();
		nhaphangcontrol.newtable();
		JOptionPane.showMessageDialog(null,"Đã cập nhật mật khẩu mới");
		load();
	}
	public static boolean checkemail(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		     + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	}
}
