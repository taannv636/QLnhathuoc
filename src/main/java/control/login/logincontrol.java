package control.login;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import form.login.*;
import model.user.listnhanvien;
import model.user.nhanvien;
public class logincontrol {
	public static nhanvien login() {
		nhanvien a=null;
		String email=login.email.getText().trim();
		String pass=new String(login.pass.getPassword()).trim();
		listnhanvien temp=new listnhanvien();
		temp.load();
		for(nhanvien b:temp.list) {
			if(email.equals(b.getEmail().trim())&&pass.equals(b.getPassword().trim())){
				a=b;
				return a;
			}
		}
		JOptionPane.showMessageDialog(null,"Sai email hoặc mật khẩu");
		return a;
	}
	public static void fogot() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fogot frame = new fogot();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
