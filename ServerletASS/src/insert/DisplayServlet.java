package insert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;	
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	 Connection conn;Statement stmt; 
	  try {
				Class.forName(DB_url);
				conn = DriverManager.getConnection(DB_path, user, pwd);
				String sql1 = "select * from Student;";
				stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			pw.print("<style>\n" + 
					"table, th, td {\n" + 
					"  border: 1px solid black;\n" + 
					"}\n" + 
					"</style>");
			pw.print("<table>");
			pw.print("<tr><th>USN</th><th>Name</th><th>Rollno</th><th>Attendance</th></tr>");
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
			pw.print("</tr></table>");
			 pw.println("<a href=Index.html>Return to home</a>");
			} catch (Exception e) {
				System.out.println(e);
			}
}
static final String DB_url = "com.mysql.jdbc.Driver";
static	final String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
static	final String user = "sahil";
static	final String pwd = "Naruhina@09";
}
