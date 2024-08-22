package in.law.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.law.dto.User;
import in.law.util.ConnectionFactory;

public class UserDAO {

	public static boolean registerUser(User r) throws SQLException {
		String sql="INSERT INTO USERS(username,password,email) VALUES (?,?,?)";
		Connection con = ConnectionFactory.getConnetion();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,r.getName());
		pstmt.setString(2,r.getEmail());
		pstmt.setString(3,r.getPwd());
		
		int rowEffect = pstmt.executeUpdate();
		
		return rowEffect>0;
	}
	
	public User validateUser(String username,String password) throws SQLException {
		User u=null;
		String sql="SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
		Connection con = ConnectionFactory.getConnetion();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2,password);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		return u;
		
	}
}
