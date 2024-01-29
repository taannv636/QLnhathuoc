package model.toathuoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databese.db;
import model.phieunhap.thongtinphieu;
public class listtoa {
	public ArrayList<thongtintoa> list=new ArrayList<thongtintoa>();
	public listtoa() {
		load();
	}
	public void load() {
		try {
			db.conect();
			list.clear();
			ResultSet res=db.getquery("select * from TOATHUOC");
			thongtintoa temp;
			while (res.next()) {
				temp=new thongtintoa();
				temp.load(res.getString(1).trim());
				list.add(temp);
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		listtoa a=new listtoa();

		System.out.print(a.list.get(0).getMaphieu());
	}
}
