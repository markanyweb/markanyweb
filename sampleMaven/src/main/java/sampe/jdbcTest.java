package sampe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class jdbcTest {
	public static void main(String[] args) {
		
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
				    Class.forName("com.mysql.jdbc.Driver");
				    
				    conn = DriverManager.getConnection(
				                    "jdbc:mysql://192.168.1.78:3306/pms",
				                     "pms", "pms");
				    pstmt = conn.prepareStatement("SELECT * FROM pms.t_business");
				    rs = pstmt.executeQuery();
				    
				    if (rs.next()) {
				    	System.out.println(rs.getString("C_REG_USER_ID"));
				    	System.out.println(rs.getString("C_REG_DT"));
				    }
				} catch(SQLException ex) {
					System.out.println(ex.getMessage());
				} catch(ClassNotFoundException ex) {
				  
				} catch(Exception ex) {
				} finally {
				    if (rs != null) try { rs.close(); } catch(SQLException ex) {}
				    if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
				    if (conn != null) try { conn.close(); } catch(SQLException ex) {}
				}
	}
}