package model.thuoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databese.db;

public class listdonvi {
	public ArrayList<id> list;
	public listdonvi() {
		load();
	}
	public void load() {
		list=new ArrayList<id>();
		db.conect();
		if(db.con!=null) {
			ResultSet res = db.getquery("SELECT* FROM DONVITHUOC");
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
}
