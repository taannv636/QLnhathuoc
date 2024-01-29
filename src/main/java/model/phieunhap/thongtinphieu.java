package model.phieunhap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import databese.db;
import model.phieunhap.*;
import model.user.nhanvien;

public class thongtinphieu {
	String maphieu;
	Date ngaynhap;
	String tennhacungcap;
	nhanvien phutrach=new nhanvien();
	int tong;
	ArrayList<chitiet> chitiet;
	public thongtinphieu() {
		// TODO Auto-generated constructor stub
	}
	
	public thongtinphieu(String maphieu, Date ngaynhap, String tennhacungcap, nhanvien phutrach, int tong,
			ArrayList<model.phieunhap.chitiet> chitiet) {
		super();
		this.maphieu = maphieu;
		this.ngaynhap = ngaynhap;
		this.tennhacungcap = tennhacungcap;
		this.phutrach = phutrach;
		this.tong = tong;
		this.chitiet = chitiet;
	}

	public int getTong() {
		return tong;
	}

	public void setTong(int tong) {
		this.tong = tong;
	}

	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getTennhacungcap() {
		return tennhacungcap;
	}
	public void setTennhacungcap(String tennhacungcap) {
		this.tennhacungcap = tennhacungcap;
	}
	public nhanvien getPhutrach() {
		return phutrach;
	}
	public void setPhutrach(nhanvien phutrach) {
		this.phutrach = phutrach;
	}
	public ArrayList<chitiet> getChitiet() {
		return chitiet;
	}
	public void setChitiet(ArrayList<chitiet> chitiet) {
		this.chitiet = chitiet;
	}
	public void nhap() {
		if(chitiet.size()<1)
		{
			JOptionPane.showConfirmDialog(null,"Cập nhật thất bại");
			return;
		}
		String sql1 = "INSERT INTO PHIEUNHAPKHO VALUES(?,?,?,?,?)";
		String sql2="INSERT INTO CHITIETPHIEU VALUES(?,?,?,?,?,?,?)";
			try{
			db.conect();
			db.con.setAutoCommit(false);
			PreparedStatement prest =db.con.prepareStatement(sql1);
			prest.setString(1, maphieu);
			prest.setDate(2, new java.sql.Date(ngaynhap.getTime()));
			prest.setString(3, tennhacungcap);
			prest.setInt(4,phutrach.getMa());
			prest.setInt(5,0);
			prest.executeUpdate();
			
			prest =db.con.prepareStatement(sql2);
			for(chitiet a:chitiet)
			{
				prest.setString(1,maphieu);
				prest.setString(2,a.getMathuoc());
				prest.setString(3,a.getHangthuoc());
				prest.setInt(4,a.getIddonvi());
				prest.setInt(5,a.getSl());
				prest.setDate(6,new java.sql.Date(a.getNgayhethan().getTime()));
				prest.setInt(7, a.getDongia());
				prest.executeUpdate();
			}
			db.con.commit();
			db.con.setAutoCommit(true);
			JOptionPane.showMessageDialog(null,"Tạo phiếu nhập thành công");
			}
			catch(SQLException e){
				try {
				db.con.rollback();
				} catch (SQLException e1) {
				System.out.println(e1.toString()); }
				e.printStackTrace(); }
				
		
	}
	public void load(String ma) {
		chitiet=new ArrayList<chitiet>();
		String sql1 = "select * from PHIEUNHAPKHO where MAPHIEU='"+ma+"'";
		String sql2="select * from dbo.fn_getChitietPhieu('"+ma+"')";
		db.conect();
		if (db.con != null){
			
			try {
				ResultSet res = db.getquery(sql1);
				while (res.next()) {
					maphieu=res.getString(1);
					ngaynhap=res.getDate(2);
					tennhacungcap=res.getString(3);
					phutrach.load(res.getInt(4));
					tong=res.getInt(5);
				}
				res = db.getquery(sql2);
				while (res.next()) {
					chitiet.add(new chitiet(res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getDate(6),res.getInt(7)));
				}
				db.disconect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}
	}
	
}
