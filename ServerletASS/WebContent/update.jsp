<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
HI im here to update
<%  
 String DB_url = "com.mysql.jdbc.Driver";
 String DB_path = "jdbc:mysql://localhost:3306/StudentDB";
 String user = "sahil";
 String pwd = "Naruhina@09";
Connection conn; Statement stmt;
String name=request.getParameter("name");
String usn=request.getParameter("usn");
int roll=Integer.parseInt(request.getParameter("roll"));
int atten=Integer.parseInt(request.getParameter("atten"));
try {
	Class.forName(DB_url);
	conn = DriverManager.getConnection(DB_path, user, pwd);
	String sql1 = "update Student set Stdname='"+name+"' ,rollno="+roll+",attandance="+atten+" where USN='"+usn+"';";
	stmt= conn.createStatement();
		stmt.executeUpdate(sql1);
 out.println("<a href=Index.html>Return to home</a>");
} catch (Exception e) {
	System.out.println(e);
}
%>
</body>
</html>