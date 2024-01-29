package model.thuoc;

import java.util.Date;

public class lothuoc {
	 String mathuoc=null;
	 String hangthuoc=null;
	 String malothuoc=null;//mã lô thuốc
	 Date hansudung;
	 int sl;
	public lothuoc(String mathuoc, String hangthuoc, String malothuoc, Date hansudung, int sl) {
		super();
		this.mathuoc = mathuoc;
		this.hangthuoc = hangthuoc;
		this.malothuoc = malothuoc;
		this.hansudung = hansudung;
		this.sl = sl;
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
	public String getMalothuoc() {
		return malothuoc;
	}
	public void setMalothuoc(String malothuoc) {
		this.malothuoc = malothuoc;
	}
	public Date getHansudung() {
		return hansudung;
	}
	public void setHansudung(Date hansudung) {
		this.hansudung = hansudung;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	 
}
