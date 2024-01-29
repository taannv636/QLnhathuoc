package model.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databese.db;

public class listnhanvien {
	public ArrayList<nhanvien> list=new ArrayList<nhanvien>();
	public listnhanvien() {
		load();
	}
	public void load() {
		list.clear();
		db.conect();
		ResultSet res = db.getquery("select * from NHANVIEN left join ADMIN on ADMIN.MANV=NHANVIEN.MANV left join DUOCSI on DUOCSI.MANV=NHANVIEN.MANV");
		try {
			nhanvien temp;
			while (res.next()) {
				if(res.getString(9)==null)
				temp=new nhanvien();
				else
				temp=new duocsi();
				temp.load(res.getInt(1));
				list.add(temp);
				}
				db.disconect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
