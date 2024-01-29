package model.nhacungcap;

import java.rmi.server.LoaderHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import databese.db;

public class nhacungcap {
	private String ma;
	private String ten;
	private String dc;
	private String sdt;
	private String madoanhnghiep;
	private String email;
	public nhacungcap(String ma, String ten, String dc, String sdt, String madoanhnghiep, String email) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.dc = dc;
		this.sdt = sdt;
		this.madoanhnghiep = madoanhnghiep;
		this.email = email;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMadoanhnghiep() {
		return madoanhnghiep;
	}
	public void setMadoanhnghiep(String madoanhnghiep) {
		this.madoanhnghiep = madoanhnghiep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public nhacungcap() {
		// TODO Auto-generated constructor stub
	}
	public void load(String ma) {
		try {
			db.conect();
			ResultSet res=db.getquery("select * from NHACUNGCAP where MACTY='"+ma+"'");
			while (res.next()) {
				this.ma=res.getString(1);
				ten=res.getString(2);
				dc=res.getString(3);
				sdt=res.getString(4);
				madoanhnghiep=res.getString(5);
				email=res.getString(6);
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean add() {
		try {
			String sql="INSERT INTO NHACUNGCAP VALUES(?,?,?,?,?,?)";
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setString(1, ma);
			pres.setString(2, ten);
			pres.setString(3, dc);
			pres.setString(4, sdt);
			pres.setString(5, madoanhnghiep);
			pres.setString(6, email);
			pres.execute();
			db.disconect();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Thêm không thành công");
			return false;
		}
		
	}
	public boolean update() {
		try {
			String sql="update NHACUNGCAP set TENCTY=? ,DCVANPHONG=? ,SDT=?, MADOANHNGHIEP=? ,EMAIL=?  where MACTY=?";
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setString(6, ma);
			pres.setString(1, ten);
			pres.setString(2, dc);
			pres.setString(3, sdt);
			pres.setString(4, madoanhnghiep);
			pres.setString(5, email);
			pres.execute();
			db.disconect();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Cập nhật không thành công");
			return false;
		}
		
	}
	@Override
	public boolean equals(Object obj) {
	    if (obj == this) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    nhacungcap other = (nhacungcap) obj;
	    return ma.equals(other.ma) &&
	            ten.equals(other.ten) &&
	            dc.equals(other.dc) &&
	            sdt.equals(other.sdt) &&
	            madoanhnghiep.equals(other.madoanhnghiep) &&
	            email.equals(other.email);
	}

}
