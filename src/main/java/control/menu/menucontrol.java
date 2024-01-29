package control.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import org.jdesktop.animation.timing.interpolation.PropertySetter;

import control.thongtincanhancontrol;
import form.main.Mainframe;
import form.menu.*;
import form.nhacungcap.dsnhacungcapform;
import form.nhacungcap.thongtinnhacungcapform;
import form.thuoc.khothuocform;
import form.thuoc.thongtinform;
import model.thuoc.thuoc;
import model.user.duocsi;
import model.user.nhanvien;
public class menucontrol {
	public static void Kho() {
		menuslide.btnThuoc.setColor(new Color(255, 255, 255,90));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		menuslide.btnThongke.setColor(new Color(0, 144, 219));
		//
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(1);
	}
	public static void Nhacungcap() {
		menuslide.btnCungcap.setColor(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		menuslide.btnThongke.setColor(new Color(0, 144, 219));
		//
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(3);
	}
	public static void Toa() {
		menuslide.btnKetoa.setColor(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		menuslide.btnThongke.setColor(new Color(0, 144, 219));
		//
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(4);
	}
	public static void Nhap() {
		menuslide.btnNhaphang.setColor(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		//
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(2);
	}
	public static void Home() {
		menuslide.btnHome.setColor(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		menuslide.btnThongke.setColor(new Color(0, 144, 219));
		//
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(0);
	}
	public static void User() {
		menuslide.btnUser.setColor(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnThongke.setColor(new Color(0, 144, 219));
		//
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(5);
	}
	public static void Thongke() {
		menuslide.btnThongke.setColor(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		//
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,90));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(6);
	}
	public static void Thongtin() {
		menuslide.btnThongke.setColor(new Color(0, 144, 219));
		menuslide.btnThuoc.setColor(new Color(0, 144, 219));
		menuslide.btnKetoa.setColor(new Color(0, 144, 219));
		menuslide.btnCungcap.setColor(new Color(0, 144, 219));
		menuslide.btnHome.setColor(new Color(0, 144, 219));
		menuslide.btnNhaphang.setColor(new Color(0, 144, 219));
		menuslide.btnUser.setColor(new Color(0, 144, 219));
		//
		menuslide.btnThongke.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnThuoc.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnKetoa.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnCungcap.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnHome.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnNhaphang.setColorOver(new Color(255, 255, 255,30));
		menuslide.btnUser.setColorOver(new Color(255, 255, 255,30));
		Mainframe.tabbedPane.setSelectedIndex(7);
		thongtincanhancontrol.load();
	}
	public static void Phanquyen() {
		nhanvien a=Mainframe.user;
		String cv=null;
		if(a.getClass()==duocsi.class) {
			cv="Dược sĩ";
		}
		else if (a.isAdmin()) {
			cv="Admin";
		}
		else {
			cv="Nhân viên";
		}
		if(cv.equals("Dược sĩ")) {
			menuslide.btnThongke.setEnabled(true);
			menuslide.btnThuoc.setEnabled(true);
			menuslide.btnKetoa.setEnabled(true);
			menuslide.btnCungcap.setEnabled(false);
			menuslide.btnHome.setEnabled(true);
			menuslide.btnNhaphang.setEnabled(false);
			menuslide.btnUser.setEnabled(false);
			thongtinnhacungcapform.rndbtnLuu.setVisible(false);
			dsnhacungcapform.rndbtnThm.setVisible(false);
			khothuocform.rndbtnThm.setVisible(false);
			thongtinform.rndbtnLu.setVisible(false);
		}
		if(cv.equals("Nhân viên")) {
			menuslide.btnThongke.setEnabled(true);
			menuslide.btnThuoc.setEnabled(true);
			menuslide.btnKetoa.setEnabled(false);
			menuslide.btnCungcap.setEnabled(true);
			menuslide.btnHome.setEnabled(true);
			menuslide.btnNhaphang.setEnabled(true);
			menuslide.btnUser.setEnabled(false);
			thongtinnhacungcapform.rndbtnLuu.setVisible(true);
			dsnhacungcapform.rndbtnThm.setVisible(true);
			khothuocform.rndbtnThm.setVisible(true);
			thongtinform.rndbtnLu.setVisible(true);
			
		}
		if(cv.equals("Admin")) {
			menuslide.btnThongke.setEnabled(true);
			menuslide.btnThuoc.setEnabled(false);
			menuslide.btnKetoa.setEnabled(false);
			menuslide.btnCungcap.setEnabled(false);
			menuslide.btnHome.setEnabled(true);
			menuslide.btnNhaphang.setEnabled(false);
			menuslide.btnUser.setEnabled(true);
			thongtinnhacungcapform.rndbtnLuu.setVisible(false);
			dsnhacungcapform.rndbtnThm.setVisible(false);
			khothuocform.rndbtnThm.setVisible(false);
			thongtinform.rndbtnLu.setVisible(false);
			
		}
	}
}
