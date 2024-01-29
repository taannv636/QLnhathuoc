package control.nhacungcap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.baocaocontrol;
import control.nhaphang.dsnhaphangcontrol;
import control.thuoc.khothuoccontrol;
import control.thuoc.themthuoccontrol;
import form.main.Mainframe;
import form.nhacungcap.tabnhacungcap;
import form.nhacungcap.themnhacungcapform;
import model.nhacungcap.nhacungcap;

public class themnhacungcapcontrol {

	public static void back() {
		tabnhacungcap.tabbedPane.setSelectedIndex(0);
	}
	public static void add() {
		String ma= themnhacungcapform.ma.getText().trim();
		String ten= themnhacungcapform.ten.getText().trim();
		String dc= themnhacungcapform.dc.getText().trim();
		String madn= themnhacungcapform.mdn.getText().trim();
		String sdt= themnhacungcapform.sdt.getText().trim();
		String email= themnhacungcapform.email.getText().trim();
		if(ma.equals("")||ten.equals("")||dc.equals("")||madn.equals("")||sdt.equals("")||email.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập dủ thông tin");
			return;
		}
		if(!checkemail(email)) {
			JOptionPane.showMessageDialog(null,"Email nhập không đúng định dạng ");
			return;
		}
		nhacungcap temp=new nhacungcap(ma, ten, dc, sdt, madn, email);
		if(temp.add())
		JOptionPane.showMessageDialog(null,"Thêm thành công");
		Mainframe.listcc.load();
		dsnhacungcapcontrol.newtable();
		khothuoccontrol.newlist();
		themthuoccontrol.newlist();
		dsnhaphangcontrol.newcombo();
		baocaocontrol.baocao();
	}
	public static boolean checkemail(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		     + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	}
}
