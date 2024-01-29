package model.phieunhap;

import java.util.Date;

import model.thuoc.lothuoc;

public class chitiet {
	public chitiet(String mathuoc, String hangthuoc, int iddonvi, int sl, Date ngayhethan,int dongia) {
		super();
		this.mathuoc = mathuoc;
		this.hangthuoc = hangthuoc;
		this.iddonvi = iddonvi;
		this.sl = sl;
		this.ngayhethan = ngayhethan;
		this.dongia=dongia;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
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
	public int getIddonvi() {
		return iddonvi;
	}
	public void setIddonvi(int iddonvi) {
		this.iddonvi = iddonvi;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	private String mathuoc;
	private String hangthuoc;
	private int iddonvi;
	private int sl ;
	private Date ngayhethan;
	private int dongia;
	public Date getNgayhethan() {
		return ngayhethan;
	}
	public void setNgayhethan(Date ngayhethan) {
		this.ngayhethan = ngayhethan;
	}
	public chitiet() {
		// TODO Auto-generated constructor stub
	}

}
