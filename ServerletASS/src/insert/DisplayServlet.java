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
	PrintWriter pw;
	 Connection conn;Statement stmt; 
	  try {
		
		        pw=resp.getWriter();
		        pw.println("<html><body>");
				Class.forName(DB_url);
				conn = DriverManager.getConnection(DB_path, user, pwd);
				String usn=req.getParameter("usn2");
				stmt= conn.createStatement();
				String sql1="select USN,Stdname,rollno,attandance from Student where USN='"+usn+"';";
				String usn1=null,name=null,roll=null,atten=null,marks=null;
       			ResultSet rs = stmt.executeQuery(sql1);
       			if(rs.next()==false)
       			{
       				pw.println("<script>alert('!!!!Not found!!!!!');window.location='Index.html';</script>");
       			}
       			else{
                do{
				usn1=rs.getString(1);
				
	            name=rs.getString(2);
	            roll=rs.getString(3);
	            atten=rs.getString(4);
	            //marks=rs.getString(5);
                }while(rs.next());
       			}
				pw.println("<h2> Student's Details </h2>");
			     pw.println("<form id='stu_form2' name='stu_form2' method='POST'>");
				  pw.println("<table id='stu_table'>");
				 pw.println("<tr>");
				 pw.println("<td>Name: </td>");
				 pw.println("<td><input type='text' name='name' id='name' value='"+name+"' required>");
				 pw.println("</tr>" +
				 		"<tr>"+
						"<td>USN: </td>");
				 pw.println("<td><input type='text' name='usn' id='usn' value='"+usn1+"' required readonly>" +
						"</tr>"+
						 "<tr>"+
						 "<td>Roll no: </td>"+
						  "<td><input type='text' name='roll' value='"+roll+"' required>"+
						"</tr>"+
						 "<tr>"+
						 "<td>Attendance: </td>"+
						 "<td><input type='text' name='atten' value='"+atten+"' required>"+
						"</tr>"+
						"<tr>"+
						"<td>Marks: </td>"+
						"<td><input type='text' name='marks' value='"+69+"' required max='100'>"+
						"</tr>"+
						 "<tr><td></td>"+
						 "<td colspan=2><input type='submit' name='update' id='update' value='Update' formaction='update.jsp'/>"+
						  "&nbsp; &nbsp; &nbsp; &nbsp;"+
						 "<input type='submit' name='delete' id='delete' value='Delete' formaction='Delete.jsp'/>"+
						  "</td>"+
						 "</tr>"+
					 "</table>"+
					"</form>"+
			  "</center>");
				 pw.println("</html></body>");
       			}
		          catch (Exception e) {
				System.out.println(e);
			}
}
static final String DB_url = "com.mysql.jdbc.Driver";
static	final String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
static	final String user = "sahil";
static	final String pwd = "Naruhina@09";
}
