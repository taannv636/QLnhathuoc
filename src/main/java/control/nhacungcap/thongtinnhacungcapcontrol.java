package control.nhacungcap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import control.nhaphang.dsnhaphangcontrol;
import control.thuoc.khothuoccontrol;
import control.thuoc.themthuoccontrol;
import form.main.Mainframe;
import form.nhacungcap.tabnhacungcap;
import form.nhacungcap.thongtinnhacungcapform;
import model.nhacungcap.nhacungcap;

public class thongtinnhacungcapcontrol {

	public static void back() {
		tabnhacungcap.tabbedPane.setSelectedIndex(0);
	}
	
	
	public static void load(String ma) {
		nhacungcap temp=null;
		for(nhacungcap a:Mainframe.listcc.list) {
			if(a.getMa().trim().equals(ma))
			{
				temp=a;
				break;
			}
		}
		thongtinnhacungcapform.ma.setText(temp.getMa());
		thongtinnhacungcapform.ten.setText(temp.getTen());
		thongtinnhacungcapform.dc.setText(temp.getDc());
		thongtinnhacungcapform.sdt.setText(temp.getSdt());
		thongtinnhacungcapform.madn.setText(temp.getMadoanhnghiep());
		thongtinnhacungcapform.email.setText(temp.getEmail());
	}
	public static void save() {
		String ma= thongtinnhacungcapform.ma.getText().trim();
		String ten= thongtinnhacungcapform.ten.getText().trim();
		String dc= thongtinnhacungcapform.dc.getText().trim();
		String madn= thongtinnhacungcapform.madn.getText().trim();
		String sdt= thongtinnhacungcapform.sdt.getText().trim();
		String email= thongtinnhacungcapform.email.getText().trim();
		if(ten.equals("")||dc.equals("")||madn.equals("")||sdt.equals("")||email.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập dủ thông tin");
			return;
		}
		if(!checkemail(email)) {
			JOptionPane.showMessageDialog(null,"Email nhập không đúng định dạng ");
			return;
		}
		nhacungcap temp=new nhacungcap(ma, ten, dc, sdt, madn, email);
		if(temp.update())
		JOptionPane.showMessageDialog(null,"Cập nhật thành công");
		Mainframe.listcc.load();
		dsnhacungcapcontrol.newtable();
		khothuoccontrol.newlist();
		themthuoccontrol.newlist();
		dsnhaphangcontrol.newcombo();
	}
	public static boolean checkemail(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		     + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	}
}
