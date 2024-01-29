package model.user;

import java.beans.JavaBean;
import java.nio.charset.Charset;
import java.rmi.server.LoaderHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import databese.db;

public class nhanvien {
	private String ten;
	private int ma;
	private boolean phai;//true: nam, False: nu
	private String email;
	private String password;
	private Date ngayvao;
	private String maxacnhan;
	private boolean admin=false;
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getTen() {
		return ten;
	}
	public nhanvien(String ten, int ma, boolean phai, String email, String password, Date ngayvao, String maxacnhan) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.phai = phai;
		this.email = email;
		this.password = password;
		this.ngayvao = ngayvao;
		this.maxacnhan = maxacnhan;
	}
	public nhanvien(String ten, int ma, boolean phai, String email, String password, Date ngayvao, String maxacnhan,
			boolean admin) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.phai = phai;
		this.email = email;
		this.password = password;
		this.ngayvao = ngayvao;
		this.maxacnhan = maxacnhan;
		this.admin = admin;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public Date getNgayvao() {
		return ngayvao;
	}
	public void setNgayvao(Date ngayvao) {
		this.ngayvao = ngayvao;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public nhanvien() {
		// TODO Auto-generated constructor stub
	}
	public boolean checklogin(){
		db.conect();
		ResultSet res = db.getquery("SELECT* FROM NHANVIEN");
		try {
			while (res.next()) {
				if(email==res.getString(5)&&password==res.getString(7)) {
					return true;
				}
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void load(String email) {
		db.conect();
		ResultSet res = db.getquery("SELECT* FROM NHANVIEN left join ADMIN on ADMIN.MANV=NHANVIEN.MANV where EMAIL='"+email+"'");
		try {
			while (res.next()) {
				ma=res.getInt(1);
				ten=res.getString(2);
				phai=res.getBoolean(3);
				ngayvao=res.getDate(4);
				this.email=res.getString(5);
				maxacnhan=res.getString(6);
				password=res.getString(7);
				if(res.getInt(8)==res.getInt(1))
					admin=true;
				else 
					admin=false;
				}
				db.disconect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void load(int ma) {
			
			ResultSet res = db.getquery("SELECT* FROM NHANVIEN left join ADMIN on ADMIN.MANV=NHANVIEN.MANV where NHANVIEN.MANV="+ma+"");
			try {
				db.conect();
				while (res.next()) {
				this.ma=res.getInt(1);
				ten=res.getString(2);
				phai=res.getBoolean(3);
				ngayvao=res.getDate(4);
				email=res.getString(5);
				maxacnhan=res.getString(6);
				password=res.getString(7);
				if(res.getInt(8)==res.getInt(1))
					admin=true;
				else 
					admin=false;
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMaxacnhan() {
		return maxacnhan;
	}
	public void setMaxacnhan(String maxacnhan) {
		this.maxacnhan = maxacnhan;
	}
	public void signin() {
	}
	public void add() {
		try {
			db.conect();
			String sql="INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?)";
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setString(1, ten);
			pres.setBoolean(2,phai);
			pres.setDate(3,new java.sql.Date(ngayvao.getTime()));
			pres.setString(4, email);
			pres.setNull(5,Types.NCHAR);
			pres.setString(6, password);
			pres.execute();
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addnv() {
		try {
			db.conect();
			load(getEmail());
			String sql="INSERT INTO KIEMKHO VALUES(?)";
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setInt(1, ma);
			pres.execute();
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void luumaxacnhan() {
		if(maxacnhan==null) {
			String sql="UPDATE NHANVIEN SET XACNHAN=? where MANV=?";
		    String ma =randomstring(8);
			try {
				db.conect();
				PreparedStatement pres=db.con.prepareCall(sql);
				pres.setString(1,ma);
				pres.setInt(2,this.ma);
				pres.execute();
				db.disconect();
				load(getEmail());
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(maxacnhan.trim().equals("")) {
			String sql="UPDATE NHANVIEN SET XACNHAN=? where MANV=?";
		    String ma =randomstring(8);
			try {
				db.conect();
				PreparedStatement pres=db.con.prepareCall(sql);
				pres.setString(1,ma);
				pres.setInt(2,this.ma);
				pres.execute();
				db.disconect();
				load(getEmail());
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	public boolean dungmaxacnhan(String ma) {
		if(!ma.equals(getMaxacnhan().trim())) {
			return false;
		}
		String sql="UPDATE NHANVIEN SET XACNHAN=? where MANV=?";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareCall(sql);
			pres.setString(1,"");
			pres.setInt(2,this.ma);
			pres.execute();
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		load(getEmail());
		return true;
	}
	public static String randomstring(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		         + "0123456789"
		         + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);
		  for (int i = 0; i < n; i++) {
		 
		   // generate a random number between
		   // 0 to AlphaNumericString variable length
		   int index
		    = (int)(AlphaNumericString.length()
		      * Math.random());
		 
		   // add Character one by one in end of sb
		   sb.append(AlphaNumericString
		      .charAt(index));
		  }
		 
		  return sb.toString();
	}
	public void changePass(String pass) {
		String sql="UPDATE NHANVIEN SET PASSWORD=? where MANV=?";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareCall(sql);
			pres.setString(1,pass);
			pres.setInt(2,this.ma);
			pres.execute();
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		load(getMa());

	}
	public void changeInfo(String name,String email) {
		String sql="UPDATE NHANVIEN SET TENNV=?,EMAIL=? where MANV=?";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareCall(sql);
			pres.setString(1,name);
			pres.setString(2,email);
			pres.setInt(3,this.ma);
			pres.execute();
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		load(getMa());

	}
	
}
