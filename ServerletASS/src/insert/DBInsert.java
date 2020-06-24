package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
//import com.mysql.jdbc.PreparedStatement;

public class DBInsert {
	String DB_url,  DB_path, user, pwd;
	public DBInsert(String DB_url, String DB_path,String user,String pwd) {
		// TODO Auto-generated constructor stub
		this.DB_url=DB_url;
		this.DB_path=DB_path;
		this.user=user;
		this.pwd=pwd;
	}  
	
	 void  ins_DB(String name,String usn,int roll,int atten) {
		  Connection conn;Statement stmt; 
		  try {
					Class.forName(DB_url);
					conn = DriverManager.getConnection(DB_path, user, pwd);
					String sql1 = "insert into Student(USN,Stdname,rollno,attandance) values('"+usn+"','"+name+"',"+roll+","+atten+");";
					stmt= conn.createStatement();
				stmt.executeUpdate(sql1);
				} catch (Exception e) {
					System.out.println(e);
				}
		 }
	 /* public static void main(String[] args) {
		  ins_DB("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/Konohadb","sahil_uzumaki09","Naruhina@1347");
	}*/
}
