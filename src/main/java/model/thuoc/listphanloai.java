package model.thuoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databese.db;

public class listphanloai {
	public ArrayList<id>list;
	public listphanloai() {
		load();
	}
	public void load() {
		list=new ArrayList<id>();
		ResultSet res = db.getquery("SELECT* FROM PHANLOAI");
		try {
			while (res.next()) {
				list.add(new id(res.getInt(1),res.getString(2)));
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
