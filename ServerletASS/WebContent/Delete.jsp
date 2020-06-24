<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp for delete</title>
</head>
<body>
HI im here to Delete
<%  
 String DB_url = "com.mysql.jdbc.Driver";
 String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
 String user = "sahil";
 String pwd = "Naruhina@09";
Connection conn; Statement stmt;
String usn=request.getParameter("USN");
try {
	Class.forName(DB_url);
	conn = DriverManager.getConnection(DB_path, user, pwd);
	String sql1 = "delete from Student where USN='"+usn+"';";
	stmt= conn.createStatement();
		stmt.executeUpdate(sql1);
 out.println("<a href=Index.html>Return to home</a>");
} catch (Exception e) {
	System.out.println(e);
}
%>
</body>
</html>