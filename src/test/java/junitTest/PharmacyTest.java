package junitTest;

import java.util.Date;
import org.junit.Test;
import java.text.SimpleDateFormat;

import control.nhacungcap.dsnhacungcapcontrol;
import form.login.login;
import form.main.Mainframe;
import form.nhacungcap.dsnhacungcapform;
import form.thuoc.themthuocform;
import model.nhacungcap.nhacungcap;
import model.thuoc.id;
import model.thuoc.lothuoc;
import model.thuoc.thuoc;
import model.user.nhanvien;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;

import org.junit.Ignore;

public class PharmacyTest {
   
	//Test sự chính xác của dữ liệu admin bên trong database
	
	@Ignore
    @Test
    public void testDataAdmin() throws ParseException {
    	//new Date(): ngày hiện tại
    	//Xử lý dữ liệu ngày vào làm
    	String ngayCuTheStr = "2023-10-29"; // Chuỗi ngày cụ thể
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date ngayCuThe = sdf.parse(ngayCuTheStr);
    	
    	//Khởi tạo đối tượng nv với dữ liệu của admin để kiểm tra
    	nhanvien nv = new nhanvien("admin", 1, true, "admin@gmail.com", "12345678", ngayCuThe, "", true);
        //String ten, int ma, boolean phai, String email, String password, Date ngayvao, String maxacnhan, boolean admin
        
    	//Chạy vòng lặp for là danh sách nhân viên
        for (nhanvien a:Mainframe.listnv.list) {
        	if(a.getMa()==(nv.getMa()))	//So sánh mã của nv với a rồi kiểm thử trước mắt 4 thuộc tính
        	{
                assertTrue(a.getTen().equals(nv.getTen()));				//Tên admin
                assertTrue(a.getEmail().equals(nv.getEmail()));			//Email admin
                assertTrue(a.getPassword().equals(nv.getPassword()));	//Password admin
                assertTrue(a.getNgayvao().equals(nv.getNgayvao()));		//Ngày vào làm của admin

        	}
        }
    }
    
  //Test chức năng sửa đổi mật khẩu tài khoản cá nhân
  	@Ignore
  	@Test
  	public void testChangePass() throws ParseException {
  		//new Date(): ngày hiện tại
      	
      	String ngayCuTheStr = "2023-10-25"; // Chuỗi ngày cụ thể
      	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      	Date ngayCuThe = sdf.parse(ngayCuTheStr);
      	
      	nhanvien nv = new nhanvien("NguyenZiDan", 2, true, "duocsi@gmail.com", "12345678", ngayCuThe, "");
          //String ten, int ma, boolean phai, String email, String password, Date ngayvao, String maxacnhan
          
      	String maNew = "123456789";
      	
  		nv.changePass(maNew);           
  		
  		for (nhanvien b:Mainframe.listnv.list) 
  		{
  			if(b.getMa()==(nv.getMa()))
  		     assertEquals(maNew,b.getPassword());
  		}
  	
  	}
  	
    
	//Test chức năng Thêm nhà cung cấp
	
	@Ignore
    @Test
    public void testAddNewSupplier() {
       nhacungcap NCC = new nhacungcap("3", "MozambiqueDrug","40 Maine, Santo Antonio, Manica",
            		"0123457788","T0123","mozamdg@gmail.com");
            //String ma, String ten, String dc, String sdt, String madoanhnghiep, String email

       NCC.add();
            
       for (nhacungcap b:Mainframe.listcc.list) {
          if(b.getMa().trim().equals(NCC.getMa())) {
               assertTrue(b.equals(NCC));
           }
        }
    }
       
	//Test chức năng sửa nhà cung cấp
		
	@Ignore
	@Test
	public void testEditSupplier() {
		 //lưu ý: không được sửa mã nhà cung cấp
		nhacungcap NCC = new nhacungcap("1", "PharmaUK","48 Pham The Hien, P4, Q8, TPHCM",
		            		"0123456788","T0121","phmuk@gmail.com");
        //String ma, String ten, String dc, String sdt, String madoanhnghiep, String email
		            
		NCC.update();
		            
		for (nhacungcap b:Mainframe.listcc.list) {
		   if(b.getMa().trim().equals(NCC.getMa())) {
		       assertTrue(b.equals(NCC));
		      }
		}
	}
	

	
}

