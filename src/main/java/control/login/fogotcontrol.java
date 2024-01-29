package control.login;

import java.awt.EventQueue;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.xml.transform.Templates;
import form.login.*;
import model.user.listnhanvien;
import model.user.nhanvien;
public class fogotcontrol {

	public static void gui() {
		if(fogot.email.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập email để gửi mã");
			return;
		}
		nhanvien temp=new nhanvien();
		temp.load(fogot.email.getText().trim());
		if(temp.getEmail().equals("")||temp.getEmail()==null) {
			JOptionPane.showMessageDialog(null,"Email này không tồn tại");
			return;
		}
		temp.luumaxacnhan();
		sendEmail(temp.getEmail(),"Đây là mã xác nhận ",temp.getMaxacnhan());
	}

	public static boolean xacnhan() {
		if(fogot.email.getText().trim().equals("")||fogot.ma.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập email để gửi mã");
			return false;
		}
		nhanvien temp=new nhanvien();
		temp.load(fogot.email.getText().trim());
		if(fogot.email.getText().trim().equals(temp.getEmail().trim()))
		{
			if(temp.dungmaxacnhan(fogot.ma.getText().trim())) {
				return true;
			}
			else {
				return false;
			}
		}
		JOptionPane.showMessageDialog(null,"Email này không tồn tại");
		return false;
	}
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	 public static void sendEmail(String to/* Địa chỉ email của người nhận*/,String subjectText,String Text)
	   {
			     String from = "zdnghost23122003@gmail.com"; // Địa chỉ email của người gửi
			     String host = "smtp.gmail.com"; // Tên máy chủ SMTP của nhà cung cấp dịch vụ email
			     final String username = "zdnghost23122003"; // Tên đăng nhập vào tài khoản email của bạn
			     final String password = "balqaqcuelzkwgwa"; // Mật khẩu đăng nhập vào tài khoản email của bạn
		
			      // Cấu hình thông tin SMTP
			     Properties props = new Properties();
			     props.put("mail.smtp.auth", "true");
			     props.put("mail.smtp.starttls.enable", "true");
			     props.put("mail.smtp.host", host);
			     props.put("mail.smtp.port", "587");
		
			      // Tạo đối tượng Session để gửi email
			     Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			     protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
			         }
			      });
		
			      try {
			         // Tạo đối tượng MimeMessage
			         MimeMessage message = new MimeMessage(session);
		
			         // Thiết lập thông tin người gửi, người nhận và tiêu đề email
			         message.setFrom(new InternetAddress(from));
			         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			         message.setSubject(subjectText);
		
			         // Thiết lập nội dung email
			         message.setText(Text);
		
			         // Gửi email
			         Transport.send(message);
			         System.out.println("Email sent successfully");
			      } catch (MessagingException e) {
			         throw new RuntimeException(e);
			      }
			   }
}
