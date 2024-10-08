package in.law.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.law.dao.BookDAO;

@WebServlet("/insert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String bid = req.getParameter("bid");
		String bname = req.getParameter("bname");
		String bprice = req.getParameter("bprice");
		
		int bookId=Integer.parseInt(bid);
		int bookPrice=Integer.parseInt(bprice);
		
		System.out.println(bookId);
		System.out.println(bname);
		System.out.println(bookPrice);
		
		BookDAO dao=new BookDAO();
			
			boolean status=false;
			try {
				status = dao.saveBook(bookId, bname, bookPrice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			String response=null;
			if(status) {
				response="<h3>Resquest Accepted</h3>";
			}else {
				response="<h3>Resquest Denied</h3>";
			}
			
			PrintWriter writer = res.getWriter();
			writer.append(response);
	}

}
