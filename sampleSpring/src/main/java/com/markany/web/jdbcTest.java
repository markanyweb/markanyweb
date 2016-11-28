package com.markany.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTest {

	public static void main(String[] args)  {
	  	Connection con = null; 
       	PreparedStatement pstmt = null;
		ResultSet rs = null;
		        try {
		        	
		            Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://192.168.1.78:3306/pms","pms", "pms");
		            
		            System.out.println("connection ok");
		    	    	
	    	    	pstmt = con.prepareStatement("SELECT * FROM t_issue WHERE C_ISSUE_SQ = 2");
	    	    	
	    	    	rs = pstmt.executeQuery();
	    	    	
	    		    if (rs.next()) {
	    		    	System.out.println(rs.getString("C_REG_USER_ID"));
	    		    }
		    		    
		    		} catch (SQLException e) {
		    			e.printStackTrace();
		    		}catch ( ClassNotFoundException e){
		    			e.printStackTrace();
		    		}finally {
		    			
		    		    if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		    		    if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		    		    if (con != null) try { con.close(); System.out.println("close connection ok");} catch(SQLException ex) {}
		    			
		    		}
	}
}
