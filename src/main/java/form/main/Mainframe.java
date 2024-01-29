 package form.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import model.user.*;
import control.login.logincontrol;
import control.menu.menucontrol;
import form.thongtincanhanform;
import form.baocao.thongkeform;
import form.home.homeform;
import form.ketoa.tabketoa;
import form.login.login;
import form.nhacungcap.tabnhacungcap;
import form.nhanvien.tabnhanvien;
import form.nhaphang.tabnhaphang;
import form.thuoc.tabkhothuoc;
import model.nhacungcap.listnhacungcap;
import model.phieunhap.listphieu;
import model.thuoc.kho;
import model.thuoc.listdonvi;
import model.thuoc.listphanloai;
import model.toathuoc.listtoa;
import form.menu.menuslide;
import java.awt.Color;
import java.awt.EventQueue;

import swing.button.RoundButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
public class Mainframe extends JFrame {
	 //model
	 public static nhanvien user=null;
	 public static kho kho=new kho();
	 public static listdonvi listdv=new listdonvi();
	 public static listphanloai listpl=new listphanloai();
	 public static listnhanvien listnv=new listnhanvien();
	 public static listnhacungcap listcc = new listnhacungcap();
	 public static listphieu listp=new listphieu(); 
	 public static listtoa listt=new listtoa();
	 
	 private JPanel contentPane= new JPanel();
	 private menuslide menuslide = new menuslide(this);
	 private JPanel panel = new JPanel();
	 public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
	 
	
	 public static tabnhaphang nhaphang= new tabnhaphang();
	 public static tabketoa ketoa= new tabketoa();  
	 public static tabnhanvien nhanvien= new tabnhanvien();
	 public static tabkhothuoc thuoc= new tabkhothuoc();
	 public static homeform home=new homeform();
	 public static thongkeform thongke=new thongkeform();
	 public static tabnhacungcap nhacungcap=new tabnhacungcap();
	 public static thongtincanhanform tt=new thongtincanhanform();
	 public static JLabel lblUser;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Mainframe(nhanvien user) {
		Mainframe.user=user;
		menucontrol.Phanquyen();
		FlatLightLaf.setup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Quản lý nhà thuốc");
		menuslide.setBounds(0, 0, 286, 761);
		menuslide.menu.setBackground(new Color(0, 144, 219));
		menuslide.menu.setLocation(25, 0);
		menuslide.menu.setSize(0, 0);
		setResizable(false);
		panel.setBackground(new Color(0, 144, 219));
		panel.setBounds(0, 0, 1264, 50);
		contentPane.setLayout(null);
		contentPane.add(menuslide);
		contentPane.add(panel);
		panel.setLayout(null);
		RoundButton rndbtnngXut = new RoundButton();
		rndbtnngXut.setBorderColor(new Color(255, 255, 255));
		rndbtnngXut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rndbtnngXut.setText("Đăng xuất");
		rndbtnngXut.setBounds(1137, 11, 117, 30);
		panel.add(rndbtnngXut);
		rndbtnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.user=null;
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(942, 0, 185, 52);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		JLabel lblUserInformation = new JLabel("Người dùng :");
		lblUserInformation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblUserInformation);	
		lblUser = new JLabel(Mainframe.user.getTen());
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menucontrol.Thongtin();
			}
		});
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblUser);
		tabbedPane.setBorder(null);
		tabbedPane.setRequestFocusEnabled(false);
		tabbedPane.setBounds(50, 50, 1239, 711);
		contentPane.add(tabbedPane);
		tabbedPane.addTab("",home);
		tabbedPane.addTab("",thuoc);
		tabbedPane.addTab("",nhaphang);
		tabbedPane.addTab("",nhacungcap);
		tabbedPane.addTab("",ketoa);
		tabbedPane.addTab("",nhanvien);
		tabbedPane.addTab("",thongke);
		tabbedPane.addTab("",tt);
		menucontrol.Home();
		tabbedPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				home.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
				thuoc.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
				nhaphang.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
				nhacungcap.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
				ketoa.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
				nhanvien.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
				thongke.setSize(tabbedPane.getWidth()-25,tabbedPane.getHeight());
			}
		});
	}
	
}
