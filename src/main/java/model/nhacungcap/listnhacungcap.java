package model.nhacungcap;

import java.rmi.server.LoaderHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databese.db;

public class listnhacungcap {
	public ArrayList<nhacungcap> list=new ArrayList<nhacungcap>();
	public listnhacungcap() {
		load();
	}
	public void load() {
	try {
			list.clear();
			nhacungcap temp;
			db.conect();
			ResultSet res=db.getquery("select * from NHACUNGCAP");
			while (res.next()) {
				temp=new nhacungcap(res.getString(1).trim(),res.getString(2).trim(),res.getString(3).trim(),res.getString(4).trim(),res.getString(5).trim(),res.getString(6).trim());		
				list.add(temp);
			}
			db.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		listnhacungcap a = new listnhacungcap();
		a.load();
		System.out.print(a.list.get(1).getMa());
	}

}
