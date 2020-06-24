package insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterEvent extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");

		Connection con ;  PreparedStatement st;
		PrintWriter p = resp.getWriter();
		String name = req.getParameter("Uname");
		String event = req.getParameter("event");
		System.out.println(name+" "+event);
		p.println("<b>welcome:</b>"+name+"<br>");
		try {
			Class.forName(DB_url);
			con=DriverManager.getConnection(DB_path,user,pwd);
			String sql="update Company set  event='"+event+"' where uname='"+name+"';";
			Statement stm = con.createStatement();
			 stm.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*p.println("<a href=Display.html>Display all users in database</a>"+"<br>");
		p.println("<a href=Index.html>Return to home</a>");*/
		
	}
		static final String DB_url = "com.mysql.jdbc.Driver";
		static	final String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
		static	final String user = "sahil";
		static	final String pwd = "Naruhina@09";

}
