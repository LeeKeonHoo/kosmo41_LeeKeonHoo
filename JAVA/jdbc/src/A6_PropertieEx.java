import java.io.*;
import java.sql.*;
import java.util.*;

public class A6_PropertieEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Properties pro = null;
		FileInputStream fis = null;

		try {
			pro = new Properties();
			fis = new FileInputStream("D:\\kunhoohei\\Study\\Java\\jdbc\\jdbc.properties");
			pro.load(fis);
			
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String pwd = pro.getProperty("password");
			
			con = DriverManager.getConnection(
					url,
					user,
					pwd);
			
			String sql = "select * from employee";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("eno : " + rs.getInt(1) + ", ");
				System.out.println("ename : " + rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException sqle) {}
		}
	}
}