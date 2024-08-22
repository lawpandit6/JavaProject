package in.law.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.law.util.ConnectionFactory;

public class BookDAO {
	
	String sql="INSERT INTO BOOK VALUES (? ,?, ?)";
	public boolean saveBook(int bid,String bname,int bprice) throws SQLException, IOException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bid);
		pstmt.setString(2, bname);
		pstmt.setInt(3, bprice);
		
		int count = pstmt.executeUpdate();
		
		return count>0;
		
	}
	
}
