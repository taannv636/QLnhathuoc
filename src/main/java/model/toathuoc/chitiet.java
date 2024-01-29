package model.toathuoc;

import java.util.Date;

import model.thuoc.lothuoc;
import model.thuoc.thuoc;

public class chitiet {
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
	private String ghichu;
	private String malothuoc;
	
	public chitiet(String mathuoc, String hangthuoc, int iddonvi, int sl, String ghichu, String malothuoc) {
		this.mathuoc = mathuoc;
		this.hangthuoc = hangthuoc;
		this.iddonvi = iddonvi;
		this.sl = sl;
		this.ghichu = ghichu;
		this.malothuoc = malothuoc;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public String getMalothuoc() {
		return malothuoc;
	}
	public void setMalothuoc(String malothuoc) {
		this.malothuoc = malothuoc;
	}
	public chitiet() {
		// TODO Auto-generated constructor stub
	}

}
