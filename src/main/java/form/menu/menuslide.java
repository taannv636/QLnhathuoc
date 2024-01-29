package form.menu;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.transaction.xa.XAException;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import control.menu.menucontrol;
import form.main.Mainframe;
import swing.button.RoundButton;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class menuslide extends JPanel {
	/**
	 * Create the panel.
	 */
	private boolean menuon=false;
	public JPanel menu = new JPanel();
	private RoundButton btnMenu = new RoundButton();
	private Animator a;
	private Animator b;
	private Animator c;
	public static RoundButton btnNhaphang = new RoundButton();
	public static RoundButton btnThuoc = new RoundButton();
	public static RoundButton btnCungcap = new RoundButton();
	public static RoundButton btnKetoa = new RoundButton();
	public static RoundButton btnUser = new RoundButton();
	public static RoundButton btnHome = new RoundButton();
	public static RoundButton btnThongke = new RoundButton();
	public menuslide(JFrame fram) {
		btnMenu.setAlignmentY(Component.TOP_ALIGNMENT);
		btnMenu.setIconTextGap(0);
		btnMenu.setSize(50, 50);
		setOpaque(false);
		menu.setBounds(0, 0, 305, 789);
		menu.setBackground(new Color(51, 255, 255));		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slide();
			}
		});
		
		btnMenu.setIcon(getImage("/form/menu/menu.png",50,50));
		setLayout(null);
		btnMenu.setLocation(255,0);
		add(btnMenu);
		add(menu);
		menu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setBounds(0, 0, 255, 50);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(lblNewLabel);
		btnNhaphang.setFocusable(false);
		btnNhaphang.setFocusTraversalKeysEnabled(false);
		btnNhaphang.setFocusPainted(false);
		btnNhaphang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			menucontrol.Nhap();
			}
		});
		btnThuoc.setFocusable(false);
		btnThuoc.setFocusTraversalKeysEnabled(false);
		btnThuoc.setFocusPainted(false);
		btnThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menucontrol.Kho();
			}
		});
		btnKetoa.setFocusTraversalKeysEnabled(false);
		btnKetoa.setFocusable(false);
		btnKetoa.setFocusPainted(false);
		btnKetoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menucontrol.Toa();
			}
		});
		btnCungcap.setFocusTraversalKeysEnabled(false);
		btnCungcap.setFocusPainted(false);
		btnCungcap.setFocusable(false);
		btnCungcap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menucontrol.Nhacungcap();
			}
		});
		btnNhaphang.setColorClick(new Color(255, 255, 255,90));
		btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		

		btnNhaphang.setBorderPainted(false);
		btnNhaphang.setColor(new Color(0, 144, 219));
		btnNhaphang.setBackground(new Color(0, 144, 219));
		btnNhaphang.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNhaphang.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaphang.setBorderColor(new Color(0, 144, 219));
		btnNhaphang.setBounds(-15, 150, 320, 50);
		menu.add(btnNhaphang);
		btnNhaphang.setIcon(getImage("/form/menu/warehouse.png",50,50));
		btnNhaphang.setText("    Nhập hàng");
		btnThuoc.setColorClick(new Color(255, 255, 255,90));
		btnThuoc.setColorOver(new Color(255, 255, 255,30));
		

		btnThuoc.setBorderPainted(false);
		btnThuoc.setColor(new Color(0, 144, 219));
		btnThuoc.setBackground(new Color(0, 144, 219));
		btnThuoc.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnThuoc.setHorizontalAlignment(SwingConstants.LEFT);
		btnThuoc.setBorderColor(new Color(0, 144, 219));
		btnThuoc.setBounds(-15, 100, 320, 50);
		menu.add(btnThuoc);
		btnThuoc.setIcon(getImage("/form/menu/pill.png",50,50));
		btnThuoc.setText("    Danh mục thuốc");
		btnCungcap.setColorClick(new Color(255, 255, 255,90));
		btnCungcap.setColorOver(new Color(255, 255, 255,30));
		

		btnCungcap.setIcon(getImage("/form/menu/organization.png",50,50));
		btnCungcap.setText("    Nhà cung cấp");
		btnCungcap.setHorizontalAlignment(SwingConstants.LEFT);
		btnCungcap.setBorderPainted(false);
		btnCungcap.setColor(new Color(0, 144, 219));
		btnCungcap.setBackground(new Color(0, 144, 219));
		btnCungcap.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCungcap.setBorderColor(new Color(0, 144, 219));
		btnCungcap.setBounds(-15, 200, 320, 50);
		menu.add(btnCungcap);
		btnKetoa.setColorClick(new Color(255, 255, 255,90));
		btnKetoa.setColorOver(new Color(255, 255, 255,30));
		
		btnKetoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnKetoa.setIcon(getImage("/form/menu/article.png",50,50));
		btnKetoa.setText("    Kê toa");
		btnKetoa.setBorderPainted(false);
		btnKetoa.setColor(new Color(0, 144, 219));
		btnKetoa.setBackground(new Color(0, 144, 219));
		btnKetoa.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnKetoa.setBorderColor(new Color(0, 144, 219));
		btnKetoa.setBounds(-15, 250, 320, 50);
		menu.add(btnKetoa);
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menucontrol.User();
			}
		});
		
		btnUser.setHorizontalAlignment(SwingConstants.LEFT);
		btnUser.setIcon(getImage("/form/menu/user.png",50,50));
		btnUser.setText("    Nhân viên");
		btnUser.setHorizontalAlignment(SwingConstants.LEFT);
		btnUser.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnUser.setFocusable(false);
		btnUser.setFocusTraversalKeysEnabled(false);
		btnUser.setFocusPainted(false);
		btnUser.setColorOver(new Color(255, 255, 255, 30));
		btnUser.setColorClick(new Color(255, 255, 255, 90));
		btnUser.setColor(new Color(0, 144, 219));
		btnUser.setBorderPainted(false);
		btnUser.setBorderColor(new Color(0, 144, 219));
		btnUser.setBackground(new Color(0, 144, 219));
		btnUser.setBounds(-15, 300, 320, 50);
		menu.add(btnUser);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menucontrol.Home();
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setIcon(getImage("/form/menu/home.png",50,50));
		btnHome.setText("    Trang chính");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnHome.setFocusable(false);
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setColorOver(new Color(255, 255, 255, 30));
		btnHome.setColorClick(new Color(255, 255, 255, 90));
		btnHome.setColor(new Color(0, 144, 219));
		btnHome.setBorderPainted(false);
		btnHome.setBorderColor(new Color(0, 144, 219));
		btnHome.setBackground(new Color(0, 144, 219));
		btnHome.setBounds(-15, 50, 320, 50);
		menu.add(btnHome);
		btnThongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menucontrol.Thongke();
			}
		});
		
		
		btnThongke.setText("    Thống kê");
		btnThongke.setIcon(getImage("/form/menu/chart.png",50,50));
		btnThongke.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongke.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnThongke.setFocusable(false);
		btnThongke.setFocusTraversalKeysEnabled(false);
		btnThongke.setFocusPainted(false);
		btnThongke.setColorOver(new Color(255, 255, 255, 30));
		btnThongke.setColorClick(new Color(255, 255, 255, 90));
		btnThongke.setColor(new Color(0, 144, 219));
		btnThongke.setBorderPainted(false);
		btnThongke.setBorderColor(new Color(0, 144, 219));
		btnThongke.setBackground(new Color(0, 144, 219));
		btnThongke.setBounds(-15, 350, 320, 50);
		menu.add(btnThongke);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				menu.setLocation(0,0);
				
				if(menuon) {
					menu.setSize(getWidth(),getHeight());
					btnMenu.setLocation(menu.getWidth()-btnMenu.getWidth(),0);

				}
				else {
					menu.setSize(btnMenu.getWidth(),getHeight());
					btnMenu.setLocation(0,0);
				}
			}
		});
		
	}
	public void slide() {
		
		if(a!=null&&a.isRunning()) {
			a.stop();
		}
		if(menuon)
		{
			//dong menu
		a=PropertySetter.createAnimator(90, menu,"size",menu.getSize(),new Dimension(btnMenu.getWidth(),getHeight()));
		b=PropertySetter.createAnimator(90,btnMenu ,"location",btnMenu.getLocation(),new Point(0,0));
		c=PropertySetter.createAnimator(90,Mainframe.tabbedPane,"bounds",Mainframe.tabbedPane.getBounds(),new Rectangle(btnMenu.getWidth(),Mainframe.tabbedPane.getY(),1264+25-btnMenu.getWidth(),Mainframe.tabbedPane.getHeight()));
		b.start();
		a.start();	
		c.start();
		menuon=false;
		}
		else
		{
			//mo menu
			a=PropertySetter.createAnimator(90, menu,"size",menu.getSize(),new Dimension(getWidth(),getHeight()));
			b=PropertySetter.createAnimator(90,btnMenu ,"location",btnMenu.getLocation(),new Point(getWidth()-btnMenu.getWidth(),0));
			c=PropertySetter.createAnimator(90,Mainframe.tabbedPane,"bounds",Mainframe.tabbedPane.getBounds(),new Rectangle(getWidth(),Mainframe.tabbedPane.getY(),1264+25-getWidth(),Mainframe.tabbedPane.getHeight()));
			b.start();
			a.start();
			c.start();
			menuon=true;
		}
	}
	public ImageIcon getImage(String source,int width,int height) {
		ImageIcon a=new ImageIcon(getClass().getResource(source));
		Image newicon;
		Image icon=a.getImage();
		icon=a.getImage();
		newicon=icon.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		a=new ImageIcon(newicon);
		return a;
	}
	public boolean getStatus() {
		return menuon;
	}
}
