package model.user;

import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import databese.db;

public class duocsi extends nhanvien{
	private String Mahieu;//mã bằng dược sĩ
	public duocsi() {
		// TODO Auto-generated constructor stub
	}
	public String getMahieu() {
		return Mahieu;
	}
	public void setMahieu(String mahieu) {
		Mahieu = mahieu;
	}
	public duocsi(String ten, int ma, boolean phai, String email, String password, Date ngayvao, String maxacnhan,
			String mahieu) {
		super(ten, ma, phai, email, password, ngayvao, maxacnhan);
		Mahieu = mahieu;
	}
	@Override
	public void load(int ma) {
		super.load(ma);
		ResultSet res = db.getquery("SELECT* FROM DUOCSI where MANV='"+ma+"'");
		try {
			db.conect();
			res.next();
			Mahieu=res.getString(2);
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void add() {
		super.add();
		super.load(getEmail());
		try {
			db.conect();
			String sql="INSERT INTO DUOCSI VALUES(?,?)";
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setInt(1, getMa());
			pres.setString(2,Mahieu);
			pres.execute();
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
