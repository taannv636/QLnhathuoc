package model.thuoc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databese.db;

public class kho {
	public ArrayList<thuoc>listthuoc ;
	public kho() {
		load();	
	}
	public void load() {
		listthuoc=new ArrayList<thuoc>();
		String sql1="SELECT* FROM dbo.fn_getDATADANHMUCTHUOC()";
		String sql2="Select * from KHOTHUOC join DONVITHUOC on DONVITHUOC.IDDONVI=KHOTHUOC.IDDONVI  where MATHUOC=? and HANGTHUOC=? and DONVI=?";
		db.conect();
		{
			try {
				ResultSet rs1=db.getquery(sql1);
				ResultSet rs2;
				PreparedStatement prs= db.con.prepareStatement(sql2);
				while (rs1.next()) {
					ArrayList<lothuoc> templist=new ArrayList<lothuoc>();
					prs.setString(1,rs1.getString(1));
					prs.setString(2,rs1.getString(3));
					prs.setString(3,rs1.getString(5));
					rs2= prs.executeQuery();
					while (rs2.next()) {
						templist.add(new lothuoc(rs2.getString(1).trim(),rs2.getString(2),rs2.getString(4),rs2.getDate(5), rs2.getInt(3)));
					}
					listthuoc.add(new thuoc(rs1.getString(1).trim(),rs1.getString(3),rs1.getString(2), rs1.getString(6),rs1.getString(7),new id(rs1.getInt(10),rs1.getString(4)),new id(rs1.getInt(9),rs1.getString(5)), templist,rs1.getInt(11),rs1.getInt(8)));	
				}	
				db.disconect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
