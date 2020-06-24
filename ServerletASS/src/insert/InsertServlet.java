package insert;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import insert.DBInsert; 
public class InsertServlet extends HttpServlet {
	DBInsert db= new DBInsert(DB_url, DB_path, user, pwd);
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	resp.setContentType("text/html");
	PrintWriter p = resp.getWriter();
	String name = req.getParameter("STname");
	String usn = req.getParameter("USN");
	int roll = Integer.parseInt(req.getParameter("roll"));
	int atten = Integer.parseInt(req.getParameter("atten"));
	System.out.println(name+" "+usn);
	p.println("<b>welcome:</b>"+name+"<br>");
	p.println("<a href=Display.html>Display all users in database</a>"+"<br>");
	p.println("<a href=Index.html>Return to home</a>");
	db.ins_DB(name,usn,roll,atten);
	
}
	static final String DB_url = "com.mysql.jdbc.Driver";
	static	final String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
	static	final String user = "sahil";
	static	final String pwd = "Naruhina@09";

}
