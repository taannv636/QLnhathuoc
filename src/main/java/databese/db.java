package databese;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class db {
	 public static Connection con;
	 public static void conect() {
		 try {
			con = DriverManager.getConnection("jdbc:sqlserver://TANNV\\TAAN:1433;databaseName=QLNHATHUOC;user=sa;password=12345;encrypt=false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	    public static ResultSet getquery(String Sql)
	    {
	            try {
					conect();
					Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery(Sql);
		            return rs;
	            } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	            
	    }
	    public static boolean update(String sql)
	    {
	        try {
	        	conect();
	        	Statement st = con.createStatement();
	            st.executeUpdate(sql);
	            return true;
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	JOptionPane.showMessageDialog(null,"Cập nhật dữ liệu thất bại");
	        	return false;
	        }
	    }
	    public static void disconect() throws SQLException
	    {
	        if(con!=null)
	        con.close();
	    }	
}
