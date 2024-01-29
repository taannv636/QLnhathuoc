package model.phieunhap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databese.db;

public class listphieu {
	public ArrayList<thongtinphieu> list=new ArrayList<thongtinphieu>();
	public listphieu() {
		load();
	}
	public void load() {
		try {
			db.conect();
			list.clear();
			ResultSet res=db.getquery("select * from PHIEUNHAPKHO");
			while (res.next()) {
				thongtinphieu temp=new thongtinphieu();
				temp.load(res.getString(1).trim());
				list.add(temp);
			}
			
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
