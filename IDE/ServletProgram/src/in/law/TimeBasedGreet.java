package in.law;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class TimeBasedGreet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		LocalTime time = LocalTime.now();
		if (time.isAfter(LocalTime.parse("06:00")) && time.isBefore(LocalTime.parse("12:00")))
			res.getWriter().append("<h1>Good Morning</h1>");
		else if (time.isAfter(LocalTime.parse("12:00")) && time.isBefore(LocalTime.parse("17:00")))
			res.getWriter().append("<h1>Good AfterNoon</h1>");
		else if (time.isAfter(LocalTime.parse("17:00")) && time.isBefore(LocalTime.parse("21:00")))
			res.getWriter().append("<h1>Good Evening</h1>");
		else if (time.isAfter(LocalTime.parse("21:00")) && time.isBefore(LocalTime.parse("04:00")))
			res.getWriter().append("<h1>Good Night</h1>");
	}

}
