package model.thuoc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import databese.db;

public class thuoc  {
	private String mathuoc;//Mã thuoc
	private String hangthuoc;//hãng thuốc
	private String tenthuoc;//Tên thuốc
	private String hoatchat;//hoạt chất
	private String hamluong;//hàm lượng
	private id phanloai;
	private id donvi;
	private ArrayList<lothuoc> lohang;//lô hàng
	private int quydoi;
	private int giaban;
	
	public thuoc(String mathuoc, String hangthuoc, String tenthuoc, String hoatchat, String hamluong, id phanloai,
			id donvi, ArrayList<lothuoc> lohang, int quydoi, int giaban) {
		super();
		this.mathuoc = mathuoc;
		this.hangthuoc = hangthuoc;
		this.tenthuoc = tenthuoc;
		this.hoatchat = hoatchat;
		this.hamluong = hamluong;
		this.phanloai = phanloai;
		this.donvi = donvi;
		this.lohang = lohang;
		this.quydoi = quydoi;
		this.giaban = giaban;
	}
	public thuoc() {
		
		// TODO Auto-generated constructor stub
	}
	public int getGiaban() {
		return giaban;
	}
	public void setGiaban(int giaban) {
		this.giaban = giaban;
	}
	public int getQuydoi() {
		return quydoi;
	}
	public void setQuydoi(int quydoi) {
		this.quydoi = quydoi;
	}
	public id getPhanloai() {
		return phanloai;
	}
	public void setPhanloai(id phanloai) {
		this.phanloai = phanloai;
	}
	public id getDonvi() {
		return donvi;
	}
	public void setDonvi(id donvi) {
		this.donvi = donvi;
	}
	public String getMathuoc() {
		return mathuoc;
	}
	public void setMathuoc(String mathuoc) {
		this.mathuoc = mathuoc;
	}
	public String getHangthuoc() {
		return hangthuoc;
	}
	public void setHangthuoc(String hangthuoc) {
		this.hangthuoc = hangthuoc;
	}
	public String getTenthuoc() {
		return tenthuoc;
	}
	public void setTenthuoc(String tenthuoc) {
		this.tenthuoc = tenthuoc;
	}
	public String getHoatchat() {
		return hoatchat;
	}
	public void setHoatchat(String hoatchat) {
		this.hoatchat = hoatchat;
	}
	public String getHamluong() {
		return hamluong;
	}
	public void setHamluong(String hamluong) {
		this.hamluong = hamluong;
	}
	public ArrayList<lothuoc> getLohang() {
		return lohang;
	}
	public void setLohang(ArrayList<lothuoc> lohang) {
		this.lohang = lohang;
	}
	public void add() {
		String sql="INSERT INTO THUOC VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setString(1,mathuoc);
			pres.setString(2,hangthuoc);
			pres.setString(3,tenthuoc);
			pres.setInt(4,phanloai.getId());
			pres.setInt(5,donvi.getId()); 
			pres.setString(6,hoatchat);
			pres.setString(7,hamluong);
			pres.setInt(8,giaban); 
			pres.setInt(9,quydoi); 
			pres.execute();
			db.disconect();
			JOptionPane.showMessageDialog(null,"Thêm thuốc thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.toString());
			JOptionPane.showMessageDialog(null,"Thêm thuốc thất bại");
		}	
	}
	public boolean updatett(String ten,int pl,String hc,String hl) {
		String sql="update THUOC set TENTHUOC=? ,IDPHANLOAI=?,HOATCHAT=? ,HAMLUONG=? where MATHUOC=? and HANGTHUOC=?";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			
			pres.setString(1,ten);
			pres.setInt(2,pl);
			pres.setString(3,hc);
			pres.setString(4,hl);
			pres.setString(5,mathuoc); 
			pres.setString(6,hangthuoc);
			pres.execute();
			db.disconect();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Cập nhật thông tin thất bại");
			return false;
		}		
	}
	public boolean updateqdgb(int qd,int gia) {
		String sql="update THUOC set QUYDOI=?,GIABAN=? where MATHUOC=? and HANGTHUOC=? and IDDONVI=?";
		try {
			db.conect();
			PreparedStatement pres=db.con.prepareStatement(sql);
			pres.setInt(1,qd);
			pres.setInt(2, gia);
			pres.setString(3,mathuoc); 
			pres.setString(4,hangthuoc);
			pres.setInt(5,donvi.getId());
			pres.execute();
			db.disconect();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Cập nhật Quy đổi hoặc Giá bán thất bại");
			return false;
		}	
	}
}
