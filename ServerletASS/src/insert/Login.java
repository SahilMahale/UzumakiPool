package insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet  {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pout = resp.getWriter();
	
		Connection con ;  PreparedStatement st;
		String name = req.getParameter("user");
		String pass = req.getParameter("pass");
		System.out.println(name +" "+pass);
		
		try {
			Class.forName(DB_url);
			con=DriverManager.getConnection(DB_path,user,pwd);
			String sql="select password from users where username='"+name+"';";
			Statement stm = con.createStatement();
			ResultSet r = stm.executeQuery(sql);
			while(r.next()) {
				if(r.getString(1).equals(pass)) {
					System.out.println("login succ"+name);
					//if(r.getString(2).equals("company"))
					//resp.sendRedirect("index_company.html");
					//else if(r.getString(2).equals("user"))
						resp.sendRedirect("Index.html");
				}
				else
					System.out.println("fail");
				pout.print("login failed");
				pout.print("<a href=Login.html>Return to login</a>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	static final String DB_url = "com.mysql.jdbc.Driver";
	static	final String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
	static	final String user = "sahil";
	static	final String pwd = "Naruhina@09";
}
