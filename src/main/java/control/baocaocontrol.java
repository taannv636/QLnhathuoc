package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import databese.db;
import form.baocao.thongkeform;
import form.nhanvien.dsnhanvienform;

public class baocaocontrol {

	public static void baocao() {
		int tongsotoa = 0;
		int tongsophieu=0;
		int hetsudung=0;
		int tientoa=0;
		int tienphieu=0;
		int doanhthu=0;
		int nvkk=0;
		int ds=0;
		int ncc=0;
		db.conect();
		String sql;
		sql="select count(*),isnull(sum(TONGCONG),0) from fn_getListToa() where MONTH(GETDATE())=MONTH(NGAYKE) and year(GETDATE())=year(NGAYKE)";
		ResultSet res = db.getquery(sql);
		try {
			while (res.next()) {
			tongsotoa=res.getInt(1);
			tientoa=res.getInt(2);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select count(*) FROM KHOTHUOC where HANSUDUNG<GETDATE() and SLTON>0";
		res = db.getquery(sql);
		try {
			while (res.next()) {
			hetsudung=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select count(*),isnull(sum(TONGCONG),0) from fn_getListPhieu() where MONTH(GETDATE())=MONTH(NGAYNHAP) and year(GETDATE())=year(NGAYNHAP)";
		res = db.getquery(sql);
		try {
			while (res.next()) {
			tongsophieu=res.getInt(1);
			tienphieu=res.getInt(2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doanhthu=tientoa-tienphieu;
		sql="select count(*) from fn_getDATANhacungcap()";
		res = db.getquery(sql);
		try {
			while (res.next()) {
			ncc=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select count(*) from dbo.fn_getDATANhanvien() where Duocsi!=0";
		res = db.getquery(sql);
		try {
			while (res.next()) {
			ds=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql="select count(*) from dbo.fn_getDATANhanvien() where Kiemkho!=0";
		res = db.getquery(sql);
		try {
			while (res.next()) {
			nvkk=res.getInt(1);
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		thongkeform.lbltoa.setText(Integer.toString(tongsotoa));
		thongkeform.lblphieunhap.setText(Integer.toString(tongsophieu));
		thongkeform.lblhetsudung.setText(Integer.toString(hetsudung));
		thongkeform.lbltongtoa.setText(Integer.toString(tientoa));
		thongkeform.lbltongphieu.setText(Integer.toString(tienphieu));
		thongkeform.lbldoanhthu.setText(Integer.toString(doanhthu));
		thongkeform.lblkk.setText(Integer.toString(nvkk));
		thongkeform.lblncc.setText(Integer.toString(ncc));
		thongkeform.lblds.setText(Integer.toString(ds));
		
	}
	
}
