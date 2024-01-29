package junitTest;

import java.util.Arrays;
import java.util.Collection;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import control.login.logincontrol;
import form.login.login;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


//Lớp PrimeNumberCheckerTest là một bài kiểm tra tham số hóa (parameterized test)
@RunWith(Parameterized.class)
public class LoginTest {
   private String email;
   private String password;
   private Boolean expectedResult;
  
   //Constructor của lớp LoginTest, sử dụng để thiết lập các tham số đầu vào và kết quả dự kiến
   public LoginTest(String email, String password, Boolean expectedResult) {
      this.email = email;
      this.password = password;
      this.expectedResult = expectedResult;
   }

   //Hàm kiểm tra kết quả trả về từ hàm login() class logincontrol có chạy đúng
   public Boolean validate(final String email, String password) {
	   login.email.setText(email);
	   login.pass.setText(password);
	
	   //Ngoại lệ để xét trường hợp trả về null ở phía hàm login()
	   try {
		   if (logincontrol.login() == null)   //gọi hàm login() từ control.login.logincontrol.login()
		     {
	            return false;
	         }
	   }
	   catch (Exception e)
	   {
		   System.out.println("Exception occured in processing");
	   }
	      return true;
	      
   }  

   //Phương thức này trả về một tập hợp các tham số cho bài kiểm tra được gợi bằng @Parameterized.Parameters
   @Parameterized.Parameters
   public static Collection ArrayLogin() {
      return Arrays.asList(new Object[][] {
         { "phathcm03@gmail.com","1122334455", false },
         { "duytan65@gmail.com","12345678", false },
         { "admin@gmail.com","12345678", true },
         { "letrunghung@gmail.com","0022334455", false },
         { "kiemkho@gmail.com","113984455", false },
         { "kiemkho@gmail.com","12345678", true },

      });
   }


   //Phương thức kiểm tra email và password
   @Test
   public void testLogin() {
      System.out.println("Account with email checked is : " + email);


	//Kiểm tra xem kết quả từ hàm Validate có khớp với kết quả dự kiếm hay không
      assertEquals(expectedResult, validate(email,password));
      
   }
}
