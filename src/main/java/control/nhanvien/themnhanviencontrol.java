package control.nhanvien;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import control.baocaocontrol;
import control.ketoa.dstoacontrol;
import databese.db;
import form.ketoa.dstoaform;
import form.main.Mainframe;
import form.nhanvien.tabnhanvien;
import form.nhanvien.themnhanvienform;
import form.nhaphang.dsnhaphangform;
import form.nhaphang.tabnhaphang;
import model.user.duocsi;
import model.user.nhanvien;

public class themnhanviencontrol {

	public static void back() {
		tabnhanvien.tabbedPane.setSelectedIndex(0);
	}
	public static void add() {
		String ten=themnhanvienform.ten.getText().trim();
		String email=themnhanvienform.email.getText().trim();
		String sohieu=themnhanvienform.sohieu.getText().trim();
		String pass= new String(themnhanvienform.pass.getPassword()).trim();
		if(ten.equals("")||email.equals("")||pass.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
			return;
		}
		if(!checkemail(email))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập email đúng");
			return;
		}
		if(themnhanvienform.date.getDate()==null)
			{
				JOptionPane.showMessageDialog(null,"Vui lòng chọn ngày ");
				return;
			}
		Date ngayvao=themnhanvienform.date.getDate();
		
		if(themnhanvienform.rdbtnDuocsi.isSelected()&&sohieu.equals("")) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập mã hiệu dược sĩ");
			return;
		}
		nhanvien temp=null;
		if(themnhanvienform.rdbtnDuocsi.isSelected())
			{
				temp=new duocsi(ten, 0, themnhanvienform.rdbtnNam.isSelected(), email, pass, ngayvao,null, sohieu);
				temp.add();
			}
		else {			
				temp=new nhanvien(ten, 0, themnhanvienform.rdbtnNam.isSelected(), email, pass, ngayvao, null);
				temp.add();
				temp.addnv();
			}
		JOptionPane.showMessageDialog(null,"Đã tạo thành công");
		Mainframe.listnv.load();
		dstoacontrol.newcombo();
		dsnhanviencontrol.newtable();
		baocaocontrol.baocao();
	}
	public static boolean checkemail(String email) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		     + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	}
}
